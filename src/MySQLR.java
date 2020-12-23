import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class MySQLR {
    
    public Connection conn;
    public Statement stmt;
    public ResultSet rs;

    public boolean connect(String address, String port, String dataBaseName, String user, String password) {
        boolean status = false; 
        try {
            conn = DriverManager.getConnection("jdbc:mysql://"+ address + ":" + port +"/"+ dataBaseName + "?user=" + user + "&password=" + password + "&useTimezone=true&serverTimezone=UTC"); 
            status = true;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return status;
    }
    // Para inserções, alterações e exclusões   
    public int executeUpdate(String query) {     
        int status = 0;
        try {
            stmt = conn.createStatement();           
            status = stmt.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return status;
    }
    // Para consultas
    public ResultSet executeQuery(String query) {
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return rs;   
    }
    
    public int inserir(Mercado mercado){
        String query = "INSERT INTO mercado (nome, email, telefone, endereco) "
                + "values ('"+mercado.nome+"', '"+mercado.email+"', '"+mercado.telefone+"', '"+mercado.endereco+"')";
        int status = executeUpdate(query);
        return status;
    }
    
    public int inserir(String produto){
        String query = "INSERT INTO produto (nome) "+"values ('"+produto+"')";
        int status = executeUpdate(query);
        return status;
    }
    
    public int excluir(int ID, String table){
        String query = "DELETE FROM "+table+" WHERE id="+ ID;
        int status = executeUpdate(query);
        return status;
    }
    
    public void inserirPedido(String numero, String produtoID){
        String query = "INSERT INTO listapedidos values ('"+numero+"','"+produtoID+"')";
        executeUpdate(query);
    }
    
    public int criarLista(String idmercado){
        String query = "INSERT INTO lista (id_mercado,situacao) values ('"+idmercado+"','Aberta')";
        int status = executeUpdate(query);
        return status;
    }
}
