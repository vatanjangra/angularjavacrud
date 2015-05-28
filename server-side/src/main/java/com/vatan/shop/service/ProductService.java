package com.vatan.shop.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.vatan.shop.model.Product;

public interface ProductService {
	public List<Product> getAllProducts();

	public void deleteProducts(ObjectId productId);

	public Product getProducts(ObjectId productId);

	public Product saveProduct(Product product);

	public void updateProduct(Product product, ObjectId productid);
}
