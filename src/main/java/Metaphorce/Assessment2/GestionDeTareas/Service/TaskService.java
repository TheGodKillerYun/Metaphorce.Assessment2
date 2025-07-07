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

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

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

    public void deleteTask(Integer id) {
        if (!taskRepository.existsById(id)){
            throw new RuntimeException("Task not found with ID: " + id);
        }
        taskRepository.deleteById(id);
    }

    public List<Task> getUncompletedTasks() {
        return taskRepository.findByCompleted(false);
    }
}