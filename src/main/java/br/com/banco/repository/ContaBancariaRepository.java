package br.com.banco.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banco.entity.ContaBancaria;

public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Integer> {
	
}
