package br.com.digital.innovation.one.Java11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Inferencia {

    public static void main(String[] args) throws IOException {
        //printarNomeCompleto("Gustavo", "Elias");
        //printarSoma(5, 7);
        connectAndPrintURLJavaOracle();
    }

    private static void connectAndPrintURLJavaOracle() throws IOException {
        // var não pode ser utlizado em nível de classe
        // var não pode ser utilizado como parâmetro
        var url = new URL("https://docs.oracle.com/javase/10/language/");
        var urlConnection = url.openConnection();

        try (var bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
            System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printarNomeCompleto(String nome, String sobrenome) {
        var nomeCompleto = String.format("%s %s", nome, sobrenome);
        System.out.println(nomeCompleto);
    }

    public static void printarSoma(int... numeros) {
        // var não pode ser utilizada em variáveis locais não inicializadas
        var soma1 = 0;
        var soma2 = 0;
        if(numeros.length > 0) {
            soma1 = Arrays.stream(numeros).sum();
        }
        System.out.println(soma1);

        for(var i = 0; i < numeros.length; i++) {
            if(numeros.length > 0) {
                soma2 += numeros[i];
            }
        }
        System.out.println(soma2);
    }
}
