package com.vatan.shop.service;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.vatan.shop.model.Order;

public interface OrderService {
	public List<Order> getAllOrders();

	public void deleteOrders(ObjectId orderId);

	public List<Order> getOrders(Date date);

	public Order getOrders(ObjectId orderId);

	public void upadteOrders(ObjectId orderId, Order order);
}
