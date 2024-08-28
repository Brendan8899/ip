package utility;

import tasktypes.Task;

import exception.AlphaException;

import java.util.ArrayList;

/**
 * The {@code TaskList} class manages a list of tasks, providing functionality to
 * store, modify, delete, and retrieve tasks.
 */
public class TaskList {
    
    /** The list of tasks managed by this {@code TaskList}. */
    private ArrayList<Task> tasks;
    
    /**
     * Constructs a {@code TaskList} object with the specified list of tasks.
     *
     * @param tasks the initial list of tasks
     * @throws AlphaException if the provided list of tasks is empty
     */
    public TaskList(ArrayList<Task> tasks) throws AlphaException {
        if (tasks.isEmpty()) {
            throw new AlphaException("No tasks currently!");
        }
        this.tasks = tasks;
    }
    
    /**
     * Constructs an empty {@code TaskList}.
     */
    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }
    
    /**
     * Stores a new task in the list.
     *
     * @param newTask the task to be added to the list
     */
    public void storeTask(Task newTask) {
        this.tasks.add(newTask);
    }
    
    /**
     * Returns the last task in the list unless the task's description is "bye".
     *
     * @return the last task in the list or {@code null} if the list is empty or the last task's description is "bye"
     */
    public Task lastTask() {
        if (!this.tasks.isEmpty()) {
            if (this.tasks.get(this.tasks.size() - 1).getDescription().equals("bye"))
                return null;
            else {
                return this.tasks.get(this.tasks.size() - 1);
            }
        }
        else {
            return null;
        }
    }
    
    /**
     * Returns a string representing all tasks in the list, each numbered sequentially.
     *
     * @return a formatted string of all tasks in the list
     */
    public String listWord() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.tasks.size(); i++) {
            result.append(i + 1).append(". ")
                    .append(this.tasks.get(i).toString()).append("\n");
        }
        return result.toString();
    }
    
    /**
     * Modifies the completion status of the task at the specified index.
     *
     * @param index the position of the task in the list (1-based index)
     * @param markStatus {@code true} to mark the task as done, {@code false} to mark it as undone
     * @return a string representing the modified task
     */
    public String modifyOperation(int index, boolean markStatus) {
        int normalizedIndex = index - 1;
        StringBuilder result = new StringBuilder();
        if (markStatus) {
            this.tasks.get(normalizedIndex).markAsDone();
        } else {
            this.tasks.get(normalizedIndex).markAsUndone();
        }
        result.append(this.tasks.get(normalizedIndex).toString());
        return result.toString();
    }
    
    /**
     * Deletes the task at the specified index from the list.
     *
     * @param index the position of the task in the list (1-based index)
     * @return a string representing the deleted task
     */
    public String deleteOperation(int index) {
        int normalizedIndex = index - 1;
        StringBuilder result = new StringBuilder();
        result.append(this.tasks.get(normalizedIndex).toString());
        this.tasks.remove(normalizedIndex);
        return result.toString();
    }
    
    /**
     * Returns a string indicating the number of tasks currently in the list.
     *
     * @return a formatted string showing the current number of tasks
     */
    public String getLength() {
        return "Now you have " + String.valueOf(this.tasks.size()) + " tasks in the list.";
    }
    
    /**
     * Returns the list of tasks managed by this {@code TaskList}.
     *
     * @return an {@code ArrayList} of tasks
     */
    public ArrayList<Task> getTaskLists() {
        return this.tasks;
    }
}
