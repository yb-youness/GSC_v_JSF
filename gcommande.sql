-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  Dim 06 juin 2021 à 02:43
-- Version du serveur :  10.4.6-MariaDB
-- Version de PHP :  7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gcommande`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `CatId` int(11) NOT NULL,
  `LibeleCat` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`CatId`, `LibeleCat`) VALUES
(8, 'technologie'),
(10, 'Musique'),
(11, 'sports');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id_client` int(11) NOT NULL,
  `Num_tel` text DEFAULT NULL,
  `nom` text DEFAULT NULL,
  `prenom` text DEFAULT NULL,
  `email` text DEFAULT NULL,
  `sexe` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id_client`, `Num_tel`, `nom`, `prenom`, `email`, `sexe`) VALUES
(7, '0606214433', 'Berriche', 'Amine', 'Amine@gmail.com', 'home'),
(8, '0722105346', 'ES', 'Imad', 'admin@gmail.com', 'home');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `id_commande` int(11) NOT NULL,
  `id_produit` int(11) NOT NULL,
  `idclient` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `adresse` text DEFAULT NULL,
  `quantite` int(11) DEFAULT NULL,
  `date_commande` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`id_commande`, `id_produit`, `idclient`, `idUser`, `adresse`, `quantite`, `date_commande`) VALUES
(1, 9, 7, 0, 'adr', 1, '11/11/111'),
(2, 9, 7, 0, '22 fr', 1, '06/04/2021'),
(3, 10, 8, 0, '41 qe', 2, '12/12/2021');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `ProduitId` int(11) NOT NULL,
  `Libele` varchar(255) NOT NULL,
  `CategorieId` int(11) NOT NULL,
  `Prix` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`ProduitId`, `Libele`, `CategorieId`, `Prix`) VALUES
(9, 'Pc', 8, 3000),
(10, 'Pc', 8, 3000),
(11, 't-shirt', 11, 10);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `Username` text DEFAULT NULL,
  `email` text DEFAULT NULL,
  `pass` text DEFAULT NULL,
  `role` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `Username`, `email`, `pass`, `role`) VALUES
(0, 'youness', 'y@youness.com', 'pass', NULL);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`CatId`) USING BTREE;

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_client`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id_commande`),
  ADD KEY `fg_keyidprod` (`id_produit`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`ProduitId`),
  ADD KEY `fg_key` (`CategorieId`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `CatId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id_client` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `id_commande` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `ProduitId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `produit`
--
ALTER TABLE `produit`
  ADD CONSTRAINT `fg_key` FOREIGN KEY (`CategorieId`) REFERENCES `categorie` (`CatId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
