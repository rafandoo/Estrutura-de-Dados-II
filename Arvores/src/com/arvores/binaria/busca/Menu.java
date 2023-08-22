package com.arvores.binaria.busca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Thread;

interface MenuItem {
    String getName();
    void execute();
}

class SimpleMenuItem implements MenuItem {
    private String name;
    private Runnable action;

    public SimpleMenuItem(String name, Runnable action) {
        this.name = name;
        this.action = action;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute() {
        action.run();
    }
}

class Menu implements MenuItem {
    private String name;
    private List<MenuItem> items = new ArrayList<>();

    public Menu(String name) {
        this.name = name;
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n" + name + ":");
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i).getName());
            }
            System.out.println((items.size() + 1) + ". Voltar");

            System.out.print("Escolha uma opção: ");
            choice = scanner.nextInt();
            clearBuffer(scanner);

            if (choice >= 1 && choice <= items.size()) {
                items.get(choice - 1).execute();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (choice == items.size() + 1) {
                System.out.println("Voltando...");
                return;
            } else {
                System.out.println("Opção inválida. Escolha novamente.");
            }
        } while (choice != items.size() + 1);

        scanner.close();
    }
    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}
