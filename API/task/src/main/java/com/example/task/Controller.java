package com.example.task;

import com.example.task.dto.CsvDTO;
import com.example.task.dto.QueryAlcoholListDTO;
import com.example.task.dto.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController  // rest api 요청을 하는 controller 등록 어노테이션
@RequiredArgsConstructor  // 필드를 자동으로 주입해주는 어노테이션
public class Controller {
    private final ApiClient apiClient;  // ApiClient 의존성 주입
    private final CsvReader csvReader; // CsvReader 의존성 주입


    @GetMapping("/api")  // localhost:8080/api 로 요청
    public ResponseDTO get() throws FileNotFoundException {
        Map<String, String> imageInfo = new HashMap<>(); // csv에서 읽어온 데이터들을 map으로 저장하기 위한 틀
        QueryAlcoholListDTO alcoholList = apiClient.get("Infuser PiupwYl4E3qXUITudPuqSalNK8/yzD8jOUgFtMIZJkEB2CPsZaDBfae+UAU9MoNKBJLvaUxIlq5jY2WwzDmEeg==");
        List<CsvDTO> csvs = csvReader.readCsv();// csv에서 데이터를 읽어오는 메소드 호출
        for (CsvDTO csv : csvs) { // csv에서 가져온 데이터의 row의 개수만큼 반복되는 반복
            imageInfo.put(csv.get이름(), csv.get링크());
            // map에 key: 술 이름, value: 술 이미지 링크로 csv에서 가져온 row의 개수만큼 할당, csv에서 읽어온 데이터들을 map으로 저장해 가져오기 더 간편하도록 가공
        }

        List<ResponseDTO.AlcoholInfo> alcoholInfo = alcoholList.getData()   // 최종으로 반환할 술 세부 정보들, openAPI로 받아온 데이터들과 csv로 읽어온 데이터들을 합치는 과정입니다.
                .stream().map(data -> ResponseDTO.AlcoholInfo.builder()
                        .전통주명(data.get전통주명())
                        .도수(data.get도수())
                        .규격(data.get규격())
                        .주원료(data.get주원료())
                        .제조사(data.get제조사())
                        .링크(imageInfo.get(data.get전통주명()))
                        .build()
                ).toList();
        // 최종의 최종. 위는 전통주명, 도수 등이었고 여기선 currentCount와 같이 추가적인 정보들과 위에서 합쳤던 alcoholInfo를 사용해 DTO에 값을 할당합니다.
        return ResponseDTO.builder()
                .currentCount(alcoholList.getCurrentCount())
                .matchCount(alcoholList.getMatchCount())
                .page(alcoholList.getPage())
                .perPage(alcoholList.getPerPage())
                .totalCount(alcoholList.getTotalCount())
                .data(alcoholInfo)
                .build();
    }
}
