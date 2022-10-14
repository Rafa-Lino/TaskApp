package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Rafael
 */
public class ConnectionFactory {
    
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/gerenciadordetarefas";
    public static final String USER = "root";
    public static final String PASS = "";
    
    //https://mvnrepository.com/artifact/mysql/mysql-connector-java
    
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception ex) {
            throw new RuntimeException("Erro na conexão com o Banco de Dados");
        }
    }
    
    public static void closeConnection(Connection connection){
        try {
            if (connection != null){
                connection.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conexão com o Banco de Dados");
        }
        
    }
}
