package taskservices;

public class Task {
    private final String taskID;  // The unique ID for each task
    private String name;          // The name of the task
    private String description;   // The description of the task

    // Constructor to create a new task with ID, name, and description
    public Task(String taskID, String name, String description) {
        // Check if the task ID is valid
        if (taskID == null || taskID.length() > 10) {
            throw new IllegalArgumentException("Task ID must be non-null and at most 10 characters long.");
        }
        // Check if the name is valid
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name must be non-null and at most 20 characters long.");
        }
        // Check if the description is valid
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must be non-null and at most 50 characters long.");
        }
        this.taskID = taskID;
        this.name = name;
        this.description = description;
    }

    
    // Get the task ID
    public String getTaskID() {
        return taskID;
    }

    
    // Get the name of the task
    public String getName() {
        return name;
    }

    
    // Set a new name for the task
    public void setName(String name) {
        // Check if the new name is valid
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name must be non-null and at most 20 characters long.");
        }
        this.name = name;
    }

    
    // Get the description of the task
    public String getDescription() {
        return description;
    }

    
    // Set a new description for the task
    public void setDescription(String description) {
        // Check if the new description is valid
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must be non-null and at most 50 characters long.");
        }
        this.description = description;
    }
}