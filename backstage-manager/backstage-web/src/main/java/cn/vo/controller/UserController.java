package cn.vo.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.vo.backstage.Utils.ListResult;
import cn.vo.backstage.Utils.PageUtils;
import cn.vo.pojo.User;
import cn.vo.service.IUserService;
import io.swagger.models.auth.In;

@Controller
@RequestMapping("users")
public class UserController {
	
	@Autowired
	private IUserService iUserService;
	
	
	
	@GetMapping("/info")
	public String info(Model model,HttpServletRequest request){
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("USER");
		model.addAttribute("user", user);
		return "views/component/anim/info";
	}
	
	@GetMapping("/list")
	public String list(){
		return "views/user/userList";
	}
	@GetMapping("/listJson")
	@ResponseBody
	public ListResult<User> listJson(String username,Integer page, Integer limit){
		Map map=new HashMap<>();
		map.put("username", username);
		map.put("index", PageUtils.getPageIndex(page, limit));
		map.put("pageSize", PageUtils.getPageSize(page, limit));
		List<User> list=iUserService.getListQuery(map);
		ListResult<User> result=new ListResult<>();
		result.setCode("0");
		result.setCount(Long.valueOf(iUserService.getCount()));
		result.setMsg("");
		result.setData(list);
		return result;
	}

	@GetMapping("/deial")
	public String deial(Model model,Integer id){
		User user=iUserService.getById(id);
		model.addAttribute("deial", user);
		return "views/user/deial";
	}
	@GetMapping("/add")
	public String add(){
		return "views/user/userAdd";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute User user){
		try {
			user.setCreateTime(new Date());
			iUserService.insertUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/users/list";
		}
		return "redirect:/users/list";
	}
	@GetMapping("/edit")
	public String edit(Model model,Integer id){
		User user=iUserService.getById(id);
		model.addAttribute("deial", user);
		return "views/user/userEdit";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute User user){
		try {
			iUserService.updateId(user);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/users/list";
		}
		return "redirect:/users/list";
	}
	@ResponseBody
	@GetMapping("/del")
	public String del(Integer id){
		try {
			iUserService.delId(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "删除成功了";
	}
}
