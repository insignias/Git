<%@ include file="/WEB-INF/views/common/CommonInclude.jsp" %>
<link href="<c:url value="/resources/css/common/GeneralStyle.css" />" rel="stylesheet">
<div class="wrapper">
			<h1>Online Shopping Center</h1>
			<br>
			<br>
			<h2>Delivery at your <span>doorstep</span></h2>
			<div class="content" >
				
				<div id="form_wrapper" class="form_wrapper">
						<form:form method="POST" commandName="implPaymentBean" action="StorePayment" >
						<!-- <form name="paymentForm" novalidate>  -->
							<h3>Pay Your bill:</h3>						
										<div class="column">
											<div>
												<label>Account Holder Name: <form:errors path="accountHolderName" cssStyle="color:#ff0000"></form:errors></label>
												<form:input path="accountHolderName"/>
												 
											</div>
											<div>
												<label>Card Type:</label>
												<form:select path="cardType">
													<form:option value="Visa"></form:option>
													<form:option value="Master"></form:option>
												</form:select>
											</div>							
											<div>
												<label>Card Number: <form:errors path="cardNumber" cssStyle="color:#ff0000"></form:errors></label>
												<form:input path="cardNumber" maxlength="16" size="16"/>
												 
											</div>
											<div>
												<label>Security Code: <form:errors path="securityCode" cssStyle="color:#ff0000"></form:errors></label>
												<form:input path="securityCode" maxlength="3" size="3"/>
												
											</div>
											<div>
												<label>Expiration Date: <form:errors path="expiryMonthYear" cssStyle="color:#ff0000"></form:errors></label>
												<form:input type="month" path="expiryMonthYear"/>
											</div>
										
											<div>
												<label>Billing Address 1: <form:errors path="implBillingAddressBean.billingAddress1" cssStyle="color:#ff0000"></form:errors></label>
												<form:input path="implBillingAddressBean.billingAddress1" maxlength="40" size="40"/>
												 
											</div>
											<div>
												<label>Billing Address 2: <form:errors path="implBillingAddressBean.billingAddress2" cssStyle="color:#ff0000"></form:errors></label>
												<form:input path="implBillingAddressBean.billingAddress2" maxlength="40" size="40"/>
												 
											</div>							
											<div>
												<label>City: <form:errors path="implBillingAddressBean.city" cssStyle="color:#ff0000"></form:errors></label>
												<form:input path="implBillingAddressBean.city"/>
												 
											</div>
											<div>
												<label>State: <form:errors path="implBillingAddressBean.state" cssStyle="color:#ff0000"></form:errors></label>
												<form:input path="implBillingAddressBean.state"/>
												 
											</div>
											<div>
												<label>Country: <form:errors path="implBillingAddressBean.country" cssStyle="color:#ff0000"></form:errors></label>
												<form:input path="implBillingAddressBean.country"/>
												 
											</div>
											<div>
												<label>Pincode: <form:errors path="implBillingAddressBean.pincode" cssStyle="color:#ff0000"></form:errors></label>
												<form:input path="implBillingAddressBean.pincode" maxlength="8" size="8"/>
												 
											</div>
										</div>
										<div class="bottom">
											<input type ="submit" name="submit" value="Pay Your Bill" />
											<div class="clear"></div>
										</div>
								<!-- </form> -->
						</form:form>
				</div>
				<div class="clear"></div>
				
			</div>
		</div>