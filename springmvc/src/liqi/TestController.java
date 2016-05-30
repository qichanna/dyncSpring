package liqi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

/**
 * Created by liqi on 2016/5/30.
 */
@Controller
@RequestMapping("/")
public class TestController {

    @RequestMapping(value = "/viewAll" )
    public ModelAndView viewAll(String name,String pwd){
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",name);
        mv.addObject("pwd",pwd);
        mv.setViewName("/hello.jsp");
        return mv;
    }
}
