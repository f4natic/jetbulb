package test_task;

public enum RomanNumbers {
    I("I", 1),
    V("V", 5),
    X("X", 10),
    L("L", 50),
    C("C", 100),
    D("D", 500),
    M("M", 1000);

    private int value;
    private String name;

    RomanNumbers(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
