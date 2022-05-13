package prova.com.demo.respositorio;

import prova.com.demo.conexao.Conexao;
import prova.com.demo.entidades.serie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class serierepositorio {
        public static  void criarTabela(){
            System.out.println("CRIANDO TABELA");
            PreparedStatement st = null;
            Connection conn = null;
    
            try {
                System.out.println("CRIANDO TABELA - TRY");
                conn = Conexao.getConnection();//CONECTANDO
                st = conn.prepareStatement(
                    "CREATE TABLE `serie` (\n" +
                    "  `id` int NOT NULL AUTO_INCREMENT,\n" +
                    "  `nome` varchar(50) DEFAULT NULL,\n" +
                    "  `genero` varchar(50) DEFAULT NULL,\n" +
                    "  `plataforma`varchar(50) DEFAULT NULL,\n" +
                    "  `n_temporadas` int DEFAULT NULL,\n" +
                    "  `n_episodios` int DEFAULT NULL,\n" +
                    "  PRIMARY KEY (`id`)\n" +
                    ");");
                st.executeUpdate();
            }catch ( Exception e){
    
            }
    
        }
    
        public static List<serie> buscarTodos() {
            PreparedStatement st = null;
            ResultSet rs = null;
            Connection conn = null;
            try {
                List<serie> series = new ArrayList<>() ;
    
                conn = Conexao.getConnection();//CONECTANDO
                st = conn.prepareStatement(
                        "SELECT * FROM serie");
                rs = st.executeQuery();
                while (rs.next()) {
                    System.out.println("--------------------------------");
    
                    serie s = new serie();
                    s.setId(rs.getInt("id"));
                    s.setNome(rs.getString("nome"));
                    s.setGenero(rs.getString("genero"));
                    s.setPlataforma(rs.getString("plataforma"));
                    s.setN_temporadas(rs.getInt("n_temporadas"));
                    s.setN_episodios(rs.getInt("n_episodios"));
                    System.out.println(s);
                    serie.add(s);
                }
    
                return  serie;
            }
            catch (SQLException e) {
                throw new exception(e.getMessage());
            }
            finally {
                Conexao.closeStatement(st);
                Conexao.closeResultSet(rs);
            }
        }
    
    
       // public static void inserir (String nome, String livro, String autor, String numero_edicao, String ano, Integer paginas){
       public static void inserir (serie serie){
            Connection conn = null;
            PreparedStatement statement = null;
            try {
                conn = Conexao.getConnection();//CONECTANDO
    
                // EXAMPLE 1:
                statement = conn.prepareStatement(//vai receber o comando SQL e ficar preparado para executar
                        "INSERT INTO serie "
                                + "(nome, genero, plataforma, n_temporadas, n_episodios)"
                                + "VALUES "
                                + "(?, ?, ?, ?, ?)", //4 posicoes
                        Statement.RETURN_GENERATED_KEYS);//SOBRECARGA RECEBE OUTRO PARAMETRO
    
                statement.setString(1, serie.getNome());//tipo string, posicao 1
                statement.setString(2, serie.getGenero());
                statement.setString(3, serie.getPlataforma());
                statement.setInt(4, serie.getN_temporadas());
                statement.setInt(5, serie.getN_episodios());
                int rowsAffected = statement.executeUpdate();//executa sql e retorna um numero inteiro indicando quantas linhas foram alteradas
    
                if (rowsAffected > 0) {
                    ResultSet rs = statement.getGeneratedKeys();//VAI pegar os codigos das linhas alteradas
                    while (rs.next()) {
                        int id = rs.getInt(1);//valor da primeira coluna
                        System.out.println("Done! Id: " + id);
                    }
                }
                else {
                    System.out.println("No rows affected!");
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexao.closeStatement(statement);
                Conexao.closeConnection();
    
            }
    
        }
    
        public static serie listarProdutosPorId(int id) {
            PreparedStatement st = null;
            ResultSet rs = null;
            Connection conn = null;
            serie s = new serie();
            try {
                conn = Conexao.getConnection();//CONECTANDO
                st = conn.prepareStatement(
                        "SELECT * FROM livro WHERE idlivro = ?");
                st.setInt(1, id);
                rs = st.executeQuery();
                if (rs.next()) {
                    s.setId(rs.getInt("id"));
                    s.setNome(rs.getString("nome"));
                    s.setGenero(rs.getString("genero"));
                    s.setPlataforma(rs.getString("plataforma"));
                    s.setN_temporadas(rs.getInt("n_temporadas"));
                    s.setN_episodios(rs.getInt("N_episodios"));
                }
    
                return  s;
            }
            catch (SQLException e) {
                throw new Exception(e.getMessage());
            }
            finally {
                Conexao.closeStatement(st);
                Conexao.closeResultSet(rs);
            }
        }
    }