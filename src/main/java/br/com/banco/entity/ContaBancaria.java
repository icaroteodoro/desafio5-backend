package br.com.banco.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conta")
public class ContaBancaria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_conta", nullable = false)
	private int id_conta;
	@Column(nullable = false, length = 50, name = "nome_responsavel")
	private String NomeResponsavel;
	
	public int getIdConta() {
		return id_conta;
	}
	public void setId(int id_conta) {
		this.id_conta = id_conta;
	}
	public String getNomeResponsavel() {
		return NomeResponsavel;
	}
	public void setNomeResponsavel(String nomeResponsavel) {
		NomeResponsavel = nomeResponsavel;
	}
	
	

}
