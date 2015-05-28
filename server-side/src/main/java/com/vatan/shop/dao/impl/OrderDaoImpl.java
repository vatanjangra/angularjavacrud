package com.vatan.shop.dao.impl;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.vatan.shop.dao.OrderDao;
import com.vatan.shop.model.Order;
import com.vatan.shop.util.DateUtil;

@Repository
public class OrderDaoImpl implements OrderDao {
	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Order> getAllOrders() {
		return mongoTemplate.findAll(Order.class);
	}

	@Override
	public void deleteOrders(ObjectId orderId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(orderId));
		mongoTemplate.findAndRemove(query, Order.class);
	}

	@Override
	public List<Order> getOrders(Date date) {
		Query query = new Query();
		Date from = DateUtil.formate(date, "dd-MM-yyyy");
		Date to = DateUtil.dateIncrimentor(from.getTime(), 1);
		query.addCriteria(Criteria.where("orderDate").gte(from).lt(to));
		return mongoTemplate.find(query, Order.class);
	}

	@Override
	public Order getOrders(ObjectId orderId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(orderId));
		return mongoTemplate.findOne(query, Order.class);
	}

	@Override
	public void updateOrders(ObjectId orderId, Order order) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(orderId));
		Update update = new Update();
		update.set("quantity", order.getQuantity());
		update.set("amount", order.getAmount());
		mongoTemplate.updateFirst(query, update, Order.class);
	}

}
