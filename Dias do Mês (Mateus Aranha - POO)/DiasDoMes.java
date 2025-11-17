/**
 * ENUNCIADO: Escreva um programa que, dado um mês e um ano, diga quantos dias tem o mês. Considere anos bissextos.
 * 
 * @author Mateus Aranha (github.com/matt-aranha) 
 * @version (16/11/2025)
*/

import java.util.Scanner;

public class DiasDoMes {

    // --- MÉTODO QUE RETORNA A QUANTIDADE DE DIAS DO MÊS ---
    public static int diasDoMes( int mes, int ano ) {
        switch ( mes ) {
            case 1:              // Janeiro
            case 3:              // Março
            case 5:              // Maio
            case 7:              // Julho
            case 8:              // Agosto
            case 10:             // Outubro
            case 12:             // Dezembro
                return 31;

            case 4:              // Abril
            case 6:              // Junho
            case 9:              // Setembro
            case 11:             // Novembro
                return 30;

            case 2:              // Fevereiro
                if ( (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0) ) {           // para ser bissexto, o ano deve ser divisível por 4 && não divisível por 100 || divisível por 400  (essa é a lógica do calendário gregoriano)
                    return 29;   // Ano bissexto
                } else {
                    return 28;   // Ano não bissexto
                }

        }
        return 0;  // Mês inválido
    }
    
    // --- MÉTODO PRINCIPAL ---
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

            IO.println( "------ ESSE PROGRAMA DIZ A QUANTIDADE DE DIAS EM UM MÊS DE UM ANO QUALQUER ------" );
            IO.println( "       Digite o ano (apenas números):" );

                while ( !leitor.hasNextInt() ) {
                    IO.println( "   Entrada inválida. Digite APENAS números:" );
                    leitor.next();
                }
                    int ano = leitor.nextInt();

            IO.println( "       Digite o número referente ao mês (ex: 1 para Janeiro):" );

                while ( !leitor.hasNextInt() ) {
                    IO.println( "   Entrada inválida. Digite APENAS números:" );
                    leitor.next();
                }
                    int mes = leitor.nextInt();

        leitor.close();

        int qntdDiasDoMes = diasDoMes(mes, ano);
        IO.println( "A quantidade de dias do mês " + mes + " no ano " + ano + " é: " + qntdDiasDoMes );
    }
    
}