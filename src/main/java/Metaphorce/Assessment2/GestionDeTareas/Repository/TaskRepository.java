package Metaphorce.Assessment2.GestionDeTareas.Repository;

import Metaphorce.Assessment2.GestionDeTareas.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByCompleted(boolean completed);
}
