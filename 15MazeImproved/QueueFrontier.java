import java.util.*;
public class QueueFrontier implements Frontier{
    private LinkedList data;
    public QueueFrontier(){
        data = new LinkedList();
    }
    public void add(Location loc){
        data.add(loc);
    }
    public Location next(){
        data.remove();
    }
    public Location peek(){
        data.peek;
    }
}