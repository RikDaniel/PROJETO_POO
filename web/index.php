<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
		<title> Área restrita</title>
	<style type = "text/css">
		#area-admin{
			margin: 0 auto;
			width: 400px;
			height:200px;
			padding:5px;
			font-size: 20px;
			background-color: #999999;
			margin-top: 40px;
			border: 2px solid #111111;
			vertical-align: middle;
			}
		#cpainel{
			margin: 0 auto;
			width: 400px;
			height:200px;
			padding:5px;
			font-size: 70px; 
			margin-top: 70px;
			vertical-align: middle;			
		
				}
		#separe{
			color:#999999;
			}
	</style>
	
	<script type = "text/javascript">	
		window.onload = function Login(){
		<?php
			if( isset($_GET['error'])){
				echo 'alert("Login inválido");';
				echo 'window.location="index.php";';
			}
		?>
	}
	
	</script>
	</head>
	
	<body bgcolor=#ccffff oncontextmenu='return false' onselectstart='return false' ondragstart='return false'>
	<div id="cpainel"> <img src="sw4.bmp"> PooPet </div>
	<div id="area-admin">
			<form name="login" method="POST" action="ficha.php">
			<div align="center">Usuário: <div align="center"><input name="login" type="text" id="login"></div></div>
			<div align="center">Senha:  <div align="center"> <input name="senha" type="password" id="senha"></div></div>
			<p></p>
			<div align="center"><input name="entrar" type="submit" id="entrar" value="Entrar"></div>
		</form>
	</div>
	</body>
</html>
