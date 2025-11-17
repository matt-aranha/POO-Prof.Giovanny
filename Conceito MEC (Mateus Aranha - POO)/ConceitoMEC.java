/**
* ENUNCIADO: Anualmente, o MEC avalia os cursos universitários de todo o país e atribui conceitos com base em diversos critérios, sendo um deles a quantidade de livros disponíveis.
* Considerando as regras definidas abaixo, escreva um programa que receba como entrada a quantidade de livros e a quantidade de alunos de um curso, ambos inteiros, e retorne a letra
* maiúscula correspondente ao conceito concedido pelo MEC.
*           1 livro para até 8 alunos --> Conceito A
*           1 livro para entre 9 e 12 alunos --> Conceito B
*           1 livro para entre 13 e 18 alunos --> Conceito C
*           1 livro para mais de 18 alunos --> Conceito D
*
* @author Mateus Aranha (github.com/matt-aranha) 
* @version (16/11/2025)
*/

import java.util.Scanner;

public class ConceitoMEC {
    
    // --- MÉTODO DE DIVISÃO ---
    public static char relacaoLivrosAlunos ( int livros, int alunos ) {
        int quociente = alunos / livros;

        if ( livros == 0) {
            return 'D';
        }

        if ( quociente <= 8 ) {
           return 'A';

        } else if ( quociente <= 12 ) {
            return 'B';

        } else if ( quociente <= 18 ) {
            return 'C';

        } else {
            return 'D';
        }
    }
    

    // --- MÉTODO PRINCIPAL ---
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

            IO.println( "---------- CONCEITO DE AVALIAÇÃO DE CURSO DO MEC ----------" );
            IO.println( "       Digite a quantidade de Livros do curso na Universidade" );

                while ( !leitor.hasNextInt() ) {                                                                    // loop que checa se a entrada corresponde à um Int. Se não corresponder, fica preso nessa etapa.  (retirei essa aplicação do site que o Prof. Giovanny colocou no classroom: https://zerotomastery.io/blog/java-scanner/ )
                    IO.println( "   Entrada inválida. Por favor, insira apenas números inteiros." );
                    leitor.next();                                                                                // passa pra próxima linha
                }
                    int qntdLivros = leitor.nextInt();

                    
            IO.println( "       Digite a quantidade de Alunos do curso na Universidade" );

                while ( !leitor.hasNextInt() ) {
                    IO.println( "   Entrada inválida. Por favor, insira apenas números inteiros." );
                    leitor.next();
                }
                    int qntdAlunos = leitor.nextInt();
                
        leitor.close();

        char conceitoMEC = relacaoLivrosAlunos(qntdLivros, qntdAlunos);
        IO.println( "O Conceito MEC desse curso na Universidade analisada é: " + conceitoMEC );
    }
}