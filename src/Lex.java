public class Lex {

    ArrayList<Token> tokens = new ArrayList();
    List<String> palavrasreservadas = new ArrayList(){
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
}
