/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion_bañeras;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author VICTOR SERRANO
 */
public class Simulacion_Bañeras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de Corridas"));
        double resultado = 0, suma = 0;
        int excedio = 0, noexcedio = 0;
        double precioA = 0, precioAnual = 0, Xn = 1;
        DecimalFormat formato = new DecimalFormat("0.00000");
        System.out.println("+---------------+-----+-------------------------+-----------------------+-----------------------+---------+");
        System.out.println("| Años      |Tina |      N. Aleatorio       |    Peso de la Tina    |     Peso acumulado    |Excedio? |");
        System.out.println("+---------------+-----+-------------------------+-----------------------+-----------------------+---------+");
        for (int i = 0; i < numero; i++) {
            precioA = 0;
            for (int j = 0; j < 260; j++) {
                suma = 0;
                resultado = 0;
                for (int k = 0; k < 5; k++) {
                    Xn = (69069 * Xn) % (Math.pow(2, 37));
                    double random = Xn / (Math.pow(2, 37));
                    if (random <= 0.5) {
                        resultado = Math.sqrt(800 * random) + 190;

                    } else {
                        resultado = 230 - Math.sqrt((1 - random) * 800);
                    }
                    suma = suma + resultado;

                    if (k == 4) {
                        if (suma > 1000) {
                            precioA = precioA + 200;
                            System.out.println("|\t \t|  " + (k + 1) + "  |\t\t" + formato.format(random) + "\t\t|\t" + formato.format(resultado) + "\t|\t" + formato.format(suma) + "\t|    " + "SI" + "   |");
                            excedio++;

                        } else {
                            System.out.println("|\t \t|  " + (k + 1) + "  |\t\t" + formato.format(random) + "\t\t|\t" + formato.format(resultado) + "\t|\t" + formato.format(suma) + "\t|    " + "NO" + "   |");
                            noexcedio++;
                        }
                        if (j==259) {
                            System.out.println("Precio Adicional Anual: "+precioA);
                        }
                        System.out.println("+---------------+-----+-------------------------+-----------------------+-----------------------+---------+");
                    } else {
                        if (k == 0) {
                            System.out.println("|\t" + (i + 1) + "\t|  " + (k + 1) + "  |\t\t" + formato.format(random) + "\t\t|\t" + formato.format(resultado) + "\t|\t" + formato.format(suma) + "\t|    " + "-" + "    |");
                        } else {
                            System.out.println("|\t \t|  " + (k + 1) + "  |\t\t" + formato.format(random) + "\t\t|\t" + formato.format(resultado) + "\t|\t" + formato.format(suma) + "\t|    " + "-" + "    |");
                        }

                    }
                    resultado = 0;
                }
            }
            precioAnual = precioAnual + precioA;
        }
        System.out.println("Excedio el peso: " + excedio + "\nNo excedio el peso: " + noexcedio);
        System.out.println("Precio Anual promedio en " + numero + " años: " + (precioAnual / numero));

    }

}
