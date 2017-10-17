/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.delicious.negocios;

import br.com.delicious.entidades.Doce;
import br.com.delicious.entidades.Pedido;
import br.com.delicious.entidades.Usuario;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Erick
 */
@Service
public class FachadaServiçosImpl implements FachadaServiços{
    @Autowired
    private ServiçosUsuario serviçosUsuario;
    @Autowired
    private ServiçosDoce serviçosDoce;
    @Autowired
    private ServiçosPedido serviçosPedido;
    //Serviços - Usuario
    @Override
    public void cadastrar(Usuario usuario) throws UsuarioCadastradoException {
    serviçosUsuario.cadastrar(usuario);
    }

    @Override
    public void atualizar(Usuario usuario) throws UsuarioNaoCadastradoException {
    serviçosUsuario.atualizar(usuario);
    }

    @Override
    public void removerUsuario(Long id) throws UsuarioNaoCadastradoException {
    serviçosUsuario.remover(id);
    }

    @Override
    public List<Usuario> listarTodos() {
    return serviçosUsuario.listarTodos();
    }

  
    @Override
    public Usuario listarByEmail(String email) throws UsuarioNaoCadastradoException {
    return serviçosUsuario.listarByEmail(email);
    }

    @Override
    public List<Usuario> listarByNome(String nome){
    return serviçosUsuario.listarByNome(nome);
    }
    @Override
    public Usuario logar(String email,String senha) throws UsuarioInvalidoException {
    return serviçosUsuario.logar(email, senha);
    }
    
//Serviços - Doce
    @Override
    public void cadastrar(Doce doce) throws DoceCadastradoException {
    serviçosDoce.cadastrar(doce);
    }

    @Override
    public void atualizar(Doce doce) throws DoceNaoCadastradoException {
    serviçosDoce.atualizar(doce);
            }

    @Override
    public void removerDoce(Long id) throws DoceNaoCadastradoException {
    serviçosDoce.remover(id);
            }

    @Override
    public Doce listByNome(String nome) throws DoceNaoCadastradoException {
    return serviçosDoce.listByNome(nome);
            }

    @Override
    public List<Doce> listByCobertura(String cobertura) {
    return serviçosDoce.listByCobertura(cobertura);
    }

    @Override
    public List<Doce> listByMassa(String massa) {
    return serviçosDoce.listByMassa(massa);
    }

    @Override
    public List<Doce> listByRecheio(String recheio) {
    return serviçosDoce.listByRecheio(recheio);
    }

    @Override
    public List<Doce> listByPreco(Double preco) {
    return serviçosDoce.listByPreco(preco);
    }

    @Override
    public List<Doce> listarTodosDoce() {
    return serviçosDoce.listarTodos();
    }

    //Serviços - Pedido
    @Override
    public void cadastrar(Pedido pedido) throws PedidoCadastradoException {
    serviçosPedido.cadastrar(pedido);
    }

    @Override
    public void atualizar(Pedido pedido) throws PedidoNaoCadastradoException {
        serviçosPedido.atualizar(pedido);
    }

    @Override
    public void removerPedido(Long id) throws PedidoNaoCadastradoException {
    serviçosPedido.remover(id);
    }

    @Override
    public List<Pedido> listByUsuario(Usuario usuario) {
    return serviçosPedido.listByUsuario(usuario);
    }

    @Override
    public List<Pedido> listByDataEntrega(Date entrega) {
    return serviçosPedido.listByDataEntrega(entrega);
    }

    @Override
    public List<Pedido> listByDataPedido(Date pedido) {
    return serviçosPedido.listByDataPedido(pedido);
    }

    @Override
    public List<Pedido> listAll() {
    return serviçosPedido.listAll();
    }
    
}
