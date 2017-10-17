/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.delicious.negocios;

import br.com.delicious.entidades.Usuario;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Erick
 */
public interface ServiçosUsuario extends Serializable{
    public void cadastrar(Usuario usuario) throws UsuarioCadastradoException;
    public void atualizar(Usuario usuario) throws UsuarioNaoCadastradoException;
    public void remover(Long id) throws UsuarioNaoCadastradoException;
    public List<Usuario> listarTodos();
    public Usuario listarByEmail(String email) throws UsuarioNaoCadastradoException;
    public List<Usuario> listarByNome(String nome);
    public Usuario logar(String email,String senha)throws UsuarioInvalidoException;
}
