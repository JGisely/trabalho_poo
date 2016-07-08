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

    public Pagamento(Double total,Compra compra) {
        this.total = total;
        pagar();
        salvarHistorico(compra);
        compra = null;
    }
    public abstract void pagar();
    
    public void salvarHistorico(Compra compra){
        Historico h = new Historico();
        h.setHistorico(compra);
    }
}
