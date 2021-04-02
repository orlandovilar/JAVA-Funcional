package br.com.digital.innovation.one.Java11;

public class StringRepeat {
    public static void main(String[] args) {
        String nome = "Orlando";
        String aux = "";

        for(int i = 0;i < 10; i++) {
            aux += nome;
        }

        System.out.println(aux);

        System.out.println(nome.repeat(10));
    }
}
