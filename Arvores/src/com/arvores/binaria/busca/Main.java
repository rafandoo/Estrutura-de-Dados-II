package com.arvores.binaria.busca;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Menu mainMenu = new Menu("Menu Principal");
        ArvoreBinaria arvore = new ArvoreBinaria();
        Scanner sc = new Scanner(System.in);

        mainMenu.addItem(new SimpleMenuItem("Inserir nodo", () -> {
            System.out.print("Digite o valor do nodo a ser inserido: ");
            int valor = sc.nextInt();
            arvore.inserir(valor);
        }));

        mainMenu.addItem(new SimpleMenuItem("Inserir nodo (nao recursivo)", () -> {
            System.out.print("Digite o valor do nodo a ser inserido: ");
            int valor = sc.nextInt();
            arvore.inserirNaoRecursivo(valor);
        }));

        mainMenu.addItem(new SimpleMenuItem("Remover nodo", () -> {
            System.out.print("Digite o valor do nodo a ser removido: ");
            int valor = sc.nextInt();
            arvore.remover(valor);
        }));

        mainMenu.addItem(new SimpleMenuItem("Buscar nodo", () -> {
            System.out.print("Digite o valor da chave a ser buscada: ");
            int valor = sc.nextInt();
            System.out.println("Chave *" + valor + "* encontrada? " + arvore.buscar(valor));
        }));

        mainMenu.addItem(new SimpleMenuItem("Arvore inicial", () -> {
            arvore.inserir(20);
            arvore.inserir(15);
            arvore.inserir(10);
            arvore.inserir(30);
            arvore.inserir(40);
            arvore.inserir(35);
            arvore.inserir(5);
        }));

        Menu submenu = new Menu("Consultas");
        submenu.addItem(new SimpleMenuItem("Arvore organizada", () -> {
            System.out.println("\nArvore organizada:");
            arvore.mostrarArvore();
        }));
        submenu.addItem(new SimpleMenuItem("Maior chave", () -> {
            System.out.println("\nMaior chave: " + arvore.maior());
        }));
        submenu.addItem(new SimpleMenuItem("Menor chave", () -> {
            System.out.println("\nMenor chave: " + arvore.menor());
        }));
        submenu.addItem(new SimpleMenuItem("Folhas", () -> {
            System.out.println("\nFolhas:");
            arvore.folhas();
        }));
        submenu.addItem(new SimpleMenuItem("Ancestrais", () -> {
            System.out.print("Digite o valor da chave: ");
            int valor = sc.nextInt();
            System.out.println("Ancestrais da chave *" + valor + "*:");
            arvore.ancestrais(valor);
        }));
        submenu.addItem(new SimpleMenuItem("Descendentes", () -> {
            System.out.print("Digite o valor da chave: ");
            int valor = sc.nextInt();
            System.out.println("Descendentes da chave *" + valor + "*:");
            arvore.descendentes(valor);
        }));
        submenu.addItem(new SimpleMenuItem("Subarvore direita", () -> {
            System.out.print("Digite o valor da chave: ");
            int valor = sc.nextInt();
            System.out.println("Subarvore direita da chave *" + valor + "*:");
            arvore.subarvoreDireita(valor);
        }));
        submenu.addItem(new SimpleMenuItem("Subarvore esquerda", () -> {
            System.out.print("Digite o valor da chave: ");
            int valor = sc.nextInt();
            System.out.println("Subarvore esquerda da chave *" + valor + "*:");
            arvore.subarvoreEsquerda(valor);
        }));
        submenu.addItem(new SimpleMenuItem("Transformar em lista encadeada", () -> {
            System.out.println("\nLista encadeada:");
            arvore.converteEmListaEncadeada();
        }));
        submenu.addItem(new SimpleMenuItem("Mostrar chaves pares", () -> {
            System.out.println("\nChaves pares: ");
            arvore.mostrarPares();
        }));
        submenu.addItem(new SimpleMenuItem("Nivel da chave", () -> {
            System.out.print("Digite o valor da chave: ");
            int valor = sc.nextInt();
            System.out.println("Nivel da chave *" + valor + "*: " + arvore.nivelChave(valor));
        }));
        submenu.addItem(new SimpleMenuItem("Altura da arvore", () -> {
            System.out.println("\nAltura da arvore: " + arvore.altura());
        }));
        submenu.addItem(new SimpleMenuItem("Tamanho da arvore", () -> {
            System.out.println("\nTamanho da arvore: " + arvore.tamanho());
        }));
        submenu.addItem(new SimpleMenuItem("Eh AVL?", () -> {
            System.out.println("\nArvore eh AVL? " + arvore.ehAVL());
        }));

        mainMenu.addItem(submenu);

        mainMenu.addItem(new SimpleMenuItem("Sair", () -> {
            System.out.println("Saindo do programa...");
            System.exit(0);
        }));

        mainMenu.execute();
    }
}
