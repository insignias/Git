<%@ include file="/WEB-INF/views/common/CommonInclude.jsp" %>
<link href="<c:url value="/resources/css/common/GeneralStyle.css" />" rel="stylesheet">
<div class="wrapper">
			<h1>Online Shopping Center</h1>
			<br>
			<br>
			<h2>Delivery at your <span>doorstep</span></h2>
			<div class="content">
				<div id="form_wrapper" class="form_wrapper">
					<h3>Registration Details:</h3>								
																
						<div class="row">
							<table>
								<tr><td><h4>User Details:</h4></td></tr>
								<tr>
									<td><label><b>USERNAME: </b></label></td><td><label>${implLoginUserBean.username}</label></td>
								<tr>			
								<tr>
									<td><label><b>EMAIL: </b></label></td><td><label>${implLoginUserBean.email}</label></td>
								</tr>					
								<tr>
									<td><label><b>CONTACT NUMBER: </b></label></td><td><label>${implLoginUserBean.contactNumber}</label></td>	
								</tr>
							</table>
						</div>	
						
						<div class="clear"></div>
							<div class="bottom">
								<form:form method="GET" action="logout" >
									<input type="submit" name="submit" value="Return to Login Page"/>
								</form:form>							
								<div class="clear"></div>
						</div>
					
				</div>
				<div class="clear"></div>
			</div>
		</div>