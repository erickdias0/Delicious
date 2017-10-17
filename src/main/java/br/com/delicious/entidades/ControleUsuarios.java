/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.delicious.entidades;

import java.util.Objects;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Erick
 */
@Entity
public class ControleUsuarios {
    
private Integer tipoId;
private Usuario usuario;
private String tipo;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.tipoId);
        hash = 37 * hash + Objects.hashCode(this.usuario);
        hash = 37 * hash + Objects.hashCode(this.tipo);
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
        final ControleUsuarios other = (ControleUsuarios) obj;
        if (!Objects.equals(this.tipoId, other.tipoId)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return true;
    }

    public void setTipoId(Integer tipoId) {
        this.tipoId = tipoId;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getTipoId() {
        return tipoId;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Usuario getUsuario() {
        return usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public static Logger getLOG() {
        return LOG;
    }

    public ControleUsuarios(Integer tipoId, Usuario usuario, String tipo) {
        this.tipoId = tipoId;
        this.usuario = usuario;
        this.tipo = tipo;
    }

    public ControleUsuarios() {
    }
    private static final Logger LOG = Logger.getLogger(ControleUsuarios.class.getName());

}
