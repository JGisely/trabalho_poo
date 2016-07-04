/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guanabara;

import java.util.ArrayList;

/**
 *
 * @author isouza
 */
public class Compra {
//    ArrayList<ArrayList<Item>> compras = new ArrayList<ArrayList<Item>>();
    ArrayList<Item> itens = new ArrayList<Item>();
    Double total = 0.0;
    public void addItem(Item item){
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
}
