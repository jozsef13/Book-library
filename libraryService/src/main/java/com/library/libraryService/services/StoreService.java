package com.library.libraryService.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.stereotype.Service;

import com.library.libraryService.modules.Book;
import com.library.libraryService.modules.OrderClass;
import com.library.libraryService.modules.OrderStatus;

@Service
public class StoreService {

	private Hashtable<Integer, OrderClass> orders = new Hashtable<Integer, OrderClass>();
	private Integer key = 1;

	public StoreService() {

		List<Integer> oBooksId = new ArrayList<>();
		oBooksId.add(1);
		oBooksId.add(2);
		oBooksId.add(4);
		
		OrderClass order = new OrderClass();
		order.setoId(key);
		order.setoBooksId(oBooksId);
		order.setoShipDate("30/11/2019");
		order.setoStatus(OrderStatus.Delivered);
		order.setoUserId(1);
		order.setoTotalSum(141.98);
		orders.put(key, order);
		key++;
		oBooksId = new ArrayList<>();
		
		oBooksId.add(3);
		oBooksId.add(5);
		oBooksId.add(7);
		order = new OrderClass();
		order.setoId(key);
		order.setoBooksId(oBooksId);
		order.setoShipDate("27/11/2019");
		order.setoStatus(OrderStatus.Delivered);
		order.setoUserId(2);
		order.setoTotalSum(184.93);
		orders.put(key, order);
		key++;
		oBooksId = new ArrayList<>();
		
		oBooksId.add(1);
		order = new OrderClass();
		order.setoId(key);
		order.setoBooksId(oBooksId);
		order.setoShipDate("02/12/2019");
		order.setoStatus(OrderStatus.Delivered);
		order.setoUserId(1);
		order.setoTotalSum(21.99);
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

	public List<Book> getBooksFromBasket(List<Integer> basket, BookService bookService) {
		List<Book> booksFromBasket = new ArrayList<>();
		
		for (Integer bookId : basket) {
			booksFromBasket.add(bookService.findById(bookId));
		}
		
		return booksFromBasket;
	}
}