/**
 * ENUNCIADO: Um supermercado está com oferta na compra de vinhos. Na compra de três garrafas pagam-se apenas duas.
 * Escreva um programa que leia a quantidade de garrafas de vinho compradas e o preço individual de cada garrafa, sem descontos, e calcule o valor total a pagar.
 * 
 * 
 * @author Mateus Aranha (github.com/matt-aranha) 
 * @version (29/10/2025)
 */

import java.util.Scanner;

public class Vinho {
    
    public static double total( double preco, double quantidade, double trios ) {
        double valorTotal = ( preco * quantidade ) - ( trios * preco );
        return valorTotal;
    }

    public static void main( String[] args ) {
        Scanner leitor = new Scanner(System.in);

            IO.println( "Insira o preço unitário do Vinho (ex: 120,90)" );
            while ( !leitor.hasNextDouble() ) {
                IO.println( "Entrada inválida. Por favor insira um preço válido (ex: 120,90)" );
            }
                double preco = leitor.nextDouble();


            IO.println( "Insira a quantidade do produto" );
            while ( !leitor.hasNextInt() ) {
                IO.println( "Entrada inválida. Por favor insira uma quantidade válida" );
            }
                int quantidadeInt = leitor.nextInt();
                double quantidadeDouble = quantidadeInt;                // transforma a quantidade em double para relacionar com o preço

                double triosInt = ( quantidadeInt / 3 );
                double triosDouble = triosInt;

        leitor.close();


                double extrato = total( preco, quantidadeDouble, triosDouble ); 
                    IO.println( "O valor total a pagar é: R$" + extrato );
                    IO.println( "(Desconto de R$" + ( triosDouble * preco ) + " )" );
}
}