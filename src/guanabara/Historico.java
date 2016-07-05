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
public class Historico {
    ArrayList<Compra> historicos = new ArrayList<Compra>();
    Double total;
    
    public void setHistorico(Compra compra){
        historicos.add(compra);
        setTotal(compra.getTotal());
    }
    
    private void setTotal(Double valor){
        total = valor;
    }
    
    public void getRelatorioVendas(){
        for (Compra compra : historicos){
            System.out.println(compra.getTotal());
        }
        System.out.println("Total vendido: " + total);
    }
}
