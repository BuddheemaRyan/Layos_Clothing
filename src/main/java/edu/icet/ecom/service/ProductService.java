package edu.icet.ecom.service;


import edu.icet.ecom.model.dto.Product;
import edu.icet.ecom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public void addProduct(Product product) throws SQLException {
            productRepository.addProduct(product);
    }

    public Product getProduct(int id) throws SQLException {
        return productRepository.getProduct(id);
    }
}
