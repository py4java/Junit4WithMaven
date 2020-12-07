package com.urbanladder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.urbanladder.dto.Product;
import com.urbanladder.helper.ConnectionService;

public class ProductDao {

	private ConnectionService connectionService;

	public ProductDao(ConnectionService connectionService) {
		this.connectionService = connectionService;
	}

	String sql = "select p.product_no,p.product_nm,p.product_desc,p.product_price from product p left outer join category c on p.category_no=c.category_no where c.category_nm=?";
	List<Product> products = new ArrayList<Product>();
	Product product = null;

	public List<Product> getProductsByCategory(String category) {
		try (Connection conn = connectionService.getConnection("db.properties");
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, category);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					product = new Product();
					product.setProductNo(rs.getInt(1));
					product.setProductName(rs.getString(2));
					product.setProductDesc(rs.getString(3));
					product.setProductPrice(rs.getDouble(4));
					products.add(product);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

}
