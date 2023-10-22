package oit.is.z2080.kaizi.janken.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z2080.kaizi.janken.model.Entry;

@Controller
public class JankenController {

  @Autowired
  private Entry room;

  @GetMapping("/janken/start")
  public String jankenStart(@RequestParam String player_hand, ModelMap model) {
    String[] hand = { "グー", "チョキ", "パー" };
    String[] result_list = { "あいこ", "勝ち", "負け" };
    String cpu_hand = hand[(int) (Math.random() * 3)];
    String result = result_list[0];

    if (player_hand.equals("グー")) {
      if (cpu_hand.equals("グー")) {
        result = result_list[0];
      } else if (cpu_hand.equals("チョキ")) {
        result = result_list[1];
      } else if (cpu_hand.equals("パー")) {
        result = result_list[2];
      }
    } else if (player_hand.equals("チョキ")) {
      if (cpu_hand.equals("グー")) {
        result = result_list[2];
      } else if (cpu_hand.equals("チョキ")) {
        result = result_list[0];
      } else if (cpu_hand.equals("パー")) {
        result = result_list[1];
      }
    } else if (player_hand.equals("パー")) {
      if (cpu_hand.equals("グー")) {
        result = result_list[1];
      } else if (cpu_hand.equals("チョキ")) {
        result = result_list[2];
      } else if (cpu_hand.equals("パー")) {
        result = result_list[0];
      }
    }

    model.addAttribute("cpu_hand", cpu_hand);
    model.addAttribute("player_hand", player_hand);
    model.addAttribute("result", result);

    return "janken.html";
  }

  @GetMapping("/janken")
  public String showLogin(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    this.room.addUser(loginUser);
    model.addAttribute("room", this.room);
    model.addAttribute("login_user", loginUser);

    return "janken.html";
  }

}
