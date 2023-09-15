package dat3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class TaskList<T extends Task> implements Iterable {
    Collection<T> tasks = new ArrayList<T>();

    public void addTask(T task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public List<T> filterTaskOnName(String keyword) {
        return this.tasks.stream()
                .filter(task -> task.getName().contains(keyword))
                .toList();
    }

    public List<T> filterTaskOnDescription(String keyword) {
        return this.tasks.stream()
                .filter(task -> task.getDescription().contains(keyword))
                .toList();
    }

    public void sortByDueDate() {
        this.tasks = this.tasks.stream()
                .sorted((t1, t2) -> t1.getDueDate().compareTo(t2.getDueDate()))
                .toList();
    }

    public List<T> overdueTasks() {
        return this.tasks.stream()
                .filter(task -> task.getDueDate().isAfter(LocalDate.now()))
                .toList();
    }

    public void printTasks() {
        for (Task t:
             tasks) {
            System.out.println(t);
        }
    }


    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {
        Iterable.super.forEach(action);
    }
}
