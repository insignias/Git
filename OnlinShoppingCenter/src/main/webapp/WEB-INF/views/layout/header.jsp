<%@ include file="/WEB-INF/views/common/CommonInclude.jsp" %>

	<div id="top-navigation">
			<p>
			<a class="checkout" title="Product Catalog" href="addToCart">Product Catalog</a>
			<a class="checkout" title="Shopping Cart" href="ProductDescription">Shopping Cart</a>
			<a class="checkout" title="Log Out" href="logout">Log Out</a>
			</p>
	</div>
	<div class="welcome-message">
		<p>Welcome ${sessionScope.loginUserName} !!</p>
	</div>
