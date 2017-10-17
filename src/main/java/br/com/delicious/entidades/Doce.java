/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.delicious.entidades;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import javax.persistence.*;
import javax.persistence.ManyToOne;
/**
 *
 * @author Erick
 */
@Entity
public class Doce implements Serializable{
    private Long id;
    private String nome;
    private String cobertura;
    private String massa;
    private String recheio;
    private Double preco;

    public Doce(Long id,String nome, String cobertura, String massa, String recheio, Double preco) {
        this.id = id;
        this.nome = nome;
        this.cobertura = cobertura;
        this.massa = massa;
        this.recheio = recheio;
        this.preco = preco;
    
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    
    
    public Long getId() {
        return id;
    }
            
    private static final Logger LOG = Logger.getLogger(Doce.class.getName());

    public Doce() {
    }

    

    public Double getPreco() {
        return this.preco;
    }
    

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + Objects.hashCode(this.cobertura);
        hash = 59 * hash + Objects.hashCode(this.massa);
        hash = 59 * hash + Objects.hashCode(this.recheio);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.preco) ^ (Double.doubleToLongBits(this.preco) >>> 32));
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
        final Doce other = (Doce) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cobertura, other.cobertura)) {
            return false;
        }
        if (!Objects.equals(this.massa, other.massa)) {
            return false;
        }
        if (!Objects.equals(this.recheio, other.recheio)) {
            return false;
        }
        if (Double.doubleToLongBits(this.preco) != Double.doubleToLongBits(other.preco)) {
            return false;
        }
        return true;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }

    public void setMassa(String massa) {
        this.massa = massa;
    }

    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCobertura() {
        return this.cobertura;
    }

    public String getMassa() {
        return massa;
    }

    public String getRecheio() {
        return recheio;
    }

    public static Logger getLOG() {
        return LOG;
    }
    
    
}
