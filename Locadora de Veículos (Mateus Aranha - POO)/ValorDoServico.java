/**
* ENUNCIADO: A Locadora de Veículos Eudora lançou uma grande promoção esse mês: pagando apenas R$ 90 por diária, o cliente pode alugar um carro de passeio. Para cada diária, o cliente recebe uma
* cota de quilometragem de 100 km. Cada quilômetro a mais custará uma taxa extra de R$ 12. Escreva um programa que receba como entrada a quantidade de dias e a quilometragem total rodada por um
* cliente dessa locadora e exiba o valor total a ser pago com duas casas decimais.
* 
* 
* @author Mateus Aranha (github.com/matt-aranha) 
* @version (16/11/2025)
*/

import java.util.Scanner;

public class ValorDoServico {

    // --- MÉTODO DE CÁLCULO DO VALOR DO SERVIÇO ---
    public static double calcularValorDoServico( int diarias, int quilometragem ) {
        double valorDasDiarias = 90.00 * diarias;
        double quilometragemExtra = quilometragem - ( 100.00 * diarias);
        double valorDaQuilometragemExtra = 0;
        
            if ( quilometragemExtra > 0 ) {
                valorDaQuilometragemExtra = quilometragemExtra * 12.00;

            } else {
                valorDaQuilometragemExtra = 0;
            }

        double valorDoServico = valorDasDiarias + valorDaQuilometragemExtra;
        return valorDoServico;
    }

    // --- MÉTODO PRINCIPAL ---
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

            IO.println( "------ BEM-VINDO AO SISTEMA DA LOCADORA DE VEÍCULOS EUDORA ------" );
            IO.println( "       Insira a quantidade de Diárias do cliente:" );

                while ( !leitor.hasNextInt() ) {
                    IO.println( "   Entrada inválida. Por favor insira apenas números inteiros." );
                    leitor.next();
                }
                    int qntdDiarias = leitor.nextInt();

            IO.println( "       Insira a quantidade de Quilômetros Rodados pelo cliente:" );

                while ( !leitor.hasNextDouble() ) {
                    IO.println( "   Entrada inválida. Por favor insira apenas números." );
                    leitor.next();
                }
                    double qntdQuilometrosDouble = leitor.nextDouble();
                    int qntdQuilometros = (int) qntdQuilometrosDouble;

        leitor.close();
        
        double valorTotalDoServico = calcularValorDoServico(qntdDiarias, qntdQuilometros);
        IO.println( "O valor total do serviço é: " + valorTotalDoServico ); 

    }
}