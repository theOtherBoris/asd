<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<script src="js/jquery.min.js"></script>

<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/2.0.1/css/toastr.css" rel="stylesheet"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/2.0.1/js/toastr.js"></script>

<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />

<title>Home Page Utente</title>

	<style>
	body{margin:0 0 0 0; 
		background: url(img/back.png) no-repeat ;
		background-attachment:fixed; 
		 
		
		color: white;}
	h1{
		font-family:Monotype Corsiva, Times, serif;
		color: white;
		text-align:center;
		opacity:1;
		font-size: 3.3em;
		}
	.cornice{
		
		padding-bottom:2px;
		border: 5px solid  double;
		border-color:white;
		background:rgba(255, 255, 255, 0.4);
		border-style: double;
		border-width: 10px;
	}	
	

	
	.navbar-custom {
    background-color:white;
    color:blue;
    border-radius:0;
	}

	.navbar-custom .navbar-nav > li > a {
		color:black;
	}
	.navbar-custom .navbar-nav > .active > a, .navbar-nav > .active > a:hover, .navbar-nav > .active > a:focus {
		color:white;
		background-color:gray;
	}
	.navbar-custom .navbar-brand {
		
	}	
	
	.padding{
	padding-top:50px;
	}
	
	p{
	
	color:white;
	text-align:center;
	font-size: 1.5em;
	}
	
	.bottone{
	background-color: white;
    color: grey;
    border: 2px solid grey;
	width: 250px;
	align:center;

	
	}
	
	.bottone:hover {
    background-color: silver; /* Green */
    color: white;
	border: 2px solid white;
	box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
}
	
	</style>	

</head>
<body onload="showMessage();">
		
<nav class="navbar navbar-default navbar-custom navbar-fixed-top">
  <div class="container-fluid">
    
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      
    </div>

    
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-left">
	  
        <li class="active "><a href="HomePageUtente"><span class="glyphicon glyphicon-home"></span>  Home <span class="sr-only">(current)</span></a></li>
        <li class="dropdown">
          <a href="" class="dropdown-toggle " data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> Gestione Profilo Utente<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="ModificaDati">Modifica Dati</a></li>
            <li class="divider"></li>
            <li><a href="ModificaPassword">Modifica Password</a></li>
            <li class="divider"></li>
			<li><a href="CercaStorico">Storico Prenotazioni</a></li>
			<li class="divider"></li>
			<li><a href="PrenotazioniAttive">Prenotazioni Attive</a></li>
           </ul>
        </li>
		<li class="divider"></li>
		<li><a  href="CercaEsame">Cerca Esame</a></li>
		<li class="divider"></li>
		<li><a  href="CercaAzienda">Cerca Azienda</a></li>
		</ul>
		
		<ul class="nav navbar-nav navbar-right">
			<li><a> <c:out value="${nome}"/></a></li>
			<li class="divider"></li>
			<li><a href="Logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
		</ul>

    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
		
		<div style="padding-top:180px">
		</div>
		
		<div class="row">
		<div class=" col-md-3 col-sm-3 col-xs-1">
		</div>
		<div class=" col-md-6 col-sm-6 col-xs-10 cornice" >
		
		<h1><big>Sanitaria.it</big></h1>
		
		</div>
		
		<div class=" col-md-3 col-sm-3 col-xs-1">
		</div>
		</div>
		
		<div class="row">
		
		<div class=" col-md-3 col-sm-2 ">
		</div>
			<div class=" col-md-6 col-sm-8 col-xs-12 " style="padding-top:100px">
		
			<p><big>Benvenuto <c:out value="${nome}"/></big><br> 
				<span style="font-size: 1em;"><i>Prenota la tua prossima visita medica da noi</i></span>
			</p>
				<div class="padding">
				<a class="btn btn-lg bottone center-block "  href="CercaEsame" role="button">Cerca Esame Medico</a>
				</div>
			</div>
		<div class=" col-md-3 col-sm-2 ">
		</div>
		</div>

		<footer style="padding-top:50px">
		</footer>
</body>

<script src="js/bootstrap.min.js" >
</script>
<script type="text/javascript">
function showMessage(){
	var esami = "${esami}";
	
    toastr.options = {
    		  "closeButton": true,
    		  "showDuration": "4500",
    		  "positionClass": "toast-top-right"
    		  }
    toastr.warning('Oggi devi sostenere '+esami+" esami");	
}
</script>
</html>