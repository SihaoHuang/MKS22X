public class MyLinkedList{
    private LNode head, tail;
    private int size;
    class LNode{
        int value;
        LNode previous;
        LNode next;
        LNode(int val){
            value = val;
            previous = null;
            next = null; 
        }
    }
    public MyLinkedList(){
        size = 0;
    } 
    public boolean add(int value){
        add(size, value);
        return true;
    }
    public boolean add(int index, int value){
        LNode toBeAdded = new LNode(value);
        if(index == 0){
            toBeAdded.next = head;
            head = toBeAdded;
            size ++;
            return true;
        }
        else{
            return insertAfter(toBeAdded, getNode(index - 1));
        }
    }
    public int get(int index){
        return getNode(index).value;
    }
    public int set(int index, int value){
        LNode target = getNode(index);
        int ans = target.value;
        target.value = value;
        return ans;
    }
    public int remove(int index){
        LNode node = getNode(index);
        int val = node.value;
        remove(node);
        return val;
    }
    public int size(){
        return size;
    }
    public void indexOf(){ // work on this
        LNode current = start;
        for(int i = 0; i < size; i ++){
            if(current.value == value) return i;
            current = current.next;
        }
        return -1;
    }
    public String toString(){
        LNode current = head;
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

    /**** PRIVATE METHODS ****/

    private LNode getNode(int index){
        LNode current = head;
        for(int i = 0; i < index; i ++){
            current = current.next;
        }
        return current;   
    }
    private void remove(LNode node){
        if(node.equals(head)){
            head = head.next;
            head.previous = null; 
        }
        else if(node.equals(tail)){
            tail = tail.previous;
            tail.next = null;
        }
        else if(size == 1){
            head = null;
            tail = null;
        }
        else{
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }
        size -= 1;
    }
    private boolean insertAfter(LNode toBeAdded, LNode location){
        if(size == 0){
            head = toBeAdded;
            tail = toBeAdded;
        }
        else if(location.equals(tail)){
            toBeAdded.previous = tail;
            tail.next = toBeAdded;
            tail = toBeAdded;
        }
        else{
            toBeAdded.previous = location;
            toBeAdded.next = location.next;
            location.next = toBeAdded;
            location.next.previous = toBeAdded;
        }
        size += 1;
        return true;
    }
}



// public class MyLinkedList{
//     private LNode start;
//     private int size;
//     class LNode{
//         int value;
//         LNode next;
//         LNode(int val){
//             value = val;
//             next = null; 
//         }
//     } 
//     public MyLinkedList(){
//         size = 0;
//     }
//     public boolean add(int value){
//         if(size == 0){   // initate the first node
//             start = new LNode(value);
//         }
//         else{
//             LNode current = start;
//             while(current.next != null){
//                 current = current.next;
//             }
//             current.next = new LNode(value);
//         }
//         size += 1;
//         return true;
//     }
//     public boolean add(int index, int value){
//         if(size == 0){   // initate the first node
//             start = new LNode(value);
//         }
//         else if(index == 0){
//             LNode newNode = new LNode(value);
//             newNode.next = start;
//             start = newNode;
//         }
//         else if(index == size){}
//         else{}
//         size += 1;
//         return true;
//     }
//     public int size(){
//         return size;
//     }
//     public String toString(){
//         LNode current = start;
//         if(current == null){
//             return "[]";
//         }
//         else{
//             String out = "[";
//             while(current != null){
//                 out += current.value + ", ";
//                 current = current.next;
//             }
//             return out.substring(0,out.length() - 2) + "]";
//         }
//     }
//     public int get(int index){
//         LNode current = start;
//         for(int i = 0; i < index; i ++){
//             current = current.next;
//         }
//         return current.value;
//     }
//     public int set(int index, int newValue){
//         LNode current = start;
//         for(int i = 0; i < index; i ++){
//             current = current.next;
//         }
//         int oldVal = current.value;
//         current.value = newValue;
//         return oldVal;
//     }
//     public int indexOf(int value){
//         LNode current = start;
//         for(int i = 0; i < size; i ++){
//             if(current.value == value) return i;
//             current = current.next;
//         }
//         return -1;
//     }
//     public int remove(int index){
//         int oldVal = 0;
//         if(index == 0){
//             oldVal = start.value;
//             start = start.next;
//             return oldVal;
//         }
//         else if(index == size){
//             LNode current = start;
//             for(int i = 0; i < index - 2; i ++){
//                 current = current.next;
//             }
//             oldVal = current.next.value;
//             current.next = null;
//             return oldVal;
//         }
//         else{
//             LNode current = start;
//             for(int i = 0; i < index - 1; i ++){
//                 current = current.next;
//             }
//             oldVal = current.next.value;
//             current.next = current.next.next;
//             return oldVal;
//         }
//     }
// }

