package com.vatan.shop.controller;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vatan.shop.model.Order;
import com.vatan.shop.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	@ResponseBody
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

	@RequestMapping(value = "/orders", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteOrders(@RequestParam("id") String orderId) {
		orderService.deleteOrders(new ObjectId(orderId));
	}

	@RequestMapping(value = "/orders/bydate", method = RequestMethod.GET)
	@ResponseBody
	public List<Order> getOrders(@RequestParam("date") long date) {
		return orderService.getOrders(new Date(date));
	}

	@RequestMapping(value = "/orders/byid", method = RequestMethod.GET)
	@ResponseBody
	public Order getOrders(@RequestParam("id") String orderId) {
		return orderService.getOrders(new ObjectId(orderId));
	}

	@RequestMapping(value = "/orders", method = RequestMethod.PUT)
	@ResponseBody
	public void updateOrders(@RequestParam("id") String orderId,
			@RequestBody Order order) {
		orderService.upadteOrders(new ObjectId(orderId), order);
	}
}
