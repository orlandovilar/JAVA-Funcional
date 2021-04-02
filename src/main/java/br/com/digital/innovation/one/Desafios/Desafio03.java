package br.com.digital.innovation.one.Desafios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Desafio03 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        String min, max, intermedio, caracteresIguais; //declare suas variaveis aqui
        while ((min = in.readLine()) != null) { // complete seu código
               max = in.readLine();
            if(min == null){
                break;
            } else if(min.length() > max.length()) {
                intermedio = max;
                max = min;
                min = intermedio;
            }
            caracteresIguais = "";
            int minLength = min.length();
            int maxS = minLength;
            boolean f = true;
            while (maxS > 0 || f) { //altere as variaveis, se achar necessario
                int diff = minLength - maxS;
                for (int i = 0; i <= maxS; i++) { //complete o laco de repeticao
                    if (max.contains(min.substring(i, maxS))) {
                        if(min.substring(i, maxS).length() > caracteresIguais.length()) {
                            caracteresIguais = min.substring(i, maxS);
                        }
                        f = false;
                        break;
                    }
                }
                maxS--;
            }
            System.out.println(caracteresIguais.length());
        }
        out.close();
    }
}