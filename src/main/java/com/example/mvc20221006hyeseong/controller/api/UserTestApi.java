package com.example.mvc20221006hyeseong.controller.api;

import com.example.mvc20221006hyeseong.dto.TestReqDto1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class UserTestApi {
    @ResponseBody
    @PostMapping("/api/test/user/param")
    public String addUserParam(@RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String name,
                               @RequestParam String email) {

          Map<String, String> map = new HashMap<String, String>();

          map.put("username", username);
          map.put("password", password);
          map.put("name",name);
          map.put("email",email);

        System.out.println("map:"+ map.toString());

         return map.toString();
    }
    @ResponseBody
    @PostMapping("/api/test/user/dto")
    public String addUserDto(TestReqDto1 testReqDto1) {

//        Map<String, String> map = new HashMap<String, String>();
//
//        map.put("username",testReqDto1.getUsername());
//        map.put("password", testReqDto1.getPassword());
//        map.put("name",testReqDto1.getName());
//        map.put("email",testReqDto1.getEmail());
//
//        System.out.println("map:"+ map.toString());

        return  testReqDto1.toString();
    }
    @ResponseBody
    @PostMapping("/api/test/user/json") //제이슨으로 받아올때 리퀘스트 바디 사용.
    public  Object addUserJSON(@RequestBody TestReqDto1 testReqDto1){
        List<Map<Integer,TestReqDto1>> list = new ArrayList<Map<Integer,TestReqDto1>>();

        Map<Integer,TestReqDto1>map = null;
        for(int i= 0;i<100;i++){
            if(i ==0 || i %10 ==0){
                map = new TreeMap<Integer, TestReqDto1>();
            }

            map.put(i+1, testReqDto1);

            if((i-9)%10 ==0){
                list.add(map);
            }
        }

        return list;
       //제이슨으로 줄때 object tostring 빼고입력.
    }


}
