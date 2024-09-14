package com.webApplication.ecom_project.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Column(length = 5000)
    private String description;
    private String brand;
    private double price;
    private String category;
    private Date releaseDate;
    private int stockQuantity;
    private boolean productAvailable;

    private String imageName;
    private String imageType;

    @Lob   // this is annotation to store large object data
    private byte[] imageData;   // this is like u can store ur image in ur cloud and then u can get the url 
    // so here we will store the image in the database itself

}
