package cn.vo.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@ResponseBody
	public String login(HttpServletRequest request) {
		String loginname = request.getParameter("loginName");
		String password = request.getParameter("password");
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginname, password);
		Subject subject = SecurityUtils.getSubject();
		
		// 进行验证，这里可以捕获异常，然后返回对应信息
		try {
			subject.login(usernamePasswordToken);
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return "用户名或密码错误";
		}
		return "登录成功";
	}

	@GetMapping("views")
	public String views(HttpServletRequest request) {
		User user=(User) request.getSession().getAttribute("USER");
		if(user==null){
			return "redirect:/index";
		}
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
