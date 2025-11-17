/**
 * ENUNCIADO:
 * A notação polaca reversa (NPR) ou posfixa é uma forma alternativa de escrever expressões aritméticas e lógicas sem a necessidade de usar parênteses. Nesta notação, os operadores seguem os
 * operandos, assim, por exemplo, ao invés de 2+3, escreve-se 2 3 +. Como outro exemplo mais significativo temos que   (2+3)*(8-5),    escrita em NPR é:    2 3 + 8 5 - *
 *          ( Vejam https://en.wikipedia.org/wiki/Reverse_Polish_notation para mais exemplos e detalhes )
 * 
 * As calculadoras Hewlett Packard (HP) popularizaram a NPR na área das engenharias.
 * A avaliação de expressões em NPR pode ser realizada usando uma pilha, realizando as seguintes:
 *          Cada vez que encontra um número, este é empilhado.
 *          Cada vez que encontra um operador binário, desempilham-se os dois elementos no topo da pilha, se realiza a operação com estes dois números como operandos e o resultado é colocado de volta na pilha.
 * 
 * No final, a pilha fica com o resultado como único valor nela.
 * 
 * Defina uma classe CalculadoraNPR que tenha os seguintes métodos:
 *          Inserir um número na pilha.
 *          Para cada operador, um método que realize a correspondente operação. Assim, por exemplo, deverá ter um método soma() que desempilha dois elementos, soma-os e o resultado é colocado de volta na pilha.
 *          Retornar um resultado. Este método verifica se há somente um elemento na pilha e então retorna este valor.  
 * 
 * 
 * @author Mateus Aranha (github.com/matt-aranha) 
 * @version (17/11/2025)
 */



public class CalculadoraNPR {

    // ====== SUB-CLASSE: ESTRUTURA DA PILHA (usando double) ======
    public static class PilhaDouble {
            // --- Atributos ---
            private double[] elementos;
            private int topo;
            private int capacidade;


            // --- Construtor ---
            public PilhaDouble( int capacidade ) {
                this.capacidade = capacidade;
                this.elementos = new double[ capacidade ];
                this.topo = -1;
            }

            
            // --- Métodos ---
            public void empilhar( double valor ) {
                if ( topo < capacidade - 1 ) {
                    topo++;
                    elementos[ topo ] = valor;

                } else {
                    IO.println( "Erro: Pilha cheia!" );
                }
            }

            public double desempilhar() {
                if ( topo != -1 ) {
                    double valor = elementos[ topo ];
                    topo--;
                    return valor;

                } else {
                    IO.println( "Erro: Pilha vazia!" );
                    return 0.0;     // Retorno de segurança
                }
            }

            public int getQuantidadeElementos() {
                return topo + 1;
            }
    }


    // =================================================================================


    // ====== ATRIBUTOS ======
    private PilhaDouble pilha;


    // ====== CONSTRUTOR ======
    public CalculadoraNPR() {
        this.pilha = new PilhaDouble( 100 );
    }


    // ====== MÉTODOS ======
        // --- ADICIONAR NÚMERO NA PILHA ---
        public void inserirNumero( double numero ) {
            pilha.empilhar( numero );
            IO.println( "Entrada: " + numero );
        }

        // --- OPERAÇÕES ARITMÉTICAS ---
        public void somar() {                       // Retira os dois do topo, soma e devolve para o topo
            double b = pilha.desempilhar();
            double a = pilha.desempilhar();
            double resultado = a + b;

            pilha.empilhar( resultado );
            IO.println( "Operação: " + a + " + " + b + " = " + resultado );
        }

        public void subtrair() {                    // Retira os dois do topo, subtrai e devolve para o topo (o primeiro a sair [b] é o subtraendo, o segundo [a] é o aditivo)
            double b = pilha.desempilhar();
            double a = pilha.desempilhar();
            double resultado = a - b;

            pilha.empilhar( resultado );
            IO.println( "Operação: " + a + " - " + b + " = " + resultado );
        }

        public void multiplicar() {                 // Retira os dois do topo, multiplica e devolve para o topo
            double b = pilha.desempilhar();
            double a = pilha.desempilhar();
            double resultado = a * b;

            pilha.empilhar( resultado );
            IO.println ( "Operação: " + a + " * " + b + " = " + resultado );
        }

        public void dividir() {                     // Retira os dois do topo, divide e devolve para o topo (o primeiro a sair [b] é o divisor, o segundo [a] é o dividendo)
            double b = pilha.desempilhar(); // Divisor
            double a = pilha.desempilhar(); // Dividendo
                if ( b == 0 ) {
                    IO.println( "Erro: Divisão por zero." );
                    return;
                }
            double resultado = a / b;

            pilha.empilhar( resultado );
            IO.println( "Operação: " + a + " / " + b + " = " + resultado );
        }

        // --- OBTER RESULTADO FINAL ---
        public double obterResultado() {
            if ( pilha.getQuantidadeElementos() == 1 ) {
                return pilha.desempilhar();

            } else {
                IO.println( "Erro: A expressão está incompleta ou incorreta. Sobraram números na pilha." );
                return Double.NaN;          // Retorna "Not a Number" indicando erro
            }
        }



    // ====== MÉTODO MAIN PARA TESTE ======
    public static void main( String[] args ) {
        CalculadoraNPR calc = new CalculadoraNPR();

        IO.println( "Calculando: (2 + 3) * (8 - 5)" );
        IO.println( "Em NPR: 2 3 + 8 5 - * \n" );

        // Passo a passo da expressão: 2 3 + 8 5 - *
        calc.inserirNumero( 2 );
        calc.inserirNumero( 3 );
        calc.somar();          // Soma 2 e 3 -> Pilha tem [5]

        calc.inserirNumero( 8 );
        calc.inserirNumero( 5 );
        calc.subtrair();       // Subtrai 8 e 5 -> Pilha tem [5, 3]

        calc.multiplicar();    // Multiplica 5 e 3 -> Pilha tem [15]

        double resultadoFinal = calc.obterResultado();
        IO.println( "\n--------------------------" );
        IO.println( "Resultado Final: " + resultadoFinal ); // Deve exibir 15
    }
}