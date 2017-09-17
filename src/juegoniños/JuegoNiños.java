/*
En el parque de un barrio de Bogotá hay un nuevo juego para que los niños aprendan a contar. Consiste en una regla gigante con marcas entre 0 y N. El juego de los niños consiste en moverse paso a paso sobre las marcas de la regla. Ellos mantienen una misma dirección de desplazamiento a menos que lleguen a uno de los extremos de la regla. En ese caso, ellos cambian de dirección. 
Se le ha solicitado desarrollar un programa en Java para simular el juego. El programa recibe como datos la cantidad de marcas en la regla, la posición y dirección de desplazamiento iniciales y cuántos pasos dará el niño en el juego. Así, los datos que se ingresan son:

•	N es la marca más alta de la regla
•	P es la posición inicial del niño (0 < P < N) 
•	d la dirección con la que el niño empieza su desplazamiento, d = 1 indica que el niño se desplaza inicialmente a la derecha, d = −1 indica que el niño se desplaza inicialmente a la izquierda. 
•	M es el número de pasos que da el niño después del momento inicial. 

Su programa debe reportar por pantalla la posición del niño después de haber dado M pasos. 
Ejemplo:
Datos leídos: N=5, P=4, d=1, M=4           
Reporte en pantalla: Al finalizar, el niño estará en la posición 2
 */
package juegoniños;

import javax.swing.JOptionPane;

public class JuegoNiños {

    private static String Solicita(String m) {
        return JOptionPane.showInputDialog(m);
    }

    private static void Muestra(String m) {
        JOptionPane.showMessageDialog(null, m);
    }

    private static String Direccion(int d) {
        if (d == 1) {
            return "Adelante";
        } else {
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

        Muestra("El niño comienza en la posición: " + P + "\nCamina hacia " + Direccion(d));
        while (M > 0) {
            if (d == 1) {
                if (P == N) {
                    //Cambia de dirección: Ahora se devuelve
                    d = -1;
                    P -= 1;
                } else {
                    //Sigue hacia adelante
                    P += 1;
                }
            } else {
                if (P == 0) {
                    //Cambia de dirección: Ahora sigue hacia adelante
                    d = 1;
                    P += 1;
                } else {
                    //Sigue hacia atrás
                    P -= 1;
                }
            }

            M -= 1;
            Muestra("El niño ahora está en la posición: " + P + "\nCamina hacia " + Direccion(d));
        }

        Muestra("Al finalizar, el niño estará en la posición " + P);

    }

}
