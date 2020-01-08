package controle.dao;

import controle.FabricaDeConexoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Usuario;

public class UsuarioDAO {

    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    public UsuarioDAO() {
        conn = new FabricaDeConexoes().getConnection();
    }
    
    public boolean login(Usuario u) throws SQLException{
        this.stmt = conn.prepareStatement("select * from usuario where usuario=? and senha = ?");
        this.stmt.setString(1, u.getUsuario());
        this.stmt.setString(2, u.getSenha());
        this.rs = this.stmt.executeQuery();
        if(rs.next()){
            return true;
        }else{
            return false;
        }
    }
}
