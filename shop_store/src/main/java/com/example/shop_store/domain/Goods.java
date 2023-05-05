package com.example.shop_store.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String goodName;
    private String goodsDesc;
    private Integer price;
    private String filename;

    public Goods(){}

    public Goods(String goodName, String goodsDesc, Integer price) {
        this.goodName = goodName;
        this.goodsDesc = goodsDesc;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodName='" + goodName + '\'' +
                ", goodsDesc='" + goodsDesc + '\'' +
                ", price=" + price +
                '}';
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
