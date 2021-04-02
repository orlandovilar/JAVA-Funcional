package br.com.digital.innovation.one.Desafios;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Desafio01 {
    private static List<String> palavrasAbreviadas;
    private static List<String> quantPalavrasAbreviadas;
    private static Map maiorTamanhoCaracteresAbreviadosMap;
    private static Map quantCaracteresAbreviadosPorPalavraMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String entradaDados = br.readLine();

        while(entradaDados != null && !entradaDados.contains(".")) {
            palavrasAbreviadas = new ArrayList<>();
            quantPalavrasAbreviadas = new ArrayList<>();
            maiorTamanhoCaracteresAbreviadosMap = new HashMap();
            quantCaracteresAbreviadosPorPalavraMap = new HashMap();
            st = new StringTokenizer(entradaDados, "\n");
            List<String> frase = new ArrayList<>();
            Collection<String> colecao = List.of(st.nextToken().split(" "));

            frase = abreviarFrase(colecao);

            frase
                    .stream()
                    .map(s -> s + " ")
                    .forEach(System.out::print);

            System.out.println("\n" + quantPalavrasAbreviadas.size());

            imprimirNotadeRodape();

            entradaDados = br.readLine();
        }
    }

    public static List<String> abreviarFrase(Collection<String> colecao) {
        List<String> frase = new ArrayList<>();

        frase.addAll(colecao);

        colecao
                .stream()
                .forEach(palavra -> {
                    if(palavra.length() > 2) {
                        if (!quantCaracteresAbreviadosPorPalavraMap.containsKey(palavra)) {
                            quantCaracteresAbreviadosPorPalavraMap.put(palavra, palavra.length() - 2);
                        } else {
                            quantCaracteresAbreviadosPorPalavraMap.put(palavra, (Integer) quantCaracteresAbreviadosPorPalavraMap.get(palavra) + palavra.length() - 2);
                        }
                    }
                });

        colecao
                .stream()
                .forEach(palavra -> {
                    if(palavra.length() > 2) {
                        String palavraAbreviada = palavra.substring(0, 1) + ".";
                        int tamanhoSalvo = 0;

                        if(maiorTamanhoCaracteresAbreviadosMap.containsKey(palavraAbreviada)) {
                            if((Integer) maiorTamanhoCaracteresAbreviadosMap.get(palavraAbreviada) < (Integer) quantCaracteresAbreviadosPorPalavraMap.get(palavra)) {
                                maiorTamanhoCaracteresAbreviadosMap.put(palavraAbreviada, quantCaracteresAbreviadosPorPalavraMap.get(palavra));
                            }
                        }else {
                            maiorTamanhoCaracteresAbreviadosMap.put(palavraAbreviada, quantCaracteresAbreviadosPorPalavraMap.get(palavra));
                        }
                    }
                });

        frase
                .stream()
                .filter(palavra -> palavra.length() > 2)
                .filter(palavra -> palavra.matches("[a-z]*"))
                .forEach(palavra -> {
                    String palavraAbreviada = palavra.substring(0, 1) + ".";

                    if(maiorTamanhoCaracteresAbreviadosMap.containsKey(palavraAbreviada)) {
                        if(quantCaracteresAbreviadosPorPalavraMap.get(palavra) == (Integer) maiorTamanhoCaracteresAbreviadosMap.get(palavraAbreviada)) {
                            if (!frase.contains(palavraAbreviada) || quantPalavrasAbreviadas.contains(palavra)) {
                                frase.set(frase.indexOf(palavra), palavraAbreviada);
                                if(!quantPalavrasAbreviadas.contains(palavra)) {
                                    quantPalavrasAbreviadas.add(palavra);
                                }
                            }
                        }
                    }
                });

        return frase;
    }

    public static void imprimirNotadeRodape() {
        quantPalavrasAbreviadas
                .stream()
                .sorted()
                .forEach(palavra -> {
                    String palavraAbreviada = palavra.substring(0, 1) + ".";
                    if (!palavrasAbreviadas.contains(palavraAbreviada)) {
                        System.out.println(palavraAbreviada + " = " + palavra);
                        palavrasAbreviadas.add(palavraAbreviada);
                    }
                });
    }
}