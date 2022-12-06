package br.edu.ifgoiano.service;

import java.util.List;

import br.edu.ifgoiano.entidade.Usuario;

public interface UsuarioService {

	List<Usuario> findAll();
	Usuario login(String email, String senha);
	Usuario salvar(Usuario usuario);
}
