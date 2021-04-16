package com.nadhem.multiDB;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nadhem.multiDB.entities.produit.Produit;
import com.nadhem.multiDB.entities.user.User;
import com.nadhem.multiDB.produit.repos.ProduitRepository;
import com.nadhem.multiDB.user.repos.UserRepository;

@SpringBootApplication
public class MultiDbApplication {
	
	@Autowired
	ProduitRepository produitRepos;
	
	@Autowired
	UserRepository userRepos;

	public static void main(String[] args) {
		SpringApplication.run(MultiDbApplication.class, args);
	}
	
	@PostConstruct
	public void ajouterProduits()
	{
		produitRepos.save(new Produit(null,"toto"));
		produitRepos.save(new Produit(null,"lolo"));
		
		userRepos.save(new User(null,"nadhem","123"));
	}

}
