package com.arvores.avl.municipios;

public class ArvoreMunicipios {

    private class Nodo {
        private String nome;
        private double area;
        private int populacao;
        private Nodo dir, esq;

        public Nodo(String nome, double area, int populacao) {
            this.nome = nome;
            this.area = area;
            this.populacao = populacao;
            dir = esq = null;
        }
    }

    private Nodo raiz;

    public ArvoreMunicipios() {
        raiz = null;
    }

    public void inserir(String nome, double area, int populacao) {
        raiz = inserir(raiz, nome, area, populacao);
    }

    private Nodo inserir(Nodo raiz, String nome, double area, int populacao) {
        if (raiz == null) {
            return new Nodo(nome, area, populacao);
        }

        if (nome.compareTo(raiz.nome) < 0) {
            raiz.esq = inserir(raiz.esq, nome, area, populacao);
        } else if (nome.compareTo(raiz.nome) > 0) {
            raiz.dir = inserir(raiz.dir, nome, area, populacao);
        }

        return raiz;
    }

    public int contarMunicipios() {
        return contarMunicipios(raiz);
    }

    private int contarMunicipios(Nodo raiz) {
        if (raiz == null) {
            return 0;
        }
        return 1 + contarMunicipios(raiz.esq) + contarMunicipios(raiz.dir);
    }

    public void mostrarMaisPopulosos(int num) {
        mostrarMaisPopulosos(raiz, num);
    }

    private void mostrarMaisPopulosos(Nodo raiz, int num) {
        if (raiz == null) {
            return;
        }
        if (raiz.populacao > num) {
            System.out.println(raiz.nome);
        }
        mostrarMaisPopulosos(raiz.esq, num);
        mostrarMaisPopulosos(raiz.dir, num);
    }

    public void densidadeDemografica() {
        densidadeDemografica(raiz);
    }

    private void densidadeDemografica(Nodo raiz) {
        if (raiz == null) {
            return;
        }
        double densidade = raiz.populacao / raiz.area;
        System.out.println("Nome do Município: " + raiz.nome + " | Densidade Demográfica: " + densidade + " pessoas/km²");
        densidadeDemografica(raiz.esq);
        densidadeDemografica(raiz.dir);
    }

    public double areaTerritorio() {
        return areaTerritorioNacional();
    }

    public double areaTerritorioNacional() {
        double territorioNacional = 8514876; // Área total do território nacional em km²
        double areaTotalCidades = somarAreaTotal(raiz);

        double porcentagem = (areaTotalCidades / territorioNacional) * 100;

        return porcentagem;
    }

    private double somarAreaTotal(Nodo raiz) {
        if (raiz == null) {
            return 0;
        }
        return raiz.area + somarAreaTotal(raiz.esq) + somarAreaTotal(raiz.dir);
    }


    public String maiorPopulacao() {
        if (raiz == null) {
            return "";
        }
        return maiorPopulacao(raiz).nome;
    }

    private Nodo maiorPopulacao(Nodo raiz) {
        if (raiz == null) {
            return null;
        }

        Nodo maior = raiz;

        Nodo dir = maiorPopulacao(raiz.dir);
        if (dir != null && dir.populacao > maior.populacao) {
            maior = dir;
        }

        Nodo esq = maiorPopulacao(raiz.esq);
        if (esq != null && esq.populacao > maior.populacao) {
            maior = esq;
        }

        return maior;
    }

    public void imprimirArvore() {
        imprimirArvoreRec(raiz, 0);
    }

    private void imprimirArvoreRec(Nodo raiz, int nivel) {
        if (raiz != null) {
            imprimirArvoreRec(raiz.dir, nivel + 1);
            for (int i = 0; i < nivel; i++) {
                System.out.print("   ");
            }
            System.out.println(raiz.nome);
            imprimirArvoreRec(raiz.esq, nivel + 1);
        }
    }

    public static void main(String[] args) {
        ArvoreMunicipios municipios = new ArvoreMunicipios();
        municipios.inserir("rio_do_sul", 1000, 150000);
        municipios.inserir("vidal_ramos", 800, 80000);
        municipios.inserir("blumenau", 1200, 200000);
        municipios.inserir("pouso_redondo", 900, 70000);

        System.out.println("Árvore de municípios:");
        municipios.imprimirArvore();

//        System.out.println("Número de municípios: " + municipios.contarMunicipios());
//        System.out.println("Municípios com mais de 100.000 habitantes:");
//        municipios.mostrarMaisPopulosos(100000);
//        System.out.println("Densidade Demográfica de todos os municípios:");
//        municipios.densidadeDemografica();
        System.out.println("Área total dos municípios em relação ao território nacional: " + municipios.areaTerritorio() + " %");
//        System.out.println("Cidade com a maior população: " + municipios.maiorPopulacao());
    }
}
