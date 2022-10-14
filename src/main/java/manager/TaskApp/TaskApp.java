package manager.TaskApp;

import controller.ProjectController;
import java.sql.SQLException;
import model.Project;

/**
 *
 * @author Rafael Lino
 */
public class TaskApp {

    public static void main(String[] args) throws SQLException {
        
        ProjectController projectController = new ProjectController();
        
        Project project = new Project();
        project.setName("Teste");
        project.setDescription("Descrição");
        projectController.save(project); 
    }
}
