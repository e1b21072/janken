package oit.is.z2080.kaizi.janken.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z2080.kaizi.janken.model.Janken;
import oit.is.z2080.kaizi.janken.model.Entry;

@Controller
public class JankenController {

  @Autowired
  private Entry room;

  @GetMapping("/jankengame")
  public String jankenStart(@RequestParam String player_hand, ModelMap model, Principal prin) {
    Janken janken = new Janken();
    janken.setPlayer(player_hand);
    janken.setCpu();

    model.addAttribute("users", this.room.getUsers());
    model.addAttribute("player_hand", janken.getPlayer());
    model.addAttribute("cpu_hand", janken.getCpu());
    model.addAttribute("result",janken.jankenResult());

    return "janken.html";
  }

}
