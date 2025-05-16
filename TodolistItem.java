/**
 * Represents a single item in the to-do list.
 * Stores the task description and its completion status.
 * Provides getter and setter methods to access and modify the item data.
 *
 * @author Min Htet Khant
 * @date May 2025
 */
package com.example.todolist;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TodolistItem {
    private String description;
    private boolean completed;
    private LocalDateTime createdAt;
    /**
     * Constructs a new TodoListItem with the given description.
     * The task is marked as not completed by default.
     *
     * @param description The text description of the task.
     */
    public TodolistItem(String description) {
        this.description = description;
        this.completed = false;
        this.createdAt = LocalDateTime.now();
    }
    /**
     * Updates the description of the task.
     *
     * @param description The new text for the task.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Returns the description of the task.
     *
     * @return The task description as a String.
     */
    public String getDescription() {
        return description;
    }
    /**
     * Returns the completion status of the task.
     *
     * @return true if the task is completed, false otherwise.
     */
    public boolean isCompleted() {
        return completed;
    }
    /**
     * Sets the completion status of the task.
     *
     * @param completed true to mark the task as complete, false to mark it as incomplete.
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    /**
     * Returns the creation date of the task as a formatted string.
     *
     * @return A string representing when the task was created.
     */
    public String getCreatedAt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return createdAt.format(formatter);
    }
    /**
     * Returns a formatted string showing the task description
     * with a checkbox indicating completion status.
     *
     * @return The formatted task string for display.
     */
    @Override
    public String toString() {
        return (completed ? "[✓] " : "[ ] ") + description + " (" + getCreatedAt() + ")";
    }
    }
