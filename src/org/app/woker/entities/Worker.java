package org.app.woker.entities;

/**
 * Basic class for representation of Worker information.
 *
 * @author alitvinov
 */

public class Worker {

    protected int workerId;

    protected String workerName;

    protected String workerPosition = "Simple worker";

    public Worker(int workerId, String workerName) {

        this.workerId = workerId;
        this.workerName = workerName;
    }

    public int getWorkerId() {
        return workerId;
    }

    public String getWorkerName() {
        return workerName;
    }

    public String getWorkerPosition() {
        return workerPosition;
    }

    @Override
    public String toString() {
        return "---WORKER---\nID: " + workerId + "\nName: " + workerName + "\nPosition: " + workerPosition;
    }
}
