package controller;

import classes.Medico;
import java.io.Serializable;
import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



@ManagedBean
@SessionScoped
public class MedicoBean implements Serializable{
    private static final long serialVersionUID = 1L;
    private Medico medico = new Medico();
    private Medico medicoLogado = new Medico();
    private List<Medico> lista ;

    public Medico getMedico() {
        return medico;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Medico getMedicoLogado() {
        return medicoLogado;
    }

    public void setMedicoLogado(Medico usuarioLogado) {
        this.medicoLogado = medicoLogado;
    }

    public List<Medico> getLista() {
        if(lista == null)
           return medico.buscarTodos();
        return lista;
    }
   
    public String atualizar(Medico medico){
        System.out.println("Entrou no atualizar!!");
        medico.atualizar();
        //usuario.listar();
        return "listarMedico";
    }
   public String cadastrarMed() {
        System.out.println("Entrou no cadastrar!!");
        medico.cadastrarMed();
        //usuario.listar();
        return "listarMedico";
    }
    /*
    public String validar() {
        if(medico.validar()){
           this.medicoLogado = medico;    
           medico = new Medico();
           return "listarMedico";
        }
        return "invalido";
    }*/
    
    public void limpar() {
       this.medico = new Medico();
    }
     
    public String remover(Medico medico){
        System.out.println("Entrou no excluir!!");// só aparece na tela do GlassFish
        medico.remover();
        lista = medico.buscarTodos();
        return "listarMedico";
    }
     public String editar(Medico medico){
        System.out.println("Entrou no editar!!");
        this.medico = medico;
        return "editarMedico";
    }
}
