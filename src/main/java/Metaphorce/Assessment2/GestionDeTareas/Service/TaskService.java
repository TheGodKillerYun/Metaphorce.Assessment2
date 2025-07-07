package Metaphorce.Assessment2.GestionDeTareas.Service;

import Metaphorce.Assessment2.GestionDeTareas.Entity.Task;
import Metaphorce.Assessment2.GestionDeTareas.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    // Create new task
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // List of all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Update an existing task (completion status)
    public Task updateTask(Integer id, Task updatedTask) {
        Optional<Task> taskOptional = taskRepository.findById((id));

        if (taskOptional.isPresent()) {
            Task t = taskOptional.get();
            t.setCompleted(true);
            return taskRepository.save(t);
        } else {
            throw new RuntimeException("Task not found with ID: " + id);
        } // Manejo de error con una estructura distinta
    }

    // Delate a task
    public void deleteTask(Integer id) {

        taskRepository.deleteById(id);
    }

    // List of uncompleted tasks
    public List<Task> getUncompletedTasks() {
        return taskRepository.findByCompleted(false);
    }
}