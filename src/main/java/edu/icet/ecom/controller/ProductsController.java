package edu.icet.ecom.controller;

import edu.icet.ecom.model.dto.Product;
import edu.icet.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
@RestController
@CrossOrigin
public class ProductsController {
    @Autowired
    ProductService productService;
    @PostMapping("add/product")
    public  void addProduct(@RequestBody  Product product) throws SQLException {
        productService.addProduct(product);
    }
    @GetMapping("get/product/{id}")
    public Product getProduct(@PathVariable int id) throws SQLException {
        return productService.getProduct(id);
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
