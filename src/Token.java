public class Token {
    String type;
    String Value;
    int Line;
    int Column;

    public Token(String type, String value,int Line, int Column) {
        this.type = type;
        this.Value = value;
        this.Line = Line;
        this.Column = Column;

    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}
