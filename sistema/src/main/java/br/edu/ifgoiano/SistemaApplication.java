package br.edu.ifgoiano;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifgoiano.entidade.Artigo;
import br.edu.ifgoiano.entidade.Dados;
import br.edu.ifgoiano.entidade.Dsv;
import br.edu.ifgoiano.entidade.Usuario;
import br.edu.ifgoiano.repository.ArtigoRepository;
import br.edu.ifgoiano.repository.DadosRepository;
import br.edu.ifgoiano.repository.DsvRepository;
import br.edu.ifgoiano.repository.UsuarioRepository;

@SpringBootApplication
public class SistemaApplication implements CommandLineRunner {

	@Autowired
	private DadosRepository dadosRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Autowired
	private DsvRepository dsvRepo;
	
	@Autowired
	private ArtigoRepository artigoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SistemaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Usuario usuario = new Usuario();
		usuario.setNome("Aleluia");
		usuario.setEmail("teste@gmail.com");
		usuario.setSenha("123");
		usuario.setCargo("orientador");
		
		usuarioRepo.save(usuario);
		////////////////////////////////
		Dados dados1 = new Dados();
		dados1.setTitulo("Teste de projeto");
		dados1.setResumo("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut "
				+ "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris ni"
				+ "si ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit ess"
				+ "e cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in cu"
				+ "lpa qui officia deserunt mollit anim id est laborum.");
		dados1.setFonte("Instituto Federal Goiano");
		dados1.setValor("2222.00");
		dados1.setMetodologia("Pesquisa experimental: Observação a partir de experimentos controlados, com análise estatística.");
		
		dadosRepository.save(dados1);
		////////////////////////////////
		Dsv dsv1 = new Dsv();
		Date data = new Date();
		dsv1.setInstituicao("Instituto Federal Goiano");
		dsv1.setAutor("Denecley");
		dsv1.setTitulo("Medidas sanzonarias");
		dsv1.setCidade("Trindade");
		dsv1.setAno("2022");
		dsv1.setOrientador("Denecley");
		dsv1.setData(data);
		
		dsvRepo.save(dsv1);
		////////////////////////////////
		Artigo artigo = new Artigo();
		artigo.setTitulo("O bullying escolar no Brasil: uma revisão de artigos científicos");
		artigo.setAutor("Lisiane Machado");
		artigo.setData("2022-12-10");
		artigo.setResumo("Bullying é um fenômeno que sugere atos de violência física ou verbal, que\n" + 
				"ocorrem de forma repetitiva e intencional contra um ou mais vítimas. O fenômeno\n" + 
				"começou a ser estudado na Suécia, na década de 1970. Este estudo buscou investigar\n" + 
				"os artigos científicos sobre bullying escolar, publicados em revistas científicas nacionais\n" + 
				"até o final de 2011.");
		artigo.setLink("https://www.redalyc.org/pdf/1938/193828216016.pdf");
		
		artigoRepository.save(artigo);
	}
}
