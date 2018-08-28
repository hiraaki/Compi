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
    private ArrayList<String> opIncremento;
    private ArrayList<String> ctrlBoloco;
    private ArrayList<String> stmtSeparador;
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
                add("char");
                add("true");
                add("false");
                add("ProgramVar:");
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
            }
        };
        this.opIncremento = new ArrayList<>(){
            {
                add("++");
            }
        };
        this.ctrlBoloco= new ArrayList<>(){
            {
                add("{");
                add("}");
                add("(");
                add(")");
                add("[");
                add("]");
            }
        };
        this.stmtSeparador = new ArrayList<>(){
            {
                add(",");
                add(";");
            }
        };
    }

    public ArrayList<Token> geTokens(){
        return tokens;
    }

    public void setTokens(){

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
                }else if(line.charAt(i)== (char)39) {
                    if (!str.isEmpty()) {
                        palavras.add(str);
                        str = new String();
                    }
                    String aux = new String();
                    aux += line.charAt(i + 1);
                    if (aux.matches("[a-zA-Z]")) {
                        if (line.charAt(i + 2) == (char) 39) {
                            str += line.charAt(i);
                            i++;
                            str += line.charAt(i);
                            i++;
                            str += line.charAt(i);

                            palavras.add(str);
                            str = new String();
                        }
                    } else {
                        str += line.charAt(i);
                    }
                }else if(line.charAt(i)=='('){
                    if (!str.isEmpty()) {
                        palavras.add(str);
                        str = new String();
                    }
                    str += line.charAt(i);
                    palavras.add(str);
                    str = new String();
                }
                else if(line.charAt(i)==')'){
                    if (!str.isEmpty()) {
                        palavras.add(str);
                        str = new String();
                    }
                    str += line.charAt(i);
                    palavras.add(str);
                    str = new String();
                }else if(line.charAt(i)=='{'){
                    if (!str.isEmpty()) {
                        palavras.add(str);
                        str = new String();
                    }
                    str += line.charAt(i);
                    palavras.add(str);
                    str = new String();
                }else if(line.charAt(i)=='}'){
                    if (!str.isEmpty()) {
                        palavras.add(str);
                        str = new String();
                    }
                    str += line.charAt(i);
                    palavras.add(str);
                    str = new String();
                }else if(line.charAt(i)=='['){
                    if (!str.isEmpty()) {
                        palavras.add(str);
                        str = new String();
                    }
                    str += line.charAt(i);
                    palavras.add(str);
                    str = new String();
                }else if(line.charAt(i)==']'){
                    if (!str.isEmpty()) {
                        palavras.add(str);
                        str = new String();
                    }
                    str += line.charAt(i);
                    palavras.add(str);
                    str = new String();
                }else if (i==line.length()-1){
                    str+=line.charAt(i);
                    if(!str.isEmpty()) {
                        palavras.add(str);
                        str=new String();
                    }
                }else{
                    str+=line.charAt(i);
                }

            }
            for(int i=0;i<palavras.size();i++){
                String s=palavras.get(i);
                if(isInt(s)){
                    //System.out.println("INT "+s);
                    this.tokens.add(new Token("Int",s));
                }else if(isDouble(s)){
                    //System.out.println("DOUBLE "+s);
                    this.tokens.add(new Token("Double",s));
                }else if(isChar(s)){
                    //System.out.println("CHAR "+s);
                    this.tokens.add(new Token("Char",s));
                }else if(isAritimetico(s)){
                    //System.out.println("OPB "+s);
                    this.tokens.add(new Token("OPB",s));
                }else if(isLogic(s)){
                    //System.out.println("OPL "+s);
                    this.tokens.add(new Token("OPL",s));
                }else if(isRelacional(s)){
                    //System.out.println("OPR "+s);
                    this.tokens.add(new Token("OPR",s));
                }else if(isReserved(s)){
                    //System.out.println("RESERVED "+s);
                    this.tokens.add(new Token("RESERVED",s));
                }else if(isatrib(s)){
                    //System.out.println("ATRIB "+s);
                    this.tokens.add(new Token("ATRIB ",s));
                }else if(isInc(s)){
                    //System.out.println("INC "+s);
                    this.tokens.add(new Token("INC ",s));
                }else if (isctrlBoloco(s)){
                    //System.out.println("CTRLBL "+s);
                    this.tokens.add(new Token("CTRLBL ",s));
                }else if (isstmtSeparador(s)){
                    //System.out.println("SEPAR "+s);
                    this.tokens.add(new Token("SEPAR ",s));
                }else if(isId(s)){
                    //System.out.println("ID "+s);
                    this.tokens.add(new Token("id",s));
                }else{
                    System.out.println("ERROR:"+s+" Não é Reconecido Pela LP. Linha:"+count+" Objeto:"+(i+1));
                    this.tokens.add(new Token("ERROR","Não Reconecido Pela LP Linha:"+count+" Objeto:"+i));
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
    public boolean isInc(String op){
        return this.opIncremento.contains(op);
    }
    public boolean isctrlBoloco(String op){
        return this.ctrlBoloco.contains(op);
    }
    public boolean isstmtSeparador(String op){
        return this.stmtSeparador.contains(op);
    }
    public boolean isId(String str){
        return str.matches("^[a-zA-Z](\\w)*");
    }

}
