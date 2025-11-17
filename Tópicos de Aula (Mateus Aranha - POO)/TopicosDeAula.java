/**
 * ENUNCIADO: Defina um sistema pequeno que permita representar uma lista de tópicos de aulas. Considere que um tópico de aula tem uma data, um título e um assunto. Deverá haver uma funcionalidade
 * que permita listar na tela todos os tópicos de uma lista. Deverá também ter uma funcionalidade que permita adicionar um tópico a uma lista de tópicos.
 * 
 * @author Mateus Aranha (github.com/matt-aranha) 
 * @version (16/11/2025)
 */

import java.util.Scanner;

public class TopicosDeAula {
    
    // --- MÉTODO QUE ADICIONA UM TÓPICO DE AULA NA LISTA ---
    public static int adicionarTopico( Scanner leitor, String[] titulos, String[] assuntos, String[] datas, int contadorTopicos ) {

            IO.println( "\n------ ADICIONAR TÓPICO DE AULA ------" );

            IO.print( "   Digite o título do tópico:  " );
                String titulo = leitor.nextLine();
                titulos[ contadorTopicos ] = titulo;

            IO.print( "   Digite o assunto do tópico:  " );
                String assunto = leitor.nextLine();
                assuntos[ contadorTopicos ] = assunto;

            IO.print( "   Digite a data do tópico (formato DD/MM/AAAA):  " );
                String data = leitor.nextLine();
                datas[ contadorTopicos ] = data;

            IO.println( "\nTópico adicionado com sucesso!" );

            return contadorTopicos + 1; 
            
    }

    // --- MÉTODO QUE LISTA TODOS OS TÓPICOS DE AULA DA LISTA ---
    public static void listarTopicos( String[] titulos, String[] assuntos, String[] datas, int contadorTopicos ) {      // para chamar esse método no terminal, dê um "listarTopicos(titulos, assuntos, datas, contadorTopicos);"
        IO.println( "\n------ LISTA DE TÓPICOS DE AULA ------" );

            if ( contadorTopicos == 0 ) {
                IO.println( "Nenhum tópico de aula cadastrado." );
            }

            for ( int i = 0; i < contadorTopicos; i++ ) {
                IO.println( "\n       Tópico " + (i + 1) + ":" );
                IO.println( "       Título: " + titulos[i] );
                IO.println( "       Assunto: " + assuntos[i] );
                IO.println( "       Data: " + datas[i] );
                IO.println( "   -------------------------------" );
            }
    }

    // --- MÉTODO PRINCIPAL ---
    public static void main( String[] args ) {
        Scanner leitor = new Scanner( System.in );

            int capacidadeMaxima = 100;
                String[] titulos = new String[ capacidadeMaxima ];
                String[] assuntos = new String[ capacidadeMaxima ];
                String[] datas = new String[ capacidadeMaxima ];
                int contadorTopicos = 0;

            int opcao = 0;
                while ( opcao != 3 ) {
                    IO.println( "\n ====== MENU ======" );
                    IO.println( "   1. Adicionar tópico de aula" );
                    IO.println( "   2. Listar tópicos de aula" );
                    IO.println( "   3. Sair" );
                    IO.print( "     \n Escolha uma opção: " );
                        opcao = Integer.parseInt( leitor.nextLine() );

                    switch ( opcao ) {
                        case 1:
                            contadorTopicos = adicionarTopico( leitor, titulos, assuntos, datas, contadorTopicos );
                            break;
                        case 2:
                            listarTopicos( titulos, assuntos, datas, contadorTopicos );
                            break;
                        case 3:
                            IO.println( "Saindo do sistema. Até mais!" );
                            break;
                        default:
                            IO.println( "Opção inválida. Tente novamente." );
                            break;
                    }

                }

        leitor.close();
    }
            
}