/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.delicious.ui;

import br.com.delicious.entidades.Pedido;
import br.com.delicious.entidades.Usuario;
import br.com.delicious.negocios.FachadaServiços;
import br.com.delicious.negocios.PedidoCadastradoException;
import br.com.delicious.negocios.PedidoNaoCadastradoException;
import br.com.delicious.negocios.UsuarioNaoCadastradoException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Erick
 */
@Controller
@RequestMapping("/delicious")

public class ControllerPedido {
    @Autowired
    private FachadaServiços fachada;
    
    
    
    @RequestMapping(value="/pedido/realizar")
    public ResponseEntity<?> realizarPedido(Pedido pedido){
       try{ 
           fachada.cadastrar(pedido);
           return new ResponseEntity<String>(HttpStatus.OK);
       } catch(PedidoCadastradoException exc){
           return new ResponseEntity<PedidoCadastradoException>(exc,HttpStatus.BAD_REQUEST);
       }
     

    
    }

    @RequestMapping(value="/pedido/atualizar",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> atualizarPedido(Pedido pedido){
       try{ 
           fachada.atualizar(pedido);
           return new ResponseEntity<String>(HttpStatus.OK);
       } catch(PedidoNaoCadastradoException exc){
           return new ResponseEntity<PedidoNaoCadastradoException>(exc,HttpStatus.BAD_REQUEST);
       }
     

    
    }
    @RequestMapping(value="/pedido/listar")
    public ResponseEntity<?> listarTodos(){
       List<Pedido> pedidos = fachada.listAll();
    return new ResponseEntity(pedidos,HttpStatus.OK);
    }
    @RequestMapping(value="/pedido/cancelar",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> cancelarPedido(Long id){
       try{ 
           fachada.removerPedido(id);
           return new ResponseEntity<String>(HttpStatus.OK);
       } catch(PedidoNaoCadastradoException exc){
           return new ResponseEntity<PedidoNaoCadastradoException>(exc,HttpStatus.BAD_REQUEST);
       }
     

   
    }

    
    @RequestMapping(value="/pedido/listarUsuario",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listarPorUsuario(Usuario usuario){
       List<Pedido> pedidosUser = fachada.listByUsuario(usuario);
    return new ResponseEntity(pedidosUser,HttpStatus.OK);
    }

 @RequestMapping(value="/pedido/listarDataEntrega",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listarPorDataEntrega(Date data){
       List<Pedido> pedidosData = fachada.listByDataEntrega(data);
    return new ResponseEntity(pedidosData,HttpStatus.OK);
    }
    @RequestMapping("/pedido")
    public String formCadastro(){
        return "pedido";
    }
 

}