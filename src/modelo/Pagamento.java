/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author allis
 */
public class Pagamento {
    
   private int idpagamento;
   private String tipopagamento;
   private String datapagamento;
   private String valortotal;
   private String valorrecebido;
   private String troco;
   
    public int getIdpagamento() {
        return idpagamento;
    }

    public void setIdpagamento(int idpagamento) {
        this.idpagamento = idpagamento;
    }

    public String getTipopagamento() {
        return tipopagamento;
    }

    public void setTipopagamento(String tipopagamento) {
        this.tipopagamento = tipopagamento;
    }

    public String getDatapagamento() {
        return datapagamento;
    }

    public void setDatapagamento(String datapagamento) {
        this.datapagamento = datapagamento;
    }

    public String getValortotal() {
        return valortotal;
    }

    public void setValortotal(String valortotal) {
        this.valortotal = valortotal;
    }

    public String getValorrecebido() {
        return valorrecebido;
    }

    public void setValorrecebido(String valorrecebido) {
        this.valorrecebido = valorrecebido;
    }

    public String getTroco() {
        return troco;
    }

    public void setTroco(String troco) {
        this.troco = troco;
    }
}
  