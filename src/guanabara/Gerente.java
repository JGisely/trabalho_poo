/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guanabara;

import static guanabara.Guanabara.listaGerente;
import static guanabara.Guanabara.gerenteLogado;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author isouza
 */
public class Gerente extends Pessoa implements PessoaContratada{    
    
    public void adicionar(){
        listaGerente.add(this);
    }
    
    public static Gerente setLogged(String username, String senha){
        for (Gerente gerente : listaGerente){
            if ((gerente.getNome().equals(username)) && (gerente.getSenha().equals(senha)) ){
                return gerente;
            }
        }
        return null;
    }
    
    public static Gerente login(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o usuario:");
        String username = teclado.nextLine();
        System.out.println("Digite a senha:");
        String senha = teclado.nextLine(); 
        return setLogged(username,senha);
    }
    
    
    public void pedirDemissao(){
      listaGerente.remove(this);
    }
}
