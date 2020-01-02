package it.longobucco.analisihttp.prova.model.dto;

import org.springframework.stereotype.Component;

@Component
public class HeadersModelDto {

    String method;
    String url;
    String ok;
    Integer statusCode;
    String err;
    String respHeader1;
    String respHeader2;
    String path;

    public HeadersModelDto(){}

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }

    public String getRespHeader1() {
        return respHeader1;
    }

    public void setRespHeader1(String respHeader1) {
        this.respHeader1 = respHeader1;
    }

    public String getRespHeader2() {
        return respHeader2;
    }

    public void setRespHeader2(String respHeader2) {
        this.respHeader2 = respHeader2;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
