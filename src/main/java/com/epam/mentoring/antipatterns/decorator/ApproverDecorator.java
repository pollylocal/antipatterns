package com.epam.mentoring.antipatterns.decorator;

import java.util.concurrent.ThreadLocalRandom;

public abstract class ApproverDecorator implements DApprover{
    private DApprover core;

    public ApproverDecorator(DApprover core) {
        this.core = core;
    }

    @Override
    public boolean process(Integer level) {
        Integer approverLevel = getApproverLevel();
        if (checkIfCanProcess(level)) {
            System.out.println("Approver with level " + approverLevel + " is processing request");
            return ThreadLocalRandom.current().nextBoolean();
        } else {
            System.out.println("Approver with level " + approverLevel + " cannot process request. Trying to pass it further");
            if (core != null) {
                return core.process(level);
            } else {
                throw new IllegalStateException("System cannot process request with initial level " + level);
            }
        }
    }

    protected abstract boolean checkIfCanProcess(Integer level);
    protected abstract Integer getApproverLevel();
}
