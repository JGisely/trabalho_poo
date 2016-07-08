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
public class PagamentoDinheiro extends Pagamento {

    private Double valorPago;
    private Double troco;    
    
    public PagamentoDinheiro(Double totalCompra, Compra compra) {
        super(totalCompra, compra);
    }
    
    @Override
    public void pagar() {        
       setValorPago();
       calculaTroco();
       printTroco();
    }

    public void setValorPago(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o valor pago:");
        valorPago = teclado.nextDouble();
    }
    
    public void printTroco(){
        System.out.println("Seu troco é de: " + troco);
    }
    
    private void calculaTroco(){
        troco = valorPago - total;
    }
}
