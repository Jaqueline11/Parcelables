package com.example.login;

import android.content.Intent;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.login.databinding.ActivityMainBinding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    String nombre, clave, clave1,rol,email, email1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Registro Login");
        registrar();
    }
    public void registrar(){
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnRegistrar.setOnClickListener(view -> {
             nombre = binding.txtNombre.getText().toString();
             clave = binding.txtClave.getText().toString();
             clave1 = binding.txtClave2.getText().toString();
             rol=binding.txtRolU.getText().toString();
             email = binding.txtEmail.getText().toString();
             email1=binding.txtEmail2.getText().toString();

            Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher mather = pattern.matcher(email);
            String rol1="admin", rol2="invitado";
            System.out.println("rol "+rol);

            //---------------------------------------------------------------------------------//

            if (rol.equals(rol1)||rol.equals(rol2)){
                if (!nombre.isEmpty() && !clave.isEmpty() && !clave1.isEmpty()){
                    if (clave.length()>4){
                        if (clave1.equals(clave)){
                            if (mather.find() == true) {
                                if(email1.equals(email)){
                                    Toast.makeText(getApplicationContext(),"Registrado correctamente", Toast.LENGTH_SHORT).show();
                                    abrirActivityDetalle(rol,nombre,clave,email);
                                }else {
                                    Toast.makeText(getApplicationContext(),"Los emails no coinciden", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(getApplicationContext(),"El email ingresado es inválido.", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(getApplicationContext(),"Las claves no coinciden", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(),"Clave minimo 5 caracteres", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Llenar todos los campos", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(getApplicationContext(),"Rol incorrecto"+rol , Toast.LENGTH_SHORT).show();
            }



        });
    }

    private void abrirActivityDetalle(String nom,String clave,String rol, String email){
        /*Intent = Abrir una nueva ventana*/
        Intent intent = new Intent(this,detalle_login.class);
        Login usu= new Login(nom,clave,rol,email);
        intent.putExtra(detalle_login.LOGIN_KEY,usu);
        startActivity(intent);
        /*intent.putExtra("nombre",nom);
        intent.putExtra("clave",clave);
        startActivity(intent);*/
    }
}