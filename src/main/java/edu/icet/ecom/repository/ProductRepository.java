package edu.icet.ecom.repository;


import edu.icet.ecom.db.DBConnection;
import edu.icet.ecom.model.dto.Product;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public Product getProduct(int id) throws SQLException {
        String sql = "SELECT * FROM Products WHERE id = ?";

        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    return new Product(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("category"),
                            rs.getDouble("price"),
                            rs.getInt("stock"),
                            rs.getString("image")
                    );
                }
            }
        }
        return null;
    }


    public List<Product> getAll() {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "SELECT * FROM Products";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rst = pstm.executeQuery();

            List<Product> productList = new ArrayList<>();
            while (rst.next()) {
                productList.add(new Product(
                                rst.getInt("id"),
                                rst.getString("name"),
                                rst.getString("category"),
                                rst.getDouble("price"),
                                rst.getInt("stock"),
                                rst.getString("image")
                        )
                );
            }
            return productList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateProduct(Product product){
        try {
            Connection connection =DBConnection.getInstance().getConnection();
            String sql ="UPDATE Products SET name=?, category=?, price=?, stock=?, image=? WHERE id=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setObject(1,product.getName());
            pstm.setObject(2,product.getCategory());
            pstm.setObject(3,product.getPrice());
            pstm.setObject(4,product.getStock());
            pstm.setObject(5,product.getImage());
            pstm.setObject(6,product.getId());
            pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteProduct(int id){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql ="DELETE FROM Products WHERE id=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1,id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
