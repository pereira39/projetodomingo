package controller;

import classes.Paciente;
import java.io.Serializable;
import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



@ManagedBean
@SessionScoped
public class PacienteBean implements Serializable{
    private static final long serialVersionUID = 1L;
    private Paciente paciente = new Paciente();
    private Paciente pacienteLogado = new Paciente();
    private List<Paciente> lista ;

    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Paciente getPacienteLogado() {
        return pacienteLogado;
    }

    public void setPacienteLogado(Paciente usuarioLogado) {
        this.pacienteLogado = pacienteLogado;
    }

    public List<Paciente> getLista() {
        if(lista == null)
           return paciente.buscarTodos();
        return lista;
    }
   
    public String atualizar(Paciente user){
        System.out.println("Entrou no atualizar!!");
        paciente.atualizar();
        //usuario.listar();
        return "listarPaciente";
    }
    public String cadastrar() {
        System.out.println("Entrou no cadastrar!!");
        paciente.cadastrar();
        //usuario.listar();
        return "listarPaciente";
    }
    /*
    public String validar() {
        if(paciente.validar()){
           this.pacienteLogado = paciente;    
           paciente = new Paciente();
           return "listarPaciente";
        }
        return "invalido";
    }*/
    
    public void limpar() {
       this.paciente = new Paciente();
    }
     
    public String remover(Paciente user){
        System.out.println("Entrou no excluir!!");// só aparece na tela do GlassFish
        user.remover();
        lista = paciente.buscarTodos();
        return "listarPaciente";
    }
     public String editar(Paciente user){
        System.out.println("Entrou no editar!!");
        this.paciente = user;
        return "editarPaciente";
    }
}
