package com.br.apiRest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.apiRest.models.Mensagem;
import com.br.apiRest.repositories.MensagemRepository;

@Service
public class MensagemService {

	@Autowired
	private MensagemRepository mensagemRepository;
	
	public Iterable<Mensagem> pegarMensagens(){
		return mensagemRepository.findAll();
	}
	
	public Mensagem pegarMensagemPeloId(int id) {
		if(mensagemRepository.existsById(id)) {
			return mensagemRepository.findById(id).get();
		}
		return null;
	}
	
	public void salvarMensagem(Mensagem mensagem) {
		mensagemRepository.save(mensagem);
		
	}
	
	public void atualizarMensagem(int id, Mensagem mensagem) {
		mensagem.setId(id);
		mensagemRepository.save(mensagem);
	}
	
	public long qtdMensagens() {
		return  mensagemRepository.count();
	}
	
	public void apagarMensagem(int id) {
		mensagemRepository.deleteById(id);
	}
	
}