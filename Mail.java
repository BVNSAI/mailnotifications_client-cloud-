package com.vedams.model;

public class Mail {
  private String name;
  private int id;
  private String toMail;
  private String ccMail;
  private String bccMail;
  private String subject;
  private String content;

  public Mail() {}

  public Mail(String name, int id, String toMail, String ccMail, String bccMail, String subject,
      String content) {
    this.name = name;
    this.id = id;
    this.toMail = toMail;
    this.ccMail = ccMail;
    this.bccMail = bccMail;
    this.subject = subject;
    this.content = content;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getToMail() {
    return toMail;
  }

  public void setToMail(String toMail) {
    this.toMail = toMail;
  }

  public String getCcMail() {
    return ccMail;
  }

  public void setCcMail(String ccMail) {
    this.ccMail = ccMail;
  }

  public String getBccMail() {
    return bccMail;
  }

  public void setBccMail(String bccMail) {
    this.bccMail = bccMail;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


}
