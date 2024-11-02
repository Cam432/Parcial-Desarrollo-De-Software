package Funcionalidad;

public class AlgoritmoADN {

    //Introducción de datos en la matriz

    static boolean matrizMutante (char[][] secuencia, String[] adn ){
        int lengthMatriz = adn.length;

        //Detección de errores
        for (int i=0; i<lengthMatriz; i++){
            char [] adnIngreso = adn [i].toCharArray();
            //Reviso que el tamaño de la matriz sea nxn con N mayor a 4
            if (adnIngreso.length!=lengthMatriz || lengthMatriz<4){
                return false;
            }
            //llama al metodo validarLetras para asegurarse que sean ACGT
            if (!validarLetras(adnIngreso)){
                return false;
            }

            secuencia[i] = adnIngreso;
        }

        return true;
    }

    // Metodo para validación de letras
    static boolean validarLetras (char [] adnIngreso){
        int tamano = adnIngreso.length;
        for (int i = 0; i < tamano; i++) {
            if(adnIngreso [i]!='A' && adnIngreso[i]!='T' && adnIngreso[i]!='C' && adnIngreso[i]!='G'){
                return false;
            }
        }
        return true;
    }

    // Mostrar matriz con ADN
    static void mostrarMatriz (char[][] arr, int largoMatriz){
        for (int i = 0; i < largoMatriz; i++) {
            for (int j = 0; j < largoMatriz; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    // Contar el número de secuencias horizontales
    static int secuenciaHorizontal (char[][] secuencia, int largoMatriz){
        int secuenciaHoriz =0;
        for (int i = 0; i < largoMatriz; i++) {
            for (int j = 0; j < largoMatriz; j++) {
                if (largoMatriz-j>=4) {
                    if (secuencia[i][j] == secuencia[i][j+ 1] &&
                            secuencia[i][j] == secuencia[i][j + 2] &&
                            secuencia[i][j] == secuencia[i][j + 3]
                    ) {
                        secuenciaHoriz++;
                        j = j + 3;
                        if (secuenciaHoriz >1){
                            return (secuenciaHoriz);
                        }
                    }
                }
            }
        }
        return secuenciaHoriz;
    }

    // Contar el número de secuencias verticales
    static int secuenciaVertical (char[][] secuencia, int largoMatriz){
        int secuenciaVert=0;
        for (int i = 0; i < largoMatriz; i++) {
            for (int j = 0; j < largoMatriz; j++) {
                if (largoMatriz -i>=4) {
                    if (secuencia[i][j] == secuencia[i+1][j] &&
                            secuencia[i][j] == secuencia[i+2][j] &&
                            secuencia[i][j] == secuencia[i+3][j]
                    ) {
                        secuenciaVert++;
                        j = j + 3;
                        if (secuenciaVert>1){
                            return (secuenciaVert);
                        }
                    }
                }
            }
        }
        return secuenciaVert;
    }

    // BUSCAR el número de secuencias de izquierda a derecha
    static int BuscarDiagIzqDer(char[][] secuencia, int largoMatriz, int i, int j, String indLimit){
        int contadorSecuencia =0;
        int limit=0;
        while (i<= largoMatriz -1 && j<= largoMatriz -1){
            if (indLimit == "J"){
                limit= largoMatriz -j;
            }else{
                limit= largoMatriz -i;
            }
            if (limit>=4) {
                if (secuencia[i][j] == secuencia[i+1][j+1] &&
                        secuencia[i][j] == secuencia[i+2][j+2] &&
                        secuencia[i][j] == secuencia[i+3][j+3]
                ) {
                    contadorSecuencia++;
                }
            }
            i++;
            j++;
        }
        return contadorSecuencia;
    }

    // Contar el número de secuencias de izquierda a derecha
    static int SecuenciaDiagIzqDer(char[][] secuencia, int largoMatriz){
        int i=0;
        int j=0;
        int contadorSecuencia=0;
        for (int indI = largoMatriz -1; indI >= 0; indI--) {
            //i=indI;
            if (indI==0){
                for (int indJ = 0; indJ < largoMatriz; indJ++) { // busca desde [0,n]
                    i=indI;
                    j=indJ;
                    int cont = BuscarDiagIzqDer(secuencia, largoMatriz, i, j, "J");
                    contadorSecuencia = contadorSecuencia + cont;
                }
            }else{
                i=indI;
                int cont = BuscarDiagIzqDer(secuencia, largoMatriz, i, j, "I");
                contadorSecuencia = contadorSecuencia + cont;
            }
            if (contadorSecuencia > 1){
                return contadorSecuencia;
            }
        }
        return contadorSecuencia;
    }

    // BUSCAR el número de secuencias de derecha a izquierda
    static int BuscarDiagDerIzq(char[][] secuencia, int largoMatriz, int i, int j, String indLimit){
        int contadorSecuencia =0;
        int limit=0;
        while (i<=largoMatriz-1 && j>=0){
            if (indLimit == "J"){
                limit=j;
            }else{
                limit=largoMatriz-i-1;
            }
            if (limit>=3) {
                if (secuencia[i][j] == secuencia[i+1][j-1] &&
                        secuencia[i][j] == secuencia[i+2][j-2] &&
                        secuencia[i][j] == secuencia[i+3][j-3]
                ) {
                    contadorSecuencia++;
                }
            }
            i++;
            j--;
        }
        return contadorSecuencia;
    }

    // Contar el número de secuencias de derecha a izquierda
    static int SecuenciaDiagDerIzq(char[][] secuencia, int largoMatriz){
        int i=0;
        int j=0;
        int contadorSecuencia=0;
        for (int indJ = 0; indJ <= largoMatriz -1; indJ++) {
            if (indJ== largoMatriz -1){
                for (int indI = 0; indI <= largoMatriz -1 ; indI++) { // busca desde [n,n]
                    i=indI;
                    j=indJ;
                    int cont = BuscarDiagDerIzq(secuencia, largoMatriz, i, j, "I");
                    contadorSecuencia = contadorSecuencia + cont;
                }
            }else{
                j=indJ;
                int cont = BuscarDiagDerIzq(secuencia, largoMatriz, i, j, "J");
                contadorSecuencia = contadorSecuencia + cont;
            }

            if (contadorSecuencia > 1){
                return contadorSecuencia;
            }

        }
        return contadorSecuencia;
    }

    // Acá utilizo el metodo isMutant

    static boolean isMutant(String[] dna){
        int largoMatriz = dna.length;
        char[][] arr = new char[largoMatriz][largoMatriz];
        if (!matrizMutante(arr,dna)){
            return false;
        }

        // Evalúa secuencia horizontal

        int totalSecuenceHoriz=0;
        totalSecuenceHoriz = secuenciaHorizontal(arr, largoMatriz);
        if (totalSecuenceHoriz>1){
            return true;
        }

        // Evalúa secuencia vertical y horizontal
        int totSecuenceVert=0;
        totSecuenceVert = secuenciaVertical(arr, largoMatriz);
        if ((totalSecuenceHoriz+totSecuenceVert)>1){
            return true;
        }

        // Evalúa secuencia diagonal de izquierda a derecha y horizontal + vertical
        int totalSecuenceDiagIzqDer=0;
        totalSecuenceDiagIzqDer = SecuenciaDiagIzqDer(arr, largoMatriz);
        if ((totalSecuenceHoriz+totSecuenceVert+totalSecuenceDiagIzqDer)>1){
            return true;
        }

        // Evalúa secuencia diagonal de derecha a izquierda y horizontal + vertical + diagonal de izquierda a derecha
        int totalSecuenceDiagDerIzq=0;
        totalSecuenceDiagDerIzq = SecuenciaDiagDerIzq(arr, largoMatriz);
        if ((totalSecuenceHoriz+totSecuenceVert+totalSecuenceDiagIzqDer+totalSecuenceDiagDerIzq)>1){
            return true;
        }

        // En caso de no encontrar ninguna de las anteriores
        return false;
    }

}
