package e2;

import java.awt.print.PrinterJob;
import java.util.Arrays;

public class Slopes {

    public static int downTheSlope(char [][] slopeMap , int right , int down) {
        int contador = 0;
        int largo = slopeMap.length, ancho = slopeMap[0].length;
        int posFinalEsquiadorI = 0, posFinalEsquiadorJ = 0;

        //EXCEPCIONES
        //+++++++++++++++++++++++++++++++

        for (int i = 0; i < largo; ++i) {
            if (slopeMap[i].length != largo) throw new IllegalArgumentException();
        }

        for (int i = 0; i < largo; ++i) {
            for (int j = 0; j < ancho; ++j) {
                if (slopeMap[i][j] != '#' && slopeMap[i][j] != '.') throw new IllegalArgumentException();
            }
        }

        if (right >= ancho || right < 1) throw new IllegalArgumentException();
        if (down >= largo || down < 1) throw new IllegalArgumentException();
        //+++++++++++++++++++++++++++++++

        int counterSalto = 1;
        for (int i = 0; i < largo; ++i) {
            System.out.print("\n\n");
            for (int j = 0; j < ancho; ++j) {
                if (i == posFinalEsquiadorI-down+counterSalto && j == posFinalEsquiadorJ && counterSalto < down) {
                    System.out.printf("\t\t(%s)", slopeMap[i][j]);
                    if (slopeMap[i][j] == '#') contador++;
                    counterSalto++;
                }
                else if (i == posFinalEsquiadorI && ancho - posFinalEsquiadorJ <= right && j <= right - (ancho - posFinalEsquiadorJ)) {
                    System.out.printf("\t\t(%s)", slopeMap[i][j]);
                    //System.out.print(posFinalEsquiadorI);
                    if (slopeMap[i][j] == '#') contador++;

                }
                else if (j == posFinalEsquiadorJ && i == posFinalEsquiadorI) {
                    counterSalto = 1;

                    System.out.printf("\t\t[%s]", slopeMap[i][j]);

                    if (slopeMap[i][j] == '#') contador++;

                    posFinalEsquiadorI += down;

                    if (posFinalEsquiadorJ + right > ancho)
                        posFinalEsquiadorJ = (posFinalEsquiadorJ + right) % ancho;
                    else
                        posFinalEsquiadorJ += right;
                }
                else if (i == posFinalEsquiadorI-down && ancho - (posFinalEsquiadorJ - right + ancho) < right && ancho - (posFinalEsquiadorJ - right + ancho) > 0  && j > ancho - (posFinalEsquiadorJ - right + ancho)) {
                    System.out.printf("\t\t(%s)", slopeMap[i][j]);
                    if (slopeMap[i][j] == '#') contador++;

                }
                else if (j <= posFinalEsquiadorJ && i == posFinalEsquiadorI-down) {
                    System.out.printf("\t\t(%s)", slopeMap[i][j]);
                    if (slopeMap[i][j] == '#') contador++;

                }
                else {
                    System.out.printf("\t\t%s", slopeMap[i][j]);
                }
            }
        }
        return contador;
    }

    public static int jumpTheSlope(char [][] slopeMap , int right , int down) {
        int contador = 0;
        int largo = slopeMap.length, ancho = slopeMap[0].length;
        int posFinalEsquiadorI = 0, posFinalEsquiadorJ = 0;

        //EXCEPCIONES
        //+++++++++++++++++++++++++++++++

        for (int i = 0; i < largo; ++i) {
            if (slopeMap[i].length != largo) throw new IllegalArgumentException();
        }

        for (int i = 0; i < largo; ++i) {
            for (int j = 0; j < ancho; ++j) {
                if (slopeMap[i][j] != '#' && slopeMap[i][j] != '.') throw new IllegalArgumentException();
            }
        }

        if (right >= ancho || right < 1) throw new IllegalArgumentException();
        if (down >= largo || down < 1) throw new IllegalArgumentException();
        //+++++++++++++++++++++++++++++++S

        for (int i = 0; i < largo; ++i) {
            //System.out.print("\n\n");
            for (int j = 0; j < ancho; ++j) {
                if (j == posFinalEsquiadorJ && i == posFinalEsquiadorI) {
                    //System.out.printf("\t\t[%s]", slopeMap[i][j]);

                    if (slopeMap[i][j] == '#') contador++;

                    if (i < largo) posFinalEsquiadorI += down;

                    if (posFinalEsquiadorJ + right > ancho)
                        posFinalEsquiadorJ = (posFinalEsquiadorJ + right) % ancho;
                    else
                        posFinalEsquiadorJ += right;
                }
                else {
                    //System.out.printf("\t\t%s", slopeMap[i][j]);
                }
            }
        }
        return contador;
    }

