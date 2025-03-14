package generics;

import java.util.ArrayList;
import java.util.List;

public class Schublade<T> {
    private List<T> inhalt = new ArrayList<>();


    /***/
    public List<T> getInhalt() {
        return this.inhalt;
    }
}
