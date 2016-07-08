/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guanabara;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author isouza
 */

public class Guanabara {
    static ArrayList<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
    static ArrayList<Gerente> listaGerente = new ArrayList<Gerente>();
    static ArrayList<Produto> listaProduto = new ArrayList<Produto>();
    static Funcionario funcionarioLogado;
    static Gerente gerenteLogado;
    
    public static void main(String[] args) {
        Mercado mercado = new Mercado();
    }
}
