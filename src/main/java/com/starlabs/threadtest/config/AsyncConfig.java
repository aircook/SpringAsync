package com.starlabs.threadtest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Executable;
import java.util.concurrent.Executor;

/**
 * 사용해도 되고 안해도 될듯
 * yml에도 속성정의 해주자
 */
@Configuration
@EnableAsync
public class AsyncConfig {
    @Bean
    public Executor asyncThreadTaskExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(8);
        taskExecutor.setMaxPoolSize(8);
        taskExecutor.setThreadNamePrefix("donghyeon-pool");
        return taskExecutor;
    }
}
