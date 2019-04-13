package com.treabear.webservice.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * WebControllerTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class WebControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void 메인페이지_로딩() {

        // when
        // TestRestTemplate를 통해 "/"로 호출했을 때, main.hbs에 포함된 코드들이 있는지 확인
        String body = this.restTemplate.getForObject("/", String.class);

        System.out.println(body);

        // then
        assertThat(body).contains("스프링부트로 시작하는 웹 서비스");
    }
}