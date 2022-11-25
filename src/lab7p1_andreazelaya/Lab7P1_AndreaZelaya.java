package lab7p1_andreazelaya;

import java.util.Scanner;
import java.util.Random;

public class Lab7P1_AndreaZelaya {

    static Scanner in = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        int opcion = menu();
        while (opcion != 4) {

            switch (opcion) {
                case 1: {
                    int[][] matrix = lectura();

                    System.out.println("La matriz rotada es: \n" + imprimir(potrait(matrix)));
                    break;
                }

                case 2: {

                    int[][] matrix = lectura();

                    System.out.println("El numero generado es: " + numMagico(matrix));

                    break;
                }

                case 3: {
                    System.out.println("Ingrese la primera cadena: ");
                    String Ocadena1 = in.next().toLowerCase();
                    String cadena1 = guion(Ocadena1);

                    System.out.println("Ingrese la segunda cadena; ");
                    String Ocadena2 = in.next().toLowerCase();
                    String cadena2 = guion(Ocadena2);

                    System.out.println(subsec(cadena1, cadena2));
                    break;
                }
            }

            opcion = menu();
        }
    }

    public static int menu() {
        int opcion;

        System.out.println("MENU");
        System.out.println("1. Potrait");
        System.out.println("2. Numero mágico");
        System.out.println("3. Subsecuencia");
        System.out.println("4. Salida");
        System.out.print("Ingrese una opcion: ");
        opcion = in.nextInt();

        return opcion;
    }

    public static int[][] lectura() {
        System.out.println("Ingrese M: ");
        int M = in.nextInt();
        System.out.println("Ingrese N: ");
        int N = in.nextInt();
        int[][] matrix = new int[M][N];
        if (M == N) {
            System.out.println("Error. La matriz no puede ser cuadrada.");
        } else {

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = random.nextInt(10);
                }
            }
            System.out.println("La matriz generada es: ");
            System.out.println(imprimir(matrix));
        }
        return matrix;
    }

    public static String imprimir(int[][] numeros) {
        String cadena = "";

        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                cadena += "[" + numeros[i][j] + "]" + " ";
            }
            cadena += "\n";
        }
        return cadena;
    }

    public static int numMagico(int[][] matrix) {
        int resp = 0, op1 = 0, op2 = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (i == 0 || j == 0 || i == matrix.length - 1 || j == matrix[0].length - 1) {
                    op1 += matrix[i][j];
                } else {

                    op2 *= matrix[i][j];
                }

            }

        }

        System.out.println("Op. 1: " + op1);
        System.out.println("Op. 2: " + op2);

        resp = op1 + op2;

        return resp;
    }

    public static int[][] potrait(int[][] matrix) {
        int[][] potraitMatrix = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                potraitMatrix[j][i] = matrix[matrix.length - i - 1][j];
            }
        }

        return potraitMatrix;
    }

    public static String guion(String cadena) {
        String newCadena = "-";

        for (int i = 0; i < cadena.length(); i++) {
            char chara = cadena.charAt(i);

            newCadena += chara;
        }

        return newCadena;
    }

    public static int subsec(String cadena1, String cadena2) {
        int rows = cadena1.length();
        int columns = cadena2.length();

        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                char char1 = cadena1.charAt(i);
                char char2 = cadena2.charAt(j);

                if (char1 == '-' || char2 == '-') {
                    matrix[i][j] = 0;
                } else if (char1 != char2) {
                    matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);

                } else if (char1 == char2) {
                    matrix[i][j] = 1 + matrix[i - 1][j - 1];
                }

            }
        }
        System.out.println(imprimir(matrix));
        return matrix[matrix.length - 1][matrix[0].length - 1];
    }
}
