package Utility;

import TaskTypes.Task;
import Exception.AlphaException;
import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> TaskLists;
    
    public TaskList(ArrayList<Task> TaskLists) throws AlphaException {
        if (TaskLists.isEmpty()) {
            throw new AlphaException("No tasks currently!");
        }
        this.TaskLists = TaskLists;
    }
    
    public TaskList() {
        this.TaskLists = new ArrayList<Task>();
    }
    
    public void storeTask(Task newTask) {
        this.TaskLists.add(newTask);
    }
    
    public Task lastTask() {
        if (!this.TaskLists.isEmpty()) {
            if (this.TaskLists.get(this.TaskLists.size() - 1).getDescription().equals("bye"))
                return null;
            else {
                return this.TaskLists.get(this.TaskLists.size() - 1);
            }
        }
        else {
            return null;
        }
    }
    
    public String listWord() {
        StringBuilder result = new StringBuilder();
        for (int i =0; i < this.TaskLists.size(); i++) {
            result.append(i + 1).append(". ")
                    .append(this.TaskLists.get(i).toString()).append("\n");
        }
        return result.toString();
    }
    
    public String modifyOperation(int index, boolean markStatus) {
        int normalizedIndex = index -1;
        StringBuilder result = new StringBuilder();
        if (markStatus) {
            this.TaskLists.get(normalizedIndex).markAsDone();
        } else {
            this.TaskLists.get(normalizedIndex).markAsUndone();
        }
        result.append(this.TaskLists.get(normalizedIndex).toString());
        return result.toString();
    }
    
    public String deleteOperation(int index) {
        int normalizedIndex = index -1;
        StringBuilder result = new StringBuilder();
        result.append(this.TaskLists.get(normalizedIndex).toString());
        this.TaskLists.remove(normalizedIndex);
        return result.toString();
    }
    
    public String getLength() {
        return "Now you have " + String.valueOf(this.TaskLists.size())+ " tasks in the list.";
    }
    
    public ArrayList<Task> getTaskLists() {
        return this.TaskLists;
    }
    
}
