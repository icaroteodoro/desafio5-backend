package br.com.banco.repository;



import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.banco.entity.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Integer>{
	List<Transferencia> findByContaId(int contaId);
	
	List<Transferencia> findByNomeOperadorTransacao(String nome_operador_transacao);
	
	@Query(nativeQuery = true, value = "SELECT * FROM transferencia WHERE data_transferencia >= :startDate AND data_transferencia <= :endDate")
	List<Transferencia> findByDataTransferenciaBetween(LocalDateTime startDate, LocalDateTime endDate);
	
	
	@Query(nativeQuery = true, value = "SELECT * FROM transferencia WHERE data_transferencia >= :startDate")
	List<Transferencia> findByDataTransferenciaMaiorQue(LocalDateTime startDate);
	
	@Query(nativeQuery = true, value = "SELECT * FROM transferencia WHERE data_transferencia <= :endDate")
	List<Transferencia> findByDataTransferenciaMenorQue(LocalDateTime endDate);
	
	@Query(nativeQuery = true, value = "SELECT * FROM transferencia WHERE data_transferencia >= :startDate AND data_transferencia < :endDate AND nome_operador_transacao LIKE :nomeOperadorTransacao")
	List<Transferencia> findByAllFilters(LocalDateTime startDate,LocalDateTime endDate, String nomeOperadorTransacao);
	
	
}
