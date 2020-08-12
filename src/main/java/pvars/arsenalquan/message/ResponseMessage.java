package pvars.arsenalquan.message;

public class ResponseMessage {
    private String massage;

    public ResponseMessage(String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
