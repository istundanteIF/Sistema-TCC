package br.edu.ifgoiano.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.ifgoiano.entidade.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Query(value = "select * from usuarios where email = :email and senha = :senha", nativeQuery = true)
	public Usuario login(String email, String senha);
}
