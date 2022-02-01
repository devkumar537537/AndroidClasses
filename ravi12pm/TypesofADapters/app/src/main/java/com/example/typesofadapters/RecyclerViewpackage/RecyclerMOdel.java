package com.example.typesofadapters.RecyclerViewpackage;

public class RecyclerMOdel {
 private String namerecycler,numberrecycler;
 private int imageurlrecycler;

    public RecyclerMOdel(String namerecycler, String numberrecycler, int imageurlrecycler) {
        this.namerecycler = namerecycler;
        this.numberrecycler = numberrecycler;
        this.imageurlrecycler = imageurlrecycler;
    }

    public RecyclerMOdel() {
    }

    public String getNamerecycler() {
        return namerecycler;
    }

    public void setNamerecycler(String namerecycler) {
        this.namerecycler = namerecycler;
    }

    public String getNumberrecycler() {
        return numberrecycler;
    }

    public void setNumberrecycler(String numberrecycler) {
        this.numberrecycler = numberrecycler;
    }

    public int getImageurlrecycler() {
        return imageurlrecycler;
    }

    public void setImageurlrecycler(int imageurlrecycler) {
        this.imageurlrecycler = imageurlrecycler;
    }
}
