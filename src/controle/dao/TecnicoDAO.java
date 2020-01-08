package controle.dao;

import controle.FabricaDeConexoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Tecnico;

public class TecnicoDAO {

    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    public TecnicoDAO() {
        conn = new FabricaDeConexoes().getConnection();
    }

    public void inserirTecnico(Tecnico t) throws SQLException {
        String sql = "insert into tecnico (nome,cpf,rg) values(?,?,?)";
        this.stmt = this.conn.prepareStatement(sql);
        this.stmt.setString(1, t.getNome());
        this.stmt.setString(2, t.getCpf());
        this.stmt.setString(3, t.getRg());
        this.stmt.execute();
        this.stmt.close();
        this.conn.close();
    }

    public void editarTecnico(Tecnico t) throws SQLException {
        String sql = "update tecnico set nome=?, cpf=?, rg=? where id= ?";
        this.stmt = this.conn.prepareStatement(sql);
        this.stmt.setString(1, t.getNome());
        this.stmt.setString(2, t.getCpf());
        this.stmt.setString(3, t.getRg());
        this.stmt.execute();
        this.stmt.close();
        this.conn.close();
    }

    public void excluirTecnico(int id) throws SQLException {
        String sql = "DELETE FROM `tecnico` WHERE `tecnico`.`id` = ?;";
        this.stmt = this.conn.prepareStatement(sql);
        this.stmt.setInt(1, id);
        this.stmt.execute();
        this.stmt.close();
        this.conn.close();
    }

    public Tecnico buscarTecnico(String cpf) throws SQLException {
        String sql = "select * from tecnico where cpf = ?";
        this.stmt = this.conn.prepareStatement(sql);
        this.stmt.setString(1, cpf);
        this.rs = this.stmt.executeQuery();
        Tecnico t = new Tecnico();

        if (rs.next()) {
            t.setId(rs.getInt("id"));
            t.setNome(rs.getString("nome"));
            t.setCpf(rs.getString("cpf"));
            t.setRg(rs.getString("rg"));
        }
        this.stmt.close();
        this.rs.close();
        this.conn.close();
        return t;
    }
}
