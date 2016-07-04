/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guanabara;

/**
 *
 * @author isouza
 */
public abstract class Pagamento {
    
    protected Double total;

    public Pagamento(Double total) {
        this.total = total;
        pagar();
    }
    public abstract void pagar();
}
