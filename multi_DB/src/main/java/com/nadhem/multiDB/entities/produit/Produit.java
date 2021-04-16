package com.nadhem.multiDB.entities.produit;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Produit {	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idProduit;		
	private String nomProduit;	
	
}
