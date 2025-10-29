/**
 * ENUNCIADO: Na última semana do circo em Aracaju os ingressos estão com 50% de desconto para menores de idade e idosos.
 * Considere menor de idade até os 18 anos, inclusive, e idoso a partir dos 60 anos. Para o resto da população o desconto é de 10%.
 * Elabore um programa que receba a idade e o preço normal do ingresso, um Int e um Double, respectivamente. O programa deve apresentar o valor a ser pago
 * 
 * @author Mateus Aranha (github.com/matt-aranha) 
 * @version (28/10/2025)
 */

import java.util.Scanner;

public class IngressoCirco {
    
    public static void main( String[] args ) {
        Scanner leitor = new Scanner(System.in);

            System.out.println( "Insira o valor normal do Ingresso (ex: 69,99)" );

                while (!leitor.hasNextDouble()) {                                                       // loop que checa se a entrada corresponde à um Double. Se não corresponder, fica preso nessa etapa.  (retirei essa aplicação do site que o Prof. Giovanny colocou no classroom: https://zerotomastery.io/blog/java-scanner/ )
                    System.out.println( "Entrada inválida. Por favor, insira apenas números." );
                    leitor.next();                                                                      // passa pra próxima linha
                }
                    double ingresso = leitor.nextDouble();

                    
            System.out.println( "Insira a idade do Cliente:" );

                while (!leitor.hasNextInt()) {
                    System.out.println( "Entrada inválida. Por favor, insira apenas números inteiros." );
                    leitor.next();
                }
                    int idade = leitor.nextInt();

        leitor.close();

        if ( idade < 18 || idade >= 60) {
            System.out.println( "O valor do ingresso, com Desconto para Idosos e Menores de Idade, ficou R$" + ingresso*0.5 );
        }
        else {
            System.out.println( "O valor do ingresso, com Desconto promocional, ficou R$" + ingresso*0.9 );
        }
    }
}