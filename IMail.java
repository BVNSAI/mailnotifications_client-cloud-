package com.vedams.interf;

import java.sql.SQLException;
import java.util.List;

import javax.mail.MessagingException;

import com.vedams.vo.MailEntity;

public interface IMail {
  public MailEntity adddetails(MailEntity mail) throws SQLException;

  public List<MailEntity> getAll();

  public void send(String name, int id, String to, String cc, String bcc, String subject,
      String body) throws MessagingException;

}


