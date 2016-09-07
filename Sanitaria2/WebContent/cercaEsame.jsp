<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<script src="js/bootstrap.min.js"></script>


<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Cerca Esame</title>

<style>
body {
	background: transparent url('img/esami.jpg') no-repeat center center
		fixed;
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
</style>
</head>
<body>

	<h1>Sanitaria</h1>
	<br><br><br>
	<h2>Cerca Esame da Prenotare</h2>
	<br><br>


	<div class="row" style="opacity: 1">
		<div class="col-md-3 colonna"></div>
		<div class="col-md-6 colonna">
			<div class="panel panel-default">
				<div class="panel-body">
					<form action="CercaEsame" method="post">
						<div class="form-group">
							<label>Seleziona Esame</label>
							 <select name="idEsame"	class="form-control">

								<c:forEach items="${listaEsame}" var="i" varStatus="status">

									<option value="${i.idEsame}"><c:out value="${i.nome}" /></option>

								</c:forEach>
							</select>
						</div>
						<button type="submit" class="btn btn-primary">Invio</button>
						<button type="reset" class="btn btn-primary">Reset</button>
				</form>
				
				
				

				</div></div>

			<div class="col-md-3 colonna"></div>
		</div>

	</div>
</body>
</html>