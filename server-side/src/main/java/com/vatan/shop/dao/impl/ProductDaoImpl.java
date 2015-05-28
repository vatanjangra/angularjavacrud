package com.vatan.shop.dao.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.vatan.shop.dao.ProductDao;
import com.vatan.shop.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Product> getAllProducts() {
		return mongoTemplate.findAll(Product.class);
	}

	@Override
	public void deleteProducts(ObjectId productId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(productId));
		mongoTemplate.findAndRemove(query, Product.class);
	}

	@Override
	public Product getProducts(ObjectId productId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(productId));
		return mongoTemplate.findOne(query, Product.class);
	}

	@Override
	public Product saveProducts(Product product) {
		mongoTemplate.save(product);
		return product;
	}

	@Override
	public void updateProducts(Product product, ObjectId productId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(productId));
		Update update = new Update();
		update.set("description", product.getDescription());
		update.set("amount", product.getAmount());
		update.set("productName", product.getProductName());
		mongoTemplate.updateFirst(query, update, Product.class);
	}

}
