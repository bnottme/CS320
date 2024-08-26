package taskservices;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TaskService {
    private Map<String, Task> taskMap = new HashMap<>();  // A map to store tasks by their unique ID

    
    // Add a new task with a generated unique ID
    public String addTask(String name, String description) {
        String taskID = generateUniqueID();
        if (taskMap.containsKey(taskID)) {
            throw new IllegalArgumentException("Task ID must be unique.");
        }
        Task task = new Task(taskID, name, description);
        taskMap.put(taskID, task);
        return taskID;
    }

    
    // Add a new task with a specified ID (for testing purposes)
    public String addTaskWithID(String taskID, String name, String description) {
        if (taskMap.containsKey(taskID)) {
            throw new IllegalArgumentException("Task ID must be unique.");
        }
        Task task = new Task(taskID, name, description);
        taskMap.put(taskID, task);
        return taskID;
    }

    
    // Delete a task by its ID
    public void deleteTask(String taskID) {
        if (!taskMap.containsKey(taskID)) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        taskMap.remove(taskID);
    }

    
   // Update the name of a task by its ID
    public void updateTaskName(String taskID, String newName) {
        Task task = taskMap.get(taskID);
        if (task == null) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        task.setName(newName);
    }

    
    // Update the description of a task by its ID
    public void updateTaskDescription(String taskID, String newDescription) {
        Task task = taskMap.get(taskID);
        if (task == null) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        task.setDescription(newDescription);
    }

    
    // Get a task by its ID
    public Task getTask(String taskID) {
        return taskMap.get(taskID);
    }

    
    // Generate a unique ID for a new task
    private String generateUniqueID() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 10);
    }
}