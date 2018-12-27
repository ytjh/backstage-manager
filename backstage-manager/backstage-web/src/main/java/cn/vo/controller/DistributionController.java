package cn.vo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.vo.pojo.Module;
import cn.vo.pojo.RoleModule;
import cn.vo.service.IModuleService;
import cn.vo.service.IRoleModuleService;
import cn.vo.service.IRoleService;

@Controller
@RequestMapping("distribution")
public class DistributionController {
	
	@Autowired
	private IModuleService iModuleService;
	
	@Autowired
	private IRoleService iRoleService;
	
	@Autowired
	private IRoleModuleService iRoleModuleService;
	
	
	
	@GetMapping("list")
	public String list(Integer id,Model model){
		Map map =new HashMap();
		List<Module> list=iModuleService.getAll(map);
		model.addAttribute("module", list);
		StringBuffer buffer=new StringBuffer();
		List<RoleModule> roleModules=iRoleModuleService.getRoleId(id);
		if(list.size()>0){
			for(int i=0;i<roleModules.size();i++){
				buffer.append(roleModules.get(i).getmId());
			}
			
		}
		
		
		return "views/module/distribution";
	}

	@PostMapping("save")
	public String save(String[] moduleIds){
		for(int i=0;i<moduleIds.length;i++){
			System.out.println(moduleIds[i]);
		}
		
		return "";
	}
}
