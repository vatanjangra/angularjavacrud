package com.vatan.shop.dao;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.vatan.shop.model.Order;

public interface OrderDao {
	public List<Order> getAllOrders();

	public void deleteOrders(ObjectId orderId);

	public List<Order> getOrders(Date date);

	public Order getOrders(ObjectId orderId);

	public void updateOrders(ObjectId orderId, Order order);
}
