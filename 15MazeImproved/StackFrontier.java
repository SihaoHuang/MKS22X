import java.util.*;
public class StackFrontier implements Frontier{
    private Stack<Location> data;
    public StackFrontier(){
        data = new Stack<Location>();
    }
    public void add(Location loc){
        data.push(loc);
    }
    public Location next(){
        return data.pop();
    }
    public Location peek(){
        return data.peek();
    }
    public boolean hasNext(){
        return !(data.peek() == null);
    }
}