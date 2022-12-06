package br.edu.ifgoiano.service;

import java.util.List;

import br.edu.ifgoiano.entidade.Dados;
import br.edu.ifgoiano.entidade.Dsv;

public interface DsvService {

	List<Dsv> findAll();
	Dsv obterDsv(Long id);
	Dsv salvar(Dsv desenv);
	void deletar(Long id);
}
