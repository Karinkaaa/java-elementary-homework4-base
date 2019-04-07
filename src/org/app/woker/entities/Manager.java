package org.app.woker.entities;

/**
 * Class for representation info about manager.
 *
 * @author alitvinov
 */

public class Manager extends Worker {

    private String project;
    private int experience;

    public Manager(int workerId, String workerName, String project, int experience) {

        super(workerId, workerName);
        this.project = project;
        this.experience = experience;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String getWorkerPosition() {
        return "Manager";
    }

    @Override
    public String toString() {

        return "---MANAGER---\nID: " + getWorkerId() + "\nName: " + getWorkerName() +
                "\nPosition: " + getWorkerPosition() + "\nProject: " + getProject() +
                "\nExperience: " + getExperience();
    }
}
