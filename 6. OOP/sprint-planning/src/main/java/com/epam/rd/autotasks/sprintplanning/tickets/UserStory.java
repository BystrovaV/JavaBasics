package com.epam.rd.autotasks.sprintplanning.tickets;

import java.util.Arrays;

public class UserStory extends Ticket {

    private UserStory[] dependsOn;
    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);

        this.dependsOn = new UserStory[dependsOn.length];
        System.arraycopy(dependsOn, 0, this.dependsOn, 0, dependsOn.length);
    }

    @Override
    public void complete() {
        for (UserStory story: dependsOn) {
            if (!story.isCompleted()) {
                return;
            }
        }

        isDone = true;
    }

    public UserStory[] getDependencies() {
        return Arrays.copyOf(dependsOn, dependsOn.length);
    }

    @Override
    public String toString() {
        return "[US " + this.getId() + "] " + this.getName();
    }
}
