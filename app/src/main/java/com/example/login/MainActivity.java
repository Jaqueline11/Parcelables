package com.example.login;

import android.content.Intent;
import android.widget.RatingBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.login.databinding.ActivityDetalleLoginBinding;
import com.example.login.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    String nombre, clave, clave1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Registro usuario");
        registrar();
    }
    public void registrar(){
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnRegistrar.setOnClickListener(view -> {
             nombre = binding.txtNombre.getText().toString();
             clave = binding.txtClave.getText().toString();
             clave1 = binding.txtClave2.getText().toString();

            if (!nombre.isEmpty() && !clave.isEmpty() && !clave1.isEmpty()){
                if (clave.length()>4){
                    if (clave1.equals(clave)){
                        Toast.makeText(getApplicationContext(),"Registrado correctamente", Toast.LENGTH_SHORT).show();
                        abrirActivityDetalle(nombre,clave);
                    }else{
                        Toast.makeText(getApplicationContext(),"Las claves no coinciden", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Clave minimo 5 caracteres", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(getApplicationContext(),"Llenar todos los campos", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void valoracion(String val){
        Intent intent = new Intent(this,detalle_login.class);
        intent.putExtra("nombre",val);
        startActivity(intent);
    }
    private void abrirActivityDetalle(String nom,String clave){
        /*Intent = Abrir una nueva ventana*/
        Intent intent = new Intent(this,detalle_login.class);
        intent.putExtra("nombre",nom);
        intent.putExtra("clave",clave);
        startActivity(intent);
    }
}