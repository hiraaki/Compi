public class Token {
    String type;
    String Value;

    public Token(String type, String value) {
        this.type = type;
        Value = value;
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
