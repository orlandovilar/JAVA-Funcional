package br.com.digital.innovation.one.Suplidores;

import java.util.function.Supplier;

public class Suplidores {
    public static void main(String[] args) {
        Supplier<Pessoa> instanciaPessoa = Pessoa::new;
        //Supplier<Pessoa> instanciaPessoa = () -> new Pessoa();
        System.out.println(instanciaPessoa.get());
    }
}

class Pessoa {
    private String nome;
    private Integer idade;

    public Pessoa() {
        nome = "Orlando";
        idade = 28;
    }

    @Override
    public String toString() {
        return String.format("nome: %s, idade %d", nome, idade);
    }
}