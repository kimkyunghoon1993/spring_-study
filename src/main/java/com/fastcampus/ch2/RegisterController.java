package com.fastcampus.ch2;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;

import javax.xml.crypto.Data;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // ctrl+shift+o 자동 import
public class RegisterController {

    @InitBinder
    public void toDate(WebDataBinder binder) {
        ConversionService conversionService = binder.getConversionService();
        System.out.println("conversionService" + conversionService);
        // SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        // binder.registerCustomEditor(Data.class, new CustomDateEditor(df, false));
        binder.registerCustomEditor(String[].class, "hobby", new StringArrayPropertyEditor("#"));
    }

    @RequestMapping(value = "/register/add", method = {RequestMethod.GET, RequestMethod.POST})
    // @RequestMapping("/register/add") // 신규회원 가입 화면
    // @GetMapping("/register/add")
    public String register() {
        return "registerForm"; // WEB-INF/views/registerForm.jsp
    }

    // @RequestMapping(value = "/register/save",method = RequestMethod.POST)
    @PostMapping("/register/save")
    public String save(User user, BindingResult result, Model m) throws Exception {
        System.out.println("result" + result);
        System.out.println("user" + user);
        // 1. 유효성 검사
        if (!isValid(user)) {
            String msg = URLEncoder.encode("id를 잘못 입력하셨습니다.", "utf-8");

            m.addAttribute("msg", msg);
            return "forward:/register/add";    // redirect 재요청
            // return "redirect:/register/add?msg=" + msg;    // URL재작성(rewriting)
        }

        // 2. DB에 신규회원 정보를 저장
        return "registerInfo";
    }

    private boolean isValid(User user) {

        return true;
    }
}
