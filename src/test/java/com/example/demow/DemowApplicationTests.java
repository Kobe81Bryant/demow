package com.example.demow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemowApplicationTests {

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Test
    public void contextLoads() throws Exception {
        threadPoolTaskExecutor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("asd");
            }
        });
    }

    private Integer test() throws Exception {
        Integer i = 0;
        try {
            i = 1;
            i = 1 / 0;
        } catch (Exception e) {
            //i=2;
            throw new Exception(e.getMessage());
        } finally {
            System.out.println("fff");
            return 0;
        }

    }
}
