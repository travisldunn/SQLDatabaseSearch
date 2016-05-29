<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="view.css">
<title>View</title>
</head>
<body>
		<header>
			<h1>Check-A-Base</h1>
		</header>
				<div>
					<h1 class="subheader">Results</h1>
				</div>
				<div>
					<table>
						<tbody>
							<c:forEach var="row" items="${result}">
								<tr>
									<c:forEach var="col" items="${row}">
										<td>${col}</td>
									</c:forEach>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
</body>
</html>
