package br.edu.ifgoiano.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifgoiano.entidade.Dsv;
import br.edu.ifgoiano.service.DsvService;

@Controller
public class DsvController {

	@Autowired
	private DsvService dsvService;
	
	@GetMapping("/projetos")
	public ModelAndView getDesenv() {
		ModelAndView model = new ModelAndView("desenvolvimento/dsv.html");
		List<Dsv> dsv = dsvService.findAll();
		model.addObject("dsv", dsv);
		return model;
	}
	
	@GetMapping("/projetos/novo")
	public String getDsvForm(Model model) {
		Dsv dsv = new Dsv();
		
		model.addAttribute("dsv", dsv);
		
		return "desenvolvimento/dsv-form.html";
	}
	
	@PostMapping("/projetos/novo")
	public String salvarDsv(Dsv dsv) {
		Date data = new Date();
		dsv.setData(data);
		dsvService.salvar(dsv);
		
		return "redirect:/projetos";
	}
	
	@GetMapping("/projetos/{id}")
	public String getAlterarDsv(@PathVariable Long id, Model model) {
		Dsv dsv = dsvService.obterDsv(id);
		
		model.addAttribute("dsv", dsv);
		
		return "desenvolvimento/alterar-dsv.html";
	}
	
	@PostMapping("/projetos/alterar")
	public String alterarDsv(Dsv dsv) {
		dsvService.salvar(dsv);
		
		return "redirect:/projetos";
	}
	
	@GetMapping("/projetos/deletar/{id}")
	public String deletarDsv(@PathVariable("id") Long id, Model model) {
		dsvService.deletar(id);
		
		model.addAttribute("dsv", dsvService.findAll());
		
		return "redirect:/projetos";
	}
}
