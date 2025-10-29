/**
 * ENUNCIADO: Defina um programa que, dado um inteiro, apresente uma string que informe se o número é positivo, negativo ou nulo.
 * Caso não seja nulo, a string deverá conter também a magnitude do número.
 * Por exemplo, para o valor 15 a função deverá retornar “Positivo 15”, para o valor -15 deverá retornar “Negativo 15” e para 0 deverá retornar “Nulo”.
 * 
 * 
 * @author Mateus Aranha (github.com/matt-aranha) 
 * @version (27/10/2025)
 */

import java.util.Scanner;

public class IntParaString {
    
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

            System.out.println( "Digite um número inteiro (Positivo, Negativo ou Nulo):" );
                while (!leitor.hasNextInt()) {
                    System.out.println( "Entrada inválida. Digite apenas números inteiros." );
                    leitor.next();
                }
                    String numeroString = leitor.next();

                    
            int numeroInt = Integer.parseInt(numeroString);
                if( numeroInt > 0) {
                    System.out.println( "Positivo, " + numeroInt );
                } 
                else if ( numeroInt < 0) {
                    int modulo = numeroInt * -1;
                    System.out.println( "Negativo, " + modulo );
                }
                else { System.out.println( "Nulo" ); }
            
        leitor.close();

    }

}