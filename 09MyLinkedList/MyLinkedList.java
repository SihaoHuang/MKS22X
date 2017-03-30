public class MyLinkedList{
    private LNode start;
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
            start = new LNode(value);
        }
        else{
            LNode current = start;
            while(current.next != null){
                current = current.next;
            }
            current.next = new LNode(value);
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
    public int get(int index){
        LNode current = start;
        for(int i = 0; i < index; i ++){
            current = current.next;
        }
        return current.value;
    }
    public int set(int index, int newValue){
        LNode current = start;
        for(int i = 0; i < index; i ++){
            current = current.next;
        }
        int oldVal = current.value;
        current.value = newValue;
        return oldVal;
    }
    public int indexOf(int value){
        LNode current = start;
        for(int i = 0; i < size; i ++){
            if(current.value == value) return i;
            current = current.next;
        }
        return -1;
    }
    public int remove(int index){
        int oldVal = 0;
        if(index == 0){
            oldVal = start.value;
            start = start.next;
            return oldVal;
        }
        else if(index == size){
            LNode current = start;
            for(int i = 0; i < index - 2; i ++){
                current = current.next;
            }
            oldVal = current.next.value;
            current.next = null;
            return oldVal;
        }
        else{
            LNode current = start;
            for(int i = 0; i < index - 1; i ++){
                current = current.next;
            }
            oldVal = current.next.value;
            current.next = current.next.next;
            return oldVal;
        }
    }
}

