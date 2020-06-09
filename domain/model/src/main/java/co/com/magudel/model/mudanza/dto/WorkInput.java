package co.com.magudel.model.mudanza.dto;

public class WorkInput {
    private String contentBase64;
    private String identification;

    public WorkInput(String contentBase64, String identification) {
        this.contentBase64 = contentBase64;
        this.identification = identification;
    }

    public String getContentBase64() {
        return contentBase64;
    }

    public void setContentBase64(String contentBase64) {
        this.contentBase64 = contentBase64;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }
}
