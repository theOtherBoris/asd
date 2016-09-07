<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<script src="js/bootstrap.min.js"></script>
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />

<title>Cerca Azienda per Citt�</title>

<style>
body {
	background: transparent url('img/healthcare.png') no-repeat center
		center fixed;
	background-size: cover;
}

h1 {
	text-align: center;
	color: white;
}

h2 {
	text-align: center;
	color: white;
}

.bottone {
	background-color: white;
	color: grey;
	border: 2px solid grey;
	width: 200px;
	align: center;
}

.bottone:hover {
	background-color: silver; /* Green */
	color: white;
	border: 2px solid white;
	box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24), 0 17px 50px 0
		rgba(0, 0, 0, 0.19);
}
</style>
</head>
<body>
	<br>

	<h1>Cerca Azienda</h1>

	<br>
	<br>

	<div class="row" style="opacity: 0.9">
		<div class="col-md-3 colonna"></div>
		<div class="col-md-6 colonna">

			<div class="panel-body">



				<div style="padding-bottom: 20px">
					<label>
						<h1>Scegli la citt�</h1>
					</label>

					<form action="ListaAziende" method="get">
						<select class="form-control" name="citta" required="required">

							<c:forEach items="${listaCitta}" var="citta">

								<option value="${citta.idCitta}"><c:out value="${citta.nome}" /></option>

							</c:forEach>

						</select>
				</div>

				<button type="submit" class="btn btn-lg bottone">Cerca</button>

				</form>
			</div>
		</div>
	</div>
</body>
</html>