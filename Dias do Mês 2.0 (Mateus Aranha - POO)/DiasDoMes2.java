/**
 * ENUNCIADO: O exercício 8 da lista de exercícios anterior, que pede para calcular quantos dias tem um mês, com o cuidado de considerar ano bissexto, pode ser implementado usando apenas um
 * comando condicional para considerar o caso particular do mês de fevereiro. Para isto, pode-se utilizar o array:
 *	                int[] diasDoMes = {31, 28, 31, 30, 31, 30,
 *	                                   31, 31, 30, 31, 30, 31}
 *
 * que, sem considerar o caso especial de ano bissexto, contém quantos dias cada mês tem. Em particular, o elemento diasDoMes[m-1] contém quantos dias tem o mês m. Reimplemente o exercício
 * usando este array. Não esqueça de tratar ano bissexto.
 * 
 * @author Mateus Arnaha (github.com/matt-aranha) 
 * @version (16/11/2025)
 */

import java.util.Scanner;

public class DiasDoMes2 {

    // --- MÉTODO QUE RETORNA A QUANTIDADE DE DIAS DO MÊS ---
    public static int diasDoMes( int mes, int ano ) {
        int [] diasDoMes = { 31, 28, 31, 30, 31, 30,
                             31, 31, 30, 31, 30, 31 };

            if ( mes < 1 || mes > 12 ) { return 0; }                                    // Checa se o Mês é válido. Se for inválido, retorna 0.

            if ( mes == 2) {                                                            // Checa se o mês é Fevereiro.
                if ( (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0) ) {           // P/ ser bissexto, o ano deve ser divisível por 4 && não divisível por 100 || divisível por 400  (essa é a lógica do calendário gregoriano)
                    return 29;   // Ano bissexto
                } else {
                    return 28;   // Ano não bissexto
                }
            } else {
                return diasDoMes[ mes - 1 ];                                            // Retorna a quantidade de dias do mês, acessando o array. Como a ordem do array começa em 0, subtrai 1 do mês.
            }

    } 
    
    // --- MÉTODO PRINCIPAL ---
    public static void main(String[] args) {                                            // Reutilizei o código do método main do exercício anterior.
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