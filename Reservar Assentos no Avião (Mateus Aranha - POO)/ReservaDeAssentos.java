/**
 * ENUNCIADO:
 *   Escreva um programa para reservar assentos num voo. O avião tem 16 assentos. O sistema deverá apresentar um mapa de assentos mostrando os ocupados e livres como neste exemplo:
 *                                      1X 2 3X 4 5 6X 7X 8 9 10X 11X 12 13 14 15 16
 *                                      
 *   em que os assentos 1, 3, 6, 7, 10 e 11 estão ocupados.
 *   Os quatro primeiros assentos são de primeira classe, os restantes são de classe econômica. O sistema deverá perguntar ao usuário se a reserva é para primeira classe ou econômica.
 *   Só devem permitir-se reservas de acordo com a classe. Assim, por exemplo, não poderá se reservar o assento 12 para a primeira classe nem 2 para a econômica. Obviamente, não se deve permitir
 *   várias reservas para um mesmo assento. Se o avião estiver lotado, o usuário deverá receber uma mensagem informando-o. O usuário poderá optar por escolher o assento ou deixar que o sistema
 *   escolha um para ele.
 *   Em qualquer momento em que o usuário escolher uma opção que não pode ser realizada, o programa terminará. Por simplicidade, uma reserva registra apenas a ocupação de um assento, ou seja,
 *   não interessa quem ocupa um assento.
 * 
 * 
 * 
 * @author Mateus Aranha (github.com/matt-aranha) 
 * @version (16/11/2025)
 */

import java.util.Scanner;

public class ReservaDeAssentos {

    // ====== MÉTODOS AUXILIARES ======
            // --- MÉTODO QUE MOSTRA O MAPA DOS ASSENTOS ---
            public static String mostrarMapa( boolean[] assentos ) {
                    String mapa = "\n ------ Mapa dos Assentos: ------ \n\n";

                        for ( int i = 0; i < assentos.length; i++ ) {
                            if ( assentos[i] ) {
                                mapa += (i + 1) + "X ";     // Assento ocupado
                            } else {
                                mapa += (i + 1) + "  ";     // Assento livre
                            }
                        }
                    return mapa;
            }


            // --- MÉTODO QUE PERMITE ESCOLHER O ASSENTO (pergunta o tipo de assento e então mostra os assentos disponíveis do tipo escolhido) --- 
            public static void escolherAssento( Scanner leitor, boolean[] assentos ) {
                    IO.print( "\n Digite o tipo de assento desejado (1 - Primeira Classe, 2 - Econômica): " );
                        int tipoAssento = Integer.parseInt( leitor.nextLine() );

                        int inicio = 0;
                        int fim = 0;
                            if ( tipoAssento == 1 ) {            // Primeira Classe
                                inicio = 0;
                                fim = 4;

                            } else if ( tipoAssento == 2 ) {     // Econômica
                                inicio = 4;
                                fim = 16;

                            } else {
                                IO.println( "\n Tipo de assento inválido." );
                                return;
                            }


                    IO.println( mostrarMapa( assentos ) );

                    IO.print( "\n Digite o número do assento que deseja reservar: " );
                        int numeroAssento = Integer.parseInt( leitor.nextLine() );

                            if ( numeroAssento < inicio + 1 || numeroAssento > fim ) {
                                IO.println( "\n Número do assento inválido para o tipo escolhido." );

                            } else if ( assentos[ numeroAssento - 1 ] == true ) {        // Checa se o assento já está ocupado (se já está "true").
                                IO.println( "\n Assento já está ocupado." );

                            } else {
                                assentos[ numeroAssento - 1 ] = true;                    // Reserva o assento, marcando como ocupado (se tiver "false", muda para "true").
                                IO.println( "\n Assento reservado com sucesso!" );
                            }
            }


            // --- MÉTODO QUE DEIXA O SISTEMA ESCOLHER O ASSENTO (pergunta o tipo de assento e então escolhe aleatoriamente um que esteja disponível) ---
            public static void assentoAleatorio( Scanner leitor, boolean[] assentos ) {
                    IO.print( "\n Digite o tipo de assento desejado (1 - Primeira Classe, 2 - Econômica): " );
                        int tipoAssento = Integer.parseInt( leitor.nextLine() );

                        int inicio = 0;
                        int fim = 0;
                            if ( tipoAssento == 1 ) {            // Primeira Classe
                                inicio = 0;
                                fim = 4;

                            } else if ( tipoAssento == 2 ) {     // Econômica
                                inicio = 4;
                                fim = 16;

                            } else {
                                IO.println( "\n Tipo de assento inválido." );
                                return;
                            }
                    
                    boolean conseguiuReservar = false;
                        for ( int i = inicio; i < fim; i++ ) {
                            if ( !assentos[i] ) {        // Se encontrar um assento livre (false).
                                assentos[i] = true;      // Reserva o assento, marcando como ocupado (muda para true).

                                IO.println( "\n Assento " + (i + 1) + " reservado com sucesso!" );
                                conseguiuReservar = true;
                                break;                   // Sai do loop após reservar o primeiro assento livre encontrado (acabei esquecendo do break e ele reservou tudo...).
                            }
                        }

                        if ( !conseguiuReservar ) {
                            IO.println( "\n Não há assentos disponíveis para a classe escolhida." );
                        }
            }


    
    // ====== MÉTODO PRINCIPAL ======
    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);
        
            boolean[] assentos = new boolean[16];   // false = livre, true = ocupado
                for ( int i = 0; i < assentos.length; i++ ) {
                    assentos[i] = false;
                }
            int opcao = 0;
                while ( opcao != 4 ) {
                    IO.println( "\n ====== MENU ======" );
                    IO.println( "   1. Mostrar Mapa" );
                    IO.println( "   2. Escolher assento" );
                    IO.println( "   3. Deixar o sistema escolher o assento" );
                    IO.println( "   4. Sair" );
                    IO.print( "     \n Escolha uma opção: " );
                        opcao = Integer.parseInt( leitor.nextLine() );
                    
                    switch ( opcao ) {
                        case 1:
                            IO.println( mostrarMapa( assentos ) );
                            break;
                        case 2:
                            escolherAssento( leitor, assentos );
                            break;
                        case 3:
                            assentoAleatorio( leitor, assentos );
                            break;
                        case 4:
                            IO.println( "\nSaindo do sistema. Até mais!" );
                            break;
                        default:
                            IO.println( "\nOpção inválida. Tente novamente." );
                    }
                }

        leitor.close();
        
    }
    
}