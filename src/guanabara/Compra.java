/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guanabara;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author isouza
 */
public class Compra {
//    ArrayList<ArrayList<Item>> compras = new ArrayList<ArrayList<Item>>();
    ArrayList<Item> itens = new ArrayList<Item>();
    Double total = 0.0;
    
    private void addItem(Item item){
        itens.add(item);
        total += item.getTotal();
    }
    
    public void listarItens(){
        for (Item item : itens){
            System.out.println(item.getNome() + ": "+ item.getQuantidade() + "*" + item.getPreco() + " = " + item.getTotal());
        }
        System.out.println("Total: " + total);
    }
    
    public Double getTotal(){
        return total;
    }
    
    
    public void adicionarItem(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Qual item voce quer adicionar?");
        Produto p = Produto.getProduto(teclado.nextLine());
        Item item = new Item();
        System.out.println("Qual a quantidade desejada?");
        item.setItem(p,teclado.nextInt());
        addItem(item);
    }
    
    public void finalizar(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("==================================");
        System.out.println("|       Formas de Pagamento      |");
        System.out.println("==================================");
        System.out.println("| Opções:                        |");
        System.out.println("|        1. Debito               |");
        System.out.println("|        2. Dinheiro             |");
        System.out.println("==================================");
        System.out.println("| OBS:  Não aceitamos cheques    |");
        System.out.println("==================================");
        int opcao = teclado.nextInt();
        switch (opcao) {
            case 1: {
                PagamentoCartao pc = new PagamentoCartao(getTotal(),this);
                break;
            }
            case 2: {
                PagamentoDinheiro pd = new PagamentoDinheiro(getTotal(),this);
                break;
            }
            default: {
                break;
            }
        }
            
    }
}
