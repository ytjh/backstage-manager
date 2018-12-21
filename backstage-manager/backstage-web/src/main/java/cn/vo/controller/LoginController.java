package cn.vo.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import cn.vo.pojo.User;

@Controller
public class LoginController {

	@GetMapping("/index")
	public String index() {
		return "views/component/login";
	}

	@GetMapping("/sigin")
	public String sigin() {
		return "views/component/login";
	}
	@GetMapping("/tg")
	public String tg() {
		return "tg";
	}


	@PostMapping("/login")
	public String login(HttpServletRequest request) {
		String loginname = request.getParameter("loginName");
		String password = request.getParameter("password");
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginname, password);
		// 进行验证，这里可以捕获异常，然后返回对应信息
		try {
			subject.login(usernamePasswordToken);
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return "views/component/login";
		}
		return "views";
	}

	@GetMapping("views")
	public String views() {
		return "views";
	}

	@GetMapping("error")
	public String error() {
		 return "views/template/tips/404";
	}

	@GetMapping("logout")
	public String logout() {
		SecurityUtils.getSubject().logout();
		return "views/component/login";
	}

	@GetMapping("console")
	public String console() {
		return "views/home/console";
	}

}
