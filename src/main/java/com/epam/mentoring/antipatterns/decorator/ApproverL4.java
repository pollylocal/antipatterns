package com.epam.mentoring.antipatterns.decorator;

public class ApproverL4 extends ApproverDecorator {
    public ApproverL4(DApprover core) {
        super(core);
    }

    @Override
    protected boolean checkIfCanProcess(Integer level) {
        return level <= 4;
    }

    @Override
    protected Integer getApproverLevel() {
        return 4;
    }
}
