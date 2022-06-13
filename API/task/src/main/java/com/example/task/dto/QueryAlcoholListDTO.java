package com.example.task.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter   // 해당 클래스에 있는 모든 필드의 get 메소드를 생성해줍니다 ex) getCurrentCount(); , getMatchCount();
@NoArgsConstructor   // noArgumentsConstructor  파라미터가 없는 생성자를 생성합니다. AllArgumentsConstructor를 생성하려면 필수로 생성시켜줘야합니다.
@AllArgsConstructor  // allArgumentsConstructor 해당 클래스에 있는 모든 필드를 파라미터로 받는 생성자를 생성합니다.
public class QueryAlcoholListDTO {    // openAPI로 값을 받아와 매핑시킬 Data Transfer Object 입니다. 받아온 값은 필드명에 맞춰 할당됩니다.
    private Integer currentCount;
    private Integer matchCount;
    private Integer page;
    private Integer perPage;
    private Integer totalCount;
    private List<QueryAlcoholListDTO.AlcoholInfoOpenAPI> data;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AlcoholInfoOpenAPI {
        public String 전통주명;
        public String 도수;
        public String 규격;
        public String 주원료;
        public String 제조사;
    }
}
