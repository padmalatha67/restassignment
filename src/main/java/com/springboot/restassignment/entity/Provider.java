package com.springboot.restassignment.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="provider")
public class Provider {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @Column(name="provider_name",unique = true)
    private String providerName;




    @Column(name="email")
    private String email;


    @Column(name="speciality")
    private String speciality;

    @OneToMany(mappedBy="providerId",
            cascade= {CascadeType.ALL})
    private List<Claim> claims;

    public Provider() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }


    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }



    public List<Claim> getClaims() {
        return claims;
    }

    public void setClaims(List<Claim> claims) {
        this.claims = claims;
    }

    public Provider(String providerName, String email, String speciality) {
        this.providerName = providerName;
        this.email = email;
        this.speciality = speciality;
    }

    public Provider(int id, String providerName, String email, String speciality, List<Claim> claims) {
        this.id = id;
        this.providerName = providerName;
        this.email = email;
        this.speciality = speciality;
        this.claims = claims;
    }
}
