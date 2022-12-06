package br.edu.ifgoiano.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lowagie.text.DocumentException;

import br.edu.ifgoiano.entidade.Dados;
import br.edu.ifgoiano.service.DadosService;
import br.edu.ifgoiano.utils.DataPDFExporter;

@Controller
public class DadosController {
	
	@Autowired
	private DadosService dadosService;
	
	@GetMapping("/dados")
	public ModelAndView getDados() {
		ModelAndView model = new ModelAndView("dados/dados.html");
		List<Dados> dados = dadosService.findAll();
		model.addObject("dados", dados);
		
		return model;
	}
	
	@GetMapping("/dados/{id}")
	public String getDadosDetalhes(@PathVariable Long id, Model model) {
		Dados dados = dadosService.obterDados(id);
		
		model.addAttribute("dados", dados);
		
		return "dados/dados-detalhes.html";
	}
	
	@GetMapping("/dados/novo")
	public String getDadosForm(Model model) {
		Dados dados = new Dados();
		
		model.addAttribute("dados", dados);
		
		return "dados/dados-form.html";
	}
	
	@PostMapping("/dados/novo")
	public String salvarDados(Dados dados) {
		this.dadosService.salvar(dados);
		
		return "redirect:/dados";
	}
	
	@GetMapping("/dados/alterar/{id}")
	public String abrirAlterarDados(@PathVariable Long id, Model model) {
		Dados dados = this.dadosService.obterDados(id);
		
		model.addAttribute("dados", dados);
		
		return "dados/alterar-dados.html";
	}
	
	@PostMapping("/dados/alterar")
	public String alterarDados(Dados dados) {
		this.dadosService.salvar(dados);
		
		return "redirect:/dados";
	}
	
	@GetMapping("/dados/salvar/{id}")
	public void teste(@PathVariable Long id, HttpServletResponse response, Model model) throws DocumentException, IOException {
		Dados dados = this.dadosService.obterDados(id);
		
		response.setContentType("application/pdf");
		
		model.addAttribute("dados", dados);
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_" + dados.getTitulo() + ".pdf";
		response.setHeader(headerKey, headerValue);
		
		DataPDFExporter ex = new DataPDFExporter(dados);
		ex.export(response, dados);
	}
	
	@GetMapping("/dados/deletar/{id}")
	public String deletarDados(@PathVariable Long id, Model model) {
		this.dadosService.deletar(id);
		
		model.addAttribute("dados", dadosService.findAll());
		
		return "redirect:/dados";
	}
}
