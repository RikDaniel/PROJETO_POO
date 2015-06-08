-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.34-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema poo_pet
--

CREATE DATABASE IF NOT EXISTS poo_pet;
USE poo_pet;

--
-- Definition of table `animal`
--

DROP TABLE IF EXISTS `animal`;
CREATE TABLE `animal` (
  `ID_ANIMAL` int(11) NOT NULL DEFAULT '0',
  `NASCIMENTO` date DEFAULT NULL,
  `TIPO` varchar(20) NOT NULL,
  `RACA` varchar(30) NOT NULL,
  `NOME` varchar(30) NOT NULL,
  `CPFCLIENTE` varchar(20) NOT NULL,
  PRIMARY KEY (`ID_ANIMAL`),
  KEY `CPFCLIENTE` (`CPFCLIENTE`),
  CONSTRAINT `animal_ibfk_1` FOREIGN KEY (`CPFCLIENTE`) REFERENCES `cliente` (`CPF_CLIENTE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `animal`
--

/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
INSERT INTO `animal` (`ID_ANIMAL`,`NASCIMENTO`,`TIPO`,`RACA`,`NOME`,`CPFCLIENTE`) VALUES 
 (1,'2014-01-01','CAO','SRD','TOTO','1'),
 (2,'2014-01-01','CAO','SRD','TOBI','1'),
 (3,'2014-01-01','GATA','SRD','XIBIU','2');
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;


--
-- Definition of table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `CPF_CLIENTE` varchar(20) NOT NULL,
  PRIMARY KEY (`CPF_CLIENTE`),
  CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`CPF_CLIENTE`) REFERENCES `pessoa` (`CPF_PESSOA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cliente`
--

/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`CPF_CLIENTE`) VALUES 
 ('1'),
 ('2');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;


--
-- Definition of table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
CREATE TABLE `endereco` (
  `ID_ENDERECO` int(11) NOT NULL DEFAULT '0',
  `LOGRADOURO` varchar(50) NOT NULL,
  `NUMERO` int(11) DEFAULT NULL,
  `COMPLEMENTO` varchar(50) NOT NULL,
  `CEP` varchar(20) NOT NULL,
  `BAIRRO` varchar(30) NOT NULL,
  `CIDADE` varchar(30) NOT NULL,
  `ESTADO` varchar(20) NOT NULL,
  PRIMARY KEY (`ID_ENDERECO`),
  KEY `CEP` (`CEP`),
  CONSTRAINT `endereco_ibfk_1` FOREIGN KEY (`CEP`) REFERENCES `pessoa` (`CPF_PESSOA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `endereco`
--

/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;


--
-- Definition of table `ficha`
--

DROP TABLE IF EXISTS `ficha`;
CREATE TABLE `ficha` (
  `ID_FICHA` int(11) NOT NULL DEFAULT '0',
  `AGENDAMENTO` date DEFAULT NULL,
  `DIAGNOSTICO` varchar(100) NOT NULL,
  `CPFCLIENTE` varchar(20) NOT NULL,
  `IDANIMAL` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_FICHA`),
  KEY `CPFCLIENTE` (`CPFCLIENTE`),
  KEY `IDANIMAL` (`IDANIMAL`),
  CONSTRAINT `ficha_ibfk_1` FOREIGN KEY (`CPFCLIENTE`) REFERENCES `cliente` (`CPF_CLIENTE`),
  CONSTRAINT `ficha_ibfk_2` FOREIGN KEY (`IDANIMAL`) REFERENCES `animal` (`ID_ANIMAL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ficha`
--

/*!40000 ALTER TABLE `ficha` DISABLE KEYS */;
INSERT INTO `ficha` (`ID_FICHA`,`AGENDAMENTO`,`DIAGNOSTICO`,`CPFCLIENTE`,`IDANIMAL`) VALUES 
 (1,'2015-01-01','DOENTE','1',1);
/*!40000 ALTER TABLE `ficha` ENABLE KEYS */;


--
-- Definition of table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
CREATE TABLE `funcionario` (
  `SALARIO` decimal(10,2) DEFAULT NULL,
  `HORARIO_INICIAL` date DEFAULT NULL,
  `SAIDA_ALMOCO` date DEFAULT NULL,
  `VOLTA_ALMOCO` date DEFAULT NULL,
  `HORARIO_SAIDA` date DEFAULT NULL,
  `FUNCAO` varchar(30) NOT NULL,
  `CPF_FUNCIONARIO` varchar(20) NOT NULL,
  PRIMARY KEY (`CPF_FUNCIONARIO`),
  CONSTRAINT `funcionario_ibfk_1` FOREIGN KEY (`CPF_FUNCIONARIO`) REFERENCES `pessoa` (`CPF_PESSOA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `funcionario`
--

/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;


--
-- Definition of table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
CREATE TABLE `pessoa` (
  `CPF_PESSOA` varchar(20) NOT NULL,
  `NOME` varchar(50) NOT NULL,
  `TELEFONE` varchar(20) NOT NULL,
  `GENERO` char(2) NOT NULL,
  `SENHA` varchar(2) NOT NULL,
  PRIMARY KEY (`CPF_PESSOA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pessoa`
--

/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` (`CPF_PESSOA`,`NOME`,`TELEFONE`,`GENERO`,`SENHA`) VALUES 
 ('1','TELBALDO','123','M','1'),
 ('2','DANIEL','123','M','2');
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;


--
-- Definition of table `servico`
--

DROP TABLE IF EXISTS `servico`;
CREATE TABLE `servico` (
  `ID_SERVICO` int(11) NOT NULL DEFAULT '0',
  `TIPO` varchar(30) NOT NULL,
  `PRECO` decimal(12,6) DEFAULT NULL,
  `IDFICHA` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_SERVICO`),
  KEY `IDFICHA` (`IDFICHA`),
  CONSTRAINT `servico_ibfk_1` FOREIGN KEY (`IDFICHA`) REFERENCES `ficha` (`ID_FICHA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `servico`
--

/*!40000 ALTER TABLE `servico` DISABLE KEYS */;
/*!40000 ALTER TABLE `servico` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
