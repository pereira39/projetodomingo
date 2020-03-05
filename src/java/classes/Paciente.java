/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import dao.PacienteDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author 0475165
 */
@Entity
@PrimaryKeyJoinColumn(name = "id_paciente",
        referencedColumnName = "id_usuario")
public class Paciente extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "id_paciente")
    private long id;
    private String cpf;
    private String telefone;
    private String endereco;
    @OneToMany(mappedBy = "paciente", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "id_consulta")//coluna responsável por relacionar os objetos
    private List<Consulta> consultas = new LinkedList<>();//Uma subClasse da entidade não pode ter idClass pq resultará em multiplos IDs
    //na hierarquia da entidade

    public Paciente() {
    }

    public Paciente(String cpf, String telefone, String endereco) {
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Paciente(String cpf, String telefone, String endereco, String nome, String identificador, int senha) {
        super(nome, identificador, senha);
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    @Override
    public String toString() {
        return "Paciente{" + "cpf=" + cpf + ", telefone=" + telefone + ", endereco=" + endereco  + '}';
    }
    
 public List<Paciente> buscarTodos() {
        return new PacienteDAO().buscarTodos();
    }
    /*
    public void salvar(){
            new PacienteDAO().salvar(this);
    }
 */
    public void cadastrar(){
            new PacienteDAO().cadastrar(this);
    }
   
   
    public void remover() {
         new PacienteDAO().remover(this.getId());
    }
    
    public Paciente atualizar() {
        return new PacienteDAO().atualizar(this);
       
    }
}
