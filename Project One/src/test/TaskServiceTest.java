package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import taskservices.TaskService;
import taskservices.Task;

class TaskServiceTest {
    private TaskService taskService;

    // Set up a new TaskService before each test
    @BeforeEach
    void setUp() {
        taskService = new TaskService();
    }

    
    // Test successful addition of a task
    @Test
    void testAddTaskSuccess() {
        String taskID = taskService.addTask("Task Name", "Task Description");
        Task task = taskService.getTask(taskID);
        assertNotNull(task);  // Ensure the task is not null
        assertEquals("Task Name", task.getName());  // Check the task name
        assertEquals("Task Description", task.getDescription());  // Check the task description
    }

    
    // Test failure when adding a task with a duplicate ID
    @Test
    void testAddTaskFailure() {
        String taskID1 = taskService.addTask("Task Name", "Task Description");
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTaskWithID(taskID1, "Another Task Name", "Another Task Description");
        });
    }

    
    // Test successful deletion of a task
    @Test
    void testDeleteTaskSuccess() {
        String taskID = taskService.addTask("Task Name", "Task Description");
        taskService.deleteTask(taskID);
        assertNull(taskService.getTask(taskID));  // Ensure the task is null after deletion
    }

    
    // Test failure when deleting a non-existent task
    @Test
    void testDeleteTaskFailure() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.deleteTask("nonexistentID");
        });
    }

    
    // Test successful update of a task's name
    @Test
    void testUpdateTaskNameSuccess() {
        String taskID = taskService.addTask("Task Name", "Task Description");
        taskService.updateTaskName(taskID, "New Task Name");
        assertEquals("New Task Name", taskService.getTask(taskID).getName());  // Check the updated name
    }

    
    
   // Test failure when updating the name of a non-existent task
    @Test
    void testUpdateTaskNameFailure() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskName("nonexistentID", "New Task Name");
        });
    }

    
    // Test successful update of a task's description
    @Test
    void testUpdateTaskDescriptionSuccess() {
        String taskID = taskService.addTask("Task Name", "Task Description");
        taskService.updateTaskDescription(taskID, "New Task Description");
        assertEquals("New Task Description", taskService.getTask(taskID).getDescription());  // Check the updated description
    }

    
    // Test failure when updating the description of a non-existent task
    @Test
    void testUpdateTaskDescriptionFailure() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskDescription("nonexistentID", "New Task Description");
        });
    }
}