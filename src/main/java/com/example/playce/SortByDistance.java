import java.util.*;
import java.lang.*;


public class SortByDistance implements Comparator <Results>{
    public int compare(Result a, Result b){
        return a.getDistance() - b.getDistance();
    }
}
