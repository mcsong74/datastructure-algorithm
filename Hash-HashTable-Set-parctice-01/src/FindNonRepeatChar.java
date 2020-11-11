import java.util.Hashtable;
import java.util.stream.Stream;

public class FindNonRepeatChar {
//        Hash Tables & Sets - Assignments
//        1. Super popular interview question. Find the first non repeated character in a string. For example “a green
//        apple” should return ’g’.
//        Hint: Use hash tables with characters as the key and number of occurrence as the value. You can use Java HashMap<> interface.


    public static void findUsingStream(String str){
        char[] chrArr = str.toCharArray();
        System.out.println("From string =[ "+str+" ]");

        Hashtable<Character, Integer> myTable2 = new Hashtable<>();

        for(char c: chrArr){
            if(myTable2.containsKey(c)){
                //                count=myTable2.get(c)+1;
                myTable2.put(c, myTable2.get(c)+1);
            }else{
                myTable2.put(c, 0);
            }

        }
//        System.out.println(myTable2);
//        System.out.println(myTable2.size());
        Stream<Character> stream=str.codePoints().mapToObj(c->(char) c); //converts char[] to char stream
        System.out.println("First non repeated character(Stream) = " + stream.filter(c -> myTable2.get(c) == 0).findFirst().get());


    }
    public static void findUsingForLoop(String str){
        char[] chrArr = str.toCharArray();
        Hashtable<Character, Integer> myTable2 = new Hashtable<>();
        System.out.println("From string =[ "+str+" ]");

        for(char c: chrArr){
            if(myTable2.containsKey(c)){
                //                count=myTable2.get(c)+1;
                myTable2.put(c, myTable2.get(c)+1);
            }else{
                myTable2.put(c, 0);
            }

        }

        for(char c: chrArr){
            if(myTable2.get(c)==0){
                System.out.println("First non repeated character = "+c);
                break;
            }
        }
    }
}
