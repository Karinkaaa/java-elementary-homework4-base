package org.app.woker.application;

import org.app.woker.entities.Manager;
import org.app.woker.entities.Programmer;
import org.app.woker.entities.QAEngineer;
import org.app.woker.entities.Worker;


public final class WorkerInfoStore {

    private final int INITIAL_LENGTH = 5;

    private Manager[] managers;
    private Programmer[] programmers;
    private QAEngineer[] qaEngineers;

    private int managerCount;
    private int programmerCount;
    private int qaCount;

    private static WorkerInfoStore instance;

    private WorkerInfoStore() {

        managers = new Manager[INITIAL_LENGTH];
        programmers = new Programmer[INITIAL_LENGTH];
        qaEngineers = new QAEngineer[INITIAL_LENGTH];
        managerCount = programmerCount = qaCount = 0;
    }

    public static WorkerInfoStore getInstance() {
        if (instance == null) {
            instance = new WorkerInfoStore();
        }
        return instance;
    }

    // добавить в массив managers
    public void add(Manager worker) {

        if (managers.length == managerCount) {
            managers = (Manager[]) arrayExpansion(managers);
        }
        managers[managerCount++] = worker;
    }

    // добавить в массив programmers
    public void add(Programmer worker) {

        if (programmers.length == programmerCount) {
            programmers = (Programmer[]) arrayExpansion(programmers);
        }
        programmers[programmerCount++] = worker;
    }

    // добавить в массив qaEngineers
    public void add(QAEngineer worker) {

        if (qaEngineers.length == qaCount) {
            qaEngineers = (QAEngineer[]) arrayExpansion(qaEngineers);
        }
        qaEngineers[qaCount++] = worker;
    }

    // получить массив всех работников
    private Worker[] getArrayAllWorkers() {

        Worker[] allWorkers = new Worker[managerCount + programmerCount + qaCount];
        System.arraycopy(managers, 0, allWorkers, 0, managerCount);
        System.arraycopy(programmers, 0, allWorkers, managerCount, programmerCount);
        System.arraycopy(qaEngineers, 0, allWorkers, managerCount + programmerCount, qaCount);
        return allWorkers;
    }

    // получить работника по номеру ID
    public Worker getWorkerByID(int id) {

        Worker[] allWorkers = getArrayAllWorkers();
        for (Worker worker : allWorkers) {
            if (worker.getWorkerId() == id) {
                return worker;
            }
        }
        return null;
    }

    /**
     * В этом методе проанализировать тип worker - с помощью instanceof.
     * Если тип - Manager - добавить в массив managers
     * Если тип - Programmer - добавить в массив managers
     * Если тип - QAEngeneer - добавить в массив qaEngeneers
     **/
    public void add(Worker worker) {

        if (worker == null) {
            return;
        } else if (worker instanceof Manager) {
            add((Manager) worker);
        } else if (worker instanceof Programmer) {
            add((Programmer) worker);
        } else if (worker instanceof QAEngineer) {
            add((QAEngineer) worker);
        } else {
            System.out.println("Suitable worker class is not found!");
        }
    }

    // метод расширения массива
    private Worker[] arrayExpansion(Worker[] workers) {

        int newSize = (int) (workers.length * 1.5 + 1);     // эту формулу нам дал предыдущий преподаватель
        Worker[] newWorkers = new Worker[newSize];
        System.arraycopy(workers, 0, newWorkers, 0, workers.length);
        return newWorkers;
    }
}
