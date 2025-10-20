/**
 * ENUNCIADO: Implemente a classe RelogioDigital discutida em sala de aula.
 * 
 * @author (Mateus Aranha) 
 * @version (18/10/2025)
 */

public class RelogioDigital {
    // --- ATRIBUTOS ---
    private int horas;
    private int minutos;
    private boolean ligado;

    // Construtor
    public RelogioDigital() {
        this.horas = 0;
        this.minutos = 0;
        this.ligado = false;
    }

    
    // --- MÉTODOS ---
    private void tick() {
        this.minutos += 1;       // atalho que significa: minutos = minutos + 1
        
        if ( minutos >= 60 ) {
            this.minutos = 0;
            this.horas += 1;
        }
        
        if ( horas >= 24 ) {
            this.horas = 0;
        }
    }
    
    public String verHorario() {
        return String.format( "%02d:%02d", this.horas, this.minutos );
    }
    
    public void ligarDesligar() {
        this.ligado = !this.ligado;
        
        if ( this.ligado == true ) {
            System.out.println( "O relógio foi ligado!" );
            new Thread( () -> {
                // Loop do relógio:
                while ( this.ligado == true ) {
                    try {
                        System.out.println( verHorario() );
                        Thread.sleep(100);                  // a cada 6 segundos, a simulação aumenta 1 hora.
                        this.tick();
                    
                    } catch ( InterruptedException e ) {
                        System.out.println("Thread do relógio interrompida.");
                    }
                }
            }).start();     // começa a Thread
        } else {
            // se o relógio for desligado
            System.out.println("O relógio foi desligado!");
        }
    }
}













