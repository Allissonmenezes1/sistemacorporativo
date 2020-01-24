/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.dao;

import modelo.Pagamento;
import modelo.produto;
import controle.FabricaDeConexoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class DaoPagamento {
       private Connection con;
    private ResultSet rs;
    public int status;
    
     public DaoPagamento(){
       this.con=new FabricaDeConexoes().getConnection(); 
    }
    
    public void cadastrar(Pagamento pag){
     try{
        PreparedStatement p=con.prepareStatement
        ("insert into pagamento(Tipopagamento,Datapagamento,Valorecebido,Troco,valortotal)values(?,?,?,?,?)");
        p.setString(1,pag.getTipopagamento());
        p.setString(2,pag.getDatapagamento());
        p.setString(3,pag.getValorrecebido());
        p.setString(4,pag.getTroco());
        p.setString(5,pag.getValortotal());
        p.execute();
        p.close();       
        
     }
     catch(SQLException erro){
         throw new RuntimeException(erro);
         
     }       
  
    }
     public void editar(Pagamento pag){
     try{
        PreparedStatement p=con.prepareStatement
        ("update pagamento set Tipopagamento=?,Datapagamento=?,Valorecebido=?,troco=? where idpag='"+pag.getIdpagamento()+"';");
        p.setString(1,pag.getTipopagamento());
        p.setString(2,pag.getDatapagamento());
        p.setString(3,pag.getValorrecebido()); 
        p.setString(4,pag.getTroco());
        p.setString(5,pag.getValortotal());
        p.execute();
        p.close();       
        
     }
     catch(SQLException erro){
         throw new RuntimeException(erro);
         
     }       
        
    }
      public void buscarpag(Pagamento pag){
    
    try{
       PreparedStatement p=con.prepareStatement
        ("select * from estoque where nome = '"+pag.getIdpagamento()+"';");
        
       rs=p.executeQuery();
       
       if(rs.first()){
     pag.setIdpagamento(rs.getInt("idpag"));
     pag.setTipopagamento(rs.getString("tipopag"));
     pag.setDatapagamento(rs.getString("datapag"));
     pag.setValorrecebido(rs.getString("valoreceb"));
     pag.setTroco(rs.getString("troco"));
      pag.setValortotal(rs.getString("valortotal"));
       }else{
           JOptionPane.showMessageDialog(null,"Pagamento não encontrado");
       }     
      
       p.close();
    }
    catch(SQLException erro){
        throw new RuntimeException(erro);
    }    
}    public List<Pagamento> listPag(){
        try{
          List<Pagamento>pagr = new ArrayList<Pagamento>();
                  PreparedStatement p=con.prepareStatement("select * From pagamento");
                  rs=p.executeQuery();
                  while(rs.next()){
                      
                      Pagamento  pag = new Pagamento();
                      pag.setIdpagamento(rs.getInt("idpagamento"));
                      pag.setTipopagamento(rs.getString("Tipopagamento"));
                      pag.setTroco(rs.getString("Troco"));
                      pag.setValortotal(rs.getString("valortotal"));
                      pag.setDatapagamento(rs.getString("Datapagamento"));
                      pag.setValorrecebido(rs.getString("Valorecebido"));
                      
                      pagr.add(pag);
                  }
                  return pagr;
            
      
        }catch(SQLException erro){
           throw new RuntimeException(erro);
        }  
      }
}
