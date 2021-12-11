package std;

class StringArrayException extends Exception {
    private static final String DEFAUTL_DESCRIPTION
            = "Common error";
    public StringArrayException() {
        super(DEFAUTL_DESCRIPTION);
    }
    public StringArrayException(String string) {
        super(string); }
}
