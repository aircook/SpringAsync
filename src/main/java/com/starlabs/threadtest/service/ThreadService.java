package com.starlabs.threadtest.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class ThreadService {

    @Autowired
    ThreadAsyncService threadAsyncService;

    /**
     * 5000까지 서로 른 ThreadPool을 사용해서
     * 불규칙적인 순서로 로그를 찍는걸 확인할 수 있다.
     * @param i
     */
    @Async
    public void asyncFor(int i) {
        log.info("async i = " + i);
    }


    /**
     * 잘못된 Async 사용사례
     * 같은 클래스 내 호출
     * @param i
     */
    public void innerMethodCall(int i) {
        innerMethodAsync(i);;
    }

    /**
     * 잘못된 Async 사용 사례
     * 같은 클래스 내 호출
     * @param i
     */
    @Async
    public void innerMethodAsync(int i){
        log.info("async i = " + i);
    }

    /**
     * ListenableFutere 성공 테스트
     * @param name
     * @throws InterruptedException
     */
    public void testNormal(String name) throws InterruptedException {
        log.info("서비스 호출");

        threadAsyncService.latelyGreeting(name).addCallback(
                (result) -> {
                    log.info("callback's result is {}",result);
                }, (e) ->{
                    log.error("Exception 발생!!!!!!");
                }
        );

        log.info("비동기 호출 이후");

        log.info("End of Service");

    }

    /**
     * ListenableFutere Exception 테스트
     * @param name
     * @throws InterruptedException
     */
    public void testExcpt(String name) throws InterruptedException {
        log.info("서비스 호출");
        threadAsyncService.latelyGreetingException(name).addCallback(
                (result) -> {
                    log.info("callback's result is {}",result);
                }, (e) ->{
                    log.error("Exception 발생!!!!!!");
                }
        );
        log.info("비동기 호출 이후");

        log.info("End of Service");
    }



    /**
     * completableFuter 테스트
     */
//    public testcptbFuter() throw Exception{
//        CompletableFuture.runasy
//
//    }
}
