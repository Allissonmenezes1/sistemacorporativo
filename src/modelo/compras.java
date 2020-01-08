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
public class compras {
    
    private int idequipamento;
    private String nomeequip;
    private String modeloequip;
    private String quantidade;
    private String observacoes;

    public int getIdequipamento() {
        return idequipamento;
    }

    public void setIdequipamento(int idequipamento) {
        this.idequipamento = idequipamento;
    }

    public String getNomeequip() {
        return nomeequip;
    }

    public void setNomeequip(String nomeequip) {
        this.nomeequip = nomeequip;
    }

    public String getModeloequip() {
        return modeloequip;
    }

    public void setModeloequip(String modeloequip) {
        this.modeloequip = modeloequip;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    

}
