package com.nadhem.multiDB.produit.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nadhem.multiDB.entities.produit.Produit;


public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
