public class Driver{
    public static void main(String[] args){
        MyHeap heap = new MyHeap(false);
        heap.add("f");
        heap.add("d");
        heap.add("a");
        heap.add("x");
        heap.add("e");
        heap.add("c");
        heap.add("d");
        heap.add("a");
        heap.add("g");
        heap.add("e");
        System.out.println(heap);
        heap.remove();
        heap.remove();
        System.out.println(heap);
        System.out.println(heap.peek());
    }
}