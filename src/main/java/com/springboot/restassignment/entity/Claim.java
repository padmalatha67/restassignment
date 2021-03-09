package com.springboot.restassignment.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="claims")
public class Claim {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="claim_id",unique = true)
    private int claimId;


    @Column(name="procedure_code")
    private String procedureCode;

    @Column(name="procedure_code_description")
    private String procedureCodeDescription;



    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="provider_id")
    private Provider providerId;


    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name="date_of_service")
    private LocalDate dateOfService;


    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }


    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="user_id")
    private User userId;



    @Column(name="cost")
    private int cost;

    @Column(name="created_at")
    private Date createdAt;

    public Claim() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProcedureCode() {
        return procedureCode;
    }

    public void setProcedureCode(String procedureCode) {
        this.procedureCode = procedureCode;
    }

    public String getProcedureCodeDescription() {
        return procedureCodeDescription;
    }

    public void setProcedureCodeDescription(String procedureCodeDescription) {
        this.procedureCodeDescription = procedureCodeDescription;
    }


    public Provider getProviderId() {
        return providerId;
    }

    public void setProviderId(Provider providerId) {
        this.providerId = providerId;
    }





    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }


    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getDateOfService() {
        return dateOfService;
    }

    public void setDateOfService(LocalDate dateOfService) {
        this.dateOfService = dateOfService;
    }



    public int getClaimId() {
        return claimId;
    }

    public void setClaimId(int claimId) {
        this.claimId = claimId;
    }


    public Claim(int id, int claimId, String procedureCode, String procedureCodeDescription, Provider providerId, LocalDate dateOfService, User userId, int cost, Date createdAt) {
        this.id = id;
        this.claimId = claimId;
        this.procedureCode = procedureCode;
        this.procedureCodeDescription = procedureCodeDescription;
        this.providerId = providerId;
        this.dateOfService = dateOfService;
        this.userId = userId;
        this.cost = cost;
        this.createdAt = createdAt;
    }

    public Claim(int claimId, String procedureCode, String procedureCodeDescription, Provider providerId, LocalDate dateOfService, User userId, int cost, Date createdAt) {
        this.claimId = claimId;
        this.procedureCode = procedureCode;
        this.procedureCodeDescription = procedureCodeDescription;
        this.providerId = providerId;
        this.dateOfService = dateOfService;
        this.userId = userId;
        this.cost = cost;
        this.createdAt = createdAt;
    }
}
