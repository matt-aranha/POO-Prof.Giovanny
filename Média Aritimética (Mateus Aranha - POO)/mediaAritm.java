/**
 * Enunciado: Defina um método que calcule a média aritmética de três números double. Escreva então um programa que leia três números double e que escreva na tela a média aritmética dos três.
 * 
 * @author Mateus Aranha (github.com/matt-aranha)
 * @version (27/10/2025)
 */

 import java.util.Scanner;
 

 public class mediaAritm {

// método que calcula a média aritimética
    private static double mediaAritmetica(double a, double b, double c) {
        double resultado = ( a + b + c ) / 3.0;
        return resultado; 
    }
 

// método principal    
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

            IO.println( "Digite o primeiro número (Inteiro ou decimal):" );
            double numA = leitor.nextDouble();

            IO.println( "Digite o segundo número (Inteiro ou decimal):" );
            double numB = leitor.nextDouble();

            IO.println( "Digite o terceiro número (Inteiro ou decimal):" );
            double numC = leitor.nextDouble();

        leitor.close();

        double media = mediaAritmetica(numA, numB, numC);
        IO.println( "A média aritimética dos três números é: " + media );
    }

 }