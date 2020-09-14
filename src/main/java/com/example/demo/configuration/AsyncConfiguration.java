package com.example.demo.configuration;

import java.util.concurrent.Executor;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.instrument.async.LazyTraceExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

// Not using LazyTraceExecutor
@Configuration
@EnableAsync
public class AsyncConfiguration  {
	
	@Bean("threadPoolTaskExecutor")
    public TaskExecutor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);
        executor.setMaxPoolSize(1000);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setThreadNamePrefix("Async-");
        return executor;
    }
}



// Using LazyTraceExecutor
//@Configuration
//@EnableAsync
//public class AsyncConfiguration  {
//
//	@Autowired
//	private BeanFactory beanFactory;
//	
//	@Bean("threadPoolTaskExecutor")
//	public Executor getAsyncExecutor() {
//      ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//      executor.setCorePoolSize(20);
//      executor.setMaxPoolSize(1000);
//      executor.initialize();
//      executor.setWaitForTasksToCompleteOnShutdown(true);
//      executor.setThreadNamePrefix("Async-");
//      return new LazyTraceExecutor(beanFactory, executor);
//  }
//}