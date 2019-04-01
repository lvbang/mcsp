package cn.com.syscom.mysql.model;

public class FileMaint extends FileMaintKey {
    private Integer updatecode;

    private String codedefinition;

    private String filename;

    private String respcode;

    private String expirationdate;

    private String operator;

    public Integer getUpdatecode() {
        return updatecode;
    }

    public void setUpdatecode(Integer updatecode) {
        this.updatecode = updatecode;
    }

    public String getCodedefinition() {
        return codedefinition;
    }

    public void setCodedefinition(String codedefinition) {
        this.codedefinition = codedefinition == null ? null : codedefinition.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getRespcode() {
        return respcode;
    }

    public void setRespcode(String respcode) {
        this.respcode = respcode == null ? null : respcode.trim();
    }

    public String getExpirationdate() {
        return expirationdate;
    }

    public void setExpirationdate(String expirationdate) {
        this.expirationdate = expirationdate == null ? null : expirationdate.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }
}