package com.openclassrooms.gestionreunions.model;

public class Contributor {

    private long id;

    private String Nom;

    private String Prenom;

    private String Email;

    public Contributor(long id, String nom, String prenom, String email) {
        this.id = id;
        Nom = nom;
        Prenom = prenom;
        Email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

}
