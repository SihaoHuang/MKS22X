import java.util.*;
public class MyDeque{
    private String[] data; 
    private int size, first, last;
    public void MyDeque(){
        data = new String[100];
        first = 0;
        last = 0;
        size = 0;
    }
    public String toString(){
        String out = "";
        for(String each:data){
            out += each + " ";
        }
        out += first + " " + last;
        return out;
    }
    private void doubleSize(){
        String[] temp = new String[size * 2];
        if(first > last){
            for(int i = 0; i < last + 1; i ++){
                temp[i] = data[i];
            }
            for(int i = first; first < data.length; first ++){
                temp[temp.length - i] = data[i]; // check this?
            }
        }
        else if(last > first){
            for(int i = 0; i < data.length; i ++){
                temp[i] = data[i];
            }
        }
    }
    public void addFirst(String e){
        if(size >= data.length) doubleSize();
        if(e == null) throw new NullPointerException();
        if(first == 0){
            first = data.length - 1;
            data[first] = e;
        }
        else{
            first --;
            data[first] = e;
        }
        size ++;
    }
    public void addLast(String e){
        if(size >= data.length) doubleSize();
        if(e == null) throw new NullPointerException();
        if(last == data.length - 1){
            last = 0;
            data[last] = e;
        }
        else{
            last --;
            data[last] = e;
        }
        size ++;
    }
    public String removeFirst(){
        if(size == 0) throw new NoSuchElementException();
        String temp = data[first];
        if(first == data.length - 1) first = 0; //no need to set null
        else first ++;
        size --;
        return temp;
    }
    public String removeLast(){
        if(size == 0) throw new NoSuchElementException();
        String temp = data[last];
        if(last == 0) last = data.length - 1;
        else last --;
        size --;
        return temp;
    }
    public String getFirst(){
        if(size == 0) throw new NoSuchElementException();
        return data[first];
    }
    public String getLast(){
        if(size == 0) throw new NoSuchElementException();
        return data[last];
    }
}