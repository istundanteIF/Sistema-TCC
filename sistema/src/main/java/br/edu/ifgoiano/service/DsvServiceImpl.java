package br.edu.ifgoiano.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifgoiano.entidade.Dsv;
import br.edu.ifgoiano.repository.DsvRepository;

@Service
public class DsvServiceImpl implements DsvService {

	@Autowired
	private DsvRepository desenvRepository;

	@Override
	public List<Dsv> findAll() {
		return desenvRepository.findAll();
	}

	@Override
	public Dsv salvar(Dsv desenv) {
		return desenvRepository.save(desenv);
	}

	@Override
	public Dsv obterDsv(Long id) {
		return desenvRepository.getReferenceById(id);
	}

	@Override
	public void deletar(Long id) {
		this.desenvRepository.deleteById(id);
	}
}
