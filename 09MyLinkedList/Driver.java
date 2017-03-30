public class Driver{
    public static void main(String[] args){
        MyLinkedList test = new MyLinkedList();
        test.add(3);
        test.add(1);
        test.add(4);
        test.add(5);
        test.add(9);
        System.out.println(test.toString());
        System.out.println(test.size());
        test.set(4, 10);
        System.out.println(test.get(4));
        System.out.println(test.indexOf(10));
        System.out.println(test.remove(5));
        System.out.println(test.toString());
    }
}
