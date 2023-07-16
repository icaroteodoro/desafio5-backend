package br.com.banco.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "transferencia")
public class Transferencia{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "data_transferencia",nullable = false)
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDateTime dataTransferencia;
	@Column(nullable = false, length=20, name = "valor")
	private Double valor;
	@Column(nullable = false, length = 20, name = "tipo")
	private String tipo;
	@Column(name = "nome_operador_transacao",nullable = false, length=50)
	private String nomeOperadorTransacao;
	@Column(nullable = false, unique = true, name = "conta_id") 	
	private int contaId;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getDataTransferencia() {
		return dataTransferencia;
	}
	public void setDataTransferencia(LocalDateTime dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNomeOperadorTransacao() {
		return nomeOperadorTransacao;
	}
	public void setNomeOperadorTransacao(String nomeOperadorTransacao) {
		this.nomeOperadorTransacao = nomeOperadorTransacao;
	}
	public int getContaId() {
		return contaId;
	}
	public void setContaId(int contaId) {
		this.contaId = contaId;
	}
	
}
