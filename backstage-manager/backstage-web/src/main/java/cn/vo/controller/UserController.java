package cn.vo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.vo.pojo.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("info")
	public String info(HttpServletRequest request){
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("USER");
		request.setAttribute("user", user);
		return "views/component/anim/info";
	}
}
