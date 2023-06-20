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
    private String measurement;
    private float price;
    private String filename;

    public Pakets(String name, String artikul, String measurement, float price, String description) {
        this.name = name;
        this.artikul = artikul;
        this.measurement = measurement;
        this.price = price;
        this.filename = filename;
        this.description = description;
    }

    public Pakets() {

    }

    @Override
    public String toString() {
        return "Pakets{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artikul='" + artikul + '\'' +
                ", measurement='" + measurement + '\'' +
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

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }
}
