package br.com.digital.innovation.one.Iteracoes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Iteracoes {
    public static void main(String[] args) {
        String[] nomes = {"Joao", "Gustavo", "Joao", "Orlando", "Thiago", "Joao", "Juliana"};
        Integer[] numeros = {1, 2, 3, 4, 5};
        List<String> profissoes = new ArrayList<>();
        profissoes.add("Desenvolvedor");
        profissoes.add("Testador");
        profissoes.add("Gerente de Projeto");
        profissoes.add("Gerente de Qualidade");

        //imprimirNomesFiltrados(nomes);
        //imprimirTodosNomes(nomes);
        //imprimirODobroDeCadaValor(numeros);
        filtrarProfissao(profissoes);
    }

    public static void filtrarProfissao(List<String> profissoes) {
        profissoes.stream()
                .filter(profissao -> profissao.contains("or"))
                        .forEach(System.out::println);

        profissoes.stream()
                .filter(profissao -> profissao.startsWith("Gerente"))
                .forEach(System.out::println);
    }

    public static void imprimirNomesFiltrados(String... nomes) {
        String nomesParaImprimirDaString = Stream.of(nomes)
                .filter(nome -> nome.equals("Joao"))
                .collect(Collectors.joining()); //String

        System.out.println("Nomes do String: " + nomesParaImprimirDaString);
    }

    public static void imprimirTodosNomes(String... nomes) {
        Stream.of(nomes)
                .forEach(System.out::println);
    }

    public static void imprimirODobroDeCadaValor(Integer... numeros) {
        Stream.of(numeros)
                .map(nome -> nome * 2)
                .forEach(System.out::println);
    }
}
