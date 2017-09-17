/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoniños;

import javax.swing.JOptionPane;

/**
 *
 * @author Kevin
 */
public class JuegoNiños {

    private static String Solicita(String m) {
        return JOptionPane.showInputDialog(m);
    }

    private static void Muestra(String m) {
        JOptionPane.showMessageDialog(null, m);
    }

    private static String Direccion(int d) {
        if(d==1)
        {
            return "Adelante";
        }else
        {
            return "Atrás";
        }
    }

    public static void main(String[] args) {
        Muestra("Bienvenido");
        int N = 0;// Marca más alta de la regla
        int P = 0;// posición inicial del niño (0 < P < N) 
        int d = 0;//la dirección con la que el niño empieza su desplazamiento, d = 1 indica que el niño se desplaza inicialmente a la derecha, d = −1 indica que el niño se desplaza inicialmente a la izquierda. 
        int M = 0;//es el número de pasos que da el niño después del momento inicial. 
        do {
            N = Integer.parseInt(Solicita("Digite la marca más alta de la regla"));
            if (N <= 0) {
                Muestra("Error. Por favor ingrese un valor valido");
            }
        } while (N <= 0);
        do {
            P = Integer.parseInt(Solicita("Digite la posición inicial del niño"));
            if (P < 0 && P > N) {
                Muestra("Error. Por favor ingrese un valor valido");
            }
        } while (P < 0 && P > N);
        do {
            d = Integer.parseInt(Solicita("Digite la dirección con la que el niño empieza el desplazamiento\n\n1. Derecha\n-1. Izquierda"));
            if (d != -1 && d != 1) {
                Muestra("Error. Por favor ingrese un valor valido");
            }
        } while (d != -1 && d != 1);
        do {
            M = Integer.parseInt(Solicita("Digite el número de pasos que da el niño despues del momento inicial"));
            if (M < 0) {
                Muestra("Error. Por favor ingrese un valor valido");
            }
        } while (M < 0);
        
        Muestra("El niño comienza en la posición: "+P+"\nCamina hacia "+Direccion(d));
        while (M > 0) {
            if (d == 1) {
                if (P == N) {
                    //Cambia de dirección: Ahora se devuelve
                    d=-1;
                    P -= 1;
                } else {
                    //Sigue hacia adelante
                    P += 1;
                }
            }else
            {
                if (P == 0) {
                    //Cambia de dirección: Ahora sigue hacia adelante
                    d=1;
                    P += 1;
                } else {
                    //Sigue hacia atrás
                    P -= 1;
                }
            }

            M -= 1;
            //Muestra(P + " " + d + " " + M);
            Muestra("El niño ahora está en la posición: "+P+"\nCamina hacia "+Direccion(d));
        }

        Muestra("Al finalizar, el niño estará en la posición " + P);

    }

}
