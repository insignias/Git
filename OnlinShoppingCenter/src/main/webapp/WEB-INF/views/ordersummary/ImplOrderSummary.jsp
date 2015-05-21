<%@ include file="/WEB-INF/views/common/CommonInclude.jsp" %>
<link href="<c:url value="/resources/css/common/GeneralStyle.css" />" rel="stylesheet">
<div class="wrapper">
			<h1>Online Shopping Center</h1>
			<br>
			<br>
			<h2>Delivery at your <span>doorstep</span></h2>
			<div class="content">
				<div id="form_wrapper" class="form_wrapper">
							<h3>Order Summary:</h3>										
																	
									<div class="row">
										<table>
											<tr><td><h4>Billing Details:</h4></td></tr>
											<tr>
												<td><label><b>Payment Id: </b></label></td><td><label>${orderSummaryInfo.implPaymentBean.paymentId}</label></td>
											<tr>			
											<tr>
												<td><label><b>Account Holder Name: </b></label></td><td><label>${orderSummaryInfo.implPaymentBean.accountHolderName}</label></td>
												
											</tr>
											<tr>
												<td><label><b>Card Type: </b></label></td><td><label>${orderSummaryInfo.implPaymentBean.cardType}</label></td>
													
											</tr>							
											<tr>
												<td><label><b>Card Number: </b></label></td><td><label>${orderSummaryInfo.implPaymentBean.cardNumber}</label></td>
													
											</tr>
											<tr>
												<td><label><b>Expiration Date(YYYY-MM): </b></label></td><td><label>${orderSummaryInfo.implPaymentBean.expiryMonthYear}</label></td>
											</tr>
										</table>
									</div>	
									<div class="row">
										<table>
											<tr><td><h4>Shipping Address Details:</h4></td></tr>
										</table>
											<div class="column">
												<table>
													<tr>
														<td><label><b>Shipping Address Id: </b></label></td><td><label>${orderSummaryInfo.billingAddressBean.billingAddressID}</label></td>
													</tr>	
													<tr>
													
														<td><label><b>Street Address: </b></label></td><td><label>${orderSummaryInfo.billingAddressBean.billingAddress1}, ${orderSummaryInfo.billingAddressBean.billingAddress2}</label></td>
														
													</tr>							
													<tr>
														<td><label><b>Pin Code: </b></label></td><td><label>${orderSummaryInfo.billingAddressBean.pincode}</label></td>
														
													</tr>
												</table>
											</div>
											<div class="column">
												<table>
													<tr>
														<td><label><b>City: </b></label></td><td><label>${orderSummaryInfo.billingAddressBean.city}</label></td>
													</tr>
													<tr>
														<td><label><b>State: </b></label></td><td><label>${orderSummaryInfo.billingAddressBean.state}</label></td>
													</tr>
													<tr>
														<td><label><b>Country: </b></label></td><td><label>${orderSummaryInfo.billingAddressBean.country}</label></td>	
													</tr>
												</table>
											</div>
										</div>
									<div class="row">
										<table>
											<tr><td><h4>Order Details:</h4></td></tr>
											<tr>
												<td><label><b>Order ID: </b></label></td><td><label>${orderSummaryInfo.orderBean.orderId}</label></td>
											</tr> 
										</table>
											<c:forEach var="product" items="${orderSummaryInfo.orderBean.productIDList}">
												
													<table>
														<tr>
															<th><label>Product Name: </label></th><td><label>${product.prodName}</label></td>
														<tr>
													
												
														<tr>
															<td><label><b>Product Description: </b></label></td><td><label>${product.prodDesc}</label></td>
														<tr>
													
												
														<tr>
															<td><label><b>Product Price: </b></label></td><td><label>${product.price}</label></td>	
														<tr>
													</table> 									
												
											</c:forEach>
											<div class="row">		
												<table>
													<tr>
														<td><label><b>Creation Date: </b></label></td><td><label>${orderSummaryInfo.orderBean.creationDate}</label></td>
													</tr>												
													<tr>
														<td><label><b>Order Status: </b></label></td><td><label>${orderSummaryInfo.orderBean.status}</label></td>
													</tr>												
													<tr>
														<td><label><b>Total Price: </b></label></td><td><label>${orderSummaryInfo.orderBean.totalPrice}</label></td>
													</tr>	
												</table>
												
											</div> 
									</div>
									<div class="clear"></div>
										<div class="bottom">
											<form:form method='POST' action='confirmOrder' >
												<input type ="submit" name="submit" value="Confirm Order"/>
											</form:form>
												<input type ="submit" name="submit" onclick="popup();"  value="Generate Billing Summary"/>	
											<div class="clear"></div>
										</div>
				</div>
				<div class="clear"></div>
			</div>
		</div>