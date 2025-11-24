package edu.icet.ecom.controller;

import edu.icet.ecom.model.dto.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController

public class ProductsController {
    @PostMapping("add/product")
    public  void addProduct(Product product){

    }
    @GetMapping("get/product/{id}")
    public Product getProduct(int id){
        return null;
    }
    @GetMapping("delete/product/{id}")
    public void deleteProduct(int id){

    }
    @PostMapping("update/product")
    public void updateProduct(Product product){

    }

    @GetMapping("/product/getAll")
    public List<Product> getAll(){
        return null;
    }

}
