package com.vedams.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vedams.interf.IMail;
import com.vedams.model.Mail;
import com.vedams.vo.MailEntity;

@RestController
public class MailController {

  private IMail mailingService;

  @Autowired
  public MailController(IMail mailingService) {
    this.mailingService = mailingService;
  }

  @RequestMapping(value = "sendmail", method = RequestMethod.POST, consumes = "application/json")
  public void adddetails(@RequestBody Mail mail) {
    System.out.println("#####" + mail.getToMail());
    System.out.println("CONTROLLER " + mail.getCcMail());
    System.out.println("CONTROLLER " + mail.getBccMail());
    System.out.println("CONTROLLER " + mail.getSubject());
    System.out.println("CONTROLLER " + mail.getContent());

    MailEntity mailEntity = null;
    try {
      mailEntity = new MailEntity();
      mailEntity.convertFromValueObject(mail);
      mailingService.adddetails(mailEntity);
      String name = mail.getName();
      int id = mail.getId();
      String to = mail.getToMail();
      String cc = mail.getCcMail();
      String bcc = mail.getBccMail();
      String subject = mail.getSubject();
      String content = mail.getContent();
      mailingService.send(name, id, to, cc, bcc, subject, content);
    } catch (Exception ex) {
      System.out.println(ex.getStackTrace());
      System.out.println(ex);
    }
    mailEntity = null;

  }



}


