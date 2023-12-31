package com.project.vipsCloneCoding.user.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.vipsCloneCoding.HomeController;
import com.project.vipsCloneCoding.user.dao.UserDAO;
import com.project.vipsCloneCoding.user.domain.UserVO;
import com.project.vipsCloneCoding.user.service.UserService;

@Controller
public class UserController {
  private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

  @Autowired
  UserService userService;
  @Autowired
  UserDAO userDAO;

  @RequestMapping(value = "/member/join", method = RequestMethod.GET)
  public String join() {
    return "vipsCloneCoding/member/join";
  }

  @RequestMapping(value = "/member/join", method = RequestMethod.POST)
  public String joinPost(@RequestParam Map<String, String> map) {

    Date tempDate = null;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    try {
      tempDate = formatter.parse(map.get("birth"));
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    String address = "우편번호 : " + map.get("postal-code") + "도로명 주소 : " + map.get("road-address")
        + "상세 주소 : " + map.get("detail-address");

    UserVO user = new UserVO(map.get("name"), map.get("phone_number"), map.get("user_id"),
        map.get("pw"), address, tempDate);
    userService.join(user);
    return "redirect:/member/login";
  }

  @RequestMapping(value = "/member/login", method = RequestMethod.GET)
  public String login() {

    return "vipsCloneCoding/member/login";
  }

  @RequestMapping(value = "/member/login", method = RequestMethod.POST)
  public String loginPost(@RequestParam Map<String, String> map, HttpSession sessoin) {
    UserVO user = new UserVO(map.get("user_id"), map.get("pw"));
    user = userService.login(user);
    sessoin.setAttribute("userId", user.getUserId());
    sessoin.setAttribute("member", user.getMember());
    sessoin.setAttribute("location", user.getLocation());
    return "vipsCloneCoding/main";
  }

  @RequestMapping(value = "/member/logout", method = RequestMethod.GET)
  public String logout(HttpSession sessoin) {
    sessoin.invalidate();
    return "vipsCloneCoding/main";
  }

  @RequestMapping(value = "/admin/adminPage", method = RequestMethod.GET)
  public String adminPage(HttpSession sessoin) {
    if (sessoin.getAttribute("member").equals("sub_admin")
        || sessoin.getAttribute("member").equals("admin")) {
      sessoin.setAttribute("subAdmin", userService.getAllSubAdmin());
      sessoin.setAttribute("lowAdmin", userService.getAllLowAdmin());
      return "/vipsCloneCoding/adminPage";
    } else {
      return "redirect:vipsCloneCoding/main";
    }
  }

  @RequestMapping(value = "/admin/deleteAdmin", method = RequestMethod.GET)
  public String adminPageDelete(@RequestParam(value = "adminChoice") int[] keys,
      HttpSession sessoin) {
    try {

      for (int i = 0; i < keys.length; i++) {
        userService.updateAdmin(keys[i], "null", "null");
      }
      sessoin.setAttribute("subAdmin", userService.getAllSubAdmin());
      sessoin.setAttribute("lowAdmin", userService.getAllLowAdmin());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "redirect:/admin/adminPage";
  }

  @RequestMapping(value = "/admin/addAdmin", method = RequestMethod.GET)
  public String adminPageAdd(@RequestParam Map<String, String> map, HttpSession sessoin) {
    sessoin.setAttribute("searchResult", userService.getUser(map.get("user_id")));
    sessoin.setAttribute("subAdmin", userService.getAllSubAdmin());
    sessoin.setAttribute("lowAdmin", userService.getAllLowAdmin());

    return "redirect:/admin/adminPage";
  }

  @RequestMapping(value = "/admin/addAdmin", method = RequestMethod.POST)
  public String adminPageAddPost(@RequestParam Map<String, String> map, HttpSession sessoin) {
    userService.updateAdmin(Integer.valueOf(map.get("id")), map.get("member"), map.get("location"));

    sessoin.setAttribute("subAdmin", userService.getAllSubAdmin());
    sessoin.setAttribute("lowAdmin", userService.getAllLowAdmin());

    return "redirect:/admin/adminPage";
  }

  @RequestMapping(value = "/member/idCheck", method = RequestMethod.GET)
  public String idCheck(@RequestParam Map<String, String> map, HttpSession sessoin) {
    try {
      sessoin.setAttribute("repeat", "중복입니다.");
      userDAO.get(map.get("user_id")).getUserId();
    } catch (Exception e) {
      sessoin.setAttribute("repeat", "사용가능합니다.");
      e.printStackTrace();
    }
    return "vipsCloneCoding/member/idCheck";
  }

}
