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
public class Estoque {
    private ArrayList<Produto> listaProduto = new ArrayList<Produto>();
       
    public void add(Produto produto){
        listaProduto.add(produto);
    }
    
    public void listar(){
        for (Produto produto : listaProduto){
            System.out.println(produto.getNome() + ": " + produto.getPreco());
        } 
    }
    
    public void remover(String nome){
        for (Produto produto : listaProduto){
            if (produto.getNome().equals(nome)) {
                listaProduto.remove(listaProduto.indexOf(produto));
            }
        }
    }
    
    public Produto getProduto(String nome){
        for (Produto produto : listaProduto) {
            if (produto.getNome().equals(nome)){
                return produto;
            }
        }
        return null;
    }
}
