package br.com.banco;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.entity.ContaBancaria;
import br.com.banco.repository.ContaBancariaRepository;


@RestController
@RequestMapping("/conta-bancaria")
public class BancoController {
	@Autowired
	private ContaBancariaRepository contaBancariaRepository;
	
	@GetMapping
	public List<ContaBancaria> listConta(){
		return contaBancariaRepository.findAll();
	}
	@GetMapping
	@RequestMapping("/{id}")
	public Optional<ContaBancaria> getContaBancariaById(@PathVariable int id){
		return contaBancariaRepository.findById(id);
	}
	
	@PostMapping
	@RequestMapping("/salvar")
	public ContaBancaria saveConta(@RequestBody ContaBancaria contaBancaria) {
		return contaBancariaRepository.save(contaBancaria);
	}
	
	@PutMapping
	@RequestMapping("/atualizar")
	public ContaBancaria updateConta(@RequestBody  ContaBancaria contaBancaria) {
		return contaBancariaRepository.save(contaBancaria);
	}
	@DeleteMapping
	@RequestMapping("/deletar")
	public void deleteConta(@RequestBody ContaBancaria contaBancaria) {
		contaBancariaRepository.delete(contaBancaria);
	}
}
