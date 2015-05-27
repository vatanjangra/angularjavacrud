package com.gurjinder.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gurjinder.home.model.Order;
import com.gurjinder.home.service.RestService;

@Controller
public class RestController {
	@Autowired
	private RestService restService;

	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	@ResponseBody
	public List<Order> getAllOrders() {
		return restService.getAllOrders();
	}
}
