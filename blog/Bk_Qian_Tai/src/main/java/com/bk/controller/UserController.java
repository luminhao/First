package com.bk.controller;

import java.io.File;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bk.dao.DynamicMapper;
import com.bk.dao.UserMapper;
import com.bk.entity.dynamic;
import com.bk.entity.users;
import com.bk.service.DynamicService;
import com.bk.service.UserService;
import com.bk.tool.Tool;

@Controller
public class UserController {
	@Autowired
	UserService userservice;
	@Autowired
	DynamicService dynamicService;
	/**
	 * 显示登录页面
	 * @return
	 */
	@RequestMapping("/login.action")
	public String login_view() {
		return "login";
	}
	/**
	 * 显示用户页面
	 * @return
	 */
	@RequestMapping("/user-view")
	public String user_view(Model model) {
		return "user";
	}
	/**
	 * 显示内联框架
	 * @param model
	 * @return
	 */
	@RequestMapping("/user-viewProfile")
	public String user_viewProfilw() {

		
		return "redirect:profile";
	}
	/**
	 * 修改用户
	 */
	@RequestMapping("edit-user")
	public String edit_user(Model model,MultipartFile file, users user,HttpSession session) {
		if (!file.isEmpty()) {
            String saveFileName = file.getOriginalFilename();
            File saveFile = new File("C:/bk-image/userimage/"+saveFileName);
            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdirs();
            }
            if(Tool.upload(saveFile, file)) {
            	user.setImage("bk-image/userimage/"+saveFileName);
            	if(userservice.update(user)) {
            		model.addAttribute("info", "修改成功");
            		session.setAttribute("user", userservice.selectUser(user.getUid()+""));
            	}else {
            		model.addAttribute("info", "修改失败");
            	}
            	System.out.println("上传成功");
            }else {
            	System.out.println("上传失败,有问题，需要检查");
            }                	
        }else { 
        	if(userservice.update(user)) {
        		model.addAttribute("info", "修改成功");
        		session.setAttribute("user", userservice.selectUser(user.getUid()+""));
        	}else {
        		model.addAttribute("info", "修改失败");
        	}
        }	
		return "profile";
	}
	/**
	 * 登录用户	
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("/login")
	public String login(@RequestParam Map<String, String> user,Model model,HttpSession session) {
		users users=userservice.login(user);
		if(users!=null) {			
			if(users.getIsnormal()==1) {
				model.addAttribute("info", "账户已过期");
				return "login";				
			}
			session.setAttribute("user",users );
			userservice.lastlogin(((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm")).format(new Date())).toString(), users.getUid()+"");
			return "redirect:index.action";
		}
		model.addAttribute("info", "用户名或密码错误");
		return "login";
	}	
	
	/**
	 * 退出登录
	 * @return
	 */
	@RequestMapping("exit-login")
	public String exit_login(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:index.action";
	}
	/**
	 * 显示注册页面
	 * @return
	 */
	@RequestMapping("/sign.action")
	public String sign_up_view() {
		return "sign";
	}	
	/**
	 * 注册用户
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("/sign")
	public String sign_up(users user,Model model) {
		user.setIsadmin(0);
		user.setDate(new Date());
		user.setLogdate("新注册用户");
		user.setNickname("请修改您的昵称");
		if(userservice.sign(user)) {
			model.addAttribute("info", "注册成功啦，请登录");
			return "login";
		}
		return "sign.action";
	}	

}
