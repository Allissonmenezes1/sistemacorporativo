/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.dao;
import modelo.produto;
import controle.FabricaDeConexoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

    
public class DaoCadasPROD {
    

     private Connection con;
    private ResultSet rs;
    public int status;
    
     public DaoCadasPROD(){
       this.con=new FabricaDeConexoes().getConnection(); 
    }
    
    public void cadastrar(produto prod){
     try{
        PreparedStatement p=con.prepareStatement
        ("insert into produto(nomeproduto,modeloproduto,valorproduto)values(?,?,?)");
        p.setString(1,prod.getNomeproduto());
        p.setString(2,prod.getModeloproduto());
        p.setString(3,prod.getValorproduto()); 
        p.execute();
        p.close();       
        
     }
     catch(SQLException erro){
         throw new RuntimeException(erro);
         
     }       
  
    }
     public void editar(produto prod){
     try{
        PreparedStatement p=con.prepareStatement
        ("update produto set nomeproduto=?,modeloproduto=?,valorproduto=? where idprod='"+prod.getIdproduto()+"';");
        p.setString(1,prod.getNomeproduto());
        p.setString(2,prod.getModeloproduto());
        p.setString(3,prod.getValorproduto()); 
        p.execute();
        p.close();       
        
     }
     catch(SQLException erro){
         throw new RuntimeException(erro);
         
     }       
        
    }
      public void buscarprod(produto prod){
    
    try{
       PreparedStatement p=con.prepareStatement
        ("select * from produto where nome = '"+prod.getNomeproduto()+"';");
        
       rs=p.executeQuery();
       
       if(rs.first()){
           prod.setIdproduto(rs.getInt("idproduto"));
           prod.setNomeproduto(rs.getString("nomeproduto"));
           prod.setModeloproduto(rs.getString("modeloproduto"));
           prod.setValorproduto(rs.getString("valorproduto"));
       }else{
           JOptionPane.showMessageDialog(null,"Produto não encontrado!");
       }     
      
       p.close();
    }
    catch(SQLException erro){
        throw new RuntimeException(erro);
    }    
}
}