package cn.itcast.ssm.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.StringUtils;


@Controller
public class UserActoin {

//	@Autowired
//	UserService userService;
	
	//获取用户测试
	@RequestMapping("/queryUser")
	public String queryUser(Model model,int id) throws Exception{
		
		//调用service指定id的用户
//		User user = userService.findUserById(id);
//		model.addAttribute("user", user);
		
		return "queryUser";
	}
	@RequestMapping("/query")
	@ResponseBody
	public String queryUser1(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		//调用service指定id的用户
//		User user = userService.findUserById(id);
//		model.addAttribute("user", user);
		String origin = request.getHeader("Origin");
        if(!StringUtils.isNullOrEmpty(origin)) {
            response.setHeader("Access-Control-Allow-Origin", origin);
        }
 
        // 自适应所有自定义头
        String headers = request.getHeader("Access-Control-Request-Headers");
        if(!StringUtils.isNullOrEmpty(headers)) {
            response.setHeader("Access-Control-Allow-Headers", headers);
            response.setHeader("Access-Control-Expose-Headers", headers);
        }
 
        // 允许跨域的请求方法类型
        response.setHeader("Access-Control-Allow-Methods", "*");
        // 预检命令（OPTIONS）缓存时间，单位：秒
        response.setHeader("Access-Control-Max-Age", "3600");
        // 明确许可客户端发送Cookie，不允许删除字段即可
        response.setHeader("Access-Control-Allow-Credentials", "true");

		return "queryUser";
	}
}
