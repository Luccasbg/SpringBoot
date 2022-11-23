/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basicsystem.controller;

import com.basicsystem.model.Escola;
import com.basicsystem.model.Usuario;
import com.basicsystem.repository.EscolaRepository;
import com.basicsystem.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Leandro
 */

@Controller
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository repository;
    
    @Autowired
    private EscolaRepository repositoryEscola;
    
    @RequestMapping(value="/cadastrar", method=RequestMethod.GET)
    public String form(){
        return "form";
    }
    
    @RequestMapping(value="/cadastrar", method=RequestMethod.POST)
    public String cadastrarUsuario(Usuario usuario){
        repository.save(usuario);
        
        return "redirect:/cadastrar";
    }
    
    @RequestMapping(value="/usuarios", method=RequestMethod.GET)
    public ModelAndView mostrarUsuarios(){
        ModelAndView mv = new ModelAndView("usuarios");
        Iterable<Usuario> usuarios = repository.findAll();
        mv.addObject("usuarios", usuarios);  
        return mv;
    }
    
    @RequestMapping(value="/cadastrarEscola", method=RequestMethod.GET)
    public String formEscola(){
        return "formEscola";
    }
    
    @RequestMapping(value="/cadastrarEscola", method=RequestMethod.POST)
    public String formEscola(Escola escola){
        repositoryEscola.save(escola);
        
        return "redirect:/cadastrarEscola";
    }
    
    @RequestMapping(value="/dados", method=RequestMethod.GET)
    public ModelAndView mostrarEscolas(){
        ModelAndView mv = new ModelAndView("dados");
        Iterable<Usuario> usuarios = repository.findAll();
        Iterable<Escola> escolas = repositoryEscola.findAll();
        mv.addObject("usuarios", usuarios);  
        mv.addObject("escolas", escolas);
        
        return mv;
    }
    
    

    

}