    public static void main(String[] args) {
        int right = 1, down = 2;
        char[][] slopeMap = new char[][]{
                {'.', '.', '#', '#', '.', '.', '.', '.', '.', '.', '.'},
                {'#', '.', '.', '.', '#', '.', '.', '.', '#', '.', '.'},
                {'.', '#', '.', '.', '.', '.', '#', '.', '.', '#', '.'},
                {'.', '.', '#', '.', '#', '.', '.', '.', '#', '.', '#'},
                {'.', '#', '.', '.', '.', '#', '#', '.', '.', '#', '.'},
                {'.', '.', '#', '.', '#', '#', '.', '.', '.', '.', '.'},
                {'.', '#', '.', '#', '.', '#', '.', '.', '.', '.', '#'},
                {'.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
                {'#', '.', '#', '#', '.', '.', '.', '#', '.', '.', '.'},
                {'#', '.', '.', '.', '#', '#', '.', '.', '.', '.', '#'},
                {'.', '#', '.', '.', '#', '.', '.', '.', '#', '.', '#'}};


        System.out.println(downTheSlope(slopeMap,right, down));

    }
}
















































        /*
        for (int i = 0; i < largo; ++i) {
            System.out.print("\n\n");
            for (int j = 0; j < ancho; ++j) {
                if (i == posFinalEsquiadorI && ancho - posFinalEsquiadorJ <= right && j <= right - (ancho - posFinalEsquiadorJ)) {
                    System.out.printf("\t\t(%s)", slopeMap[i][j]);
                    if (slopeMap[i][j] == '#') contador++;

                }
                else if (j == posFinalEsquiadorJ && i == posFinalEsquiadorI) {
                    System.out.printf("\t\t[%s]", slopeMap[i][j]);

                    if (slopeMap[i][j] == '#') contador++;

                    posFinalEsquiadorI += down;

                    if (posFinalEsquiadorJ + right > ancho)
                        posFinalEsquiadorJ = (posFinalEsquiadorJ + right) % ancho;
                    else
                        posFinalEsquiadorJ += right;
                }
                else if (i == posFinalEsquiadorI-down && ancho - (posFinalEsquiadorJ - right + ancho) < right && ancho - (posFinalEsquiadorJ - right + ancho) > 0  && j > ancho - (posFinalEsquiadorJ - right + ancho)) {
                    System.out.printf("\t\t(%s)", slopeMap[i][j]);
                    if (slopeMap[i][j] == '#') contador++;

                }
                else if (j <= posFinalEsquiadorJ && i == posFinalEsquiadorI-down) {
                    System.out.printf("\t\t(%s)", slopeMap[i][j]);
                    if (slopeMap[i][j] == '#') contador++;

                }
                else {
                    System.out.printf("\t\t%s", slopeMap[i][j]);
                }
            }
        }
        return contador;
    }
    public static int jumpTheSlope(char [][] slopeMap , int right , int down) {
        int ancho = 11, largo = 11;
        int contador = 0;
        int posFinalEsquiadorJ = 0, posFinalEsquiadorI = 0;

        for (int i = 0; i < largo; ++i) {
            //System.out.print("\n\n");
            for (int j = 0; j < ancho; ++j) {
                if (j == posFinalEsquiadorJ && i == posFinalEsquiadorI) {
                    //System.out.printf("\t\t[%s]", slopeMap[i][j]);

                    if (slopeMap[i][j] == '#') contador++;

                    if (i < largo) posFinalEsquiadorI += down;

                    if (posFinalEsquiadorJ + right > ancho)
                        posFinalEsquiadorJ = (posFinalEsquiadorJ + right) % ancho;
                    else
                        posFinalEsquiadorJ += right;
                }
                else {
                    //System.out.printf("\t\t%s", slopeMap[i][j]);
                }
            }
        }
        return contador;
    }

    public static void main(String[] args) {
        int right = 1, down = 2;
        char[][] slopeMap = new char[][]{
                {'.', '.', '#', '#', '.', '.', '.', '.', '.', '.', '.'},
                {'#', '.', '.', '.', '#', '.', '.', '.', '#', '.', '.'},
                {'.', '#', '.', '.', '.', '.', '#', '.', '.', '#', '.'},
                {'.', '.', '#', '.', '#', '.', '.', '.', '#', '.', '#'},
                {'.', '#', '.', '.', '.', '#', '#', '.', '.', '#', '.'},
                {'.', '.', '#', '.', '#', '#', '.', '.', '.', '.', '.'},
                {'.', '#', '.', '#', '.', '#', '.', '.', '.', '.', '#'},
                {'.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
                {'#', '.', '#', '#', '.', '.', '.', '#', '.', '.', '.'},
                {'#', '.', '.', '.', '#', '#', '.', '.', '.', '.', '#'},
                {'.', '#', '.', '.', '#', '.', '.', '.', '#', '.', '#'}};


        System.out.println(downTheSlope(slopeMap,right, down));
        //System.out.println(jumpTheSlope(slopeMap,right, down));


         */

