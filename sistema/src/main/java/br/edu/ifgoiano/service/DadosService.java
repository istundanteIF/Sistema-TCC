package br.edu.ifgoiano.service;

import java.util.List;

import br.edu.ifgoiano.entidade.Dados;

public interface DadosService {
	
	List<Dados> findAll();
	Dados obterDados(Long id);
	Dados salvar(Dados dados);
	void deletar(Long id);
}
