package Entities;

import javax.persistence.*;
import java.util.Set;

@Entity

@Table(name = "USER")
public class User {

    @Id
    private String nick_Name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String last_Name;

    @Column(nullable = false)
    private String mail;

    @Column(nullable = false)
    private boolean rol;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    private Set<Keep> keeps;

    public User(){
    }

    public User(String nick_Name, String password, String name, String last_Name, String mail, boolean rol){
        setNick_Name(nick_Name);
        setPassword(password);
        setName(name);
        setLast_Name(last_Name);
        setMail(mail);
        setRol(rol);
    }

    public String getNick_Name(){
        return nick_Name;
    }

    public String getPassword(){
        return password;
    }

    public String getName(){
        return name;
    }

    public String getLast_Name(){
        return last_Name;
    }

    public String getMail(){
        return mail;
    }

    public boolean getRol(){
        return rol;
    }

    public Set geKeeps(){
        return keeps;
    }

    private void setNick_Name(String nick_Name){
        // base data consult
    }

    private void setPassword(String password){
        this.password = password;
    }

    private void setName(String name){
        this.name = name;
    }

    private void setLast_Name(String last_Name){
        this.last_Name = last_Name;
    }

    private void setMail(String mail){
        this.mail = mail;
    }

    private void setRol(boolean rol){
        this.rol = rol;
    }

}
