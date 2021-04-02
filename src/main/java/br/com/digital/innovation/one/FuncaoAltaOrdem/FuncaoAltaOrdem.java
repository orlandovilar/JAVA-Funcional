package br.com.digital.innovation.one.FuncaoAltaOrdem;

public class FuncaoAltaOrdem {
    public static void main(String[] args) {
        int num1 = 10, num2 = 31;
        Calculo soma = (a, b) -> a + b;
        Calculo subtracao = (a, b) -> b - a;
        Calculo multiplicacao = (a, b) -> a * b;
        Calculo divisao = (a, b) -> b / a;
        Calculo resto = (a, b) -> b % a;
        System.out.println("Soma: " + executarOperacao(soma, num1, num2));
        System.out.println("Subtração: " + executarOperacao(subtracao, num1, num2));
        System.out.println("Multiplicação: " + executarOperacao(multiplicacao, num1, num2));
        System.out.println("Divisão: " + executarOperacao(divisao, num1, num2));
        System.out.println("Resto da divisão: " + executarOperacao(resto, num1, num2));
    }

    public static int executarOperacao(Calculo calculo, int a, int b) {
        return calculo.calcular(a, b);
    }
}

interface Calculo {
    public int calcular(int a, int b);
}
