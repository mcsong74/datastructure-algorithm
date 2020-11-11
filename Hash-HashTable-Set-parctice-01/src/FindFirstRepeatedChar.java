import java.util.HashSet;

public class FindFirstRepeatedChar {
    public static void findFirstRepeatedCharacter(String str){
//        String testStr3="a gren gapple";
        char[] chrArr=str.toCharArray();
        HashSet<Character> mySet = new HashSet<>();
        System.out.println("From String = [ "+str+" ]");
        for(char c: chrArr){
            if(c!=' '){
                if(mySet.contains(c)){
                    System.out.println("First Repeated Character = "+c);
                    break;
                }else{
                    mySet.add(c);
                }
            }

        }
    }
}
