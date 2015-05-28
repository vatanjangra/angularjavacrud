package com.vatan.shop.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vatan.shop.util.ObjectIdSerializer;

@Document(collection = "order")
public class Order {
	@JsonSerialize(using = ObjectIdSerializer.class)
	@Id
	@Field(value = "_id")
	private ObjectId id;
	private Date orderDate;
	@JsonSerialize(using = ObjectIdSerializer.class)
	private ObjectId sku;
	private int quantity;
	private float amount;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public ObjectId getSku() {
		return sku;
	}

	public void setSku(ObjectId sku) {
		this.sku = sku;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

}
