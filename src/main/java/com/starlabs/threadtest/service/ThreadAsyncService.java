package com.starlabs.threadtest.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
@Slf4j
public class ThreadAsyncService {

    /**
     * 비동기 서비스 5초 후 문자열 반환
     * @param name
     * @return
     * @throws InterruptedException
     */
    @Async
    public ListenableFuture<String> latelyGreeting(String name) throws InterruptedException{
        log.info("ListenableFuter Method 내부 시작");
        Thread.sleep(5000); // 5초
        log.info("ListenableFuter Method 내부 종료");
        return new AsyncResult<>("Lately Hello? " + name);
    }

    /**
     * 비동기 서비스 5초 후 Exception 반환
     * @param name
     * @return
     * @throws InterruptedException
     */
    @Async
    public ListenableFuture<String> latelyGreetingException(String name) throws InterruptedException{
        log.info("ListenableFuter Method 내부");
        Thread.sleep(5000); // 5초
        throw new InterruptedException();
    }
}
