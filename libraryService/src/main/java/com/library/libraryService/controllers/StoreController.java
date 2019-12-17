package com.library.libraryService.controllers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.libraryService.modules.Book;
import com.library.libraryService.modules.OrderClass;
import com.library.libraryService.modules.OrderStatus;
import com.library.libraryService.services.BookService;
import com.library.libraryService.services.StoreService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(StoreController.CONTRACT_BASE_URL)
@ApiModel(description = "Acces to library orders")
public class StoreController {

	@Autowired
	private StoreService storeService;
	private List<Integer> basket = new ArrayList<Integer>();
	private double totalSum = 0;
	@Autowired
	private BookService bookService;
	public static final String CONTRACT_BASE_URL = "/store";

	@PostMapping("/order")
	@ApiOperation(value = "Place an order", response = OrderClass.class)
	private OrderClass placeOrder(@ApiParam(value = "Order object to be added") @RequestBody OrderClass order) {
		List<Integer> tempBasket = new ArrayList<>(basket);
		order.setoBooksId(tempBasket);
		order.setoTotalSum(round(totalSum, 2));
		storeService.placeOrder(order);
		totalSum = 0;
		basket.clear();
		return order;
	}

	@GetMapping("/order/addToBasket/{bookId}")
	@ApiOperation(value = "Add book to the basket", response = OrderClass.class)
	private Book addToBasket(@ApiParam(value = "ID of the book to be added to the basket") @PathVariable int bookId)
	{
		basket.add(bookId);
		Book book = bookService.findById(bookId);
		totalSum = totalSum + book.getBookPrice();
		return book;
	}
	
	@GetMapping("/order/basket")
	@ApiOperation(value = "Show what books are in the basket", response = OrderClass.class)
	private List<Book> getBasket()
	{
		return storeService.getBooksFromBasket(basket, bookService);
	}
	
	@DeleteMapping("/DeleteOrder/{orderId}")
	@ApiOperation(value = "Delete an order", response = OrderClass.class)
	private String deleteOrderById(@ApiParam(value = "ID of the order to be deleted") @PathVariable int orderId) {
		storeService.delete(orderId);

		return "Order deleted successfully";
	}

	@GetMapping("/order/{orderId}")
	@ApiOperation(value = "Finds an order by its id", response = OrderClass.class)
	private OrderClass getOrderById(@ApiParam(value = "ID of the order to be returned") @PathVariable int orderId) {
		return storeService.findById(orderId);
	}

	@GetMapping("/allOrders")
	@ApiOperation(value = "Find all orders", response = OrderClass.class)
	private Hashtable<Integer, OrderClass> getAllOrders() {
		return storeService.findAll();
	}

	@GetMapping("/order/findByStatus/{status}")
	@ApiOperation(value = "Find orders by their status", response = OrderClass.class)
	private List<OrderClass> getOrdersByStatus(@ApiParam(value = "Status values for finding the orders") @PathVariable OrderStatus status) {
		return storeService.findByOStatus(status);
	}

	@PutMapping("/order/{orderId}/update")
	@ApiOperation(value = "Update orders", response = OrderClass.class)
	private String updateOrder(@ApiParam(value = "The ID of the order that will be updated") @PathVariable int orderId, @ApiParam("The updated order") @RequestBody OrderClass updatedOrder) {
		OrderClass oldOrder = storeService.findById(orderId);
		updatedOrder.setoBooksId(oldOrder.getoBooksId());
		updatedOrder.setoTotalSum(oldOrder.getoTotalSum());
		return storeService.updateOrder(orderId, updatedOrder);
	}

	@GetMapping("/usersOrders/{userId}")
	@ApiOperation(value = "Find orders by the users that placed the order")
	private List<OrderClass> getOrderByUserId(@ApiParam(value = "The ID of the user that placed the orders") @PathVariable int userId) {
		return storeService.findByUserId(userId);
	}

	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = BigDecimal.valueOf(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
}
