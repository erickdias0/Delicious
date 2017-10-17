/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.delicious.ui;

import br.com.delicious.entidades.Usuario;
import br.com.delicious.negocios.FachadaServiços;
import br.com.delicious.negocios.UsuarioCadastradoException;
import br.com.delicious.negocios.UsuarioInvalidoException;
import br.com.delicious.negocios.UsuarioNaoCadastradoException;
import java.awt.PageAttributes;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Erick
 */
@Controller
@RequestMapping("/delicious")
public class ControllerUsuario {
    @Autowired
    private FachadaServiços fachada;
    
    
    @RequestMapping(value="/usuarios/adicionar",method = RequestMethod.POST)
    public ResponseEntity<?> adicionarUsuario(Usuario usuario){
       try{ 
           fachada.cadastrar(usuario);
           return new ResponseEntity<String>(HttpStatus.OK);
       } catch(UsuarioCadastradoException exc){
           return new ResponseEntity<UsuarioCadastradoException>(exc,HttpStatus.BAD_REQUEST);
       }
     
    }
    @RequestMapping(value="/usuarios/atualizar",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> atualizarUsuario(Usuario usuario){
       try{ 
           fachada.atualizar(usuario);
           return new ResponseEntity<String>(HttpStatus.OK);
       } catch(UsuarioNaoCadastradoException exc){
           return new ResponseEntity<UsuarioNaoCadastradoException>(exc,HttpStatus.BAD_REQUEST);
       }
     
    }
    
    @RequestMapping(value="/usuarios/deletar",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deletarUsuario(Long id){
       try{ 
           fachada.removerUsuario(id);
           return new ResponseEntity<String>(HttpStatus.OK);
       } catch(UsuarioNaoCadastradoException exc){
           return new ResponseEntity<UsuarioNaoCadastradoException>(exc,HttpStatus.BAD_REQUEST);
       }
     
    }
    
    //Lista todos usuários
    @RequestMapping(value = "/usuarios/listar")
    public @ResponseBody ResponseEntity<?> listarTodos(){
    List<Usuario> todosUsers = fachada.listarTodos();
    return new ResponseEntity(todosUsers,HttpStatus.OK);
    }
    
    //Pesquisa um usuário por email
    @RequestMapping(value = "/usuarios/listarPorEmail",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listarPorEmail(String email){
    
        try{
        Usuario usuarioPesquisa = fachada.listarByEmail(email);
    
        return new ResponseEntity(usuarioPesquisa,HttpStatus.OK);
    }catch(UsuarioNaoCadastradoException exc){
           return new ResponseEntity<UsuarioNaoCadastradoException>(exc,HttpStatus.BAD_REQUEST);
        
    }
    }
    //Pesquisa lista de usuários por nome
    @RequestMapping(value = "/usuarios/listarPorNome")
    public ResponseEntity<?> listarPorNome(String nome){
    List<Usuario> usuariosPesquisa = fachada.listarByNome(nome);
    return new ResponseEntity(usuariosPesquisa,HttpStatus.OK);
    
    }
    //Login
    @RequestMapping(value = "/usuarios/login",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(String email,String senha){
    
        try{
        Usuario usuarioLogado = fachada.logar(email,senha);
    
        return new ResponseEntity(usuarioLogado,HttpStatus.OK);
    }catch(UsuarioInvalidoException exc){
           return new ResponseEntity<UsuarioInvalidoException>(exc,HttpStatus.BAD_REQUEST);
        
    }
    }
    @RequestMapping("/cadastro")
    public String formCadastro(){
        return "cadastro";
    }
    @RequestMapping("/listarTodos")
    public String formListAll(){
        return "listall";
    }
    @RequestMapping("/pesquisarNome")
    public String formListNome(){
        return "listnome";
    }
}