public class MyHeap{
    private String[] data;
    private int size;
    private int isMax;
    public MyHeap(){
        data = new String[10];
        isMax = 1;
    }
    public MyHeap(boolean t){
        data = new String[10];
        if(t) isMax = 1;
        else isMax = -1; 
    }
    public String toString(){
        String temp = "";
        for(String each:data){
            temp += each + " ";
        }
        return temp;
    }
    public void add(String s){
        if(size >= data.length - 1) resize();
        data[size] = s;
        pushUp(size);
        size ++;
    }
    public String remove(){
        String temp = data[0];
        data[0] = data[size - 1];
        pushDown(0);
        size --;
        return temp;
    }
    public String peek(){
        return data[0];
    }
    private void pushUp(int index){
        while(data[index].compareTo(data[index/2])*isMax > 0){
            swap(index, index/2);
            index = index/2;
        }
    }
    private void pushDown(int index){
        int swapTo = 0;
        while(hasChild(index)){
            if(data[index].compareTo(data[index * 2 + 1])*isMax < 0){
                swapTo = index * 2 + 1;
                if(data[index * 2 + 1].compareTo(data[index * 2 + 2])*isMax < 0) swapTo = index * 2 + 2;
                swap(index, swapTo);
                index = swapTo;
            }
            else break;
        }
    }
    private boolean hasChild(int index){
        return ((2 * index + 1) < size);
    }
    private void swap(int first, int second){
        String temp = data[second];
        data[second] = data[first];
        data[first] = temp;
    }
    private void resize(){
        String[] temp = new String[data.length * 2];
        for(int i = 0; i < data.length; i ++){
            temp[i] = data[i];
        }
        data = temp;
    }
}