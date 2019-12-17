package com.library.libraryService.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

import org.springframework.stereotype.Service;

import com.library.libraryService.modules.OrderClass;
import com.library.libraryService.modules.OrderStatus;

@Service
public class StoreService {

	private Hashtable<Integer, OrderClass> orders = new Hashtable<Integer, OrderClass>();
	private Integer key = 1;

	public StoreService() {

		OrderClass order = new OrderClass();
		order.setoId(key);
		order.setoBookId(2);
		order.setoQuantity(5);
		order.setoShipDate("30/11/2019");
		order.setoStatus(OrderStatus.Delivered);
		order.setoUserId(1);
		orders.put(key, order);
		key++;

		order = new OrderClass();
		order.setoId(key);
		order.setoBookId(1);
		order.setoQuantity(2);
		order.setoShipDate("27/11/2019");
		order.setoStatus(OrderStatus.Delivered);
		order.setoUserId(2);
		orders.put(key, order);
		key++;

		order = new OrderClass();
		order.setoId(key);
		order.setoBookId(5);
		order.setoQuantity(1);
		order.setoShipDate("02/12/2019");
		order.setoStatus(OrderStatus.Delivered);
		order.setoUserId(1);
		orders.put(key, order);
		key++;
	}

	public void placeOrder(OrderClass order) {
		order.setoId(key);
		orders.put(key, order);
		key++;
	}

	public void delete(int orderId) {
		orders.remove(orderId);
	}

	public OrderClass findById(int orderId) {
		if (orders.containsKey(orderId)) {
			return orders.get(orderId);
		}

		return null;
	}

	public Hashtable<Integer, OrderClass> findAll() {
		return orders;
	}

	public List<OrderClass> findByOStatus(OrderStatus status) {

		List<OrderClass> returningOrders = new ArrayList<>();
		Collection<OrderClass> orderValue = orders.values();

		for (OrderClass order : orderValue) {
			if (order.getoStatus().equals(status)) {
				returningOrders.add(orders.get(order.getoId()));
			}
		}

		if (returningOrders.isEmpty()) {
			return null;
		}

		return returningOrders;

	}

	public String updateOrder(int orderId, OrderClass updatedOrder) {
		orders.put(orderId, updatedOrder);

		return "Updated successfully!";
	}

	public List<OrderClass> findByUserId(int userId) {
		List<OrderClass> returningOrders = new ArrayList<>();
		Collection<OrderClass> orderValue = orders.values();

		for (OrderClass order : orderValue) {
			if (order.getoUserId() == userId) {
				returningOrders.add(orders.get(order.getoId()));
			}
		}

		if (returningOrders.isEmpty()) {
			return null;
		}

		return returningOrders;
	}
}