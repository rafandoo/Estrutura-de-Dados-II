package com.arvores.avl;

public class Main {

    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();

        arvore.inserir(20);
        arvore.inserir(15);
        arvore.inserir(10);
        arvore.inserir(30);
        arvore.inserir(40);
        arvore.inserir(2);
        arvore.inserir(35);
        arvore.inserir(5);

        System.out.println("Arvore inicial:");
        arvore.mostrarArvore();

        System.out.println("Soma dos nodos em niveis impares: " + arvore.somarNodosNiveisImpares());
    }
}
