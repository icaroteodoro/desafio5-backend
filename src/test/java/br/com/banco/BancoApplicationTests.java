package br.com.banco;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import br.com.banco.entity.ContaBancaria;
import br.com.banco.entity.Transferencia;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class BancoApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate;

    @Test
    public void cadatroTransferencia() {
    	Transferencia t = new Transferencia();
    	t.setDataTransferencia(LocalDateTime.now());
    	t.setNomeOperadorTransacao("Icaro");
    	t.setTipo("DEPOSITO");
    	t.setValor(1500.00);
    	
 
    	Transferencia transfer = restTemplate.postForObject("/transferencias/save", t, Transferencia.class);
//    	VERIFICA SE O OBJETO RECEBIDO É NULO
    	assertNotNull(transfer);
//    	VERIFICA SE O OBJETO RECEBIDO TEM O MESMO id DO OBJETO ENVIADO
    	assertEquals(transfer.getId(), t.getId());
    }
    
    @Test
    public void buscarContaPeloId() {
    	ContaBancaria conta = restTemplate.getForObject("/conta-bancaria/1", ContaBancaria.class);
//    	VERIFICA SE O OBJETO RECEBIDO É NULO
    	assertNotNull(conta);
//    	VERIFICA SE O OBJETO RECEBIDO TEM O MESMO nomePresponsavel DO OBJETO ENVIADO
    	assertEquals("Fulano", conta.getNomeResponsavel());
    }

}
