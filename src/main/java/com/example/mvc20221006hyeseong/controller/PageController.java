package com.example.mvc20221006hyeseong.controller;

import com.example.mvc20221006hyeseong.dto.TestReqDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.model.IModel;

@Controller
public class PageController {

    @GetMapping("/test1") //page 주소
    public String test1(Model model){
        model.addAttribute("name","김준일");
        return "test_page1"; //경로 HTML test_page1
    }

    @GetMapping("/test2")
    public String test2(){
        System.out.println("test2");
        return "test/test_page2";
    }
    //모델로 쓰면 복잡하다.
    @GetMapping("/test3")
    public ModelAndView test3(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModel().put("test1data","이혜성");
        modelAndView.getModel().put("test2data","이혜성1");
        modelAndView.getModel().put("test3data","이혜성2");
        modelAndView.getModel().put("test4data","이혜성3");
        modelAndView.getModel().put("test5data","이혜성4");
        modelAndView.setViewName("test/test_page3");
        return modelAndView;
    }
    @ResponseBody //응답을 값으로 하겠다.
    @GetMapping("/test4")
    public String test4(){
        return "/test/test_page2";
    }
    //주소
   @GetMapping("test5")
  //이게 mvc
    public String test5(Model model,@RequestParam String str, @RequestParam String name){
       System.out.println(str);
       System.out.println(name);
       //데이터 전달  입력 할 수 있음
       model.addAttribute("data", str);
       model.addAttribute("name", name);
        return "test/test_page5";
   }
   //@RequestParam 써주는게 좋다
   //RequestParam  서버에다가 요청 주소? 전달 할 데이터
   //변수명이 같으면      변수명이 같으면  @RequestParamString strData sout strData 적어주고  Re퀘스트파람 없어도됨
   @GetMapping("test6")
   //이게 mvc
   public String test6(Model model,TestReqDto testReqDto){
       System.out.println(testReqDto);
       //데이터 전달  입력 할 수 있음

       model.addAttribute("data", testReqDto.getStr());
       model.addAttribute("name", testReqDto.getName());
       model.addAttribute("number", testReqDto.getNumber());
       return "test/test_page6";
   }

}
