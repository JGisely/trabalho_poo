/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guanabara;

import static guanabara.Guanabara.listaFuncionario;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author isouza
 */
public class Funcionario extends Pessoa {
    
    public void create(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o nome:");
        setNome(teclado.nextLine());
        System.out.println("Digite a senha:");
        setSenha(teclado.nextLine());
        listaFuncionario.add(this);
    }
    
    public static Funcionario login(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o funcionario buscado:");
        String username = teclado.nextLine();
        System.out.println("Digite a senha do funcionario:");
        String senha = teclado.nextLine();
        for (Funcionario func : listaFuncionario){
            if ((func.getNome().equals(username)) && (func.getSenha().equals(senha)) ){
                return func;
            }
        }
        return null;
    }
}
