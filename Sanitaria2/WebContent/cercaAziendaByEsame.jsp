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

<script src="js/jquery.min.js"></script>

<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Seleziona Azienda</title>
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
<body>
	<h1>Sanitaria</h1>
	<br>
	<br>
	<br>
	<h2>Seleziona Azienda</h2>
	<br>
	<br>


	<div class="row" style="opacity: 1">
		<div class="col-md-3 colonna"></div>
		<div class="col-md-6 colonna">
			<div class="panel panel-default">
				<div class="panel-body">

					<c:choose>
						<c:when test="${not empty listaEsameAzienda}">
						
							<center>
								<table class="table table-striped">
									<thead>
										<tr>
											<th>Indice</th>
											<th>Azienda</th>
											<th>Citt�</th>
											<th>Costo Esame</th>
											<th>Prenota</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listaEsameAzienda}" var="esameAzienda"
											varStatus="status">
											<tr>
												<td><c:out value="${status.count}" /></td>
												<td><c:out value="${esameAzienda.nomeAzienda}" /></td>
												<td><c:out value="${esameAzienda.cittaAzienda}" /></td>
												<td><c:out value="${esameAzienda.costo}" /></td>
												
												<td><a class="btn btn-lg bottone center-block " href="PrenotazioneEsame?idEsame=<c:out value="${esameAzienda.idEsame}"/>&idAzienda=<c:out value="${esameAzienda.idAzienda}"/>&cittaAzienda=<c:out value="${esameAzienda.cittaAzienda}"/>" role="button">
												Prenota </a></td>
												<td>
											</tr>
										</c:forEach>

									</tbody>
								</table>
							</center>
							

						</c:when>
						<c:otherwise>
							<h4>Nessuna azienda trovata</h4>
						</c:otherwise>
					</c:choose>
					
					
							
					</div>
			</div>
			<a class="btn btn-lg bottone center-block "  href="CercaEsame" role="button">Torna a Cerca Esame Medico</a>	

			<div class="col-md-3 colonna"></div>
		</div>

	</div>

</body>
</html>