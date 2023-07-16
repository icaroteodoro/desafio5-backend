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
public class BancoController {
	@Autowired
	private ContaBancariaRepository contaBancariaRepository;
	
	@GetMapping
	@RequestMapping("/conta-bancaria")
	public List<ContaBancaria> listConta(){
		return contaBancariaRepository.findAll();
	}
	@GetMapping
	@RequestMapping("/conta-bancaria/{id}")
	public Optional<ContaBancaria> getContaBancariaById(@PathVariable int id){
		return contaBancariaRepository.findById(id);
	}
	
	@PostMapping
	public void saveConta(@RequestBody ContaBancaria contaBancaria) {
		contaBancariaRepository.save(contaBancaria);
	}
	
	@PutMapping
	public void updateConta(@RequestBody  ContaBancaria contaBancaria) {
		contaBancariaRepository.save(contaBancaria);
	}
	@DeleteMapping
	public void deleteConta(@RequestBody ContaBancaria contaBancaria) {
		contaBancariaRepository.delete(contaBancaria);
	}
}
