/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.delicious.negocios;

import br.com.delicious.entidades.Usuario;
import br.com.delicious.persistencia.RepositorioUsuarios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Erick
 */
@Service
public class ServiçosUsuarioImpl implements ServiçosUsuario{
    
    @Autowired
    private RepositorioUsuarios repositorio;

    public ServiçosUsuarioImpl() {
    }
    
    @Override
    @Transactional(rollbackFor = UsuarioCadastradoException.class)
    public void cadastrar(Usuario usuario) throws UsuarioCadastradoException {
        
        if(repositorio.findByEmail(usuario.getEmail())!=null) throw new UsuarioCadastradoException();
        repositorio.save(usuario);
   
                }

    @Override
    @Transactional(rollbackFor = UsuarioNaoCadastradoException.class)
    public void atualizar(Usuario usuario) throws UsuarioNaoCadastradoException {
    
        Usuario userAtualizar = repositorio.findByEmail(usuario.getEmail());
        if(userAtualizar==null)throw new UsuarioNaoCadastradoException();
        userAtualizar.setNome(usuario.getNome());
        userAtualizar.setSenha(usuario.getSenha());
        userAtualizar.setEndereco(usuario.getEndereco());
        userAtualizar.setTelefone(usuario.getTelefone());
        repositorio.save(userAtualizar);
            
    
    }

    @Override
    @Transactional(rollbackFor = UsuarioNaoCadastradoException.class)
    public void remover(Long id) throws UsuarioNaoCadastradoException {
    
        Usuario userDelete = repositorio.findById(id);
        if(userDelete==null)throw new UsuarioNaoCadastradoException();
        
        if(userDelete.getPedido().isEmpty()) repositorio.delete(userDelete);
        else{
        userDelete.setAtivo(false);
        repositorio.save(userDelete);
    
    }
    }
    
    @Override
    public List<Usuario> listarTodos() {
       return (List<Usuario>) repositorio.findAll();
    }

    @Override
    public Usuario listarByEmail(String email) throws UsuarioNaoCadastradoException {
    
        Usuario userProcurar = repositorio.findByEmail(email);
        if(userProcurar==null)throw new UsuarioNaoCadastradoException();
        
        else 
            return userProcurar;
         
   
    }

    @Override
    public List<Usuario> listarByNome(String nome) {
        return repositorio.findByNome(nome);
        
    }

    @Override
    public Usuario logar(String email, String senha) throws UsuarioInvalidoException {
        Usuario userLogado = repositorio.findByEmailAndSenha(email, senha);
        if(userLogado==null) throw new UsuarioInvalidoException();
        else 
            return userLogado;
    }
    
}
