package edu.hackeru;

/**
 * Created by hackeru on 29/03/2017.
 */
public abstract class Y extends X {

    public boolean male = true;

    public abstract int wiii();

    public Y(){
        super(false);
        System.out.println("Y");
    }

    @Override
    public int wow(String s, int i) {
        super.wow("name", 90);
        return 0;
    }

    public String getWow(){
        return "wow";
    }
}
