<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Home!</title>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.4.0/css/bulma.min.css" />
		<style>
			.container{
				margin-top:40px;
			}
		</style>
	</head>
	<body>
		<div class="container">
			<h2 class="title">GeoIP2 Precision</h2>
			<table class="table">
				<thead>
					<tr>
						<th>Organization</th>
						<th>IP address</th>
						<th>Country</th>
						<th>Subdivision</th>
						<th>City</th>
						<th>Postal</th>
						<th>Location</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ipAddress}" var="item">
					<tr>
						<td>
							<c:if test="${not empty item.traits.organization}">
							${item.traits.organization}<br/>
							ISP : ${item.traits.isp}
							</c:if>
							<c:if test="${empty item.traits.organization}">
							-
							</c:if>							
						</td>
						<td>${item.traits.ipAddress}</td>
						<td>${item.country.name }</td>
						<td>${item.subdivision.name}</td>
						<td>${item.city.name}</td>
						<td>${item.postal.code}</td>
						<td>
							${item.location.latitude}, ${item.location.longitude} <br/>
							accuracy : ${item.location.accuracyRadius}km
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<h2 class="title">GeoIP2 Lite Database</h2>
			<table class="table">
				<thead>
					<tr>
						<th>Organization</th>
						<th>IP address</th>
						<th>Country</th>
						<th>Subdivision</th>
						<th>City</th>
						<th>Postal</th>
						<th>Location</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ipAddress2}" var="item">
					<tr>
						<td>
							<c:if test="${not empty item.traits.organization}">
							${item.traits.organization}<br/>
							</c:if>
							ISP : ${item.traits.isp}					
							<c:if test="${empty item.traits.organization}">
							-
							</c:if>		
						</td>
						<td>${item.traits.ipAddress}</td>
						<td>${item.country.name }</td>
						<td>${item.subdivision.name}</td>
						<td>${item.city.name}</td>
						<td>${item.postal.code}</td>
						<td>
							${item.location.latitude}, ${item.location.longitude} <br/>
							accuracy : ${item.location.accuracyRadius}km
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>		
	</body>
</html>