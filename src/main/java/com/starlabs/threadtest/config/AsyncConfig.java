package com.starlabs.threadtest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Executable;
import java.util.concurrent.Executor;

/**
 * @Async 어노테이션을 사용해 메서드를 비동기로 호출할경우
 * ThreadPool을 명시적으로 선언하지 않으면 기본적으로 SimpleAyncTaskExecutor를 사용하는데
 * 각 비동기 호출마다 계속 새로운 쓰레드를 생성하므로 비효율적일 수 있다.
 * 비동기 호출 빈도에 따라서 설정을 하느냐 마느냐 할것같다.
 *
 * SpringBoot 2.0 이상이라면 Config를 작성하던지, yml을 수정하던지 둘 중 하나만 해도 적용된다.
 */
@Configuration
@EnableAsync
public class AsyncConfig {
    @Bean
    public Executor asyncThreadTaskExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        // 쓰레드풀일 해당 개수까지 기본적으로 생성한다. 처음 요청이 들어올때 PoolSize만큼 생성
        taskExecutor.setCorePoolSize(100);
        // Core스레드를 모두 사용중일때, 큐에 만들어 대기시킨다.
        taskExecutor.setQueueCapacity(5000);
        // 대기작업이 큐에 꽉 찰 경우, 풀을 해당계수까지 더 생성한다.
        taskExecutor.setMaxPoolSize(100);
        taskExecutor.setThreadNamePrefix("donghyeon-pool");
        return taskExecutor;
    }
}
