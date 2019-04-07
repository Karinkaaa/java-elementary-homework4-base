package org.app.woker.application;

import org.app.woker.entities.Manager;
import org.app.woker.entities.Programmer;
import org.app.woker.entities.QAEngineer;
import org.app.woker.entities.Worker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        menu();

    }

    private static void menu() {

        WorkerInfoStore workerInfoStore = WorkerInfoStore.getInstance();
        Worker worker = null;
        Scanner in = new Scanner(System.in);
        int action = -1;

        while (action != 0) {

            System.out.println("Select an action:\n[1] add worker\n[2] look information about worker\n[0] exit");
            action = in.nextInt();

            if (action == 1) {
                System.out.println("Select a position:\n[1] Manager\n[2] Programmer\n[3] QAEngineer");
                action = in.nextInt();
                worker = getWorker(action, in);
                workerInfoStore.add(worker);

            } else if (action == 2) {
                System.out.print("Enter the ID of desired worker: ");
                action = in.nextInt();
                worker = workerInfoStore.getWorkerByID(action);
                System.out.println("\n\n" + worker);
            }
            System.out.println("\n");
        }
    }

    private static Worker getWorker(int pos, Scanner in) {

        Worker worker = null;
        System.out.print("Enter the id: ");
        int id = in.nextInt();
        System.out.print("Enter the name: ");
        in = new Scanner(System.in);    // пересоздаю, потому что пропускает ввод переменной name
        String name = in.nextLine();

        if (pos == 1) {
            System.out.print("Enter the project: ");
            String project = in.nextLine();
            System.out.print("Enter the experience: ");
            int experience = in.nextInt();
            worker = new Manager(id, name, project, experience);

        } else if (pos == 2) {
            System.out.print("Enter the language: ");
            String language = in.nextLine();
            System.out.print("Enter the rate: ");
            String rate = in.nextLine();
            worker = new Programmer(id, name, language, rate);

        } else if (pos == 3) {
            System.out.print("Is automation QA? (true, false): ");
            boolean automationQA = in.nextBoolean();
            worker = new QAEngineer(id, name, automationQA);
        }
        return worker;
    }
}
