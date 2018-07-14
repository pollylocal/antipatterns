package com.epam.mentoring.antipatterns;

import com.epam.mentoring.antipatterns.cor.Approver;
import com.epam.mentoring.antipatterns.cor.ApproverImpl;
import com.epam.mentoring.antipatterns.decorator.*;

import java.util.concurrent.ThreadLocalRandom;

public class Application {
    public static void main(String[] args) {
        System.out.println("---------------CHAIN OF RESPONSIBILITY--------------");

        Approver approverL1 = new ApproverImpl(i -> i <= 1, 1);
        Approver approverL2 = new ApproverImpl(i -> i <= 2, 2);
        Approver approverL3 = new ApproverImpl(i -> i <= 3, 3);
        Approver approverL4 = new ApproverImpl(i -> i <= 4, 4);
        approverL1.setNextApprover(approverL2);
        approverL2.setNextApprover(approverL3);
        approverL3.setNextApprover(approverL4);

        for (int i = 0; i < 5; i++) {
            Integer level = ThreadLocalRandom.current().nextInt(1,4);
            System.out.println("Level - " + level);
            Boolean result = approverL1.process(level);
            System.out.println("Result: " + result);
            System.out.println("-----------------------------");
        }

        System.out.println("---------------DECORATOR--------------");
        DApprover approver = new ApproverL1(new ApproverL2(new ApproverL3(new ApproverL4(null))));

        for (int i = 0; i < 5; i++) {
            Integer level = ThreadLocalRandom.current().nextInt(1,4);
            System.out.println("Level - " + level);
            Boolean result = approver.process(level);
            System.out.println("Result: " + result);
            System.out.println("-----------------------------");
        }

    }
}
