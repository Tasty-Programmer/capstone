package com.example.task;

import com.example.task.dto.CsvDTO;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Component
public class CsvReader {
    public List<CsvDTO> readCsv() throws FileNotFoundException {
        // csv 파일을 task 디렉토리 밑에 둡니다. FileReader를 사용해 값을 읽어옵니다.
        return new CsvToBeanBuilder<CsvDTO>(new FileReader("C:\\Users\\kimhu\\Desktop\\Spring_Alcol\\task\\술 이름 목록 - 시트1.csv"))
                .withType(CsvDTO.class)  // csv에서 읽어온 데이터의 타입, 명시한 DTO에 자동 할당됩니다.
                .build()
                .parse();
    }
}
