package com.vatan.shop.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vatan.shop.model.Product;
import com.vatan.shop.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	@ResponseBody
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@RequestMapping(value = "/products", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteProducts(@RequestParam("id") String productId) {
		productService.deleteProducts(new ObjectId(productId));
	}

	@RequestMapping(value = "/products/byid", method = RequestMethod.GET)
	@ResponseBody
	public Product getOrders(@RequestParam("id") String productId) {
		return productService.getProducts(new ObjectId(productId));
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	@ResponseBody
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	@RequestMapping(value = "/products", method = RequestMethod.PUT)
	@ResponseBody
	public void updateProduct(@RequestBody Product product,
			@RequestParam("id") String productId) {

		productService.updateProduct(product, new ObjectId(productId));
	}
}
