package cn.itcast.ssm.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.itcast.ssm.annotation.MyLog;

/**
 * @author sam
 * @since 2017/7/13
 */
@Controller
@RequestMapping(value = "/index")
public class IndexController {

    @MyLog(requestUrl = "/index请求")
    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
