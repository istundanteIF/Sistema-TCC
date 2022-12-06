package br.edu.ifgoiano.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifgoiano.entidade.Artigo;
import br.edu.ifgoiano.repository.ArtigoRepository;

@Service
public class ArtigoServiceImpl implements ArtigoService {
	
	@Autowired
	private ArtigoRepository artigoRepository;

	@Override
	public List<Artigo> findAll() {
		return artigoRepository.findAll();
	}

	@Override
	public Artigo obterArtigos(Long id) {
		return artigoRepository.getReferenceById(id);
	}

	@Override
	public Artigo salvar(Artigo artigo) {
		return artigoRepository.save(artigo);
	}

}
