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
public class Item extends Produto {
    private int quantidade;
    private double total;
    private Scanner teclado = new Scanner(System.in);
    
    public Item(Produto p) {
        System.out.println("Digite a quantidade do produto");
        this.setQuantidade(teclado.nextInt());
        this.setNome(p.getNome());
        this.setPreco(p.getPreco());
        setTotal();
    }
    
    
    
    public void setQuantidade(int novaQuantidade){
        quantidade = novaQuantidade;
    }
    
    public int getQuantidade(){
        return quantidade;
    }
    
    public void setTotal(){
        total = quantidade * preco;
    }
    
    public Double getTotal(){
        return total;
    }
    
    public void setItem(Produto p, int quantidade){
        this.setNome(p.getNome());
        this.setPreco(p.getPreco());
        this.setQuantidade(quantidade);
        setTotal();
    }
}
