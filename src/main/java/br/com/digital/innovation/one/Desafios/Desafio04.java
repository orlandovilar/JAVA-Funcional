package br.com.digital.innovation.one.Desafios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Desafio04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String palavra;

        while ((palavra = br.readLine()) != null) {
            corrigirPalavra(palavra);
        }
    }

    public static void corrigirPalavra(String palavra) {
        int posUltimoCaracter = palavra.length() - 1;
        boolean existemCaracteresRepetidos = false;

        for(int i = 0; i <= posUltimoCaracter; i++) {
            if(palavra.substring(0, i).endsWith(palavra.substring(i))) {
                System.out.println(palavra.substring(0, i));
                existemCaracteresRepetidos = true;
            }
        }

        if(!existemCaracteresRepetidos) {
            System.out.println(palavra);
        }
    }
}
