/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guanabara;

import static guanabara.Guanabara.listaGerente;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author isouza
 */
public class Gerente extends Pessoa{
    
    
    public void create(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o nome:");
        setNome(teclado.nextLine());
        System.out.println("Digite a senha:");
        setSenha(teclado.nextLine());
        listaGerente.add(this);
    }
    
    public static Gerente login(ArrayList<Gerente> listaGerente){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o gerente buscado:");
        String username = teclado.nextLine();
        System.out.println("Digite a senha do gerente:");
        String senha = teclado.nextLine();
        for (Gerente gerente : listaGerente){
            if ((gerente.getNome().equals(username)) && (gerente.getSenha().equals(senha)) ){
                return gerente;
            }
        }
        return null;
    }
}
