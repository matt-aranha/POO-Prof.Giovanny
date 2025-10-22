/**
 * ENUNCIADO: Considere o jogo clássico Pong (https://www.ponggame.org/). Tendo como contexto este jogo, defina uma classe para modelar a bola do Pong. Para a modelagem da dinâmica da bola,
 * a classe deverá ter um método que tem como argumento um tempo t. Este método deverá implementar a mudança do estado da bola quando se passar o tempo t. Certamente, a bola deverá ter também
 * outros métodos. Defina alguns.
 * 
 * @author Mateus Aranha (github.com/matt-aranha) 
 * @version 20/10/2025
 */

import java.awt.Rectangle;

public class Bolinha {
    // --- ATRIBUTOS ---
    private double x, y;               // posição atual
    private double velX, velY;         // velocidades
    private int largura, altura;       // medidas (px)

    
    // Construtor   [inicializa variáveis de instância (os atributos)]
    public Bolinha() {
        this.x = 0;
        this.y = 0;
        this.velX = 25;                // pixels por segundo (valor hipotético, nem ideia se é alto ou baixo demais hahaha)
        this.velY = 0;                 // 0 pois a bola iniciará apenas se movendo para um dos lados (+ para direita, - para esquerda)
        this.largura = 50;             // pixels
        this.altura = this.largura;
        
        resetar();
    }

    
    // --- MÉTODOS ---
    public void atualizar(double t) {
        x += velX * t;
        y += velY * t;
    }
    
        // gets básicos:
    public Rectangle getLimites() {
        return new Rectangle((int)x, (int)y, largura, altura);        // converte X e Y de 'double' para 'int' e retorna um retangulo que mostra os atributos da bola =D
    }
    public double getX () {        
        return x;
    }
    public double getY() {
        return y;
    }
    public int getLargura() {
        return this.largura;
    }
    public int getAltura(){
        return this.altura;
    }
    
        // métodos para inverter o sentido de X e Y:
    public void inverterVelX() {
        this.velX = -this.velX;
    }
    public void inverterVelY() {
        this.velY = -this.velY;
    }
    
        // volta a bolinha pra posição inicial:
    public void resetar() {
        this.x = 0;
        this.y = 0;
        inverterVelX();
    }
    
        // checar se houve colisão entre a raquete e a bola. se tiver tido, acelera a bolinha e inverte o sentido do movimento no eixo x:
    public void colisaoRaquete(Raquete raquete) {
        if ( this.getLimites().intersects(raquete.getLimites()) ) {
            inverterVelX();         // muda o sentido do movimento no eixo x
            this.velX *= 1.1;       // aumenta a velocidade em 10%
            
            if( velX > 0) {
                x = raquete.getX() + raquete.getLargura();      // se agora tá indo para a direita, significa que bateu na raquete da esquerda
            } else {
                x = raquete.getX() - this.largura;              // se agora tá indo para a esquerda, significa que bateu na raquete da direita
            }
        }
    }
}