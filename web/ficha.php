<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Ficha Do Cliente</title>
	</head>

	<body bgcolor="#cccccc">
	<?php
	include "conexao.php";
	include "confirmar_login.php";
	$q = "
	SELECT 
		C.CPF_CLIENTE AS C_CPF,
		P.CPF_PESSOA AS P_CPF,
		P.NOME AS P_NOME,
		P.TELEFONE AS P_TELEFONE,
		P.GENERO AS P_GENERO,
		P.SENHA AS P_SENHA,
		A.ID_ANIMAL AS A_ID,
		A.NASCIMENTO AS A_NASCIMENTO,
		A.TIPO AS A_TIPO,
		A.RACA AS A_RACA,
		A.NOME AS A_NOME,
		F.ID_FICHA AS F_ID,
		F.AGENDAMENTO AS F_AGENDAMENTO,
		F.DIAGNOSTICO AS F_DIAGNOSTICO
	FROM
		(CLIENTE C
		INNER JOIN PESSOA P ON C.CPF_CLIENTE=P.CPF_PESSOA)
		LEFT JOIN ANIMAL A ON C.CPF_CLIENTE = A.CPFCLIENTE
		LEFT JOIN FICHA F ON C.CPF_CLIENTE = F.CPFCLIENTE AND A.ID_ANIMAL=F.IDANIMAL
	WHERE C.CPF_CLIENTE = $login";
	$query = mysql_query($q)or die(mysql_error());
	$ResultSet = mysql_fetch_array($query);
	?>
	<form style="background:#cccccc" name="form1"  >
	<h2>Informações do Cliente</h2>
		<table width="800" border="0">
		<tbody>
			<tr>
				<td align="right" width="100">CPF:</td>
				<td align="left"><?php echo $ResultSet['P_CPF'];?></td>
			</tr>
			<tr>
				<td align="right" width="100">Nome:</td>
				<td align="left"><?php echo $ResultSet['P_NOME'];?></td>
			</tr>
		</tbody>
		</table>
		<p></p>
		<h2>Pets</h2>
		<table width="800" border="1">
			<tbody>
				<tr bgcolor="#D5D5D5">
					<th width="50" scope="col">Código Animal</th>
					<th width="150" scope="col">Nome</th>
					<th width="150" scope="col">Tipo</th>
					<th width="50" scope="col">Ficha</th>
					<th width="100" scope="col">Agendamento</th>
					<th  scope="col">Diagnostico</th>
				</tr>
				<?php 
				$queryTab = mysql_query($q) or die(mysql_error());
				while($arrayTab = mysql_fetch_array($queryTab)){
				?>
				<tr>
					<td align="center"><p><?php echo $arrayTab['A_ID'] ?></p></td>
					<td align="center"><p><?php echo $arrayTab['A_NOME'] ?></p></td>
					<td align="center"><p><?php echo $arrayTab['A_TIPO']." - ".$arrayTab['A_RACA'] ?></p></td>
					<td align="center"><p><?php echo $arrayTab['F_ID'] ?></p></td>
					<td align="center"><p><?php echo $arrayTab['F_AGENDAMENTO'] ?></p></td>
					<td align="center"><p><?php echo $arrayTab['F_DIAGNOSTICO'] ?></p></td>
				</tr>
				<?php
				}
				?>
			</tbody>
		</table>
	</form>
	</body>
</html>
