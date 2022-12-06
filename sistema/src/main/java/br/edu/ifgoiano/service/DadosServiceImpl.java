package br.edu.ifgoiano.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifgoiano.entidade.Dados;
import br.edu.ifgoiano.repository.DadosRepository;

@Service
public class DadosServiceImpl implements DadosService {

	@Autowired
	private DadosRepository dadosRepository;

	@Override
	public List<Dados> findAll() {
		return dadosRepository.findAll();
	}

	@Override
	public Dados obterDados(Long id) {
		return dadosRepository.getReferenceById(id);
	}

	@Override
	public Dados salvar(Dados dados) {
		return dadosRepository.save(dados);
	}

	@Override
	public void deletar(Long id) {
		this.dadosRepository.deleteById(id);
	}
}
