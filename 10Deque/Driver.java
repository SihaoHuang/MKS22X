public class Driver{
    public static void main(String[] args){
       MyDeque test = new MyDeque();
       test.addLast("a");
       test.addLast("b");
       test.addLast("c");
       test.addLast("d");
       test.addLast("e");
       test.addLast("f");
       test.addLast("g");
       test.addLast("h");
       test.addLast("i");
       test.addLast("j");
       test.addLast("k");
       test.addLast("l");
       test.addFirst("x");
       System.out.println(test.toString());
       System.out.println(test.removeFirst());
       System.out.println(test.toString());
    }
}

