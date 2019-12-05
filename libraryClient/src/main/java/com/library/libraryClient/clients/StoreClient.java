package com.library.libraryClient.clients;

import java.util.Collection;
import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import com.library.libraryService.modules.OrderClass;
import com.library.libraryService.modules.OrderStatus;

@Component
public class StoreClient {

	@Autowired
	private RestOperations restOperations;
	private String url;
	
	@Autowired
	public StoreClient(@Value("${service.url}") String url) {
		this.url = url;
	}
	
	public OrderClass getOrderById(int orderId)
	{
		final String uri = url + "store/order/" + orderId;
	
		return restOperations.getForObject(uri, OrderClass.class);
	}
	
	public Collection<OrderClass> getAllOrders()
	{
		final String uri = url + "store/allOrders";
		
		Hashtable<Integer, OrderClass> orders = restOperations.getForObject(uri, Hashtable.class);
		Collection<OrderClass> ordersList = orders.values();
		
		return ordersList;
	}
	
	public OrderClass addOrder(OrderClass newOrder)
	{
		final String uri = url + "store/order";
		
		return restOperations.postForObject(uri, newOrder, OrderClass.class);
	}
	
	public Collection<OrderClass> getOrderByStatus(OrderStatus status)
	{
		final String uri = url + "store/order/findByStatus/" + status;
		
		Hashtable<Integer, OrderClass> orders = restOperations.getForObject(uri, Hashtable.class);
		Collection<OrderClass> ordersList = orders.values();
		
		return ordersList;
	}

	public void updateOrderStatus(int orderId, OrderClass updatedOrder) {
		final String uri = url + "store/order/" + orderId + "/update";
		
		restOperations.put(uri, updatedOrder); 
	}

	public void deleteOrder(int orderId) {
		final String uri = url + "store/DeleteOrder/" + orderId;
		
		restOperations.delete(uri);
	}	
}
