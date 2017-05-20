public class MyHeap{
    private Location[] data;
    private int size; //not actually size, but last index
    private int isMax;
    public MyHeap(){
        data = new Location[10];
        size = 1;
        isMax = 1;
    }
    public MyHeap(boolean t){
        data = new Location[10];
        size = 1;
        if(t) isMax = 1;
        else isMax = -1; 
    }
    public String toString(){
        String temp = "";
        for(Location each:data){
            temp += each + " ";
        }
        return temp;
    }
    public void add(Location s){
        if(size >= data.length - 1) resize();
        data[size] = s;
        pushUp(size);
        size ++;
    }
    public Location remove(){
        Location temp = data[1];
        data[1] = data[size - 1];
        pushDown(1);
        size --;
        return temp;
    }
    public Location peek(){
        return data[1];
    }
    public int size(){
        return size - 1;
    }
    private void pushUp(int index){
        while(index != 1 && (data[index].compareTo(data[index/2])*isMax > 0)){
            swap(index, index/2);
            index = index/2;
        }
    }
    private void pushDown(int index){
        int swapTo = 0;
        while(hasChild(index)){
            if(data[index].compareTo(data[index * 2])*isMax < 0){
                swapTo = index * 2;
                if(data[index * 2].compareTo(data[index * 2 + 1])*isMax < 0) swapTo = index * 2 + 1;
                swap(index, swapTo);
                index = swapTo;
            }
            else break;
        }
    }
    private boolean hasChild(int index){
        return ((2 * index) < size);
    }
    private void swap(int first, int second){
        Location temp = data[second];
        data[second] = data[first];
        data[first] = temp;
    }
    private void resize(){
        Location[] temp = new Location[data.length * 2];
        for(int i = 1; i < data.length; i ++){
            temp[i] = data[i];
        }
        data = temp;
    }
}