import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Path filePath = Paths.get("src/file.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Token> tokens = new ArrayList<>();
        while (scanner.hasNext()) {
//            System.out.println(scanner.nextLine());
            char[] line = scanner.nextLine().toCharArray();
            String num = new String();
            for(int i=0;i< line.length;i++){
                boolean error=false;
                String str= new String();
                str+=line;
                if(str.matches("[0-9]")){
                    num+=a;
                }else if(a==' '){
                    tokens.add(new Token("INT",num));
                    break;
                }
                if(!str.matches("[0-9]")&&(str!=".")){

                }
            }
            System.out.println(num);


        }
    }
}
