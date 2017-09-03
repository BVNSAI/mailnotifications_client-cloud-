package com.vedams.service;

import java.sql.SQLException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.vedams.interf.IMail;
import com.vedams.repository.MailRepository;
import com.vedams.vo.MailEntity;

@Service
public class MailingService implements IMail {

  @Autowired
  private MailRepository mailrepository;

  @Override
  public MailEntity adddetails(MailEntity mail) throws SQLException {
    return mailrepository.saveAndFlush(mail);
  }

  @Override
  public List<MailEntity> getAll() {
    return mailrepository.findAll();
  }

  @Autowired
  private JavaMailSender javaMailSender;

  @Override
  public void send(String name, int id, String to, String cc, String bcc, String subject,
      String body) throws MessagingException {
    System.out.println("*********** IN SERVICE ");
    try {
      MimeMessage message = javaMailSender.createMimeMessage();

      MimeMessageHelper helper;
      helper = new MimeMessageHelper(message, true);
      helper.setTo(to);
      helper.setBcc(bcc);
      helper.setCc(cc);
      helper.setSubject(subject);
      helper.setText(body, true);
      javaMailSender.send(helper.getMimeMessage());
    } catch (MailException e) {

      e.printStackTrace();
    }

  }

}


