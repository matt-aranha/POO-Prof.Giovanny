/**
 * ENUNCIADO: Considere o jogo clássico Pong (https://www.ponggame.org/). Tendo como contexto este jogo, defina uma classe para modelar as raquetes.
 * De forma similar à bola, as raquetes têm um método que implementa como se comporta a raquete quando se passa um tempo t. Também deverá ter outros métodos. Defina-os.
 * 
 * @author Mateus Aranha (github.com/matt-aranha) 
 * @version 20/10/2025
 */

import java.awt.Rectangle;

public class Raquete {
    // --- ATRIBUTOS ---
    private double x, y;
    private double velY;                // px por segundo (0 = parada, > 0 = pra cima, < 0 = pra baixo)
    private double velMovimento;        // px por segundo
    private int largura, altura;

    
    // Construtor
    public Raquete() {
        this.x = x;
        this.y = 0;
        this.velY = 0;                  // começa parada
        this.velMovimento = 50;         // px por segundo (valor hipotético, só testando pra ver...)
        this.largura = 25;              // px (valor hipotético)
        this.altura = 150;              // px (valor hipotético)
    }

  
    // --- MÉTODOS ---
    public void atualizar(double t, int alturaTela) {
        y += velY * t;
        
        if ( y < 0) {                               // impede que saia por cima da tela
            y = 0;
            velY = 0;
        }
        
        if ( y + altura > alturaTela) {            // impede que saia por baixo da tela
            y = alturaTela - altura;
            velY = 0;
        }
    }
    
        // controles:
    public void moverParaCima() {
        this.velY = this.velMovimento;
    }
    public void moverParaBaixo() {
        this.velY = -this.velMovimento;
    }
    public void parar() {
        this.velY = 0;
    }
        
        // gets básicos:
    public Rectangle getLimites() {
        return new Rectangle((int)x, (int)y, largura, altura);        // retorna um retangulo que mostra os atributos da raquete (mesmo método da classe da bola)
    }
    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }
    public int getLargura() {
        return this.largura;
    }
    public int getAltura(){
        return this.altura;
    }
}