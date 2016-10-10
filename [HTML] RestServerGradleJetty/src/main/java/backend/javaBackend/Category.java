package backend.javaBackend;

public enum Category {

    GENERAL,
    MHSSOS,
    KARDEX,
    ROUTINE,
    SILO;

    public String toString() {
        String base = super.toString();

        return base.charAt(0)+base.substring(1).toLowerCase();
    }

    public static void main(String[] args) {
        System.out.println(GENERAL);
    }
}
