package com.starlabs.threadtest.controller;


import com.starlabs.threadtest.service.ThreadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/thread")
@Slf4j
public class ThreadController {

    @Autowired
    ThreadService threadService;


    /**
     * 5000까지 서로 다른 ThreadPool을 사용해서
     *  불규칙적인 순서로 로그를 찍는걸 확인할 수 있다.
     */
    @GetMapping("/test1")
    public void test1(){
        for(int i =0; i < 5000; i++){
            threadService.asyncFor(i);
        }
    }

    /**
     * 동기로 작동하는 잘못된 Async 사용 사례
     * 동일 클래스 내부에 @ASync를 사용하는 경우
     */
    @GetMapping("/test2")
    public void test2(){
        for(int i =0; i < 5000; i++){
            threadService.innerMethodCall(i);
        }
    }

    /**
     * ListenableFutere 성공 테스트
     * @param name
     * @throws InterruptedException
     */
    @GetMapping(value = "/test")
    public void testNormal(@RequestParam String name) throws InterruptedException {
        threadService.testNormal(name);

    }

    /**
     * ListenableFutere Exception 테스트
     * @param name
     * @throws InterruptedException
     */
    @GetMapping(value = "/test/exception")
    public void testExcpt(@RequestParam String name) throws InterruptedException {
         threadService.testExcpt(name);
    }

    /**
     * 그냥 비동기 테스트
     * @throws InterruptedException
     */
    @GetMapping("/simpletest")
    public void logSimpleText() throws InterruptedException {
        log.info("컨트롤러 심플텍스트 호출");
        Thread.sleep(8000);
        log.info("컨트롤러 심플텍스트 출력");
    }


}
