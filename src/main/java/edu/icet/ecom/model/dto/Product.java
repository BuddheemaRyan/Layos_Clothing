package edu.icet.ecom.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    private int id;
    private String  name;
    private String category;
    private double price;
    private int stock;
    private String image;
}
