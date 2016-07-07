/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guanabara;

import static guanabara.Guanabara.compra;

/**
 *
 * @author isouza
 */
public abstract class Pagamento implements Runnable {
    
    protected Double total;

    public Pagamento(Double total) {
        this.total = total;
        pagar();
        finalizar();
    }
    public abstract void pagar();
    
    public void finalizar(){
        Historico h = new Historico();
        h.setHistorico(compra);
        compra = null;
    }
}
