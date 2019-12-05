package com.library.libraryClient.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.library.libraryClient.clients.StoreClient;
import com.library.libraryService.modules.OrderClass;
import com.library.libraryService.modules.OrderStatus;

@RestController
@RequestMapping(StoreClientController.CONTRACT_BASE_URL)
public class StoreClientController {

	@Autowired
	private StoreClient sc;
	public static final String CONTRACT_BASE_URL = "/store";
	
	@PostMapping("/order/bookId={bookId}&userId={userId}")
	public ModelAndView addOrder(OrderClass newOrder, @PathVariable(value = "bookId") int bookId, @PathVariable(value = "userId") int userId)
	{
		ModelAndView model = new ModelAndView("orderPlaced");
		newOrder.setoBookId(bookId);
		newOrder.setoUserId(userId);
		OrderClass order = sc.addOrder(newOrder);
		model.addObject(order);
		return model;
	}
	
	@GetMapping("/order/{orderId}")
	public ModelAndView getOrderById(@PathVariable int orderId, HttpSession session)
	{
		ModelAndView model = new ModelAndView("manageOrder");
		OrderClass orderById = sc.getOrderById(orderId);
		model.addObject("orderById", orderById);
		session.setAttribute("orderId", orderId);
		return model;
	}
	
	@GetMapping("/order/FindByStatus/{status}")
	public Collection<OrderClass> getOrderByStatus(@PathVariable OrderStatus status)
	{
		return sc.getOrderByStatus(status);
	}
	
	@GetMapping("/allOrders")
	public ModelAndView getAllOrders()
	{
		ModelAndView model = new ModelAndView("allOrders");
		List<OrderClass> orders = new ArrayList<OrderClass>(sc.getAllOrders());
		model.addObject("orders", orders);
		return model;
	}
	
	@PostMapping("/order/update/{orderId}")
	public ModelAndView updateOrderStatus(OrderClass updatedOrder, @PathVariable int orderId)
	{
		ModelAndView model = new ModelAndView("updatedOrder");
		updatedOrder.setoId(orderId);
		sc.updateOrder(orderId, updatedOrder);
		model.addObject(updatedOrder);
		return model;
	}
	
	@RequestMapping(value = "/deleteOrder/{orderId}")
	public ModelAndView deleteOrder(@PathVariable int orderId)
	{
		ModelAndView model = new ModelAndView("orderDeleted");
		sc.deleteOrder(orderId);
		return model;
	}
	
	@GetMapping("/usersOrders/{userId}")
	public ModelAndView getOrdersByUserId(@PathVariable int userId)
	{
		ModelAndView model = new ModelAndView("allOrders");
		model.addObject("orders", sc.getOrderByUserId(userId));
		
		return model;
	}
}
