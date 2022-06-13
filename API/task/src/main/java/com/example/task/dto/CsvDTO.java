package com.example.task.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CsvDTO {
    @CsvBindByName  // csv로 이 데이터를 받아올 것이라고 spring에게 알려주는 어노테이션입니다.
    private String 이름;
    @CsvBindByName
    private String 링크;
}
