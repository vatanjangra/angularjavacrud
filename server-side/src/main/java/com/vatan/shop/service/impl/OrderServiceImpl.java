package com.vatan.shop.service.impl;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vatan.shop.dao.OrderDao;
import com.vatan.shop.model.Order;
import com.vatan.shop.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;

	public List<Order> getAllOrders() {
		return orderDao.getAllOrders();
	}

	@Override
	public void deleteOrders(ObjectId orderId) {
		orderDao.deleteOrders(orderId);

	}

	@Override
	public List<Order> getOrders(Date date) {
		return orderDao.getOrders(date);
	}

	@Override
	public Order getOrders(ObjectId orderId) {
		return orderDao.getOrders(orderId);

	}

	@Override
	public void upadteOrders(ObjectId orderId,Order order) {
		orderDao.updateOrders(orderId, order);
	}

}
