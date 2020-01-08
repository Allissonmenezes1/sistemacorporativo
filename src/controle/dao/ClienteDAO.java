package controle.dao;

import controle.FabricaDeConexoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Cliente;

public class ClienteDAO {

    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    public ClienteDAO() {
        conn = new FabricaDeConexoes().getConnection();
    }

    public void InserirCliente(Cliente c) throws SQLException {

        String sql = "insert into cliente (nome,email,telefone,cep,cpf,cidade,bairro,"
                + "logradouro,numero,complemento)"
                + " values(?,?,?,?,?,?,?,?,?,?) ";
        this.stmt = conn.prepareStatement(sql);

        this.stmt.setString(1, c.getNome());
        this.stmt.setString(2, c.getEmail());
        this.stmt.setString(3, c.getTelefone());
        this.stmt.setString(4, c.getCep());
        this.stmt.setString(5, c.getCpf());
        this.stmt.setString(6, c.getCidade());
        this.stmt.setString(7, c.getBairro());
        this.stmt.setString(8, c.getLogradouro());
        this.stmt.setInt(9, c.getNumero());
        this.stmt.setString(10, c.getComplemento());
        
        this.stmt.execute();
        this.stmt.close();
        this.conn.close();
    }

    public void excluirCliente(int id) throws SQLException {
        this.stmt = this.conn.prepareStatement("delete from cliente  ?");
        this.stmt.setInt(1, id);
        this.stmt.execute();
        this.stmt.close();
        this.conn.close();
    }

    public Cliente buscarCliente(String cpf) throws SQLException {
        String sql = "select * from cliente where cpf =?";
        this.stmt = this.conn.prepareStatement(sql);
        this.stmt.setString(1, cpf);
        this.rs = this.stmt.executeQuery();
            Cliente c = new Cliente();
        
            if (rs.next()) {
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setEmail(rs.getString("email"));
            c.setTelefone(rs.getString("telefone"));
            c.setCep(rs.getString("cep"));
            c.setCpf(rs.getString("cpf"));
            c.setCidade(rs.getString("cidade"));
            c.setBairro(rs.getString("bairro"));
            c.setLogradouro(rs.getString("logradouro"));
            c.setNumero(rs.getInt("numero"));
            c.setComplemento(rs.getString("complemento"));
        }

        this.stmt.close();
        this.rs.close();
        this.conn.close();
        return c;
    }

    public void editarCliente(Cliente c) throws SQLException {
        String sql = "UPDATE `cliente` SET `nome`=?,`email`=?,"
                + "`telefone`=?,`cep`=?,`cpf`=?,`cidade`=?,`bairro`=?,"
                + "`logradouro`=?,`numero`=?,`complemento`=?";
        this.stmt = this.conn.prepareStatement(sql);

        this.stmt.setString(1, c.getNome());
        this.stmt.setString(2, c.getEmail());
        this.stmt.setString(3, c.getTelefone());
        this.stmt.setString(4, c.getCep());
        this.stmt.setString(5, c.getCpf());
        this.stmt.setString(6, c.getCidade());
        this.stmt.setString(7, c.getBairro());
        this.stmt.setString(8, c.getLogradouro());
        this.stmt.setInt(9, c.getNumero());
        this.stmt.setString(10, c.getComplemento());
        this.stmt.setInt(11, c.getId());

        this.stmt.execute();
        this.stmt.close();
        this.conn.close();
    }
}
