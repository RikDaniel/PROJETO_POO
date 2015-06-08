<?php
	include "conexao.php";

	$login = $_POST['login'];
	$senha = $_POST['senha'];
	$q = "	SELECT C.CPF_CLIENTE AS login, P.SENHA AS senha FROM CLIENTE C INNER JOIN PESSOA P ON C.CPF_CLIENTE=P.CPF_PESSOA
			WHERE
			concat(0,replace(C.CPF_CLIENTE,'\'','')) = concat(0,replace('$login','\'',''))
			AND
			concat(0,replace(P.SENHA,'\'','')) = concat(0,replace('$senha','\'',''))";
	$num_rows = mysql_num_rows(mysql_query($q));
	if ($num_rows == 1 ) {
		echo "logado.";
	} else {
		echo "deslogado.";
		if( isset($_POST['login'])){
			header("Location: index.php?error=301");
		}else{
			header("Location: index.php");
		}
	}
?>
