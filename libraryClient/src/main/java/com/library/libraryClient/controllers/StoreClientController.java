package com.library.libraryClient.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.library.libraryClient.clients.BookClient;
import com.library.libraryClient.clients.StoreClient;
import com.library.libraryService.modules.Book;
import com.library.libraryService.modules.OrderClass;
import com.library.libraryService.modules.OrderStatus;

@RestController
@RequestMapping(StoreClientController.CONTRACT_BASE_URL)
public class StoreClientController {

	@Autowired
	private StoreClient sc;
	public static final String CONTRACT_BASE_URL = "/store";

	@PostMapping("/order/placeOrder/{userId}")
	public ModelAndView addOrder(OrderClass newOrder, @PathVariable(value = "userId") int userId) {
		ModelAndView model = new ModelAndView("orderPlaced");
		newOrder.setoUserId(userId);
		OrderClass order = sc.addOrder(newOrder);
		model.addObject(order);
		return model;
	}

	@GetMapping("/order/addToBasket/{bookId}")
	public ModelAndView addToBasket(@PathVariable("bookId") int bookId)
	{
		ModelAndView model = new ModelAndView("addedToBasket");
		sc.addToBasket(bookId);
		return model;
	}
	
	@GetMapping("/order/basket")
	public ModelAndView getBasket()
	{
		ModelAndView model = new ModelAndView("basket");
		List<Book> books = new ArrayList<Book>(sc.getBasket());
		model.addObject("books", books);
		return model;
	}
	
	@GetMapping("/order/{orderId}")
	public ModelAndView getOrderById(@PathVariable int orderId, HttpSession session) {
		ModelAndView model = new ModelAndView("manageOrder");
		OrderClass orderById = sc.getOrderById(orderId);
		model.addObject("orderById", orderById);
		session.setAttribute("orderId", orderId);
		return model;
	}

	@GetMapping("/order/FindByStatus/{status}")
	public Collection<OrderClass> getOrderByStatus(@PathVariable OrderStatus status) {
		return sc.getOrderByStatus(status);
	}

	@GetMapping("/allOrders")
	public ModelAndView getAllOrders() {
		ModelAndView model = new ModelAndView("allOrders");
		List<OrderClass> orders = new ArrayList<OrderClass>(sc.getAllOrders());
		model.addObject("orders", orders);
		return model;
	}

	@PostMapping("/order/update/{orderId}")
	public ModelAndView updateOrderStatus(OrderClass updatedOrder, @PathVariable int orderId, HttpSession session) {
		ModelAndView model = new ModelAndView("updatedOrder");
		updatedOrder.setoId(orderId);
		int userId = (int) session.getAttribute("userId");
		updatedOrder.setoUserId(userId);
		sc.updateOrder(orderId, updatedOrder);
		model.addObject(updatedOrder);
		return model;
	}

	@RequestMapping(value = "/deleteOrder/{orderId}")
	public ModelAndView deleteOrder(@PathVariable int orderId) {
		ModelAndView model = new ModelAndView("orderDeleted");
		sc.deleteOrder(orderId);
		return model;
	}

	@GetMapping("/usersOrders/{userId}")
	public ModelAndView getOrdersByUserId(@PathVariable int userId) {
		ModelAndView model = new ModelAndView("allOrders");
		model.addObject("orders", sc.getOrderByUserId(userId));

		return model;
	}
}
