package cat.iesesteveterradas.fites;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * Implementa codi que compleixi el següent:
 * 
 * - Llegeix un fitxer de text d'entrada amb codificació UTF-8.
 * - Inverteix el text de cada línia utilitzant el mètode 'giraText'.
 * - Escriu les línies invertides en un fitxer de sortida amb codificació UTF-8.
 * - El fitxer de sortida es crea o sobrescriu si ja existeix.
 * - Si hi ha un error en llegir o escriure els fitxers, l'excepció es mostra a la consola.
 */
public class Exercici1 {

    private String filePathIn;
    private String filePathOut;


    public static void main(String args[]) {
        Exercici1 exercici = new Exercici1();
        // Configurar els fitxers d'entrada i sortida
        exercici.configuraRutaFitxerEntrada(System.getProperty("user.dir") + "/data/exercici1/Exercici1Entrada.txt");
        exercici.configuraRutaFitxerSortida(System.getProperty("user.dir") + "/data/exercici1/Exercici1Solucio.txt");
        // Executar la lògica principal
        exercici.executa();
    }    

    // Processa el fitxer d'entrada i genera el fitxer de sortida.
    public void executa() {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePathOut), StandardCharsets.UTF_8));
            List<String> linies = Files.readAllLines(Paths.get(filePathIn), StandardCharsets.UTF_8);
            for (String linia : linies) {
                String newLine = giraText(linia);
                bw.write(newLine);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Mètode per invertir el text d'una línia
    public static String giraText(String text) {
        String reverseText = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            reverseText = reverseText + text.charAt(i);
        }
        return reverseText;
    }

    /****************************************************************************/
    /*                          NO CAL MODIFICAR                                */
    /****************************************************************************/
    // Mètode per configurar el fitxer d'entrada
    public void configuraRutaFitxerEntrada(String filePathIn) {
        this.filePathIn = filePathIn;
    }

    // Mètode per configurar el fitxer de sortida
    public void configuraRutaFitxerSortida(String filePathOut) {
        this.filePathOut = filePathOut;
    }
}
