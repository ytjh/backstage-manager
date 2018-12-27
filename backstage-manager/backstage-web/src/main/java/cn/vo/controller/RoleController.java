package cn.vo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.vo.backstage.Utils.ListResult;
import cn.vo.backstage.Utils.PageUtils;
import cn.vo.pojo.Role;
import cn.vo.service.IRoleService;

@Controller
@RequestMapping("role")
public class RoleController {
	
	@Autowired
	private IRoleService roleService;
	
	
	@GetMapping("list")
	public String list(){
		return "views/role/roleList";
	}
	@GetMapping("/listJson")
	@ResponseBody
	public ListResult<Role> listJson(String name,Integer page, Integer limit){
		Map map=new HashMap<>();
		map.put("name", name);
		map.put("index", PageUtils.getPageIndex(page, limit));
		map.put("pageSize", PageUtils.getPageSize(page, limit));
		List<Role> list=roleService.getListQuery(map);
		ListResult<Role> result=new ListResult<>();
		result.setCode("0");
		result.setCount(Long.valueOf(roleService.count()));
		result.setMsg("");
		result.setData(list);
		return result;
	}
	@GetMapping("/deial")
	public String deial(Model model,Integer id){
		Role role=roleService.getById(id);
		model.addAttribute("deial", role);
		return "views/role/roleDeial";
	}
	@GetMapping("/add")
	public String add(){
		return "views/role/roleAdd";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute Role role){
		try {
			roleService.insert(role);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/role/list";
		}
		return "redirect:/role/list";
	}
	@GetMapping("/edit")
	public String edit(Model model,Integer id){
		Role role=roleService.getById(id);
		model.addAttribute("deial", role);
		return "views/role/roleEdit";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Role role){
		try {
			roleService.update(role);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/role/list";
		}
		return "redirect:/role/list";
	}
	@ResponseBody
	@GetMapping("/del")
	public String del(Integer id){
		try {
			roleService.delId(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "删除成功了";
	}

}
