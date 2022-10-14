package manager.TaskApp;

import controller.ProjectController;
import controller.TaskController;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import model.Project;
import model.Task;

/**
 *
 * @author Rafael Lino
 */
public class TaskApp {

    public static void main(String[] args) throws SQLException {
        
        ProjectController projectController = new ProjectController();
        
       /* //criando novo projeto
        Project project = new Project();
        project.setId(1);
        project.setName("TestandoTasks");
        project.setDescription("Descrição aleatoria");
        projectController.save(project);
        
        //projectController.update(project); */
        
        List<Project> projects = projectController.getAll();
        System.out.println("Total de projetos: " + projects.size());
        
        // projectController.removeById(1);
        
        
        //TESTE DE CRIAÇÃO DE TASKS
        
        TaskController taskController = new TaskController();
        
        //criando nvoas tasks
        Task task = new Task();
        task.setIdProject(3);
        task.setId(1);
        task.setName("VAI VARRER");
        task.setDescription("Varre");
        task.setNotes("tem que varrer");
        task.setIsCompleted(false);
        task.setDeadline(new Date());
        
        //taskController.save(task);
               
        taskController.update(task);
        List<Task> tasks = taskController.getAll(3);
        System.out.println("Total de tarefas: " + tasks.size());
        
       // taskController.removeById(1);
        
        
        
    }
}
