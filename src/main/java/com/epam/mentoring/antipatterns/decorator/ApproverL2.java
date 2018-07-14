package com.epam.mentoring.antipatterns.decorator;

public class ApproverL2 extends ApproverDecorator {
    public ApproverL2(DApprover core) {
        super(core);
    }

    @Override
    protected boolean checkIfCanProcess(Integer level) {
        return level <= 2;
    }

    @Override
    protected Integer getApproverLevel() {
        return 2;
    }
}
