-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 08-Jan-2020 às 22:53
-- Versão do servidor: 10.1.37-MariaDB
-- versão do PHP: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projetofinal`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `email` varchar(255) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `cep` varchar(16) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `bairro` varchar(50) NOT NULL,
  `logradouro` varchar(100) NOT NULL,
  `numero` int(11) NOT NULL,
  `complemento` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id`, `nome`, `email`, `telefone`, `cep`, `cpf`, `cidade`, `bairro`, `logradouro`, `numero`, `complemento`) VALUES
(1, 'dsda', 'asd', 'dsd', 'sd', '', 'sad', 'ad', 'sd', 1, 'sa'),
(2, 'dsdadadsadsadasdsa', 'asdsaddsadasdsadsad', 'dsdsad', 'sddasd', '', 'saddasdsdsa', 'addsadsad', 'sddsdsadsdsadaadsad', 122, 'sadasdsadsdaddsadsadasda'),
(3, 'dasdsa', 'dasdsadsa', 'dadsad', 'dasdas', '333', 'asdsadsad', 'sdsadsa', 'dsadsad', 333, 'dsadsadsadasdas'),
(4, 'dasdsad', 'dsdadsad', 'dsadsad', 'asdsad', '161625754', 'bfgbfg', 'dfdf', 'fsdf', 33, 'ssdsa'),
(5, '', 'fdsdsfs', 'fsdfsd', 'fdsfsd', '161625754', 'fsfdsf', 'fsdfsdf', 'fsdfs', 32, 'dada');

-- --------------------------------------------------------

--
-- Estrutura da tabela `compras`
--

CREATE TABLE `compras` (
  `idequipamento` int(11) NOT NULL,
  `nomeequip` varchar(255) NOT NULL,
  `modeloequip` varchar(255) NOT NULL,
  `quantidade` varchar(255) NOT NULL,
  `observacoes` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `compras`
--

INSERT INTO `compras` (`idequipamento`, `nomeequip`, `modeloequip`, `quantidade`, `observacoes`) VALUES
(1, 'ds', 'dsa', 'ds', 'ds'),
(2, 'vada', 'dsa', 'ds', 'ddada'),
(3, 'allisson', 'meu pau', '34cm', 'ele é mt veiudo');

-- --------------------------------------------------------

--
-- Estrutura da tabela `estoque`
--

CREATE TABLE `estoque` (
  `idestoque` int(11) NOT NULL,
  `quantidade` varchar(255) NOT NULL,
  `modelo` varchar(255) NOT NULL,
  `valor` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `estoque`
--

INSERT INTO `estoque` (`idestoque`, `quantidade`, `modelo`, `valor`) VALUES
(1, 'ds', 'sda', 'ds'),
(2, '22', 'CAMP', '331');

-- --------------------------------------------------------

--
-- Estrutura da tabela `os`
--

CREATE TABLE `os` (
  `id` int(11) NOT NULL,
  `momento` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `equipamento` varchar(100) NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `dataSaida` varchar(45) DEFAULT NULL,
  `clienteId` int(11) NOT NULL,
  `tecnicoId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `os`
--

INSERT INTO `os` (`id`, `momento`, `equipamento`, `descricao`, `dataSaida`, `clienteId`, `tecnicoId`) VALUES
(2, '2019-11-05 11:33:53', 'Notebook 3dd', 'Notebook 3dd', '12/02/2012', 3, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pagamento`
--

CREATE TABLE `pagamento` (
  `idpagamento` int(11) NOT NULL,
  `Tipopagamento` varchar(255) NOT NULL,
  `Datapagamento` varchar(12) NOT NULL,
  `Valorecebido` varchar(255) NOT NULL,
  `Troco` varchar(255) NOT NULL,
  `valortotal` varchar(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `idproduto` int(11) NOT NULL,
  `nomeproduto` varchar(255) NOT NULL,
  `modeloproduto` varchar(255) NOT NULL,
  `valorproduto` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`idproduto`, `nomeproduto`, `modeloproduto`, `valorproduto`) VALUES
(1, 'ds', 'ds', 'ds'),
(2, 'AURORA', 'MINHA PIROCA', '30');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tecnico`
--

CREATE TABLE `tecnico` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `rg` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tecnico`
--

INSERT INTO `tecnico` (`id`, `nome`, `cpf`, `rg`) VALUES
(2, 'Ricardo', '123', '321');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `usuario`, `senha`) VALUES
(1, 'root', 'admin'),
(2, 'teste', '123456');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `compras`
--
ALTER TABLE `compras`
  ADD PRIMARY KEY (`idequipamento`);

--
-- Indexes for table `estoque`
--
ALTER TABLE `estoque`
  ADD PRIMARY KEY (`idestoque`);

--
-- Indexes for table `os`
--
ALTER TABLE `os`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pagamento`
--
ALTER TABLE `pagamento`
  ADD PRIMARY KEY (`idpagamento`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`idproduto`);

--
-- Indexes for table `tecnico`
--
ALTER TABLE `tecnico`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `usuario` (`usuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `compras`
--
ALTER TABLE `compras`
  MODIFY `idequipamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `estoque`
--
ALTER TABLE `estoque`
  MODIFY `idestoque` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `os`
--
ALTER TABLE `os`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `pagamento`
--
ALTER TABLE `pagamento`
  MODIFY `idpagamento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `idproduto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tecnico`
--
ALTER TABLE `tecnico`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
