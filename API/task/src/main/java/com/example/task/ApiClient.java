package com.example.task;

import com.example.task.dto.QueryAlcoholListDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component  // 의존성 주입을 하기 위해 컴포넌트로 등록 <- 컴포넌트 등록을 하게 되면 빈 등록이 되면서 다른 클래스에서 이 클래스를 주입받아 사용할 수 있게 됩니다.
@FeignClient(name = "feign", url = "http://api.odcloud.kr/api/15048755/v1/uddi:fec53d3a-2bef-4494-b50e-f4e566f403e0?page=1&perPage=100")
// name: 그냥 명시해놓았습니다. url: open api 호출을 할 때 요청을 보낼 url을 값으로 넣어줍니다.
public interface ApiClient {
    @RequestMapping(method = RequestMethod.GET) // HTTP METHOD GET으로 요청을 보낼 것이라고 명시해줍니다.
    QueryAlcoholListDTO get(@RequestHeader(value = "Authorization") String token);
    // 반환값이 ResponseDTO인 메소드, @RequestHeader로 Authorization: {token} 헤더를 설정해줍니다. {token} 에는 컨트롤러에서 파라미터 값으로 보낸 토큰 값이 적용됩니다.
}
