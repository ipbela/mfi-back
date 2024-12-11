package com.example.mfi.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "TB_LPR")
public class LprModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idLpr;
    private LocalDate data;
    private String produto;
    private String norma;
    private String molde;
    private Boolean situacao;

    public UUID getIdLpr() {
        return idLpr;
    }

    public void setIdLpr(UUID idLpr) {
        this.idLpr = idLpr;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getNorma() {
        return norma;
    }

    public void setNorma(String norma) {
        this.norma = norma;
    }

    public String getMolde() {
        return molde;
    }

    public void setMolde(String molde) {
        this.molde = molde;
    }

    public Boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(Boolean situacao) {
        this.situacao = situacao;
    }
}
