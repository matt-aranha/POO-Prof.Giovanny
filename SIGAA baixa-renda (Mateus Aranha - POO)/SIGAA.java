/**
 * ENUNCIADO: Defina um sistema pequeno que permita representar uma turma de alunos. Cada aluno deverá ter nome e número de matrícula. O sistema deve permitir adicionar alunos numa turma e listar na
 * tela todos os alunos de uma dada turma. As turmas terão outras informações, tais como as que aparecem no SIGAA (Turma [ex: T02], Disciplina [ex: Cálculo A], Semestre [ex: 2025.1], Nome do Professor [ex: Giovanny Lucero]. ).
 * 
 * @author Mateus Aranha (github.com/matt-aranha) 
 * @version (16/11/2025)
*/

import java.util.Scanner;

public class SIGAA {
    
    // ====== MÉTODOS AUXILIARES ======
            // --- MÉTODO QUE CRIA UMA TURMA ---
            public static int criarTurma( Scanner leitor, String[] nomesDisciplinas, String[] semestres, String[] nomesProfessores, String[] codigosTurmas, int contadorTurmas ) {

                    IO.println( "\n------ CRIAR TURMA ------" );

                    IO.print( "   Digite o código da turma (ex: T02):  " );
                        String codigoTurma = leitor.nextLine();
                        codigosTurmas[ contadorTurmas ] = codigoTurma;

                    IO.print( "   Digite o nome da disciplina (ex: Cálculo A):  " );
                        String nomeDisciplina = leitor.nextLine();
                        nomesDisciplinas[ contadorTurmas ] = nomeDisciplina;

                    IO.print( "   Digite o semestre (ex: 2025.1):  " );
                        String semestre = leitor.nextLine();
                        semestres[ contadorTurmas ] = semestre;

                    IO.print( "   Digite o nome do(a) professor(a) (ex: Giovanny Lucero):  " );
                        String nomeProfessor = leitor.nextLine();
                        nomesProfessores[ contadorTurmas ] = nomeProfessor;

                    IO.println( "\nTurma criada com sucesso!" );

                    return contadorTurmas + 1; 
            }


            // --- METÓDO QUE LISTA AS TURMAS CRIADAS ---
            public static void listarTurmas( String[] nomesDisciplinas, String[] semestres, String[] nomesProfessores, String[] codigosTurmas, int contadorTurmas ) {
                    IO.println( "\n------ LISTA DE TURMAS ------" );

                        if ( contadorTurmas == 0 ) {
                            IO.println( "Nenhuma turma criada." );
                        }

                        for ( int i = 0; i < contadorTurmas; i++ ) {
                            IO.println( "\n       Turma " + (i + 1) + ":" );
                            IO.println( "       Código da Turma: " + codigosTurmas[i] );
                            IO.println( "       Disciplina: " + nomesDisciplinas[i] );
                            IO.println( "       Semestre: " + semestres[i] );
                            IO.println( "       Nome do Professor: " + nomesProfessores[i] );
                            IO.println( "   -------------------------------" );
                        }
            }            
            

            // --- MÉTODO QUE ADICIONA UM ALUNO EM ALGUMA TURMA CRIADA (utilizando o número dessa turma) ---
            public static int adicionarAluno( Scanner leitor, int numeroDaTurma, String[] nomesAlunos, String[] numerosMatriculas, int contadorAlunos ) {
                    IO.println( "\n------ ADICIONAR ALUNO(A) EM UMA TURMA ------" );

                    IO.print( "   Digite o número da turma:  " );
                        int turmaEscolhida = Integer.parseInt( leitor.nextLine() );

                    IO.print( "   Digite o nome do(a) aluno(a):  " );
                        String nomeAluno = leitor.nextLine();
                        nomesAlunos[ contadorAlunos ] = nomeAluno;

                    IO.print( "   Digite o número de matrícula do(a) aluno(a):  " );
                        String numeroMatricula = leitor.nextLine();
                        numerosMatriculas[ contadorAlunos ] = numeroMatricula;

                    IO.println( "\nAluno(a) adicionado(a) com sucesso na turma " + turmaEscolhida + "!" );

                    return contadorAlunos + 1;
            }


            // --- MÉTODO QUE LISTA OS ALUNOS DE UMA TURMA (como o método de listar turmas) ---
            public static void listarAlunos( String[] nomesAlunos, String[] numerosMatriculas, int contadorAlunos ) {
                    IO.println( "\n------ LISTA DE ALUNOS ------" );

                        if ( contadorAlunos == 0 ) {
                            IO.println( "Nenhum aluno cadastrado." );
                        }

                        for ( int i = 0; i < contadorAlunos; i++ ) {
                            IO.println( "\n       Aluno " + (i + 1) + ":" );
                            IO.println( "       Nome: " + nomesAlunos[i] );
                            IO.println( "       Número de Matrícula: " + numerosMatriculas[i] );
                            IO.println( "   -------------------------------" );
                        }
            }
    


            
    // ====== MÉTODO PRINCIPAL ======
    public static void main( String[] args ) {
        Scanner leitor = new Scanner(System.in);

            int capacidadeMaximaTurmas = 100;
                String[] nomesDisciplinas = new String[ capacidadeMaximaTurmas ];
                String[] semestres = new String[ capacidadeMaximaTurmas ];
                String[] nomesProfessores = new String[ capacidadeMaximaTurmas ];
                String[] codigosTurmas = new String[ capacidadeMaximaTurmas ];
                int contadorTurmas = 0;

            int capacidadeMaximaAlunos = 500;
                String[] nomesAlunos = new String[ capacidadeMaximaAlunos ];
                String[] numerosMatriculas = new String[ capacidadeMaximaAlunos ];
                int contadorAlunos = 0;

            int opcao = 0;
                while ( opcao != 5 ) {
                    IO.println( "\n ====== MENU ======" );
                    IO.println( "   1. Criar turma" );
                    IO.println( "   2. Listar turmas" );
                    IO.println( "   3. Adicionar aluno(a) em uma turma" );
                    IO.println( "   4. Listar alunos de uma turma" );
                    IO.println( "   5. Sair" );
                    IO.print( "     \n Escolha uma opção: " );
                        opcao = Integer.parseInt( leitor.nextLine() );

                    switch ( opcao ) {
                        case 1:
                            contadorTurmas = criarTurma( leitor, nomesDisciplinas, semestres, nomesProfessores, codigosTurmas, contadorTurmas );
                            break;
                        case 2:
                            listarTurmas( nomesDisciplinas, semestres, nomesProfessores, codigosTurmas, contadorTurmas );
                            break;
                        case 3:
                            contadorAlunos = adicionarAluno( leitor, contadorTurmas, nomesAlunos, numerosMatriculas, contadorAlunos );
                            break;
                        case 4:
                            listarAlunos(nomesAlunos, numerosMatriculas, contadorAlunos);
                            break;
                        case 5:
                            IO.println( "\nSaindo do sistema. Até mais!" );
                            break;
                        default:
                            IO.println( "\nOpção inválida. Tente novamente." );
                    }
                }
    }

}