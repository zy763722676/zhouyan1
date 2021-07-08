package com.zy.testmyjpa.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Parameter  implements Serializable {
    @Id
//    @GeneratedValue
    @Column
    private Integer id;
    @Column
    private Integer Product_Id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProduct_Id() {
        return Product_Id;
    }

    public void setProduct_Id(Integer product_Id) {
        Product_Id = product_Id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getMarkettime() {
        return markettime;
    }

    public void setMarkettime(String markettime) {
        this.markettime = markettime;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    /**
     * 品牌
     */
    @Column
    private String brand;
    /**
     * 功能
     */
    @Column
    private String features;
    /**
     * 款式
     */
    @Column
    private String style;
    /**
     * 季节
     */
    @Column
    private String season;
    /**
     * 颜色
     */
    @Column
    private String colour;
    /**
     * 上市时间
     */
    @Column
    private String markettime;
    /**
     * 款号
     */
    @Column
    private String section;
    /**
     * 分类
     */
    @Column
    private String classs;
    /**
     * 场合
     */
    @Column
    private String occasion;


}
