/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guanabara;

import java.util.Scanner;

/**
 *
 * @author isouza
 */
public abstract class Pessoa implements Login {
    protected String nome;
    protected String senha;
    protected String matricula;

    public Pessoa() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o nome:");
        setNome(teclado.nextLine());
        System.out.println("Digite a senha:");
        setSenha(teclado.nextLine());
        System.out.println("Digite a matricula:");
        setMatricula(teclado.nextLine());
    }
    
    public void setMatricula(String novaMatricula){
        matricula = novaMatricula;
    }
    
    public String getMatricula(){
        return matricula;
    }
    
    public void setNome(String novoNome){
        nome = novoNome;
    }
    
    public void setSenha(String novaSenha){
        senha = novaSenha;
    }
    
    public String getSenha(){
        return senha;
    }
    
    public String getNome(){
        return nome;
    }    
}
