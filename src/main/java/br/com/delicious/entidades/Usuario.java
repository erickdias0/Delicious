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
public class Usuario implements Serializable{
    private Boolean ativo;
    private Long id;
    private String nome;
    private String endereco;
    private String senha;
    private String telefone;
    private String email;
    private String cpf;
    private List<Pedido> pedido;
    private List<Doce> docescustom;
    private Set<ControleUsuarios> controleusuarios = new HashSet<ControleUsuarios>(0);
    public Usuario(Set<ControleUsuarios> controle,Long id, String nome, String endereco, String senha, String telefone, String login, String cpf) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.senha = senha;
        this.telefone = telefone;
        this.email = login;
        this.cpf = cpf;
        this.pedido = new ArrayList<>();
        this.ativo = true;
        this.docescustom = new ArrayList<>();
        this.controleusuarios = controle;
    }

    public Usuario() {
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isAtivo() {
        return ativo;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + Objects.hashCode(this.endereco);
        hash = 79 * hash + Objects.hashCode(this.senha);
        hash = 79 * hash + Objects.hashCode(this.telefone);
        hash = 79 * hash + Objects.hashCode(this.email);
        hash = 79 * hash + Objects.hashCode(this.cpf);
        return hash;
    }

    public void setDocescustom(List<Doce> docescustom) {
        this.docescustom = docescustom;
    }
    @ManyToMany(fetch=FetchType.EAGER)
    public List<Doce> getDocescustom() {
        return docescustom;
    }
    @OneToMany(mappedBy = "usuario",fetch = FetchType.EAGER)
    public List<Pedido> getPedido() {
        return pedido;
    }

    public static Logger getLOG() {
        return LOG;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public Set<ControleUsuarios> getControleUsuarios() {
		return this.controleusuarios;
	}

        public void setControleUsuarios(Set<ControleUsuarios> controle) {
		this.controleusuarios = controle;
	}
    
        public void setPedido(List<Pedido> pedido) {
        this.pedido = pedido;
    }
    private static final Logger LOG = Logger.getLogger(Usuario.class.getName());

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        return true;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}

