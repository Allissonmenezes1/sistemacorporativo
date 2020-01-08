/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.dao;

import modelo.Estoque;
import modelo.produto;
import controle.FabricaDeConexoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DaoEstoque {
    private Connection con;
    private ResultSet rs;
    public int status;
    
     public DaoEstoque(){
       this.con=new FabricaDeConexoes().getConnection(); 
    }
    
    public void cadastrar(Estoque esto){
     try{
        PreparedStatement p=con.prepareStatement
        ("insert into estoque(modelo,quantidade,valor)values(?,?,?)");
        p.setString(1,esto.getModelo());
        p.setString(2,esto.getQuantidade());
        p.setString(3,esto.getValor()); 
        p.execute();
        p.close();       
        
     }
     catch(SQLException erro){
         throw new RuntimeException(erro);
         
     }       
  
    }
     public void editar(Estoque esto){
     try{
        PreparedStatement p=con.prepareStatement
        ("update estoque set modelo=?,quantidade=?,valor=? where idesto='"+esto.getIdestoque()+"';");
        p.setString(1,esto.getModelo());
        p.setString(2,esto.getQuantidade());
        p.setString(3,esto.getValor()); 
        p.execute();
        p.close();       
        
     }
     catch(SQLException erro){
         throw new RuntimeException(erro);
         
     }       
        
    }
      public void buscarprod(Estoque esto){
    
    try{
       PreparedStatement p=con.prepareStatement
        ("select * from estoque where nome = '"+esto.getIdestoque()+"';");
        
       rs=p.executeQuery();
       
       if(rs.first()){
     esto.setIdestoque(rs.getInt("idestoque"));
     esto.setModelo(rs.getString("modelo"));
     esto.setQuantidade(rs.getString("quantidade"));
     esto.setValor(rs.getString("valor"));
       }else{
           JOptionPane.showMessageDialog(null,"Produto não encontrado no estoque");
       }     
      
       p.close();
    }
    catch(SQLException erro){
        throw new RuntimeException(erro);
    }    
}    

    public void cadastrar(visualizacao.estoque esto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
