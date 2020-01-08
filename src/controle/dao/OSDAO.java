 
package controle.dao;
 
import controle.FabricaDeConexoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Cliente;
import modelo.OS;
import modelo.Tecnico;

public class OSDAO {
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    public OSDAO() {
        conn = new FabricaDeConexoes().getConnection();
    }
    
    public void inserirOS(OS os) throws SQLException{
        String sql = "INSERT INTO `os`(`equipamento`, `descricao`, `dataSaida`, `clienteId`, `tecnicoId`) VALUES "
                + "(?,?,?,?,?)";
        this.stmt = conn.prepareStatement(sql);
        this.stmt.setString(1, os.getEquipamento());
        this.stmt.setString(2, os.getDescricao());
        this.stmt.setString(3, os.getDataSaida());
        this.stmt.setInt(4, os.getIdCliente() );
        this.stmt.setInt(5, os.getIdTecnico());
        this.stmt.execute();
        this.stmt.close();
        this.conn.close();
    }
    
    public void editarOS(OS os) throws SQLException {
        String sql = "UPDATE `os` SET "
                + "`equipamento`=?,`descricao`=?,"
                + "`dataSaida`=?,`clienteId`=?,`"
                + "tecnicoId`=? ";
        this.stmt = conn.prepareStatement(sql);
       
        this.stmt.setString(1, os.getEquipamento());
        this.stmt.setString(2, os.getDescricao());
        this.stmt.setString(3, os.getDataSaida());
        this.stmt.setInt(4, os.getIdCliente() );
        this.stmt.setInt(5, os.getIdTecnico());
        this.stmt.setInt(6, os.getId());
        
        this.stmt.execute();
        this.stmt.close();
        this.conn.close();
    }
    
    public void excluirOS(int id) throws SQLException {
        this.stmt = conn.prepareStatement("DELETE FROM `os` ");
        this.stmt.setInt(1, id);
        this.stmt.execute();
    }
    
     public OS buscarOS(int id) throws SQLException{
          String sql = "SELECT * FROM os WHERE id=? ";
          stmt = conn.prepareStatement(sql);
          stmt.setInt(1, id);
          rs = stmt.executeQuery();
          OS os = new OS();
          if(rs.next()){
              os.setId(rs.getInt("id"));
              os.setMomento(rs.getDate("momento"));
              os.setEquipamento(rs.getString("equipamento"));
              os.setDescricao(rs.getString("descricao"));
              os.setDataSaida(rs.getString("dataSaida"));
              Cliente c = new Cliente();
              c.setId(rs.getInt("clienteId"));
              Tecnico t = new Tecnico();
              t.setId(rs.getInt("TecnicoId"));
              os.setIdCliente(c);
              os.setIdTecnico(t);        
          }
          return os;
      }
}
