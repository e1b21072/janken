package oit.is.z2080.kaizi.janken.controller;

import java.security.Principal;
import java.util.ArrayList;

import oit.is.z2080.kaizi.janken.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JankenController {

  @Autowired
    private UserMapper usermapper;

  @GetMapping("/jankengame")
  public String jankengame(@RequestParam String hand, ModelMap model, Principal prin) {
    Janken janken = new Janken();
    janken.setPlayer(hand);
    janken.setCpu();

    model.addAttribute("users", this.room.getUsers());
    model.addAttribute("player_hand", janken.getPlayer());
    model.addAttribute("cpu_hand", janken.getCpu());
    model.addAttribute("result",janken.jankenResult());

    return "janken.html";
  }

  @GetMapping("/janken")
  public String showLogin(ModelMap model) {
    ArrayList<User> users = usermapper.selectAllUsers();

    model.addAttribute("users", users);

    return "janken.html";
  }

}
