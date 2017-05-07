public class Driver{
    public static void main(String[] args){
        MyHeap heap = new MyHeap(false);
        heap.add("a");
        heap.add("b");
        heap.add("c");
        heap.add("d");
        heap.add("e");
        System.out.println(heap);
        heap.remove();
        System.out.println(heap);
    }
}