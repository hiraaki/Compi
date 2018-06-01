import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Lex {
    private ArrayList<Token> tokens;
    private ArrayList<String> palavrasreservadas;
    private ArrayList<String> oplogicos;
    private ArrayList<String> oparitimeticos;
    private ArrayList<String> oprelacionais;
    private ArrayList<String> opatribuicao;
    private Path filePath;
    private Scanner scanner;
    public Lex(String file) {
        this.filePath = Paths.get(file);
        this.scanner = null;
        try {
            scanner = new Scanner(this.filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.tokens = new ArrayList<>();
        this.palavrasreservadas = new ArrayList<>(){
            {
                add("if");
                add("else");
                add("while");
                add("for");
                add("switch");
                add("case");
                add("break");
                add("int");
                add("double");
                add("bool");
                add("true");
                add("false");
                add("ProgramVar");
                add("ProgramBody");
                add("print");
                add("scan");
                add("begin");
                add("end");

            }
        };
        this.oparitimeticos= new ArrayList<>(){
            {
                add("+");
                add("-");
                add("/");
                add("*");
            }
        };
        this.oplogicos = new ArrayList<>(){
            {
                add("||");
                add("&&");
                add("!");
                add("^");
            }
        };
        this.oprelacionais = new ArrayList<>(){
            {
                add("==");
                add("!=");
                add("<=");
                add(">=");
                add(">");
                add("<");
            }
        };
        this.opatribuicao= new ArrayList<>(){
            {
                add("=");
                add("++");
            }
        };
    }

    public void getTokens(){

        int count=1;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            ArrayList<String> palavras = new ArrayList<>();
            String str= new String();
            for(int i=0;i<line.length();i++){

                if(line.charAt(i)==' '){
                    if(!str.isEmpty()) {
                        palavras.add(str);
                        str=new String();
                    }
                }else if (i==line.length()-1){
                    str+=line.charAt(i);
                    if(!str.isEmpty()) {
                        palavras.add(str);
                        str=new String();
                    }
                }else if(line.charAt(i)=='+'){
                    if(!str.isEmpty()) {
                        palavras.add(str);
                        str=new String();
                    }
                    if (line.charAt(i+1)=='+'||line.charAt(i+1)=='='){
                        str+=line.charAt(i);
                        i++;
                        str+=line.charAt(i);
                        palavras.add(str);
                        str=new String();
                    }else{
                        str+=line.charAt(i);
                        palavras.add(str);
                        str=new String();
                    }
                }else if(line.charAt(i)=='=') {
                    if(!str.isEmpty()) {
                        palavras.add(str);
                        str=new String();
                    }
                    if (line.charAt(i+1)=='='){
                        str+=line.charAt(i);
                        i++;
                        str+=line.charAt(i);
                        palavras.add(str);
                        str=new String();
                    }else{
                        str+=line.charAt(i);
                        palavras.add(str);
                        str=new String();
                    }
                }else if(line.charAt(i)==','){
                    if(!str.isEmpty()) {
                        palavras.add(str);
                        str=new String();
                    }
                    str+=line.charAt(i);
                    palavras.add(str);
                    str=new String();

                }else if(line.charAt(i)==';') {
                    if (!str.isEmpty()) {
                        palavras.add(str);
                        str = new String();
                    }
                    str += line.charAt(i);
                    palavras.add(str);
                    str = new String();

                }else if(line.charAt(i)=='|'){
                    if(!str.isEmpty()) {
                        palavras.add(str);
                        str=new String();
                    }if(line.charAt(i+1)=='|'){
                        str += line.charAt(i);
                        i++;
                        str+=line.charAt(i);
                        palavras.add(str);
                        str = new String();
                    }else{
                        str+=line.charAt(i);
                        palavras.add(str);
                        str = new String();
                    }
                }else if(line.charAt(i)=='>'){
                    if(!str.isEmpty()){
                        palavras.add(str);
                        str=new String();
                    }if(line.charAt(i+1)=='='){
                        str += line.charAt(i);
                        i++;
                        str+=line.charAt(i);
                        palavras.add(str);
                        str=new String();
                    }else{
                        str+=line.charAt(i);
                        palavras.add(str);
                        str=new String();
                    }
                }else if(line.charAt(i)=='<') {
                    if (!str.isEmpty()) {
                        palavras.add(str);
                        str = new String();
                    }
                    if (line.charAt(i + 1) == '=') {
                        str += line.charAt(i);
                        i++;
                        str += line.charAt(i);
                        palavras.add(str);
                        str = new String();
                    } else {
                        str += line.charAt(i);
                        palavras.add(str);
                        str = new String();
                    }
                }else if(line.charAt(i)=='!') {
                    if (!str.isEmpty()) {
                        palavras.add(str);
                        str = new String();
                    }
                    if (line.charAt(i + 1) == '=') {
                        str += line.charAt(i);
                        i++;
                        str += line.charAt(i);
                        palavras.add(str);
                        str = new String();
                    } else {
                        str += line.charAt(i);
                        palavras.add(str);
                        str = new String();
                    }
                }else if(line.charAt(i)=='&') {
                    if (!str.isEmpty()) {
                        palavras.add(str);
                        str = new String();
                    }
                    if (line.charAt(i + 1) == '&') {
                        str += line.charAt(i);
                        i++;
                        str += line.charAt(i);
                        palavras.add(str);
                        str = new String();
                    } else {
                        str += line.charAt(i);
                        palavras.add(str);
                        str = new String();
                    }
                }else if(line.charAt(i)=='/'){

                }else{
                    str+=line.charAt(i);
                }

            }
            for(String s:palavras){

                System.out.println(s);
                if(isInt(s)){
                    System.out.println("INT "+s);
                }else if(isDouble(s)){
                    System.out.println("DOUBLE "+s);
                }else if(isChar(s)){
                    System.out.println("CHAR "+s);
                }
                if(isAritimetico(s)){
                    System.out.println("OPA "+s);
                }
                if(isLogic(s)){
                    System.out.println("OPL "+s);
                }
                if(isRelacional(s)){
                    System.out.println("OPR "+s);
                }
                if(isReserved(s)){
                    System.out.println("RESERVED "+s);
                }

            }

            count++;
        }
    }
    public boolean isInt(String Num){
        return Num.matches("\\d+");
    }
    public boolean isDouble(String Num){
        return Num.matches("\\d+(\\.\\d+)+");
    }
    public boolean isChar(String Char){
        return Char.matches("'[a-zA-Z]'");
    }
    public boolean isReserved(String reserv){
        return this.palavrasreservadas.contains(reserv);
    }
    public boolean isLogic(String op){
        return this.oplogicos.contains(op);
    }
    public boolean isAritimetico(String op){
        return this.oparitimeticos.contains(op);
    }
    public boolean isRelacional(String op){
        return this.oprelacionais.contains(op);
    }
    public boolean isatrib(String op){
        return this.opatribuicao.contains(op);
    }


}
