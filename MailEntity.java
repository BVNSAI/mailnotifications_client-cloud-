package com.vedams.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vedams.model.Mail;

@Entity
@Table(name = "mail")
public class MailEntity {

  @Id
  @Column(name = "EMPLOYEE_NAME")
  private String name;

  @Column(name = "EMPLOYEE_ID")
  private int id;

  @Column(name = "TO_MAIL")
  private String toMail;

  @Column(name = "CC")
  private String ccMail;

  @Column(name = "BCC")
  private String bccMail;

  @Column(name = "SUBJECT")
  private String subject;

  @Column(name = "CONTENT")
  private String content;

  public MailEntity() {}

  public MailEntity(String name, int id, String toMail, String ccMail, String bccMail,
      String subject, String content) {
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

  @Override
  public String toString() {
    return "Mail [toMail=" + toMail + "]";
  }

  public void convertFromValueObject(Mail mail) {
    this.name = mail.getName();
    this.id = mail.getId();
    this.toMail = mail.getToMail();
    this.ccMail = mail.getCcMail();
    this.bccMail = mail.getBccMail();
    this.subject = mail.getSubject();
    this.content = mail.getContent();
  }

  public void convertToValudObject(Mail mail) {
    mail.setName(name);
    mail.setId(id);
    mail.setToMail(toMail);
    mail.setCcMail(ccMail);
    mail.setBccMail(bccMail);
    mail.setSubject(subject);
    mail.setContent(content);
  }
}
