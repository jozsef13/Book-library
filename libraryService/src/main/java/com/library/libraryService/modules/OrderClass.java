package com.library.libraryService.modules;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about an order")
public class OrderClass {

	@ApiModelProperty(notes = "The unique ID")
	private int oId;
	@ApiModelProperty(notes = "The ID of the book ordered")
	private int oBookId;
	@ApiModelProperty(notes = "How many copies of the book was ordered")
	private int oQuantity;
	@ApiModelProperty(notes = "The ship date")
	private String oShipDate = dateTime();
	@ApiModelProperty(notes = "Status of the order which can be Placed, Approved or Delivered")
	private OrderStatus oStatus = OrderStatus.Placed;
	@ApiModelProperty(notes = "The ID of the user that placed the order")
	private int oUserId;

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

	public int getoUserId() {
		return oUserId;
	}

	public void setoUserId(int oUserId) {
		this.oUserId = oUserId;
	}

	@Override
	public String toString() {
		return "OrderClass [oId=" + oId + ", oBookId=" + oBookId + ", oQuantity=" + oQuantity + ", oShipDate="
				+ oShipDate + ", oStatus=" + oStatus + ", oUserId=" + oUserId + "]";
	}

}
