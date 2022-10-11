package com.example.mvc20221006hyeseong.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data //게타 세타 다 포함
public class TestReqDto1 {
     private String username;
     private String password;
     private String name;
     private String email;


}
