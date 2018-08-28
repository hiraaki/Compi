import java.util.ArrayList;
import java.util.Stack;

public class Sintatico {
    ArrayList <Token> tokens;
    ArrayList <State> states;

    public Sintatico(ArrayList<Token> tokens) {
        this.tokens = tokens;
        this.states = new ArrayList<>();

        ArrayList <String> stacklist = new ArrayList<String>(){
            {
                add("PROGRAMVAR");
                add("PROGRAMBODY");
            }
        };
        ArrayList <Interactions> interactions = new ArrayList<>();
        interactions.add(new Interactions("ProgramVar:", stacklist ));
        State state = new State("S",interactions);
        this.states.add(state);

        stacklist = new ArrayList<>(){
            {
                add("ProgramVar:");
                add("{");
                add("ASSIGN");
                add("}");
            }
        };
        interactions = new ArrayList<>();
        interactions.add( new Interactions("ProgramVar",stacklist));
        state = new State("PROGRAMVAR", interactions);
        this.states.add(state);

        stacklist = new ArrayList<>(){
            {
                add("ASSTERM");
                add("ASSIGN'");
            }
        };
        interactions = new ArrayList<>();
        interactions.add(new Interactions("int",stacklist));
        interactions.add( new Interactions("double",stacklist ));
        interactions.add( new Interactions("bool",stacklist ));
        interactions.add( new Interactions("char",stacklist ));
        state = new State("ASSIGN",interactions);
        this.states.add(state);

        stacklist = new ArrayList<>(){
            {
                add("ASSTERM");
                add("ASSIGN'");
            }
        };
        interactions = new ArrayList<>();
        interactions.add(new Interactions("int",stacklist));
        interactions.add( new Interactions("double",stacklist ));
        interactions.add( new Interactions("bool",stacklist ));
        interactions.add( new Interactions("char",stacklist ));
        stacklist = new ArrayList<>(){
            {
                add("VAZIO");
            }
        };
        interactions.add( new Interactions("}",stacklist ));
        state = new State("ASSIGN'",interactions);
        this.states.add(state);

        stacklist = new ArrayList<>(){
            {
                add("int");
                add("id");
                add("=");
                add("ATRIBINT");
            }
        };
        interactions = new ArrayList<>();
        interactions.add(new Interactions("int",stacklist));
        stacklist = new ArrayList<>(){
            {
                add("double");
                add("id");
                add("=");
                add("ATRIBDOUBLE");
            }
        };
        interactions.add( new Interactions("double",stacklist ));
        stacklist = new ArrayList<>(){
            {
                add("bool");
                add("id");
                add("=");
                add("ATRIBBOOL");
            }
        };
        interactions.add( new Interactions("bool",stacklist ));
        stacklist = new ArrayList<>(){
            {
                add("char");
                add("id");
                add("=");
                add("ATRIBCHAR");
            }
        };
        interactions.add( new Interactions("char",stacklist ));
        state = new State("ASSTERM",interactions);
        this.states.add(state);

        stacklist = new ArrayList<>(){
            {
                add("Int");
                add(";");
            }
        };
        interactions = new ArrayList<>();
        interactions.add(new Interactions("Int",stacklist));
        state = new State("ATRIBINT",interactions);
        this.states.add(state);

        stacklist = new ArrayList<>(){
            {
                add("Int");
                add(";");
            }
        };
        interactions = new ArrayList<>();
        interactions.add(new Interactions("Int",stacklist));
        state = new State("ATRIBINT",interactions);
        this.states.add(state);

        stacklist = new ArrayList<>(){
            {
                add("Double");
                add(";");
            }
        };
        interactions = new ArrayList<>();
        interactions.add(new Interactions("Double",stacklist));
        state = new State("ATRIBDOUBLE",interactions);
        this.states.add(state);

        stacklist = new ArrayList<>(){
            {
                add("Bool");
                add(";");
            }
        };
        interactions = new ArrayList<>();
        interactions.add(new Interactions("Bool",stacklist));
        state = new State("ATRIBBOOL",interactions);
        this.states.add(state);

        stacklist = new ArrayList<>(){
            {
                add("Char");
                add(";");
            }
        };
        interactions = new ArrayList<>();
        interactions.add(new Interactions("Char",stacklist));
        state = new State("ATRIBCHAR",interactions);
        this.states.add(state);

        stacklist = new ArrayList<>(){
            {
                add("ProgramBody");
                add("begin");
                add("{");
                add("STM");
                add("}");
                add("end");
            }
        };
        interactions = new ArrayList<>();
        interactions.add(new Interactions("ProgramBody",stacklist));
        state = new State("PROGRAMBODY",interactions);
        this.states.add(state);

        stacklist = new ArrayList<>(){
            {
                add("VAZIO");
            }
        };
        interactions = new ArrayList<>();
        interactions.add(new Interactions("}",stacklist));
        stacklist = new ArrayList<>(){
            {
                add("TERM");
                add("STM'");
            }
        };
        interactions.add(new Interactions("id",stacklist));
        interactions.add(new Interactions("if",stacklist));
        interactions.add(new Interactions("switch",stacklist));
        interactions.add(new Interactions("while",stacklist));
        interactions.add(new Interactions("for",stacklist));
        interactions.add(new Interactions("print",stacklist));
        interactions.add(new Interactions("scan",stacklist));
        state = new State("STM",interactions);
        this.states.add(state);

        stacklist = new ArrayList<>(){
            {
                add("VAZIO");
            }
        };
        interactions = new ArrayList<>();
        interactions.add(new Interactions("}",stacklist));
        stacklist = new ArrayList<>(){
            {
                add("TERM");
                add("STM'");
            }
        };
        interactions.add(new Interactions("id",stacklist));
        interactions.add(new Interactions("if",stacklist));
        interactions.add(new Interactions("switch",stacklist));
        interactions.add(new Interactions("while",stacklist));
        interactions.add(new Interactions("for",stacklist));
        interactions.add(new Interactions("print",stacklist));
        interactions.add(new Interactions("scan",stacklist));
        state = new State("STM'",interactions);
        this.states.add(state);

        stacklist = new ArrayList<>(){
            {
                add("ATRIB");
            }
        };
        interactions = new ArrayList<>();
        interactions.add(new Interactions("id",stacklist));
        stacklist = new ArrayList<>(){
            {
                add("if ");
                add("( ");
                add("EXP");
                add(")");
                add("{");
                add("STM");
                add("}");
                add("ELSESTM");
            }
        };
        interactions.add(new Interactions("if",stacklist));
        stacklist = new ArrayList<>(){
            {
                add("switch");
                add("(");
                add("id");
                add(")");
                add("{");
                add("CASETERM");
                add("}");
            }
        };
        interactions.add(new Interactions("switch",stacklist));
        stacklist = new ArrayList<>(){
            {
                add("while");
                add("(");
                add("EXP");
                add(")");
                add("{");
                add("STM");
                add("}");
            }
        };
        interactions.add(new Interactions("while",stacklist));
        stacklist = new ArrayList<>(){
            {
                add("for");
                add("(");
                add("FORATRIB");
                add("EXP");
                add(";");
                add("FORCOUNT");
                add(")");
                add("{");
                add("STM");
                add("}");
            }
        };
        interactions.add(new Interactions("for",stacklist));
        stacklist = new ArrayList<>(){
            {
                add("print");
                add("(");
                add("char");
                add(",");
                add("id");
                add(")");
                add(";");
            }
        };
        interactions.add(new Interactions("print",stacklist));
        state = new State("TERM",interactions);
        this.states.add(state);

        stacklist = new ArrayList<>(){
            {
                add("int");
            }
        };
        interactions = new ArrayList<>();
        interactions.add(new Interactions("int",stacklist));
        stacklist = new ArrayList<>(){
            {
                add("double");
            }
        };
        interactions.add(new Interactions("double",stacklist));
        stacklist = new ArrayList<>(){
            {
                add("char");
            }
        };
        interactions.add(new Interactions("char",stacklist));
        stacklist = new ArrayList<>(){
            {
                add("bool");
            }
        };
        interactions.add(new Interactions("bool",stacklist));
        state = new State("TYPE",interactions);
        this.states.add(state);

        stacklist = new ArrayList<>(){
            {
                add("VAZIO");
            }
        };
        interactions = new ArrayList<>();
        interactions.add(new Interactions("id",stacklist));
        interactions.add(new Interactions("if",stacklist));
        interactions.add(new Interactions("switch",stacklist));
        interactions.add(new Interactions("while",stacklist));
        interactions.add(new Interactions("for",stacklist));
        interactions.add(new Interactions("print",stacklist));
        interactions.add(new Interactions("scan",stacklist));
        stacklist = new ArrayList<>(){
            {
                add("else");
                add("{");
                add("STM");
                add("}");
            }
        };
        interactions.add(new Interactions("else",stacklist));
        state = new State("ELSESTM",interactions);
        this.states.add(state);

        stacklist = new ArrayList<>(){
            {
                add("case:");
                add("CASEFACT");
                add("{");
                add("STM");
                add("}");
            }
        };
        interactions = new ArrayList<>();
        interactions.add(new Interactions("case:",stacklist));
        state = new State("CASETERM",interactions);
        this.states.add(state);

        stacklist = new ArrayList<>(){
            {
                add("id");
            }
        };
        interactions = new ArrayList<>();
        interactions.add(new Interactions("id",stacklist));
        stacklist = new ArrayList<>(){
            {
                add("Char");
            }
        };
        interactions.add(new Interactions("Char",stacklist));
        stacklist = new ArrayList<>(){
            {
                add("num");
            }
        };
        interactions.add(new Interactions("num",stacklist));
        state = new State("CASEFACT",interactions);
        this.states.add(state);

        stacklist = new ArrayList<>(){
            {
                add("id");
                add("FORCOUNT'");
            }
        };
        interactions = new ArrayList<>();
        interactions.add(new Interactions("id",stacklist));
        state = new State("FORCOUNT",interactions);
        this.states.add(state);

        stacklist = new ArrayList<>(){
            {
                add("--");
            }
        };
        interactions = new ArrayList<>();
        interactions.add(new Interactions("--",stacklist));
        stacklist = new ArrayList<>(){
            {
                add("++");
            }
        };
        interactions.add(new Interactions("++",stacklist));
        stacklist = new ArrayList<>(){
            {
                add("+");
                add("num");
            }
        };
        interactions.add(new Interactions("+",stacklist));
        stacklist = new ArrayList<>(){
            {
                add("-");
                add("num");
            }
        };
        interactions.add(new Interactions("-",stacklist));
        state = new State("FORCOUNT",interactions);
        this.states.add(state);

        stacklist = new ArrayList<>(){
            {
                add("ASSTERM");
            }
        };
        interactions = new ArrayList<>();
        interactions.add(new Interactions("int",stacklist));
        interactions.add(new Interactions("double",stacklist));
        interactions.add(new Interactions("bool",stacklist));
        interactions.add(new Interactions("char",stacklist));
        state = new State("FORATRIB",interactions);
        this.states.add(state);

        stacklist = new ArrayList<>(){
            {
                add("EXPT");
                add("EXP'");
            }
        };
        interactions = new ArrayList<>();
        interactions.add(new Interactions("id",stacklist));
        interactions.add(new Interactions("(",stacklist));
        interactions.add(new Interactions("num",stacklist));
        interactions.add(new Interactions("!",stacklist));
        interactions.add(new Interactions("!",stacklist));
        state = new State("EXP",interactions);
        this.states.add(state);

        stacklist = new ArrayList<>(){
            {
                add("VAZIO");
            }
        };
        interactions = new ArrayList<>();
        interactions.add(new Interactions(";",stacklist));
        interactions.add(new Interactions(")",stacklist));
        interactions.add(new Interactions(")",stacklist));
        stacklist = new ArrayList<>(){
            {
                add("OPB");
                add("EXPT");
                add("EXP'");
            }
        };
        state = new State("EXP'",interactions);
        this.states.add(state);


    }

    public void analize(){
        Stack <String> pilha;

    }



}
