package es.stackoverflow.com.questions484544;

public class TrueFalseTreeNodeData {
    protected final String value;
    protected boolean booleanValue;

    public TrueFalseTreeNodeData(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public boolean isBooleanValue() {
        return booleanValue;
    }

    public void setBooleanValue(boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    @Override
    public String toString() {
        return value + " = " + booleanValue;
    }
}
