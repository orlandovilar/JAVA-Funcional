package br.com.digital.innovation.one.Desafios;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collection;
import java.util.List;


public class Desafio05 {
    private static boolean requisitosNaoAtendidos = false, possuiLetraMinuscula = false, possuiLetraMaiuscula = false, possuiNumero = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String senha = new String();

        while((senha = br.readLine()) != null) {
            testarSenha(senha);
        }
	}

	public static void testarSenha(String senha) {
        requisitosNaoAtendidos = false;
        possuiLetraMinuscula = false;
        possuiLetraMaiuscula = false;
        possuiNumero = false;

        Collection<String> colecaoCaracteresSenha = List.of(senha.split(""));

        colecaoCaracteresSenha
                .stream()
                .forEach(caracter -> {
                    if(!caracter.toLowerCase().matches("[a-z]*")) {
                        if(!caracter.matches("[0-9]*")) {
                            requisitosNaoAtendidos = true;
                        }
                    }
                    if(caracter.matches("[a-z]*") == true && requisitosNaoAtendidos == false) {
                        possuiLetraMinuscula = true;
                    }
                    if(caracter.matches("[A-Z]*") == true && requisitosNaoAtendidos == false) {
                        possuiLetraMaiuscula = true;
                    }
                    if(caracter.matches("[0-9]*") == true && requisitosNaoAtendidos == false) {
                        possuiNumero = true;
                    }
                });

        if(possuiLetraMinuscula == false || possuiLetraMaiuscula == false || possuiNumero == false) {
            requisitosNaoAtendidos = true;
        }

        if(senha.length() > 32 || senha.length() < 6 || requisitosNaoAtendidos == true || senha.length()== 0) { //complete o if de acordo com suas variaveis
            System.out.println("Senha invalida.");
        } else {
            System.out.println("Senha valida.");
        }
    }
}
