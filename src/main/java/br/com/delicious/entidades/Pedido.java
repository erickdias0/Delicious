/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.delicious.entidades;
import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import java.util.logging.Logger;
/**
 *
 * @author Erick
 */
@Entity
public class Pedido implements Serializable{

    public Pedido(Long id,Usuario usuario, List<Doce> doce) {
        this.id = id;
        this.pedido = new Date();
        this.entrega=new Date();
        this.usuario = usuario;
        this.doce = new ArrayList<>();
 }
    
    private Long id;
    private Date pedido;

    
    private Date entrega;
    private Usuario usuario;
    private List<Doce> doce;
        private static final Logger LOG = Logger.getLogger(Pedido.class.getName());

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pedido() {
    }

    
    @ManyToOne
    public Usuario getUsuario() {
        return usuario;
    }
    //mappedby colocar
    @ManyToMany(fetch = FetchType.EAGER)
    public List<Doce> getDoce() {
        return doce;
    }

    public static Logger getLOG() {
        return LOG;
    }

    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.pedido);
        hash = 97 * hash + Objects.hashCode(this.entrega);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.pedido, other.pedido)) {
            return false;
        }
        if (!Objects.equals(this.entrega, other.entrega)) {
            return false;
        }
        return true;
    }
    
    

    /**
     *
     * @return
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setDoce(List<Doce> doce) {
        this.doce = doce;
    }
    

    public void setId(Long id) {
        this.id = id;
    }
    
    
    

    public void setPedido(Date pedido) {
        this.pedido = pedido;
    }

    public void setEntrega(Date entrega) {
        this.entrega = entrega;
    }
    @Temporal(TemporalType.DATE)
    public Date getPedido() {
        return pedido;
    }
    @Temporal(TemporalType.DATE)
    public Date getEntrega() {
        return entrega;
    }

    
    
    
    
    
}

