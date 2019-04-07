package org.app.woker.entities;

/**
 * Class for representation info about QA engineer.
 *
 * @author alitvinov
 */

public class QAEngineer extends Worker {

    private boolean automationQA;

    public QAEngineer(int workerId, String workerName, boolean automationQA) {

        super(workerId, workerName);
        this.automationQA = automationQA;
    }

    public boolean isAutomationQA() {
        return automationQA;
    }

    public void setAutomationQA(boolean automationQA) {
        this.automationQA = automationQA;
    }

    @Override
    public String getWorkerPosition() {
        return "QAEngineer";
    }

    @Override
    public String toString() {

        return "---QA_ENGINEER---\nID: " + getWorkerId() + "\nName: " + getWorkerName() + "\nPosition: " +
                getWorkerPosition() + "\nAutomationQA: " + isAutomationQA();
    }
}
