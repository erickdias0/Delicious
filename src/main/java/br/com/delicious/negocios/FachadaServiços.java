/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.delicious.negocios;

import br.com.delicious.entidades.Doce;
import br.com.delicious.entidades.Pedido;
import br.com.delicious.entidades.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Erick
 */
public interface FachadaServiços extends Serializable{
    public void cadastrar(Usuario usuario) throws UsuarioCadastradoException;
    public void atualizar(Usuario usuario) throws UsuarioNaoCadastradoException;
    public void removerUsuario(Long id) throws UsuarioNaoCadastradoException;
    public List<Usuario> listarTodos();
    public Usuario listarByEmail(String email) throws UsuarioNaoCadastradoException;
    public List<Usuario> listarByNome(String nome) ;
    public Usuario logar(String email,String senha) throws UsuarioInvalidoException;
    
    public void cadastrar(Doce doce) throws DoceCadastradoException;
    public void atualizar(Doce doce) throws DoceNaoCadastradoException;
    public void removerDoce(Long id) throws DoceNaoCadastradoException;
    public Doce listByNome(String nome)throws DoceNaoCadastradoException;
    public List<Doce> listByCobertura(String cobertura);
    public List<Doce> listByMassa(String massa);
    public List<Doce> listByRecheio(String recheio);
    public List<Doce> listByPreco(Double preco);
    public List<Doce> listarTodosDoce();

    public void cadastrar(Pedido pedido) throws PedidoCadastradoException;
    public void atualizar(Pedido pedido) throws PedidoNaoCadastradoException;
    public void removerPedido(Long id) throws PedidoNaoCadastradoException;
    public List<Pedido> listByUsuario(Usuario usuario);
    public List<Pedido> listByDataEntrega(Date entrega);
    public List<Pedido> listByDataPedido(Date pedido);
    public List<Pedido> listAll();
}
