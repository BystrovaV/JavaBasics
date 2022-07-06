package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

import java.util.Arrays;
import java.util.Objects;

public class Sprint {

    private final int ticketsLimit;
    private final int capacity;

    private int currentTicketsLimit;

    private Ticket[] tickets;

    public Sprint(int capacity, int ticketsLimit) {
        this.ticketsLimit = ticketsLimit;
        this.capacity = capacity;
        tickets = new Ticket[ticketsLimit];
        currentTicketsLimit = ticketsLimit;
    }

    public boolean addUserStory(UserStory userStory) {
        if (!checkTicket(userStory)) {
            return false;
        }

        System.out.println("First check pass");
        boolean isHere;

        if (userStory.getDependencies().length != 0) {

            for (UserStory story : userStory.getDependencies()) {
                if (!story.isCompleted()) {
                    isHere = false;
                    for (Ticket ticket : tickets) {
                        if (ticket != null) {
                            if (!(ticket instanceof UserStory)) {
                                continue;
                            }
                            if (story.getId() == ticket.getId() && Objects.equals(story.getName(), ticket.getName())) {
                                isHere = true;
                                break;
                            }
                        }
                    }

                    if (!isHere) {
                        return false;
                    }
                }
            }
        }

        tickets[ticketsLimit - currentTicketsLimit] = userStory;
        currentTicketsLimit--;

        return true;
    }

    public boolean addBug(Bug bugReport) {
        if (!checkTicket(bugReport)) {
            return false;
        }

        tickets[ticketsLimit - currentTicketsLimit] = bugReport;
        currentTicketsLimit--;

        return true;
    }

    public Ticket[] getTickets() {
        return Arrays.copyOf(tickets, ticketsLimit - currentTicketsLimit);
    }

    public int getTotalEstimate() {
        int total = 0;

        for (Ticket ticket: tickets) {
            if (ticket != null)
                total += ticket.getEstimate();
        }

        return total;
    }

    private boolean checkTicket(Ticket ticket) {
        if (ticket == null) {
            return false;
        }

        if (ticket.isCompleted()) {
            return false;
        }

        if (currentTicketsLimit == 0) {
            return false;
        }

        if (ticket.getEstimate() + getTotalEstimate() > capacity) {
            return false;
        }

        return true;
    }

}
