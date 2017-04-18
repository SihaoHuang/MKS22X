public class Driver{
    public static void main(String[] args){
        MyLinkedList test = new MyLinkedList();
        test.add(3);
        test.add(1);
        test.add(4);
        test.add(1);
        test.add(5);
        test.add(9);
        for(int each:test){
            System.out.println(each);
        }
        // System.out.println(test.toString());
        // System.out.println(test.size());
        // test.set(4, 10);
        // System.out.println(test.toString());
        // System.out.println(test.get(4));
        // System.out.println(test.remove(3));
        // System.out.println(test.toString());
        // System.out.println(test.set(0,100));
        // System.out.println(test.toString());
        // System.out.println(test.indexOf(99));
        // System.out.println(test.add(4,-10));
        // System.out.println(test.toString());
    }
}


//make a node toString() which prints (null)5(3) (5)3(6) eetc
//iterator<Integer>