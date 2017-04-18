import java.util.*;
public class MyLinkedList implements Iterable<Integer>{
    private LNode head, tail;
    private int size;
    private int at;
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
        if((index > size) || (index < 0)){
            throw new IndexOutOfBoundsException();
        }
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
        if((index > size) || (index < 0)){
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).value;
    }
    public int set(int index, int value){ 
        if((index > size) || (index < 0)){
            throw new IndexOutOfBoundsException();
        }
        LNode target = getNode(index);
        int ans = target.value;
        target.value = value;
        return ans;
    }
    public int remove(int index){
        if((index > size) || (index < 0)){
            throw new IndexOutOfBoundsException();
        }
        LNode node = getNode(index);
        int val = node.value;
        remove(node);
        return val;
    }
    public int size(){
        return size;
    }
    public int indexOf(int value){
        LNode current = head;
        for(int i = 0; i < size + 1; i ++){
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

    public Iterator<Integer> iterator(){
        return new MyLinkedListIterator(this, at); 
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

/*********************************************************************/

class MyLinkedListIterator implements Iterator<Integer>{
  
  MyLinkedList list = new MyLinkedList();
  int at;

  public MyLinkedListIterator(MyLinkedList argList, int argAt){
    at = argAt;
    list = argList;
  }

  public Integer next(){
    if (hasNext()) {
      at ++;
      return list.get(at - 1);
    }
    else {
      throw new NoSuchElementException(); //import util later!!!
    }
  }

  public boolean hasNext(){
    return at < list.size();
  }

  public void remove(){
    throw new UnsupportedOperationException();
  }

}