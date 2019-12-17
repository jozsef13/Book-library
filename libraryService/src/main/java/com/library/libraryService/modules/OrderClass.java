package com.library.libraryService.modules;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about an order")
public class OrderClass {

	@ApiModelProperty(notes = "The unique ID")
	private int oId;
	@ApiModelProperty(notes = "The IDs of the books ordered")
	private List<Integer> oBooksId;
	@ApiModelProperty(notes = "The ship date")
	private String oShipDate = dateTime();
	@ApiModelProperty(notes = "Status of the order which can be Placed, Approved or Delivered")
	private OrderStatus oStatus = OrderStatus.Approved;
	@ApiModelProperty(notes = "The ID of the user that placed the order")
	private int oUserId;
	@ApiModelProperty(notes = "The total price of the order")
	private double oTotalSum;

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

	public List<Integer> getoBooksId() {
		return oBooksId;
	}

	public void setoBooksId(List<Integer> oBooksId) {
		this.oBooksId = oBooksId;
	}

	public double getoTotalSum() {
		return oTotalSum;
	}

	public void setoTotalSum(double oTotalSum) {
		this.oTotalSum = oTotalSum;
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
		return "OrderClass [oId=" + oId + ", oBooksId=" + oBooksId + ", oShipDate=" + oShipDate + ", oStatus=" + oStatus
				+ ", oUserId=" + oUserId + ", oTotalSum=" + oTotalSum + "]";
	}

}
