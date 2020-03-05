/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import dao.UsuarioDAO;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author antoniocar Justificativa para a escolha da estratégia de
 * generalização como JOINED: este modelo é o mais se aproxima ao modelo
 * orientado a objetos, pois cada classe possuirá a sua própria tabela e suas
 * respectivas chaves primárias e estrangeias quando couber. Dá mais clareza ao
 * projeto efacilidade de manutenção.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;
    private String nome;
    private String identificador;
    private int senha;

    public Usuario() {
    }

    public Usuario(String nome, String identificador, int senha) {
        this.nome = nome;
        this.identificador = identificador;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

   public void cadastrar(){
            new UsuarioDAO().cadastrar(this);

}

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", identificador=" + identificador + ", senha=" + senha + '}';
    }
   
}