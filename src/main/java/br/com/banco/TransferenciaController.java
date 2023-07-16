package br.com.banco;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.entity.Transferencia;
import br.com.banco.repository.TransferenciaRepository;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {
	@Autowired
	private TransferenciaRepository transferenciaRepository;
	
	@GetMapping
	public List<Transferencia> listTransferencia(){
		return transferenciaRepository.findAll();
	}
	
//	RETORNA AS TRANSFERENCIA PELO ID DA CONTA
	@GetMapping
	@RequestMapping("conta/{conta_id}")
	public List<Transferencia> listTransferenciaByContaId(@PathVariable int conta_id){
		return transferenciaRepository.findByContaId(conta_id);
	}
	
//	RETORNA AS TRANSFERENCIAS PELO NOME DO OPERADOR
	@GetMapping
	@RequestMapping("/nome/{nome_operador_transacao}")
	public List<Transferencia> listTransferenciaByNomeResponsavelTransacao(@PathVariable String nome_operador_transacao){
		return transferenciaRepository.findByNomeOperadorTransacao(nome_operador_transacao);
	}
//	RETORNA AS TRANSFERENCIAS COM FILTRO DE DATAS
	@GetMapping("/data")
	public List<Transferencia> listTransferenciaByDate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate){
		DateTimeFormatter parser = new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd").parseDefaulting(ChronoField.HOUR_OF_DAY, 0).toFormatter();
		LocalDateTime start = LocalDateTime.parse(startDate, parser);
		LocalDateTime end = LocalDateTime.parse(endDate, parser);
		
		return transferenciaRepository.findByDataTransferenciaBetween(start, end);
	}
//	RETORNA AS TRANSFERENCIAS COM FILTRO DE DATA INICIAL 
	@GetMapping("/data-maior")
	public List<Transferencia> listTransferenciaMaiorQue(@RequestParam("startDate") String startDate){
		DateTimeFormatter parser = new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd").parseDefaulting(ChronoField.HOUR_OF_DAY, 0).toFormatter();
		LocalDateTime start = LocalDateTime.parse(startDate, parser);
		return transferenciaRepository.findByDataTransferenciaMaiorQue(start);
	}
//	RETORNA AS TRANSFERENCIAS COM FILTRO DE DATA FINAL
	@GetMapping("/data-menor")
	public List<Transferencia> listTransferenciaMenorQue(@RequestParam("endDate") String endDate){
		DateTimeFormatter parser = new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd").parseDefaulting(ChronoField.HOUR_OF_DAY, 0).toFormatter();
		LocalDateTime end = LocalDateTime.parse(endDate, parser);
		return transferenciaRepository.findByDataTransferenciaMenorQue(end);
	}
//	RETORNA AS TRANSFERENCIAS COM TODOS OS FILTROS
	@GetMapping("/all-filters")
	public List<Transferencia> listByAllFilters(
			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate,
			@RequestParam("nome_operador_transacao") String nome_operador_transacao)
	{
		DateTimeFormatter parser = new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd").parseDefaulting(ChronoField.HOUR_OF_DAY, 0).toFormatter();
		LocalDateTime start = LocalDateTime.parse(startDate, parser);
		LocalDateTime end = LocalDateTime.parse(endDate, parser);
		System.out.println(end);
		return transferenciaRepository.findByAllFilters(start, end, nome_operador_transacao);
	}
}
