package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.login.databinding.ActivityDetalleLoginBinding;
import com.example.login.databinding.ActivityDetalleLoginBindingImpl;

public class detalle_login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetalleLoginBinding binding= ActivityDetalleLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("nombre");
        setTitle("               BIENVENIDO "+nombre.toUpperCase());
        String clave=extras.getString("clave");


        //-------------------------------------------------------------------------------------//
        int capSignos = 0;                  // Variable usada para almacenar los signos
        int Arroba = 0;                     // solo la arroba
        int suma=0;
        for (int x = 0; x < clave.length(); x++) {
            if ( (clave.charAt(x) >= 63 && clave.charAt(x) <= 65) || (clave.charAt(x) >= 32 && clave.charAt(x) <= 44) ) {
            }
            if ((clave.charAt(x) > 63 && clave.charAt(x) < 65)) { // Cuenta las arrobas
                Arroba++;
            }
            if ((clave.charAt(x) > 32 && clave.charAt(x) < 44)) { // Cuenta la cantidad signos
                capSignos++;
            }
            suma=Arroba+capSignos;
        }
        //-----------------------------------------------------------------------------------//
        
        if (clave.length()<=5){
            binding.rtgValidacion.setRating(1);
            binding.txtValoracion.setText("La clave de seguridad se considera insegura");
        }else if(clave.length()<=8 && suma==1){
            binding.rtgValidacion.setRating(3);
            binding.txtValoracion.setText("La clave de seguridad se considera media");
        }else if(clave.length()<=8){
            binding.rtgValidacion.setRating(2);
            binding.txtValoracion.setText("La clave de seguridad se considera baja");
        }else if(clave.length()<=10 && suma==2){
            binding.rtgValidacion.setRating(4);
            binding.txtValoracion.setText("La clave de seguridad se considera media alta");
        }else if(clave.length()<=10){
            binding.rtgValidacion.setRating(4);
            binding.txtValoracion.setText("La clave de seguridad se considera media alta");
        }else if(clave.length()<=12 && suma>=4) {
            binding.rtgValidacion.setRating(5);
            binding.txtValoracion.setText("La clave de seguridad se considera alta");
        }else if(clave.length()<=12) {
            binding.rtgValidacion.setRating(5);
            binding.txtValoracion.setText("La clave de seguridad se considera alta");
        }

    }
}