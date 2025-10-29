/**
 * ENUNCIADO: Defina dois métodos, um para transformar graus Fahrenheit para centígrados e outro que faz o inverso.
 * Escreva um programa que permita fazer ambas transformações.
 * O usuário deverá escolher qual transformação deve ser feita.
 * 
 * 
 * @author Mateus Aranha (github.com/matt-aranha) 
 * @version (28/10/2025)
 */

import java.util.Scanner;

public class Graus {
   
    // --- MÉTODOS DE CONVERSÂO --- 
    public static double celciusParaFahrenheit(  double celcius ) {
        return ( ( celcius * 1.8 ) + 32 );
    }
    public static double fahrenheitParaCelcius( double fahrenheit ) {
        return ( ( fahrenheit - 32 ) * 5.0 / 9.0 );
    }


    // --- MÉTODO PRINCIPAL ---
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
            
            IO.println( "--- CONVERSOR DE TEMPERATURAS ---" );
            IO.println( "   Digite '1' caso queira transformar de °C para °F" );
            IO.println( "   Digite '2' caso queira trasnformar de °F para °C" );

                int entrada;

                while ( true ) {
                    if ( leitor.hasNextInt() ) { entrada = leitor.nextInt();    // lê a entrada
                        if ( entrada == 1 || entrada == 2 ) { break; }          // sai do loop
                            else {
                                IO.println( "Entrada inválida. Por favor, selecione novamente" );
                                leitor.next();
                            }
                    }
                }    

                    

                    if (entrada == 1) {
                        IO.println( "Certo. Digite a temperatura em °C (apenas números)" );

                        while (!leitor.hasNextDouble()) {
                            IO.println( "Entrada inválida. Por favor, digite a a temperatura em °C (apenas números)" );
                            leitor.next();
                        }
                            double celcius = leitor.nextDouble();

                            double fahrenheit = celciusParaFahrenheit(celcius);
                            IO.println( "A temperatura de " + celcius + " °C corresponde à: " + fahrenheit + " °F" );
                    }

                    else {
                        IO.println( "Certo. Digite a temperatura em °F (apenas números)" );
                        
                        while (!leitor.hasNextDouble()) {
                            IO.println( "Entrada inválida. Por favor, digite a a temperatura em °F (apenas números)" );
                            leitor.next();
                        }
                            double fahrenheit = leitor.nextDouble();

                            double celcius = fahrenheitParaCelcius(fahrenheit);
                            IO.println( "A temperatura de " + fahrenheit + " °F corresponde à: " + celcius + " °C" );
                    }
                    
        leitor.close();
        
    }
}