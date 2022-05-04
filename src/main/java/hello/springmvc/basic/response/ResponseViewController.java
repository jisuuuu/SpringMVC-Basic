package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello!");
        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "hello!");
        return "response/hello";
    }
    //ResponseBody 하면 안댐! 왜냐 String을 HTTP BODY에 내용 콱 박아버림

    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello!");
    }
    // 추천하지 않음 Controller, View 논리 이름 같을 때 void로 해도 호출 가능
    // HTTP 메세지 바디를 처리하는 파라미터 없으면 논리 뷰 이름으로 사용 => 명시성 떨어져 추천 X
}
