package com.openclassrooms.gestionreunions.model;

import java.util.Objects;

public class Contributor {

    private long id;

    private String nom;

    private String prenom;

    private String email;

    public Contributor(long id, String nom, String prenom, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contributor contributor = (Contributor) o;
        return Objects.equals(this.id, contributor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

}
