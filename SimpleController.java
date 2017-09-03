package com.vedams.simplecontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vedams.interf.IMail;
import com.vedams.vo.MailEntity;

@Controller
public class SimpleController {

  private IMail mailSenderService;

  @Autowired
  public SimpleController(IMail mailSenderService) {
    this.mailSenderService = mailSenderService;
  }

  @RequestMapping(value = "hai", method = RequestMethod.GET)
  public String hello() {
    return "hello";
  }

  @RequestMapping(value = "recipients", method = RequestMethod.GET)
  public String getrecipients(Model model) {
    List<MailEntity> recipients = mailSenderService.getAll();
    model.addAttribute("recipients", recipients);
    return "recipients_list";

  }

}