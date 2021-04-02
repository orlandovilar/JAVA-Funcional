package br.com.digital.innovation.one.Desafios;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.StringTokenizer;


public class Desafio02 {
    private static int index;
    private static boolean conjuntoRuim;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String entradaDados = br.readLine();

        while(entradaDados != null && !entradaDados.contains("0")) {
            index = 0;
            conjuntoRuim = false;
            st = new StringTokenizer(entradaDados, "\n");
            Collection<String> colecao = new ArrayList<>();
            int N = Integer.parseInt(st.nextToken());

            for(int i = 0; i < N; i++) {
                entradaDados = br.readLine();
                st = new StringTokenizer(entradaDados, "\n");
                colecao.add(st.nextToken());
            }

            validarConjunto(colecao);

            if(conjuntoRuim) {
                System.out.println("Conjunto Ruim");
            }else {
                System.out.println("Conjunto Bom");
            }

            entradaDados = br.readLine();
        }
    }

    public static void validarConjunto(Collection<String> colecao) {
        colecao
                .stream()
                .forEach(palavra -> {
                    colecao
                            .stream()
                            .forEach(palavra2 -> {
                                if(palavra2.startsWith(palavra)) {
                                    index++;
                                }
                                if(index > 1) {
                                    conjuntoRuim = true;
                                }
                            });
                    index = 0;
                });
    }
}