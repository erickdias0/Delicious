/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.delicious.persistencia;

import br.com.delicious.entidades.Pedido;
import br.com.delicious.entidades.Usuario;
import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Erick
 */

public interface RepositorioPedido extends CrudRepository<Pedido, Long>{
public Pedido findById(Long id);
public List<Pedido> findByPedido(Date pedido);
public List<Pedido> findByEntrega(Date entrega);
public List<Pedido> findByUsuario(Usuario usuario);


}
