package com.example.login;

import android.os.Parcel;
import android.os.Parcelable;

public class Login implements Parcelable {

    private String rol;
    private String usuario;
    private String clave;
    private String email;

    public Login(String rol, String usuario, String clave, String email) {
        this.rol = rol;
        this.usuario = usuario;
        this.clave = clave;
        this.email = email;
    }

    public Login(){

    }
    protected Login(Parcel in) {
        rol = in.readString();
        usuario = in.readString();
        clave = in.readString();
        email = in.readString();
    }


    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(rol);
        parcel.writeString(usuario);
        parcel.writeString(clave);
        parcel.writeString(email);

    }
    public static final Creator<Login> CREATOR = new Creator<Login>() {
        @Override
        public Login createFromParcel(Parcel in) {
            return new Login(in);
        }

        @Override
        public Login[] newArray(int size) {
            return new Login[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
