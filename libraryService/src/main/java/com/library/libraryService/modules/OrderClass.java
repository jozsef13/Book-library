package com.library.libraryService.modules;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrderClass {

	private int oId;
	private int oBookId;
	private int oQuantity;
	private String oShipDate = dateTime();
	private OrderStatus oStatus = OrderStatus.Placed;
	
	private String dateTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate local = LocalDate.now();
		LocalDate shipDay = local.plusDays(3);
		return dtf.format(shipDay);
	}

	public int getoId() {
		return oId;
	}

	public void setoId(int oId) {
		this.oId = oId;
	}

	public int getoBookId() {
		return oBookId;
	}

	public void setoBookId(int oBookId) {
		this.oBookId = oBookId;
	}

	public int getoQuantity() {
		return oQuantity;
	}

	public void setoQuantity(int oQuantity) {
		this.oQuantity = oQuantity;
	}

	public String getoShipDate() {
		return oShipDate;
	}

	public void setoShipDate(String oShipDate) {
		this.oShipDate = oShipDate;
	}

	public OrderStatus getoStatus() {
		return oStatus;
	}

	public void setoStatus(OrderStatus oStatus) {
		this.oStatus = oStatus;
	}

	@Override
	public String toString() {
		return "OrderClass [oId=" + oId + ", oBookId=" + oBookId + ", oQuantity=" + oQuantity + ", oShipDate="
				+ oShipDate + ", oStatus=" + oStatus + "]";
	}

}
