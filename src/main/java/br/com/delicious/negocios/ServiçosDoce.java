/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.delicious.negocios;

import br.com.delicious.entidades.Doce;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Erick
 */
public interface ServiçosDoce extends Serializable {
    public void cadastrar(Doce doce) throws DoceCadastradoException;
    public void atualizar(Doce doce) throws DoceNaoCadastradoException;
    public void remover(Long id) throws DoceNaoCadastradoException;
    public Doce listByNome(String nome)throws DoceNaoCadastradoException;
    public List<Doce> listByCobertura(String cobertura);
    public List<Doce> listByMassa(String massa);
    public List<Doce> listByRecheio(String recheio);
    public List<Doce> listByPreco(Double preco);
    public List<Doce> listarTodos();
        

}
