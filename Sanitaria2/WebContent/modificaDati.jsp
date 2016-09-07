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

<title>Modifica Dati</title>

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
</style>
</head>
<body onload=" viewError();">

	<h2>Modifica Dati</h2>

	<div class="row" style="opacity: 1">
		<div class="col-md-3 colonna"></div>
		<div class="col-md-6 colonna">
			<div class="panel panel-default">
				<div class="panel-body">

					<form method="post" action="ModificaDati">
						
						<center><font color="#a94442"><label class="control-label" id="errore"></label> </font></center>

						<fieldset class="form-group">
						
							<legend>Dati Anagrafici</legend>


							<div class="form-group" id="nome">
								<label class="control-label">Nome </label>
								<input type="TEXT" class="form-control" name="nome" SIZE="25" VALUE="${paziente.nome}" placeholder="Nome"></input>
							</div>

							<div class="form-group" id="cognome">
								<label class="control-label">Cognome </label>
								<input type="TEXT" class="form-control" name="cognome" SIZE="25" VALUE="${paziente.cognome }" placeholder="Cognome"></input>
							</div>

							<div class="form-group" id="dataNascita">
								<label class="control-label">Data di nascita</label>
								<input type="date" class="form-control" name="dataNascita" VALUE="${paziente.formatDataNasForBS()}"	placeholder="dd/mm/yyyy">
							</div>

							<br>
								<label>Sesso:</label>
								<input class="form-check-input" type="radio" name="sesso" value="M" <c:if test = "${paziente.sesso eq 'M' }"><c:out value="checked='checked'"></c:out></c:if>> M
								<input class="form-check-input" type="radio" name="sesso" value="F"	<c:if test = "${paziente.sesso eq 'F' }"><c:out value="checked='checked'"></c:out></c:if>> F
								<br> <br>

							<div class="form-group">
								<label>Città Di Nascita</label>
								<select name="idCitta" class="form-control">
									<c:forEach items="${listaCitta}" var="citta" varStatus="status">
										<option value="${citta.idCitta }" <c:if test = "${citta.idCitta eq paziente.idCitta }"><c:out value="selected"></c:out></c:if>>${citta.nome}</option>
									</c:forEach>
								</select>
							</div>

							<div class="form-group" id="indirizzo">
								<label class="control-label">Indirizzo </label>
								<input type="TEXT" class="form-control" name="indirizzo" SIZE="25" VALUE="${paziente.indirizzo }" placeholder="Indirizzo"></input>
							</div>

							<div class="form-group" id="cf">
								<label class="control-label">Codice Fiscale </label> 
								<input type="TEXT" class="form-control" name="cf" SIZE="16" VALUE="${paziente.cf }" placeholder="Codice Fiscale"></input>
							</div>

							<br>

						</fieldset>

						<button type="submit" class="btn btn-primary">Invio</button>
						<button type="reset" class="btn btn-primary">Reset</button>

					</form>

				</div>

			</div>

		</div>
		<div class="col-md-3 colonna"></div>
	</div>

</body>

 	<script>
		function viewError(){
			
			var cf ="${errore[1]}";
 			var nome ="${errore[2]}";
			var cognome ="${errore[3]}";
			var indirizzo ="${errore[6]}";
			var dataNascita ="${errore[11]}";
			var errori = 0;

			if(cf=="true"){
				document.getElementById('cf').className="form-group has-error has-feedback";
				errori ++;
			}
			 
			if(nome=="true"){
				document.getElementById('nome').className="form-group has-error has-feedback";
				errori ++;
			}
			
			if(cognome=="true"){
				document.getElementById('cognome').className="form-group has-error has-feedback";
				errori ++;
			}
			
			if(indirizzo=="true"){
				document.getElementById('indirizzo').className="form-group has-error has-feedback";
				errori ++;
			}

			if(dataNascita=="true"){
				document.getElementById('dataNascita').className="form-group has-error has-feedback";
				errori ++;
			}
			
			if(errori>1)
				document.getElementById('errore').innerHTML = 'Alcuni campi sono errati';
			else if(errori==1)
				document.getElementById('errore').innerHTML = 'Un campo è errato'; 
			
		}
	</script>	
	
</html>