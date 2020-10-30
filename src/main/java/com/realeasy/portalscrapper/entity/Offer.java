package com.realeasy.portalscrapper.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String coverImageLink;
    private String headline;
    private String vendorId;
    private int price;
    private String address;
    private int roomCount;
    private int size;
    private String text;
}
