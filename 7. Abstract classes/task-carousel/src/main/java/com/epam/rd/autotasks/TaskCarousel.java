package com.epam.rd.autotasks;

public class TaskCarousel {

    private int capacity;
    private Task[] tasks;

    private int currentTask = 0;

    public TaskCarousel(int capacity) {
        this.capacity = capacity;
        this.tasks = new Task[capacity];
    }

    public boolean addTask(Task task) {
        if (checkTask(task)) {
            tasks[findFreePlace()] = task;
            capacity--;
            return true;
        }

        return false;
    }

    public boolean execute() {
        do {
            if (currentTask == tasks.length)
                currentTask = 0;

            if (tasks[currentTask] != null) {
                tasks[currentTask].execute();

                if (tasks[currentTask].isFinished()) {
                    tasks[currentTask] = null;
                    capacity++;
                }
                currentTask++;
                return true;
            }

            currentTask++;
            if (isEmpty()) {
                currentTask = 0;
                return false;
            }
        } while (true);
    }

    public boolean isFull() {
        return capacity == 0;
    }

    public boolean isEmpty() {
        return capacity == tasks.length;
    }

    private boolean checkTask(Task task) {
        return !isFull() && !task.isFinished();
    }

    private int findFreePlace() {
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] == null)
                return i;
        }

        return -1;
    }

}
