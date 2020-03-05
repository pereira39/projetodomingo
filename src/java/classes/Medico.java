/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import dao.*;
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
 * @author antoniocar
 */
@Entity
@PrimaryKeyJoinColumn(name = "id_medico", referencedColumnName = "id_usuario")
public class Medico extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "id_medico")
    private long id;
    private String crm;
    private String especialidade;
    @OneToMany(mappedBy = "medico", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "id_consulta")//coluna responsável por relacionar os objetos
    private List<Consulta> consultas = new LinkedList<>();//Uma subClasse da entidade não pode ter idClass pq resultará em multiplos IDs
    //na hierarquia da entidade

    public Medico() {
    }

    public Medico(String crm, String especialidade) {
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public Medico(String crm, String especialidade, String nome, String identificador, int senha) {
        super(nome, identificador, senha);
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    @Override
    public String toString() {
        return "Medico{" + "crm=" + crm + ", especialidade=" + especialidade + ", consultas=" + consultas + '}';
    }

    public List<Medico> buscarTodos() {
        return new MedicoDAO().buscarTodos();
    }
    
    public void salvar(){
            new MedicoDAO().salvar(this);
    }
   
    public void remover() {
        new MedicoDAO().remover(this.getId());
    }
   
   public void cadastrarMed(){
            new MedicoDAO().cadastrarMed(this);
    }
    public Medico atualizar() {
        return new MedicoDAO().atualizar(this);
    }

}
