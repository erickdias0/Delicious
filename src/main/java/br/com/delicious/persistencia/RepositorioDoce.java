/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.delicious.persistencia;

import br.com.delicious.entidades.Doce;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Erick
 */

public interface RepositorioDoce extends CrudRepository<Doce, Long>{
    
    public Doce findById(Long id);
    public Doce findByNome(String nome);
    public List<Doce> findByCobertura(String cobertura);
    public List<Doce> findByMassa(String massa);
    public List<Doce> findByRecheio(String recheio);
    public List<Doce> findByPreco(Double preco);
    
}

