/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guanabara;

import static guanabara.Guanabara.listaFuncionario;
import static guanabara.Guanabara.funcionarioLogado;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author isouza
 */
public class Funcionario extends Pessoa implements PessoaContratada {
    public static Funcionario setLogged(String username, String senha){
        for (Funcionario func : listaFuncionario){
            if ((func.getNome().equals(username)) && (func.getSenha().equals(senha)) ){
                return func;
            }
        }
        return null;
    }
  
    public static Funcionario login(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o usuario:");
        String username = teclado.nextLine();
        System.out.println("Digite a senha:");
        String senha = teclado.nextLine(); 
        return setLogged(username,senha);
    }
    
    
    public void pedirDemissao(){
        listaFuncionario.remove(this);
    }

}
