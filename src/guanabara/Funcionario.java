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
    
    public void adicionar(){
        listaFuncionario.add(this);
    }
    
    public void setLogged(String username, String senha){
        for (Funcionario func : listaFuncionario){
            if ((func.getNome().equals(username)) && (func.getSenha().equals(senha)) ){
                funcionarioLogado = func;
            }
        }
    }
    
    public void pedirDemissao(){
        listaFuncionario.remove(this);
        funcionarioLogado = null;
    }
}
