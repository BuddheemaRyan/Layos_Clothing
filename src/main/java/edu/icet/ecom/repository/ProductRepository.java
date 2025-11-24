package edu.icet.ecom.repository;


import edu.icet.ecom.db.DBConnection;
import edu.icet.ecom.model.dto.Product;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ProductRepository {
    public void addProduct(Product product) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "INSERT INTO Products (id, name, category, price, stock, image) VALUES (?,?,?,?,?,?)";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setObject(1, product.getId());
            pstm.setObject(2, product.getName());
            pstm.setObject(3, product.getCategory());
            pstm.setObject(4, product.getPrice());
            pstm.setObject(5, product.getStock());
            pstm.setObject(6, product.getImage());

            pstm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
