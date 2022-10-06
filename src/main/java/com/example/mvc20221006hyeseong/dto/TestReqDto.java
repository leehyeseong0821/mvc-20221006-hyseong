package com.example.mvc20221006hyeseong.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data //게타 세타 다 포함
public class TestReqDto {
     private String str;
     private String name;
     private int number;


}
