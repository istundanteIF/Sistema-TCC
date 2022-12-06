package br.edu.ifgoiano.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifgoiano.entidade.Artigo;
import br.edu.ifgoiano.service.ArtigoService;

@Controller
public class ArtigoController {

	@Autowired
	ArtigoService artigoService;
	
	@GetMapping("/literatura")
	public String getArtigo(Model model) {
		List<Artigo> artigos = artigoService.findAll();
		
		model.addAttribute("artigos", artigos);
		
		return "artigos/artigos.html";
	}
	
	@GetMapping("/literatura/{id}")
	public String getArtigoDetalhes(@PathVariable Long id, Model model) {
		Artigo artigo = artigoService.obterArtigos(id);
		
		model.addAttribute("artigo", artigo);
		
		return "artigos/artigos-detalhes.html";
	}
	
	@GetMapping("/literatura/novo")
	public String getArtigoForm(Model model) {
		Artigo artigo = new Artigo();
		
		model.addAttribute("artigo", artigo);
		
		return "artigos/artigos-form.html";
	}
	
	@PostMapping("/literatura/novo")
	public String salvarArtigo(Artigo artigo) {
		this.artigoService.salvar(artigo);
		
		return "redirect:/literatura";
	}
}
