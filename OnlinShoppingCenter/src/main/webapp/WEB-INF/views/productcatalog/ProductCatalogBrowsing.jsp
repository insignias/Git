<%@ include file="/WEB-INF/views/common/CommonInclude.jsp" %>
<script src="<c:url value="resources/js/common/generalscript.js"/>" type="text/javascript"></script>
<body data-ng-controller="PanelController as panel">
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
				<!-- Search -->
				<div id="search">
						<input type="text" class="field" data-ng-model="query" />								
				</div>
				<!-- END Search -->				
			</div>
			<!-- END Header -->
			<!-- Navigation -->
			<div id="navigation">
				<ul class="nav nav-pills">
					<li class="first" data-ng-class="{active:panel.isSelected('home')}"> 
						<a data-ng-click="panel.selectTab('home')">Home</a>
					</li>
					<li data-ng-class="{active:panel.isSelected('sports')}">
						<a data-ng-click="panel.selectTab('sports')">Sports</a>
					</li>
					<li data-ng-class="{active:panel.isSelected('appliances')}"> 
						<a data-ng-click="panel.selectTab('appliances')">Appliances</a>
					</li>
					<li data-ng-class="{active:panel.isSelected('computers')}">
						<a data-ng-click="panel.selectTab('computers')">Computers</a>
					</li>
					<li data-ng-class="{active:panel.isSelected('clothes')}">
						<a data-ng-click="panel.selectTab('clothes')">Clothes</a>
					</li>
					<li data-ng-class="{active:panel.isSelected('books')}"> 
						<a data-ng-click="panel.selectTab('books')">Books</a>
					</li>
				</ul>				
				<div class="cl"></div>
			</div>
			<!-- END Navigation -->
			<!-- Main -->
			<div id="main">
				<div id="sidebar">
				<div class="box">
				<div class="products">
						<div class="title">
							<h2 style="width:210px">Your Shopping Cart</h2>
						</div>
						<div>
								<div class="row">																	
										<c:forEach var="item" items="${scb.getShoppingCartBeanList()}" step="1">
										<form:form action="RemoveCart" commandName="shoppingCart" method="POST">
											<div class="product-holder">
												<div class="product" >
													<form:input path='productId' value="${item.productId}" type="hidden"/> 
													<p><img src="${item.productURL}"/></p>
													<form:input path='productURL' value="${item.productURL}" type="hidden"/>
													<p>${item.productName}</p>
													<form:input path='productName' value="${item.productName}" type="hidden"/>
													<p>${item.productDescription}</p>
													<form:input path='productDescription' value="${item.productDescription}" type="hidden"/>
													<p>{{${item.productPrice} | currency}}</p>
													<form:input path='productPrice' value="${item.productPrice}" type="hidden"/>												 		
												 </div>
												 <input class="button" type='submit' value='Remove'></input>
											</div>  
											</form:form>									
										</c:forEach>
													
													<%-- <p>Total Price: {{${scb.totalPrice} | currency}}</p> --%>
												<form:form action="Checkout" method="POST">
													<input type='hidden' name='TotalPrice' value='${scb.getTotalPrice()}' id='totalPrice'/>
													Total Price: $${scb.getTotalPrice()}
													<c:if  test="${scb.totalPrice gt 0}"> 
													<p><input class="button" type='submit' name='submit' value='Check Out'></input></p>
													</c:if>
												</form:form>
								<div class="product-bottom"></div>
							</div>
						</div>	
							
						<div class="cl"></div>
					</div> 
				</div>
			</div>
				<!-- Content -->
				<div id="content">
					<!-- Products -->
					<div class="products">
						<div class="title">
							<h2>Product Catalog</h2>
						</div>
						<div >
								<div class="row">	
								<div data-ng-repeat="product in products | filter:query">
									<div class="product-holder">	
										<div class="product" >
										<form:form commandName="shoppingCart" action="addToCart" method="GET">
											<form:input path='productId' value="{{product.productID}}" type="hidden"/>
											<p>{{product.productName}}</p>
											<form:input path='productName' value="{{product.productName}}" type="hidden"/>
											<a><img data-ng-src="{{product.productURL}}" alt="Television stand" /></a>
											<form:input path='productURL' value="{{product.productURL}}" type="hidden"/>
											<table>
												<tr>
													<td><p style="float:left">{{product.productPrice | currency}}</p>
														<form:input path='productPrice' value="{{product.productPrice}}" type="hidden"/>
													</td>
													<td>
														<input style="float:right" class="button" type='submit' value='Add To Cart'></input>
													</td>													
												</tr>
												<tr>
													<td><p>{{product.productDescription}}</p>
														<form:input path='productDescription' value="{{product.productDescription}}" type="hidden"/>
													</td>
												</tr>
											</table>
									    </form:form>
										</div>	
										<div class="product-bottom"></div>
									</div>
								</div>
							</div>
						</div>
						<div class="cl"></div>
					</div>					
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
