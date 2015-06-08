<?php
 
//nome ou ip do servidor
$servidor = "localhost";
 
//usuario do bd
$user = "poo_pet";
 
//senha do bd
$senha = "poo_pet";
 
//nome da base de dados
$db = "poo_pet";
 
//executa a conexão com o banco, caso contrário mostra o erro ocorrido
$conexao = mysql_connect($servidor,$user,$senha) or die (mysql_error());
 
//seleciona a base de dados daquela conexão, caso contrário mostra o erro ocorrido
$banco = mysql_select_db($db, $conexao) or die(mysql_error());
 ?>
