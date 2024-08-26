package test;

import org.junit.jupiter.api.Test;
import taskservices.Task;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    // Test successful creation of a Task object
    @Test
    void testTaskCreationSuccess() {
        Task task = new Task("1234567890", "Task Name", "Task Description");
        assertEquals("1234567890", task.getTaskID());
        assertEquals("Task Name", task.getName());
        assertEquals("Task Description", task.getDescription());
    }

    
   // Test failure scenarios for Task creation with invalid inputs
    @Test
    void testTaskCreationFailure() {
        // Test with null task ID
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Task Name", "Task Description");
        });

        // Test with too long task ID
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Task Name", "Task Description");
        });

        // Test with null name
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", null, "Task Description");
        });

        // Test with too long name
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", "This name is way too long for the given requirement", "Task Description");
        });

        // Test with null description
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", "Task Name", null);
        });

        // Test with too long description
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", "Task Name", "This description is way too long for the given requirement and should throw an exception.");
        });
    }

    

// Test successful setting of a new name for a Task
    @Test
    void testSetNameSuccess() {
        Task task = new Task("1234567890", "Task Name", "Task Description");
        task.setName("New Task Name");
        assertEquals("New Task Name", task.getName());
    }

    
    // Test failure scenarios for setting an invalid name
    @Test
    void testSetNameFailure() {
        Task task = new Task("1234567890", "Task Name", "Task Description");
        // Test with null name
        assertThrows(IllegalArgumentException.class, () -> {
            task.setName(null);
        });
        // Test with too long name
        assertThrows(IllegalArgumentException.class, () -> {
            task.setName("This name is way too long for the given requirement");
        });
    }

    
    // Test successful setting of a new description for a Task
    @Test
    void testSetDescriptionSuccess() {
        Task task = new Task("1234567890", "Task Name", "Task Description");
        task.setDescription("New Task Description");
        assertEquals("New Task Description", task.getDescription());
    }

    
    // Test failure scenarios for setting an invalid description
    @Test
    void testSetDescriptionFailure() {
        Task task = new Task("1234567890", "Task Name", "Task Description");
        // Test with null description
        assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription(null);
        });
        // Test with too long description
        assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription("This description is way too long for the given requirement and should throw an exception.");
        });
    }
}