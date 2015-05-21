<%@ include file="/WEB-INF/views/common/CommonInclude.jsp" %>

<body>
	<div class="shell" >	
		<div id="wrapper-top"></div>
		<!-- Wrapper Middle -->
		<div id="wrapper-middle">
			<!-- Header -->
			<div id="header">
				<h1>Online Shopping Center</h1>
				<br>
				<br>
				<h2>Delivery at your <span>doorstep</span></h2>			
			</div>
			
			<!-- Main -->
			<div id="main">
				<!-- Slider -->
				
				<!-- END Slider -->
				<!-- Sidebar -->
				
				<!-- END Sidebar -->
				<!-- Content -->
				<div id="content">
					<!-- Products -->
					<div class="products">
						<div class="title">
							<h2>Products In Your Cart</h2>
												<div class="title-link">
													<input type="hidden" name="productID" id="productID" value=""/>
													<h4>Total Price: {{${sc.getTotalPrice()} | currency}}</h4>
												</div>
						</div>
						<div>
								<div class="row">
								<c:forEach var="item" items="${sc.getShoppingCartBeanList()}" step="1"> 
								<form:form action="RemoveShoppingCart" commandName="shoppingCart" method="POST">
									<div class="product-holder">	
										<div class="product" >
											<p><img src="${item.productURL}"/></p>
											<p>${item.productName}</p>
											<p>${item.productDescription}</p>
											<p>{{${item.productPrice} | currency}}</p> 
										</div>	
										<form:input path='productId' value="${item.productId}" type="hidden"/> 
										<form:input path='productURL' value="${item.productURL}" type="hidden"/>
										<form:input path='productName' value="${item.productName}" type="hidden"/>
										<form:input path='productDescription' value="${item.productDescription}" type="hidden"/>
										<form:input path='productPrice' value="${item.productPrice}" type="hidden"/>
										<input class="button" type='submit' value='Remove'></input>
										<div class="product-bottom"></div>
									</div>
								</form:form>
								</c:forEach> 
												
							</div>
												<form:form action="Checkout" method="POST">
														<input type='hidden' name='TotalPrice' value='${sc.totalPrice}' id='totalPrice'/>
														<c:if  test="${sc.totalPrice gt 0}"> 
														<input class="button" type='submit' name='submit' value='Check Out' style="width: 200px; "></input>
														</c:if>
												</form:form>
						</div>	
							
						<div class="cl"></div>
					</div>
					<!-- END Products -->
					<!-- Products -->
							
					<!-- END Products -->
				</div>
				<!-- END Content -->
				<div class="cl"></div>
			</div>
			<!-- END Main -->
		</div>
		<!-- END Wrapper Middle -->
		<div id="wrapper-bottom"></div>	
		
	</div>
</body>
<!-- </html> -->