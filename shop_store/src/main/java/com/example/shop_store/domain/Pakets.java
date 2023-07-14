package com.example.shop_store.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "pakets")
public class Pakets {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private String artikul;
    private double price;
    private String filename;

    public Pakets(String name, String artikul, double price, String description) {
        this.name = name;
        this.artikul = artikul;
        this.price = price;
        this.description = description;
    }

    public Pakets() {

    }

    @Override
    public String toString() {
        return "Pakets{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", artikul='" + artikul + '\'' +
                ", price=" + price +
                ", filename='" + filename + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtikul() {
        return artikul;
    }

    public void setArtikul(String artikul) {
        this.artikul = artikul;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
