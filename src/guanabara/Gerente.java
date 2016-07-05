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
public class Gerente extends Pessoa{    
    
    public void adicionar(){
        listaGerente.add(this);
    }
    
    public void setLogged(String username, String senha){
        for (Gerente gerente : listaGerente){
            if ((gerente.getNome().equals(username)) && (gerente.getSenha().equals(senha)) ){
                gerenteLogado = gerente;
            }
        }
    }
}
