/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.delicious.negocios;

import br.com.delicious.entidades.Pedido;
import br.com.delicious.entidades.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Erick
 */
public interface ServiçosPedido extends Serializable{
    public void cadastrar(Pedido pedido) throws PedidoCadastradoException;
    public void atualizar(Pedido pedido) throws PedidoNaoCadastradoException;
    public void remover(Long id) throws PedidoNaoCadastradoException;
    public List<Pedido> listByUsuario(Usuario usuario);
    public List<Pedido> listByDataEntrega(Date entrega);
    public List<Pedido> listByDataPedido(Date pedido);
    public List<Pedido> listAll();
        

}
