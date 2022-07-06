package com.epam.rd.autotasks.sprintplanning.tickets;

public class Ticket {

    private int id;
    private String name;
    private int estimate;

    protected boolean isDone;

    public Ticket(int id, String name, int estimate) {
        this.id = id;
        this.name = name;
        this.estimate = estimate;
        this.isDone = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return isDone;
    }

    public void complete() {
        isDone = true;
    }

    public int getEstimate() {
        return estimate;
    }
}
