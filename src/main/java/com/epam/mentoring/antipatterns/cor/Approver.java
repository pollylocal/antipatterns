package com.epam.mentoring.antipatterns.cor;

public interface Approver {
    void setNextApprover(Approver approver);
    boolean process(Integer level);
}
