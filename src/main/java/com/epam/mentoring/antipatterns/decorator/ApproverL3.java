package com.epam.mentoring.antipatterns.decorator;

public class ApproverL3 extends ApproverDecorator {
    public ApproverL3(DApprover core) {
        super(core);
    }

    @Override
    protected boolean checkIfCanProcess(Integer level) {
        return level <= 3;
    }

    @Override
    protected Integer getApproverLevel() {
        return 3;
    }
}
