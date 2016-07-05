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
public abstract class Pessoa {
    protected String nome;
    protected String senha;
    
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
    
    public void create(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o nome:");
        setNome(teclado.nextLine());
        System.out.println("Digite a senha:");
        setSenha(teclado.nextLine());
        adicionar();
    };
    
    public void login(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o usuario:");
        String username = teclado.nextLine();
        System.out.println("Digite a senha:");
        String senha = teclado.nextLine();
        setLogged(username,senha);
    }
    
    public abstract void setLogged(String username, String senha);
    public abstract void adicionar();
    
}
