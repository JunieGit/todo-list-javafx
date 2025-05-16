/**
 * This is the controller for the JavaFX To-Do List App.
 * Handles user interaction with the list.
 * @author Min Htet Khant
 * @date May 2025
 */

package com.example.todolist;
import javafx.scene.control.Alert;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TodolistController {

    @FXML
    private TextField taskInput;

    @FXML
    private ListView<TodolistItem> taskListView;

    private final ObservableList<TodolistItem> taskList = FXCollections.observableArrayList();
    /**
     * Initializes the ListView by binding it to the task list.
     * This method runs automatically after the FXML components are loaded.
     */
    @FXML
    public void initialize() {
        taskListView.setItems(taskList);
    }
    /**
     * Adds a new task to the list from the input field.
     * Prevents empty input.
     */
    @FXML
    protected void onAddTaskClick() {
        String desc = taskInput.getText().trim();

        if (desc.isEmpty()) {
            showAlert("Task cannot be empty!");
            return;
        }

        taskList.add(new TodolistItem(desc));
        taskInput.clear();
    }
    /**
     * Removes the currently selected task from the list.
     * Does nothing if no task is selected.
     */
    @FXML
    protected void onRemoveTaskClick() {
        TodolistItem selected = taskListView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            taskList.remove(selected);
        } else {
            showAlert("Please select a task to remove.");
        }
    }
    /**
     * Edits the description of the selected task using input field text.
     * Shows an alert if nothing is selected or the input is empty.
     */
    @FXML
    protected void onEditTaskClick() {
        TodolistItem selected = taskListView.getSelectionModel().getSelectedItem();
        String newText = taskInput.getText().trim();

        if (selected == null) {
            showAlert("Please select a task to edit.");
            return;
        }

        if (newText.isEmpty()) {
            showAlert("Edited task cannot be empty.");
            return;
        }

        selected.setDescription(newText);
        taskListView.refresh();
        taskInput.clear();
    }
    /**
     * Toggles the completion status (checked/unchecked) of the selected task.
     */
    @FXML
    protected void onToggleCompleteClick() {
        TodolistItem selected = taskListView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Please select a task to mark as complete.");
            return;
        }

        selected.setCompleted(!selected.isCompleted());
        taskListView.refresh();
    }
    /**
     * Displays a warning message to the user.
     *
     * @param message The text to be shown in the alert dialog.
     */
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
            }
