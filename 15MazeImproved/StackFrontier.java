import java.util.*;
public class StackFrontier implements Frontier{
    private Stack<Locaton> data;
    public StackFrontier(){
        data = new Stack()<Location>;
    }
    public void add(Location loc){
        data.push(loc);
    }
    public Location next(){
        data.pop();
    }
    public Location peek(){
        data.peek;
    }
}