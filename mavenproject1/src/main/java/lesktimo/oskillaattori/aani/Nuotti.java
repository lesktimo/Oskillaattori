package lesktimo.oskillaattori.aani;

public enum Nuotti {
    C4(-9),
    CSHARP4(-8),
    D4(-7),
    DSHARP4(-6),
    E4(-5),
    F4(-4),
    FSHARP4(-3),
    G4(-2),
    GSHARP4(-1),
    A4(0),
    ASHARP4(1),
    B4(2),
    C5(3),
    CSHARP5(4),
    D5(5),
    DSHARP5(6),
    E5(7),
    F5(8),
    FSHARP5(9),
    G5(10),
    GSHARP5(11),
    A5(12),
    ASHARP5(13),
    B5(14);

    private final int i;

    Nuotti(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }
}
