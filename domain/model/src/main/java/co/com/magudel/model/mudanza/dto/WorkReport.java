package co.com.magudel.model.mudanza.dto;

public class WorkReport {
    private String content;
    private String identification;

    public WorkReport(String content, String number) {
        this.content = content;
        this.identification = number;
    }

    public WorkReport() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }
}
