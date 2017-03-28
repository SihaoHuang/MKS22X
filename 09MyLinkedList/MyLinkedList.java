public class MyLinkedList{
    private LNode start, end;
    private int size;

    class LNode{
        int value;
        LNode next;

        LNode(int val){
            value = val;
            next = null; 
        }
    } 

    public MyLinkedList(){
        size = 0;
    }
    public boolean add(int value){
        if(size == 0){   // initate the first node
            LNode temp = new LNode(value);
            start = temp;
            end = temp;
        }
        else{
            //start.next = new LNode(value);
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
                current = current.next;
            }
            return out.substring(0,out.length() - 2) + "]";
        }
    }
    // public int get(int index){}
    // public int set(int index, int newValue){}
}

