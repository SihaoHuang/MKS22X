public class Driver{
    public static void main(String[] args){
       MyDeque test = new MyDeque();
       System.out.println(test.toString());
       test.addFirst("a");
       test.addFirst("b");
       test.addLast("c");
       test.addLast("d");
    }
}

