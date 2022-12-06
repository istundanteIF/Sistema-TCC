package br.edu.ifgoiano.service;

import java.util.List;

import br.edu.ifgoiano.entidade.Artigo;

public interface ArtigoService {
	
	List<Artigo> findAll();
	Artigo obterArtigos(Long id);
	Artigo salvar(Artigo artigo);
}
