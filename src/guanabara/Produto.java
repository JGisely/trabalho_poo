/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guanabara;

import static guanabara.Guanabara.listaProduto;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author isouza
 */
public class Produto {
    private String nome;
    protected Double preco;

    public Produto() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o nome do produto:");
        setNome(teclado.nextLine());
        System.out.println("Digite o preço do produto:");
        setPreco(teclado.nextDouble());
    }
    
    
    
    public void setNome(String novoNome){
        nome = novoNome;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setPreco(Double novoPreco){
        preco = novoPreco;
    }
    
    public Double getPreco(){
        return preco;
    }
    
//    public void create(){
//        Scanner teclado = new Scanner(System.in);
//        System.out.println("Digite o nome do produto:");
//        setNome(teclado.nextLine());
//        System.out.println("Digite o preço do produto:");
//        setPreco(teclado.nextDouble());
//        listaProduto.add(this);
//    }
    
    public static void editar(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o nome do produto:");
        String nome = teclado.nextLine();
        System.out.println("Digite o novo preco:");
        Double preco = teclado.nextDouble();
        for (Produto produto : listaProduto){
            if (produto.getNome().equals(nome)) {
                listaProduto.get(listaProduto.indexOf(produto)).setPreco(preco);
            }
        }
    }
    
    public static void remove(String nome){
        for (Produto produto : listaProduto){
            if (produto.getNome().equals(nome)) {
                listaProduto.remove(listaProduto.indexOf(produto));
            }
        }
    }
    
    public void imprimeProduto(){
        System.out.println(nome + ": " + preco);
    }
    
    public static Produto getProduto(String nome){
        for (Produto produto : listaProduto) {
            if (produto.getNome().equals(nome)){
                return produto;
            }
        }
        return null;
    }
    
}
