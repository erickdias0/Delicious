/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.delicious.persistencia;

import br.com.delicious.entidades.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Erick
 */

public interface RepositorioUsuarios extends CrudRepository<Usuario,Long>{
    
   public Usuario findByEmail(String email);
   public Usuario findByEmailAndSenha(String email,String senha);
   public Usuario findById(Long id);
   public List<Usuario> findByNome(String nome);
   
}
