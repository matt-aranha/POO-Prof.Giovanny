
/**
 * ENUNCIADO: Em escadas ou corredores longos frequentemente se usam dois interruptores de tal forma que ambos servem para ligar e desligar uma mesma lâmpada.
 * A forma em que os interruptores se conectam entre eles e a lâmpada é conhecida com o nome de circuito three way ou interruptores paralelos.
 * Defina uma classe que modele interruptores paralelos. A classe deverá incluir dois métodos, um para ligar/desligar o primeiro interruptor e outro para o segundo.
 * 
 * @author (Mateus Aranha) 
 * @version (18/10/2025)
 */

public class InterruptoresThreeWay {
    // --- ATRIBUTOS ---
    private boolean lampada;        

    // Construtor
    public InterruptoresThreeWay() {
       lampada = false;     // desligada
    }

    
    // --- MÉTODOS ---
    public void acionarInterruptor1() {
        this.lampada = !this.lampada;
        if (this.lampada == false) {
            System.out.println("O Interruptor 1 foi acionado! a Lâmpada está APAGADA.");
        } else{
            System.out.println("O Interruptor 1 foi acionado! a Lâmpada está ACESSA.");
        }
    }
    
    public void acionarInterruptor2() {
        this.lampada = !this.lampada;
        if (this.lampada == false) {
            System.out.println("O Interruptor 2 foi acionado! a Lâmpada está APAGADA.");
        } else{
            System.out.println("O Interruptor 2 foi acionado! a Lâmpada está ACESSA.");
        }
    }
}