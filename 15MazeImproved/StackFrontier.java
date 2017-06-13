import java.util.*;
public class StackFrontier implements Frontier{
    private Stack<Location> data;
    public StackFrontier(){
        data = new Stack<Location>();
    }
    public void add(Location loc){
        data.add(loc);
    }
    public Location next(){
        return data.pop();
    }
    public boolean hasNext(){
        return data.size() > 0;
    }
    public int size(){
        return data.size();
    }
}