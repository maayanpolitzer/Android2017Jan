package edu.tomer.java;

/**
 * Created by hackeru on 08/03/2017.
 */
public class Word {

    private String heb,eng;

    public Word(String heb, String eng){
        this.heb = heb;
        this.eng = eng;
    }

    public String getHeb() {
        return heb;
    }

    public String getEng() {
        return eng;
    }
}
