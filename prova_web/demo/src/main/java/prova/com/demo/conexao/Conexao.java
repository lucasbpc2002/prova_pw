package prova.com.demo.conexao;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Conexao{

    private static Connection connection = null; 

    public static Connection getConnection() {
        if (connection == null) {
                Properties properties = loadProperties();
                String url = properties.getProperty("dburl");
                connection = DriverManager.getConnection(url, properties);
                System.out.println("Conexao realizada com sucesso!");
            }
            catch (SQLException e) {
                System.out.println("Conexao falhou!");
                throw new Exception(e.getMessage());

            }
        }
        return connection; //retorno do connection. conexao feita
    }

    public static void closeConnection() {//desligando a conexao
        if (connection != null) {//quando ligado
            try {//tenta desligar
                connection.close(); //fecha a conexao
                connection = null;
                System.out.println("Conexao encerrada com sucesso!");
            } catch (SQLException e) {
                System.out.println("Conexao nao encerrada com sucesso!");
                throw new Exception(e.getMessage());
            }
        }
    }

    private static Properties loadProperties() {
        //abrindo o arquivo db.properties
        try (FileInputStream fileInputStream = new FileInputStream("db.properties")) {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            
            return properties;
        }
        catch (IOException e) {
            throw new Exception(e.getMessage()); 
        }
    }


    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new Exception(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new Exception(e.getMessage());
            }
        }
    }
}