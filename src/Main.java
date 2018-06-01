import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Lex lex= new Lex("src/file.txt");
        lex.getTokens();
    }
}
