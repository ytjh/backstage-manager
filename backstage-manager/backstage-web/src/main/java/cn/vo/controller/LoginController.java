package cn.vo.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		SecurityUtils.getSubject().logout();
		return "views/component/login";
	}

	@GetMapping("/sigin")
	public String sigin() {
		return "views/component/login";
	}
	@GetMapping("/")
	public String redirect() {
		return "redirect:/index";
	}


	@PostMapping("/login")
	@ResponseBody
	public String login(HttpServletRequest request,HttpSession session) {
	     String code = (String) session.getAttribute("number");
	     System.out.println("获取 的 session ==="+ code);
		String loginname = request.getParameter("loginName");
		String password = request.getParameter("password");
		String vercode = request.getParameter("vercode");
		
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginname, password);
		Subject subject = SecurityUtils.getSubject();
		
		try {
			if(vercode==null||vercode.length()==0||!code.equalsIgnoreCase(vercode)){
				//return "验证码错误";
			}
		} catch (Exception e1) {
			//return "获取验证码失败！";
		}
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
	
	@GetMapping("req")
	public String req(){
		return "views/component/reg";
	}
	@GetMapping("forget")
	public String forget(){
		return "views/component/forget";
	}
	/**
	 * 生成验证码 start
	 * @param response
	 * @param session
	 * @throws IOException
	 */
	@GetMapping("/createImage")
    public void createImage(HttpServletResponse response,HttpSession session) throws IOException {
		
        BufferedImage image = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Random r = new Random();
        g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        g.fillRect(0, 0, 80, 20);
        //获取生成的验证码
        String code = getNumber();
        //绑定验证码
        session.setAttribute("number", code);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        g.drawString(code, 5, 25);
        //设置消息头
        response.setContentType("image/jpeg");
        OutputStream os = response.getOutputStream();
        System.out.println(session.getId()+"session 存储 后 查询结果 =="+ session.getAttribute("number"));
        ImageIO.write(image, "jpeg", os);
    }
    public String getNumber(){
        String str = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String code = "";
        for(int i= 0;i<4;i++){
            int index = (int)(Math.random()*str.length());
            code+=str.charAt(index);
        }
        return code;
    }
	//生辰验证码 end
	

}
