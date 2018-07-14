package com.epam.mentoring.antipatterns.decorator;

public class ApproverL1 extends ApproverDecorator {
    public ApproverL1(DApprover core) {
        super(core);
    }

    @Override
    protected boolean checkIfCanProcess(Integer level) {
        return level <= 1;
    }

    @Override
    protected Integer getApproverLevel() {
        return 1;
    }
}
