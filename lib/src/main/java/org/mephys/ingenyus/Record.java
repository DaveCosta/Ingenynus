package org.mephys.ingenyus;

import static org.mephys.tools.Utils.getFloat;
import static org.mephys.tools.Utils.getInt;

public class Record {
    private int id = 0;
    private int disks;
    private String artist;
    private String title;
    private float price;
    private String category;

    public Record() {
        id = 0;
        disks = 1;
        artist = "";
        title = "";
        price = 0.0F;
        category = "";
    }

    public Record(String[] array) {
        id = getInt(array[0],0);
        artist = array[2];
        title = array[3];
        price = getFloat(array[4],0.0F);
        category = array[5];
    }

    @Override
    public String toString() {
        return "{" +
                "id: "+ id +
                ", artist: "+ artist +
                ", title: "+ title +
                ", price: "+ String.format("%.2f", price) +
                ", category: "+ category +
                "}";
    }
}
