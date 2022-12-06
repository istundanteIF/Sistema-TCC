package br.edu.ifgoiano.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifgoiano.entidade.Artigo;

public interface ArtigoRepository extends JpaRepository<Artigo, Long> {

}
