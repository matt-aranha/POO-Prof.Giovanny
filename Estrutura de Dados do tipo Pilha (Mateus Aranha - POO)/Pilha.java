/**
 * ENUNCIADO: Defina uma classe que implemente a estrutura de dados Pilha. Nesta estrutura, o último que entra é o primeiro em sair. As instâncias devem ter uma capacidade máxima.
 * Após atingir esta capacidade, nenhum empilhamento poderá ser feito. Antes de implementar em Java, descreva a classe com um diagrama.
 * 
 * @author Mateus Aranha (github.com/matt-aranha) 
 * @version (17/11/2025)
*/


public class Pilha {

    /**
     * Diagrama de classe:
     *      classe Pilha {
     *          - elementos : String[]
     *          - topo : int
     *          - capacidade : int
     *          + Pilha(tamanho : int)
     *          + empilhar(valor : String) : void
     *          + desempilhar() : String
     *          + estaCheia() : boolean
     *          + estaVazia() : boolean
     *          + verTopo() : String 
     *      }
    */


    // === ATRIBUTOS ===
    private String[] elementos;
    private int topo;
    private int capacidade;


    // === CONSTRUTOR ===
    public Pilha( int capacidade ) {
        this.capacidade = capacidade;
        this.elementos = new String[ capacidade ];
        this.topo = -1;                                 // -1 indica que a pilha está vazia (índice 0 ainda não foi usado).
    }


    // ====== MÉTODOS OPERACIONAIS ======
            // --- MÉTODOS PARA VERIFICAR O ESTADO DA PILHA ---
            public boolean estaVazia() {
                return ( topo == -1 );                    // Se o topo for -1, não tem nada na pilha.
            }

            public boolean estaCheia() {
                return ( topo == this.capacidade - 1 );   // Se o topo for igual ao último índice possível (tamanho - 1), a pilha está cheia.
            }


            // --- MÉTODO EMPILHAR (PUSH) ---
            public void empilhar( String valor ) {
                if ( estaCheia() ) {
                    System.out.println( "ERRO: A pilha está cheia! Não é possível adicionar \"" + valor + "\"." );

                } else {
                    topo++;                         // Sobe o ponteiro para a próxima posição livre
                    elementos[ topo ] = valor;      // Grava o valor
                    System.out.println( "Item empilhado: " + valor );
                }
            }

            // --- MÉTODO DESEMPILHAR (POP) ---
            public String desempilhar() {
                if ( estaVazia() ) {
                    System.out.println( "ERRO: A pilha está vazia! Nada para remover." );
                    return null;

                } else {
                    String elementoRemovido = elementos[ topo ];
                    elementos[ topo ] = null;       // Limpa a posição
                    topo--;                         // Desce o ponteiro para o item de baixo
                    return elementoRemovido;
                }
            }
            
            // --- MÉTODO PARA VER O TOPO (PEEK) ---
            public String verTopo() {
                if ( estaVazia() ) {
                    return null;

                } else return elementos[ topo ];
            }



    // ====== MÉTODO MAIN PARA TESTES ======
    public static void main( String[] args ) {
        // Criando uma pilha com capacidade para apenas 3 livros
        Pilha minhaPilha = new Pilha( 3 );

        IO.println( "----- EMPILHANDO -----" );
            minhaPilha.empilhar( "   Livro A" );
            minhaPilha.empilhar( "   Livro B" );
            minhaPilha.empilhar( "   Livro C" );
        
        // Tentando estourar a capacidade
        minhaPilha.empilhar("   Livro D" ); 

        IO.println( "\n --- DESEMPILHANDO (LIFO) ---" );
        // Deve sair o C, depois o B, depois o A
        while ( !minhaPilha.estaVazia() ) {
            String item = minhaPilha.desempilhar();
            IO.println( "Item removido: " + item );
        }

        // Tentando remover de pilha vazia
        minhaPilha.desempilhar();
    }
}