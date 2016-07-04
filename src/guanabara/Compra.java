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
    ArrayList<ArrayList<Item>> compras = new ArrayList<ArrayList<Item>>();
    
    
    public void setCompra(ArrayList<Item> listaCompras){
        compras.add(listaCompras);
        listaCompras = null;
    }
}
