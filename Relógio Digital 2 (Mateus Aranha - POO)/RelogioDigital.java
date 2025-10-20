/**
 * ENUNCIADO: Considere a classe RelogioDigital do exercício anterior.
 * Adicione um método que permita ajustar a hora (horas e minutos).
 * Altere a definição para considerar também que o relógio meça segundos.
 * Estenda a definição de tal forma que os relógios tenham alarme. Acrescente atributos e métodos necessários.
 * 
 * @author (Mateus Aranha) 
 * @version (18/10/2025)
 */

import java.awt.Toolkit;        // import do beep do alarme

public class RelogioDigital {
    // --- ATRIBUTOS ---
    private int horas;
    private int minutos;
    private int segundos;
    private boolean ligado;
    
    private int alarmeHoras;
    private int alarmeMinutos;
    private boolean alarmeLigado;

    // Construtor (estado inicial dos atributos)
    public RelogioDigital() {
        this.horas = 0;
        this.minutos = 0;
        this.segundos = 0;
        this.ligado = false;
        
        this.alarmeHoras = 0;
        this.alarmeMinutos = 0;
        this.alarmeLigado = false;
    }

    
    // --- MÉTODOS ---
    private void tick() {
        this.segundos += 1;       // atalho que significa: minutos = minutos + 1
        
        if ( segundos >= 60 ) {
            this.segundos = 0;
            this.minutos += 1;
        }
        
        if ( minutos >= 60 ) {
            this.minutos = 0;
            this.horas += 1;
        }
        
        if ( horas >= 24 ) {
            this.horas = 0;
        }
        
        somAlarme();
    }
    
    public String verHorario() {
        return String.format( "%02d:%02d:%02d", this.horas, this.minutos, this.segundos );
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
                        Thread.sleep(1000);                  // a cada 1 segundos, a simulação aumenta 1 segundo. (redundante, eu sei. mas decidi manter a anotação do exercício anterior para que seja mais fácil identificar onde mexer para alterar o tempo de simulação)
                        this.tick();
                    
                    } catch ( InterruptedException e ) {
                        System.out.println( "Thread do relógio interrompida." );
                    }
                }
            }).start();     // começa a Thread
            
        } else {
            // se o relógio for desligado
            System.out.println( "O relógio foi desligado!" );
        }
    }
    
    public void ajustarHorario( int hora, int minuto ) {
        if ( this.ligado == false ) {
            this.horas = hora;
            this.minutos = minuto;
            this.segundos = 0;
            System.out.println( "O horário foi definido para " + this.horas + ":" + this.minutos + ". Por favor, ligue o relógio novamente." );
            
        } else {
            System.out.println( "Por favor, primeiro desligue o rélogio para alterar o horário." );
        }
    }
    
    public void definirAlarme( int hora, int minuto ) {
        if ( hora >= 0  &&  hora < 24  &&  minuto >= 0  &&  minuto < 60 ) {
            this.alarmeHoras = hora;
            this.alarmeMinutos = minuto;
            this.alarmeLigado = true;
            System.out.println( "Alarme definido para " + String.format( "%02d:%02d", hora, minuto ) );
            
        } else {
            System.out.println( "Hora e/ou minuto inválido(s)." );
        }
    }
    
    private void somAlarme() {
        if ( this.alarmeLigado == true  &&  this.alarmeHoras == this.horas  &&  this.alarmeMinutos == this.minutos &&  this.segundos == 0 ) {
                Toolkit.getDefaultToolkit().beep();         // vai emitir um som
                System.out.println( "BEEP! BEEP! BEEP! BEEP! BEEP! BEEP!" );
        } else {}
    }
    
    public void desligarAlarme() {
        if ( this.alarmeLigado == true ) {
            this.alarmeLigado = false;
            System.out.println( "Alarme desligado!" );
            
        } else {
            System.out.println( "Não há alarmes definidos." );
        }
    }
}













