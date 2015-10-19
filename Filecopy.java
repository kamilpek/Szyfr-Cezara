package filecopy;

/**
 * Program szyfrujacy plik za pomaca szyfru Cezara;
 * Nastepnie deszyfruje pliki;
 */

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Kamil Pek [231050];
 */

public class Filecopy {
    
    public static String cezar(String str){        //metoda szyfrujaca;
        char x[] = str.toCharArray();
        
        for(int i=0; i != x.length; i++){
            int n = x[i];
            n += 5;
            x[i] = (char)n;
        }
        return new String(x);
    }
    
    public static String cezarwroc(String str){     //metoda deszyfrujaca;
        char x[] = str.toCharArray();
        
        for(int i=0; i != x.length; i++) {
            int n = x[i];
            n -= 5;
            x[i] = (char)n;
        }
        return new String(x);
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File wejscie = new File("./src/filecopy/dane.txt");
        Scanner in = new Scanner(wejscie);
        PrintWriter wyjscie = new PrintWriter("./src/filecopy/dane_zaszyfrowane.txt");
        File wejscie2 = new File("./src/filecopy/dane_zaszyfrowane.txt");
        Scanner in2 = new Scanner(wejscie2);
                               
        int i = 0;
        int j = 0;
        
        String slowo;
        String szyfr;
        String[] dane = new String[100];            //deklaracja tablicy dane o wielkosci 100;
                
        while (in.hasNextLine()){                   //wczytywanie zawartosci pliku do tablicy dane;
            String zdanie = in.nextLine();
            dane[i] = zdanie;
            i++;
        }        
                
        while (j != i){                            //petla wysylajaca elementy tablice dane jako parametry metody cezar;
            slowo = dane[j];
            szyfr = Filecopy.cezar(slowo);          //przypisujemy zaszyfrownae slowa do zmiennej szyfr;
            wyjscie.println(szyfr);                 //zapis do pliku;
            j++;            
        }
        
        wyjscie.close();                            //zamykanie pliku output.txt;
        
        while (in2.hasNextLine()) {                 //odszyfrowywanie pliku;
            String szyfrowane = in2.nextLine();
            String odszyfrowane = Filecopy.cezarwroc(szyfrowane);
            System.out.println(odszyfrowane);       //wypisywanie na ekran odszyfrowanej zawartosci pliku
        }
    }
}