package com.gurjinder.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gurjinder.home.dao.OrderDao;
import com.gurjinder.home.model.Order;
import com.gurjinder.home.service.RestService;

@Service
public class RestServiceImpl implements RestService {
	@Autowired
	private OrderDao orderDao;

	public List<Order> getAllOrders() {
		return orderDao.getAllOrders();
	}

}
