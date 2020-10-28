package br.com.isaccanedo;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Programa Java para calcular o valor de hash MD5
public class Main {

    public static String encryptThisString(String input)
    {
        try {
            // O método estático getInstance() é chamado com hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // método digest() é chamado
            // para calcular o resumo da mensagem da string de entrada
            // retornada como matriz de bytes
            byte[] messageDigest = md.digest(input.getBytes());

            // Converter matriz de bytes em representação de signum
            BigInteger no = new BigInteger(1, messageDigest);

            // Converta o resumo da mensagem em valor hexadecimal
            String hashtext = no.toString(16);

            // Adicione o sistema operacional anterior para torná-lo de 32 bits
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            // retorna o HashText
            return hashtext;
        }

        // Para especificar algoritmos de resumo de mensagem errados
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String args[]) throws NoSuchAlgorithmException
    {

        System.out.println("Seu HashCode gerado por MD5 é: ");

        String s = "Isac Canedo de Almeida";
        System.out.println("\n" + s + " : " + encryptThisString(s));

    }
}