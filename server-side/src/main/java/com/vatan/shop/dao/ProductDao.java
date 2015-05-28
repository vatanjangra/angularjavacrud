package com.vatan.shop.dao;

import java.util.List;

import org.bson.types.ObjectId;

import com.vatan.shop.model.Product;

public interface ProductDao {
	public List<Product> getAllProducts();

	public void deleteProducts(ObjectId productId);

	public Product getProducts(ObjectId productId);

	public Product saveProducts(Product product);

	public void updateProducts(Product product, ObjectId productId);
}
