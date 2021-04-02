package br.com.digital.innovation.one.Java11;

public class StringBlank {
    public static void main(String[] args) {
        String espaco = "         ";


        System.out.println(espaco == null || espaco.length() == 0 || espaco.chars().allMatch(c -> c == ' '));
        System.out.println(espaco.isBlank());
    }
}

