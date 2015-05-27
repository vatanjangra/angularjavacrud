package com.gurjinder.home.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.gurjinder.home.dao.OrderDao;
import com.gurjinder.home.model.Order;

@Repository
public class OrderDaoImpl implements OrderDao {
	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Order> getAllOrders() {
		return mongoTemplate.findAll(Order.class);
	}

}
