package com.proyecto.chefsito.model;

public class Usuario {
    private String nombre;
    private String nickname;
    private String password;
    private String correo;

    public Usuario(String nombre, String nickname,String password,String correo){
        this.nombre=nombre;
        this.nickname=nickname;
        this.password=password;
        this.correo=correo;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
