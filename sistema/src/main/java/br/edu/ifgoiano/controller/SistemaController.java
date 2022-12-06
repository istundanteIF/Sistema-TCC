package br.edu.ifgoiano.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifgoiano.entidade.Usuario;
import br.edu.ifgoiano.service.UsuarioService;

@Controller
public class SistemaController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/cadastro")
	public String cadastro() {
		return "registro/cadastro";
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(Model  model, Usuario usuario) {
		List<Usuario> listaUsuarios = usuarioService.findAll();
		for (Usuario u : listaUsuarios) {
			if (u.getEmail().equals(usuario.getEmail())) {
				model.addAttribute("error", "E-mail já cadastrado!");
				return "registro/cadastro";
			}
		}
		usuarioService.salvar(usuario);
		return "registro/login";
	}
	
	@GetMapping("/login")
	public String login() {
		return "registro/login";
	}
	
	@PostMapping("/logar")
	public String logar(Model  model, Usuario usuarios) {
		Usuario usuario = usuarioService.login(usuarios.getEmail(), usuarios.getSenha());
		if(usuario != null) {
			return "redirect:/";
		}
		model.addAttribute("error", "E-mail ou senha inválidos!");
		return "registro/login";
	}

	@GetMapping("/")
	public String painel() {
		return "home.html";
	}
}
