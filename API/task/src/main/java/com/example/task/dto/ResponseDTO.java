package com.example.task.dto;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDTO {
    private Integer currentCount;
    private Integer matchCount;
    private Integer page;
    private Integer perPage;
    private Integer totalCount;
    private List<AlcoholInfo> data;

    @Getter // 해당 클래스에 있는 모든 필드의 get 메소드를 생성해줍니다 ex) getCurrentCount(); , getMatchCount();
    @NoArgsConstructor  // noArgumentsConstructor  파라미터가 없는 생성자를 생성합니다. AllArgumentsConstructor를 생성하려면 필수로 생성시켜줘야합니다.
    @AllArgsConstructor // allArgumentsConstructor 해당 클래스에 있는 모든 필드를 파라미터로 받는 생성자를 생성합니다.
    @Builder  // java에서 생성자같이 사용할 수 있는 어노테이션입니다. 기존에 있던 생성자보다 유연하게 객체를 생성할 수 있기 때문에 이 어노테이션을 사용합니다.
    public static class AlcoholInfo {
        public String 전통주명;
        public String 도수;
        public String 규격;
        public String 주원료;
        public String 제조사;
        public String 링크;
    }
}
