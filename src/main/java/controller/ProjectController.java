package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;

/**
 *
 * @author Rafael
 */
public class ProjectController {
    
    public void save(Project project) throws SQLException{
        //comando em SQL para a inserção de dados na tabela
        String sql = "INSERT INTO projects (name,"
                + "description,"
                + "createdAt,"
                + "updatedAt) VALUES (?, ?, ?, ?)";
        
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //estabelecendo conexão com o BD
            connection = ConnectionFactory.getConnection();
            
            //preparando a query
            statement = connection.prepareStatement(sql);
            
            //Setando os valores do statement
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            //executando o statement
            statement.execute();
  
        } catch (Exception ex) {
            //exceção caso dê erro em alguma linha acima
            throw new SQLException("Erro ao salvar o projeto" , ex);
        } finally {
            //fechando conexão com o banco de dados e o statement.
            ConnectionFactory.closeConnection(connection, statement);
            
        }
        
    }
    
    public void update(Project project){
        
        String sql = "UPDATE projects SET"
                + " name = ?,"
                + " description = ?,"
                + " createdAt = ?,"
                + " updatedAt = ?"
                + " WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //estabelecend oconexão
            connection = ConnectionFactory.getConnection();
            
            //preparando query
            statement = connection.prepareStatement(sql);
            
            //setando valores
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            statement.setInt(5, project.getId());
            //executando statement
            statement.execute();
            
                    
           
        } catch (Exception ex) {
            //exceção no caso de erro
            throw new RuntimeException("Erro ao atualizar o projeto" + ex.getMessage(), ex);
        } finally {
            //fechando conexão e statement
            ConnectionFactory.closeConnection(connection, statement);
        }
        
    }
    
    public void removeById(int idProject) throws SQLException{
        
        String sql = "DELETE FROM projects WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //estabelecendo conexão
            connection = ConnectionFactory.getConnection();
            //preparando a query
            statement = connection.prepareStatement(sql);
            //valores
            statement.setInt(1, idProject);
            statement.execute();
                    
           
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar o projeto" + ex.getMessage(), ex);
        } finally {
            //fechando conexão
            ConnectionFactory.closeConnection(connection, statement);
        }
        
    }
    
    public List<Project> getAll(){
        
        String sql = "SELECT * FROM projects";
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        //lista de tarefas a ser devolvida
        List<Project> projects = new ArrayList<>();
        
        
        try {
            
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            //valor retornado pela execução da query
            resultSet = statement.executeQuery(); 
            
            //enquanto houver valores, o loop continuará.
            while(resultSet.next()){
                
                Project project = new Project();
                
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreatedAt(resultSet.getDate("createdAt"));
                project.setUpdatedAt(resultSet.getDate("UpdatedAt"));
                
                projects.add(project);
                
            }
                    
           
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao inserir o projeto" + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        return projects;    
    }
    
    
}
