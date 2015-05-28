package com.vatan.shop.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vatan.shop.dao.ProductDao;
import com.vatan.shop.model.Product;
import com.vatan.shop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

	@Override
	public void deleteProducts(ObjectId productId) {
		productDao.deleteProducts(productId);
	}

	@Override
	public Product getProducts(ObjectId productId) {
		return productDao.getProducts(productId);
	}

	@Override
	public Product saveProduct(Product product) {
		productDao.saveProducts(product);
		Product temp = new Product();
		temp.setId(product.getId());
		return temp;
	}

	@Override
	public void updateProduct(Product product, ObjectId productid) {
		productDao.updateProducts(product, productid);
	}

}
