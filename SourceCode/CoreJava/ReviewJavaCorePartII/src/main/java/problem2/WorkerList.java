package problem2;

import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class WorkerList {
    List<Worker> workers = new ArrayList<>();

    public List<Worker> initializeWorkers() {
        Scanner input = new Scanner(System.in);
        int nWorkers;

        System.out.print("Enter numbers of workers: ");
        nWorkers = input.nextInt();

        for (int i = 0; i < nWorkers; i++)
            workers.add(addWorker());

        return workers;
    }

    public Worker addWorker() {
        Worker newWorker = new Worker();
        Scanner input = new Scanner(System.in);

        do {
            System.out.print("Enter worker's id: ");
            newWorker.setId(input.nextInt());
            input.nextLine();
        } while (newWorker.getId() < 0);

        System.out.print("Enter worker's last name: ");
        newWorker.setLastName(input.nextLine());

        System.out.print("Enter worker's first name: ");
        newWorker.setFirstName(input.nextLine());

        do {
            System.out.print("Enter number of products: ");
            newWorker.setProducts(input.nextInt());
            input.nextLine();
        } while (newWorker.getProducts() < 0);

        return newWorker;
    }

    public void showWorkersInfo() {
        for (Worker worker : workers)
            System.out.println(worker.toString());
    }

    public int getNumberOfWorkers() {
        return workers.size();
    }

    public void showWorkersHaveMoreThan200Products() {
        for (Worker worker : workers)
            if (worker.getProducts() > 200) System.out.println(worker.toString());
    }

    public List<Worker> sortedListByProductsDESC() {
        List<Worker> sortedList = new ArrayList<>();
        sortedList.addAll(workers);
        Collections.sort(sortedList);

        return sortedList;
    }

    public static void main(String[] args) {
        WorkerList workers = new WorkerList();

        workers.initializeWorkers();
        workers.showWorkersInfo();
        System.out.println("Total workers: " + workers.getNumberOfWorkers());

        workers.showWorkersHaveMoreThan200Products();
        List<Worker> sortedList = workers.sortedListByProductsDESC();
        for (Worker worker: sortedList )
            System.out.println(worker.toString());
    }

}
