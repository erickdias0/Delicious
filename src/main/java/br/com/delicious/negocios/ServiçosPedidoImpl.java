/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.delicious.negocios;

import br.com.delicious.entidades.Pedido;
import br.com.delicious.entidades.Usuario;
import br.com.delicious.persistencia.RepositorioPedido;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiçosPedidoImpl implements ServiçosPedido {
@Autowired
private RepositorioPedido repositorio;

    public ServiçosPedidoImpl() {
    }
    
@Override
@Transactional(rollbackFor = PedidoCadastradoException.class)    
public void cadastrar(Pedido pedido) throws PedidoCadastradoException {
    if(repositorio.findById(pedido.getId())!=null) throw new PedidoCadastradoException();
        repositorio.save(pedido);
   
    }

    @Override
    @Transactional(rollbackFor = PedidoNaoCadastradoException.class)
    public void atualizar(Pedido pedido) throws PedidoNaoCadastradoException {
    Pedido pedidoAtualizar = repositorio.findById(pedido.getId());
        if(pedidoAtualizar==null)throw new PedidoNaoCadastradoException();
        pedidoAtualizar.setEntrega(pedido.getEntrega());
        pedidoAtualizar.setDoce(pedido.getDoce());
        
        
        repositorio.save(pedidoAtualizar);
        
    }

    @Override
    @Transactional(rollbackFor = PedidoNaoCadastradoException.class)
    public void remover(Long id) throws PedidoNaoCadastradoException {
    Pedido pedidoDelete = repositorio.findById(id);
        if(pedidoDelete == null) throw new PedidoNaoCadastradoException();
        repositorio.delete(pedidoDelete);
    
    }

    @Override
    public List<Pedido> listByUsuario(Usuario usuario) {
     
            return repositorio.findByUsuario(usuario);
        
    }

    @Override
    public List<Pedido> listByDataEntrega(Date entrega) {
     return repositorio.findByEntrega(entrega);
            
    }

    @Override
    public List<Pedido> listByDataPedido(Date pedido) {
    return repositorio.findByPedido(pedido);
    }

    @Override
    public List<Pedido> listAll() {
        return (List<Pedido>) repositorio.findAll();
    }
    
}
