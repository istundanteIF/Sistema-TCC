package br.edu.ifgoiano.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifgoiano.entidade.Dados;
import br.edu.ifgoiano.entidade.Dsv;

public interface DadosRepository extends JpaRepository<Dados, Long>{

}