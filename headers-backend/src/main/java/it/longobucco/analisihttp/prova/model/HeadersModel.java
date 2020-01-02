package it.longobucco.analisihttp.prova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class HeadersModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Integer id;

  String url;
  String method;
  Integer validCode;
  String ok;
  @Size(max= 5000)
  String request;
  @Size(max= 5000)
  String response;
  String header1;
  String header2;
  String error;

  public HeadersModel(){}


  public HeadersModel(String url, Integer validCode, String ok , String method, String request, String response,String header1, String header2, String error){
    this.url = url;
    this.validCode = validCode;
    this.ok = ok;
    this.method = method;
    this.request= request;
    this.response = response;
    this.header1 = header1;
    this.header2 = header2;
    this.error = error;

  }

  public Integer getValidCode() {
    return validCode;
  }

  public void setValidCode(Integer validCode) {
    this.validCode = validCode;
  }

  public String getOk() {
    return ok;
  }

  public void setOk(String ok) {
    this.ok = ok;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public String getRequest() {
    return request;
  }

  public void setRequest(String request) {
    this.request = request;
  }

  public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }

  public String getHeader1() {
    return header1;
  }

  public void setHeader1(String header1) {
    this.header1 = header1;
  }

  public String getHeader2() {
    return header2;
  }

  public void setHeader2(String header2) {
    this.header2 = header2;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }
}
