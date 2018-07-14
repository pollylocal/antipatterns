package com.epam.mentoring.antipatterns.cor;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;

public class ApproverImpl implements Approver {
    private Approver nextApprover;
    private Predicate<Integer> predicate;
    private Integer approverLevel;

    public ApproverImpl(Predicate<Integer> predicate, Integer approverLevel) {
        this.approverLevel = approverLevel;
        this.predicate = predicate;
    }

    public void setNextApprover(Approver approver) {
        this.nextApprover = approver;
    }

    public boolean process(Integer level) {
        if (predicate.test(level)) {
            System.out.println("Approver with level " + approverLevel + " is processing request");
            return ThreadLocalRandom.current().nextBoolean();
        } else {
            System.out.println("Approver with level " + approverLevel + " cannot process request. Trying to pass it further");
            if (nextApprover != null) {
                return nextApprover.process(level);
            } else {
                throw new IllegalStateException("System cannot process request with initial level " + level);
            }
        }
    }
}
