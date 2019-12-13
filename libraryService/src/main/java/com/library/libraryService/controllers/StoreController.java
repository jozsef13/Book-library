package com.library.libraryService.controllers;

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

import com.library.libraryService.modules.OrderClass;
import com.library.libraryService.modules.OrderStatus;
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
	public static final String CONTRACT_BASE_URL = "/store";
	
	@PostMapping("/order")
	@ApiOperation(value = "Place an order", response = OrderClass.class)
	private OrderClass placeOrder(@ApiParam(value = "Order object to be added")@RequestBody OrderClass order)
	{
		storeService.placeOrder(order);
		return order;
	}
	
	@DeleteMapping("/DeleteOrder/{orderId}")
	@ApiOperation(value = "Delete an order", response = OrderClass.class)
	private String deleteOrderById(@ApiParam(value = "ID of the order to be deleted") @PathVariable int orderId)
	{
		storeService.delete(orderId);
		
		return "Order deleted successfully";
	}
	
	@GetMapping("/order/{orderId}")
	@ApiOperation(value = "Finds an order by its id", response = OrderClass.class)
	private OrderClass getOrderById(@ApiParam(value = "ID of the order to be returned") @PathVariable int orderId)
	{
		return storeService.findById(orderId);
	}
	
	@GetMapping("/allOrders")
	@ApiOperation(value = "Find all orders", response = OrderClass.class)
	private Hashtable<Integer, OrderClass> getAllOrders()
	{
		return storeService.findAll();
	}
	
	@GetMapping("/order/findByStatus/{status}")
	@ApiOperation(value = "Find orders by their status", response = OrderClass.class)
	private List<OrderClass> getOrdersByStatus(@ApiParam(value = "Status values for finding the orders") @PathVariable OrderStatus status)
	{
		return storeService.findByOStatus(status);
	}
	
	@PutMapping("/order/{orderId}/update")
	@ApiOperation(value = "Update orders", response = OrderClass.class)
	private String updateOrder(@ApiParam(value = "The ID of the order that will be updated") @PathVariable int orderId,@ApiParam("The updated order")@RequestBody OrderClass updatedOrder)
	{
		return storeService.updateOrder(orderId, updatedOrder);
	}
	
	@GetMapping("/usersOrders/{userId}")
	@ApiOperation(value = "Find orders by the users that placed the order")
	private List<OrderClass> getOrderByUserId(@ApiParam(value = "The ID of the user that placed the orders") @PathVariable int userId)
	{
		return storeService.findByUserId(userId);
	}
	
}
