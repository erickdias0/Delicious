/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.delicious.negocios;

import br.com.delicious.entidades.Doce;
import br.com.delicious.persistencia.RepositorioDoce;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Erick
 */
@Service
public class ServiçosDoceImpl implements ServiçosDoce{
    @Autowired
    private RepositorioDoce repositorio;

    public ServiçosDoceImpl() {
    }

    @Override
    @Transactional(rollbackFor = DoceCadastradoException.class)
    public void cadastrar(Doce doce) throws DoceCadastradoException {
    
        if(repositorio.findByNome(doce.getNome())!=null) throw new DoceCadastradoException();
        repositorio.save(doce);
   
                }

    @Override
    @Transactional(rollbackFor = DoceNaoCadastradoException.class)
    public void atualizar(Doce doce) throws DoceNaoCadastradoException {
        Doce doceAtualizar = repositorio.findByNome(doce.getNome());
        if(doceAtualizar==null)throw new DoceNaoCadastradoException();
        doceAtualizar.setNome(doce.getNome());
        doceAtualizar.setCobertura(doce.getCobertura());
        doceAtualizar.setMassa(doce.getMassa());
        doceAtualizar.setRecheio(doce.getRecheio());
        doceAtualizar.setPreco(doce.getPreco());
        
        repositorio.save(doceAtualizar);
        
    
    }

    @Override
    @Transactional(rollbackFor = DoceNaoCadastradoException.class)
    public void remover(Long id) throws DoceNaoCadastradoException {
        Doce doceDelete = repositorio.findById(id);
        if(doceDelete == null) throw new DoceNaoCadastradoException();
        repositorio.delete(doceDelete);
    
    }

    @Override
    public Doce listByNome(String nome) throws DoceNaoCadastradoException {
        Doce doceProcurar = repositorio.findByNome(nome);
        if(doceProcurar==null)throw new DoceNaoCadastradoException();
        
        else 
            return doceProcurar;
        
    }

    @Override
    public List<Doce> listByCobertura(String cobertura) {
    return repositorio.findByCobertura(cobertura);
        
         
            
    
    }

    @Override
    public List<Doce> listByMassa(String massa) {
            
         
            return repositorio.findByMassa(massa);
         
    
    }

    @Override
    public List<Doce> listByRecheio(String recheio) {
    return repositorio.findByRecheio(recheio);
        
         
           
    
    }

    @Override
    public List<Doce> listByPreco(Double preco) {
        
        return repositorio.findByPreco(preco);
    
        
                }

    @Override
    public List<Doce> listarTodos() {
    return (List<Doce>) repositorio.findAll();
    }
    

    
}
