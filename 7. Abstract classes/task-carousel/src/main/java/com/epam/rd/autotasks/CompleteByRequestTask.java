package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {

    private boolean isComplete = false;
    private boolean isExecute = false;
    @Override
    public void execute() {
        isExecute = isComplete;
    }

    @Override
    public boolean isFinished() {
        return isExecute;
    }

    public void complete() {
        isComplete = true;
    }
}
