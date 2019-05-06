package org.mephys.ingenyus;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ingenyus {

    public static String MAU_GENIO = "http://www.maugenio.com/data/";
    public static String MAU_GENIO_CD = "cd.txt";
    public static String MAU_GENIO_DVD = "dvd.txt";
    public static String MAU_GENIO_BOOK = "livro.txt";
    public static String MAU_GENIO_VINIL = "lp.txt";


    public static void main(String[] args) {
        List<Record> records = new ArrayList<>();

        try {
            URL url = new URL(MAU_GENIO + MAU_GENIO_CD);
            Scanner s = new Scanner(url.openStream());
            int count = 0;
            while (s.hasNext()) {
                String line = s.nextLine().trim();
                String[] array = line.split("\t");
                Record record = new Record(array);
                records.add(record);
                System.out.println(record);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nTotal: "+ records.size());
    }

}
