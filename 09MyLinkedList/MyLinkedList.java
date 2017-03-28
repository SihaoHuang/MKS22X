public class MyLinkedList{
    private LNode start;
    private int size;

    public MyLinkedList(){
        size = 0;
    }
    public boolean add(int value){
        if(start == null){   // initate the first node
            LNode start = new LNode(value);
        }
        else{
            start.next = new LNode(value);
        }
        size += 1;
        return true;
    }
    public int size(){
        return size;
    }
    public String toString(){
        LNode current = start;
        if(current == null){
            return "[]";
        }
        else{
            String out = "[";
            while(current != null){
                out += current.value + ", ";
                current = start.next;
            }
            return out + "]";
        }
    }
    // public int get(int index){}
    // public int set(int index, int newValue){}
}

class LNode{
    int value;
    LNode next;

    LNode(int val){
        value = val;
        next = null; 
    }
} 