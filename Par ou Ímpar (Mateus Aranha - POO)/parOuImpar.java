/**
 * Enunciado: Escreva um programa que leia um número inteiro e que escreva na tela se o número é par ou ímpar.
 * 
 * 
 * @author Mateus Aranha (github.com/matt-aranha) 
 * @version (27/10/2025)
 */

import java.util.Scanner;


public class parOuImpar {

    public static void main (String[] args) {
        Scanner scanner  = new Scanner(System.in);                       // inicializei um novo scanner que lê as entradas do teclado (System.in)
      
            System.out.println( "Digite um número inteiro" );
                while (!scanner.hasNextInt()) {
                    System.out.println( "Entrada inválida. Digite um número inteiro." );
                    scanner.next();
                }
                    int numero = scanner.nextInt();

                    if ( numero % 2 == 0) {                              // o operador "%" retorna o resto da divisão entre dois números. se o resto for == 0, então, nesse caso, o número é divisível por 2. Logo, é par.
                        System.out.println( "O número é par!" );      
                    } else {
                        System.out.println( "O número é ímpar!" );     // se o resto da divisão for > 0, então o número não é multiplo de 2. Portanto é ímpar.
                    }

        scanner.close();

    }
}