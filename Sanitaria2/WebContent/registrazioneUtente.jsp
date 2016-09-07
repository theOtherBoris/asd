<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/bootstrap-theme.min.css">
		<script src="js/bootstrap.min.js"></script>
		<script src="js/jquery.min.js"></script>

		<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />

		<title>Registrazione Paziente</title>

		<style>
body{
	background: transparent url('img/back.png') no-repeat center center fixed;
	background-size: cover;
				
	}

h1 {
	text-align:center;
	color:white;
	}
			
h2 {
	text-align:center;
	color:white;
}
#pannello {
		border-radius: 12px;
}
			
		</style>
	</head>

	<body onload=" viewError();">
	
	<h1>Sanitaria</h1>
	<h2>Registrazione Utente</h2>
	
		<div class="row" style="opacity:1">
			<div class="col-md-3 col-sm-2 col-xs-1 colonna" >
			</div>
			<div class="col-md-6 col-sm-8 col-xs-10 colonna" >
				<div class="panel panel-default" id="pannello">
					<div class="panel-body"> 
		  	
					<form method="post" action="Registrazione">
					<center><font color="#a94442"><label class="control-label" id="errore"></label> </font></center>
				
					<fieldset class="form-group">
					<legend>Dati Anagrafici</legend>
					
					
					<div class="form-group" id="nome">
						<label class="control-label" >Nome </label> 
						<input type="TEXT" class="form-control" name="nome" SIZE="25" VALUE="" placeholder="Nome"  ></input>
					</div>
					
					<div class="form-group" id="cognome">
						<label class="control-label" >Cognome </label>
						<input type="TEXT" class="form-control" name="cognome" SIZE="25" VALUE="" placeholder="Cognome"  ></input>
					</div>
					
					<div class="form-group" id="indirizzo">
						<label class="control-label" >Indirizzo </label>
						<input type="TEXT" class="form-control" name="indirizzo" SIZE="25" VALUE="" placeholder="Indirizzo" ></input>
					</div>
					
					<div class="form-group" id="cf">
						<label class="control-label" >Codice Fiscale </label>
						<input type="TEXT" class="form-control" name="cf" SIZE="16" VALUE="" placeholder="Codice Fiscale"  ></input>
					</div>
					
					<div class="form-group" id="dataNascita">
						<label class="control-label" >Data di nascita</label>
						<input type="date" class="form-control" name="dataNascita"  placeholder="mm/dd/yyyy" >
					</div>
					<br>
					
					<label>Sesso:</label>
					<label class="form-check-inline">
					  <input class="form-check-input" type="radio" name="sesso"  value="M"  checked = "checked"> M     
					</label>
					<label class="form-check-inline">
					  <input class="form-check-input" type="radio" name="sesso" value="F"> F
					</label> 
					<br>
					  <div class="form-group" id="citta">
						<label class="control-label" > Citt�</label>
						<select class="form-control" name="citta">
						
						<option value="0" >Selezionare una citt�</option>
						
						<c:forEach items="${listaCitta}" var="i" varStatus="status">
						
						  <option value="${i.idCitta}"><c:out value="${i.nome}"/></option>
						  
						</c:forEach>
												  
						</select>
					  </div>
					
										
					</fieldset>
					
					<fieldset class="form-group">
					<legend>Credenziali d'accesso</legend>
					
					  <div class="form-group" id="email">
						<label class="control-label" >Email address</label>
						<input type="email" class="form-control" name="email" aria-describedby="emailHelp" placeholder="Email" >
						
					  </div>

					  <div class="form-group" id="password">
						<label class="control-label"  >Password</label>
						<input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password" >
					  </div>
					  <div class="form-group" id="confirmPassword">
						<label class="control-label" >Conferma Password</label>
						<input type="password" name="confirmPassword" class="form-control" id="exampleInputPassword1" placeholder="Conferma Password" >
					  </div>  
					</fieldset>  
						  
					  <button type="submit" class="btn btn-primary">Invio</button>
					  <button type="reset" class="btn btn-primary">Reset</button>  
					</form>	
		  </div>
					
				</div>
			</div>	
				<div class="col-md-3 col-sm-2 col-xs-1 colonna" >
				
				</div>
			</div>
	</body>
 	<script>
		function viewError(){
			
			var cf ="${errori[1]}";
			var nome ="${errori[2]}";
			var cognome ="${errori[3]}";
			var email ="${errori[4]}"; //email formato errato
			var password ="${errori[5]}";
			var indirizzo ="${errori[6]}";
			var citta ="${errori[7]}";
			var email2 ="${errori[8]}"; //email gia presente	
			var data ="${errori[11]}";
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
			
			if(email=="true"){
				document.getElementById('email').className="form-group has-error has-feedback";
				errori ++;
			}
			
			if(password=="true"){
				document.getElementById('password').className="form-group has-error has-feedback";
				document.getElementById('confirmPassword').className="form-group has-error has-feedback";
				errori ++;
			}
			
			if(indirizzo=="true"){
				document.getElementById('indirizzo').className="form-group has-error has-feedback";
				errori ++;
			}
			
			if(citta=="true"){
				document.getElementById('citta').className="form-group has-error has-feedback";
				errori ++;
			}
			
			if(email2=="true"){
				document.getElementById('email').className="form-group has-error has-feedback";
				errori ++;
			}
			
			if(data=="true"){
				document.getElementById('dataNascita').className="form-group has-error has-feedback";
				errori ++;
			}
			
			if(errori>2)
				document.getElementById('errore').innerHTML = 'Alcuni campi sono errati';
			else if(errori>1 & errori<2)
				document.getElementById('errore').innerHTML = 'Un campo � errato';
			
		}
	</script>	
</html>