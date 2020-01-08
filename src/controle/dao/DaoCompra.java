/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.dao;

import modelo.compras;
import controle.FabricaDeConexoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DaoCompra {

     private Connection con;
    private ResultSet rs;
    public int status;
    
     public DaoCompra(){
       this.con=new FabricaDeConexoes().getConnection(); 
    }
    
    public void cadastrar(compras comp){
     try{
        PreparedStatement p=con.prepareStatement
        ("insert into compras(nomeequip,modeloequip,quantidade,observacoes) values(?,?,?,?)");
        p.setString(1,comp.getNomeequip());
        p.setString(2,comp.getModeloequip());
        p.setString(3,comp.getQuantidade()); 
        p.setString(4,comp.getObservacoes());
        p.execute();
        p.close();       
        
     }
     catch(SQLException erro){
         throw new RuntimeException(erro);
         
     }       
        
    }
     public void editar(compras comp){
     try{
        PreparedStatement p=con.prepareStatement
        ("update compras set nomeequip=?,modeloequip=?,quantidade=? where idcomp='"+comp.getIdequipamento()+"';");
        p.setString(1,comp.getNomeequip());
        p.setString(2,comp.getModeloequip());
        p.setString(3,comp.getQuantidade()); 
        p.setString(4,comp.getObservacoes());
        p.execute();
        p.close();       
        
     }
     catch(SQLException erro){
         throw new RuntimeException(erro);
         
     }       
        
    }
     public void buscarcompra(compras comp){
    
    try{
       PreparedStatement p=con.prepareStatement
        ("select * from compras where nome = '"+comp.getNomeequip()+"';");
        
       rs=p.executeQuery();
       
       if(rs.first()){
           comp.setIdequipamento(rs.getInt("idequipamento"));
           comp.setNomeequip(rs.getString("nomeequip"));
           comp.setModeloequip(rs.getString("modeloequip"));
           comp.setQuantidade(rs.getString("quantidade"));
           comp.setObservacoes(rs.getString("observacoes"));
       }else{
           JOptionPane.showMessageDialog(null,"Venda não encontrada!");
       }     
      
       p.close();
    }
    catch(SQLException erro){
        throw new RuntimeException(erro);
    }    
}
}
   