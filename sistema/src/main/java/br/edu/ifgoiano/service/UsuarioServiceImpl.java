package br.edu.ifgoiano.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifgoiano.entidade.Usuario;
import br.edu.ifgoiano.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario login(String email, String senha) {
		return usuarioRepository.login(email, senha);
	}

	@Override
	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

}
