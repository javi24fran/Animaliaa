package com.example.animalia;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);


        TabLayout tl =( TabLayout) findViewById(R.id.tablayout);
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //Codificar cosas a ejecutar cuando le das a tap a un tab
                int position = tab.getPosition();
                switch (position){
                    case 0:
                        //Llamar al fragmento inicio
                        Inicio i = new Inicio();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,i).commit();
                        Toast.makeText(Principal.this, "inicio", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        //Llamar al fragmento publicaciones
                        Publicaciones p= new Publicaciones();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,p).commit();
                        Toast.makeText(Principal.this, "publicaciones", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        //LLamar al fragmento Cuidado
                        Cuidado c = new Cuidado();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,c);
                        Toast.makeText(Principal.this, "cuidado", Toast.LENGTH_SHORT).show();
                        break;
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId(); // Recuperar el id de la opción seleccionada
        Fragment fragment = null; //Inicializamos un fragmento

        if (id == R.id.op1) {
            fragment = new Perfil();
            Toast.makeText(this, "Vas al perfil", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.op2) {
            fragment = new notificaciones();
            Toast.makeText(this, "Notificaciones", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.op3) {
            fragment = new Busqueda();
            Toast.makeText(this, "Búsqueda", Toast.LENGTH_SHORT).show();
        }

        //Si se seleccionó una opción válida, reemplazamos el fragmento en el contenedor
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragment).commit();
        }


        return super.onOptionsItemSelected(item);
    }


}