package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.login.databinding.ActivityDetalleLoginBinding;


public class detalle_login extends AppCompatActivity {

    public static final String LOGIN_KEY= "Login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetalleLoginBinding binding= ActivityDetalleLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("BIENVENIDO");
        Bundle extras = getIntent().getExtras();
        Login log= extras.getParcelable(LOGIN_KEY);
        binding.setLogin(log);



        String clave=binding.getLogin().getClave();
        int c=contarCaracteres(clave);
        if(c>=4 && clave.length()>=12 ) {
            binding.rtgValidacion.setRating(5);
            binding.txtValcontraseA.setText("La clave de seguridad se considera Alta");
        }else if (c>=2 && clave.length()>=10){
            binding.rtgValidacion.setRating(4);
            binding.txtValcontraseA.setText("La clave de seguridad se considera Media Alta");
        }else if (c>=1 && clave.length()>=8){
            binding.rtgValidacion.setRating(3);
            binding.txtValcontraseA.setText("La clave de seguridad se considera media");
        }else if (clave.length()>=8){
            binding.rtgValidacion.setRating(2);
            binding.txtValcontraseA.setText("La clave de seguridad se considera baja");
        }else{
            binding.rtgValidacion.setRating(1);
            binding.txtValcontraseA.setText("La clave de seguridad se considera insegura");
        }

    }
    public int contarCaracteres(String texto){
        int con=0;

        char[] car= texto.toCharArray();
        for (int i=0; i<car.length; i++){
            if(Character.isLetter(car[i])){
            }else if (Character.isDigit(car[i])){
            }else if (Character.isSpaceChar(car[i])){
            }else{
                ++con;
            }
        }

        return con;
    }
}