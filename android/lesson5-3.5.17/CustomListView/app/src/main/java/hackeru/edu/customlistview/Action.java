package hackeru.edu.customlistview;

/**
 * Created by hackeru on 03/05/2017.
 */

public class Action {

    private String title;
    private int icon;

    public Action(String title, int icon){
        this.title = title;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public int getIcon() {
        return icon;
    }

    @Override
    public String toString() {
        return title + ", " + icon;
    }
}
