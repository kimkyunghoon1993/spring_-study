package com.fastcampus.ch2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
    @GetMapping("/list")
    public String list(HttpServletRequest request){
        if (!loginCheck(request))   // loginCheck 를 해서 login 하지 않았으면 /login/login 으로 이동
            return "redirect:/login/login?toURL="+request.getRequestURI();  // 로그인을 안했으면 로그인 화면으로 이동
        return "boardList"; // 로그인 했다면 boardList 로 이동
    }

    private boolean loginCheck(HttpServletRequest request){
        // 1. 세션을 얻어서
        HttpSession session = request.getSession();
        // 2. 세션에 id가 있는지 확인, 있으면 true 를 반환
        // if (session.getAttribute("id")!=null)
        //     return true;
        //     else
        //         return false;
        return session.getAttribute("id")!=null; // session에 id 가 null 이 아니면 true
    }
}
