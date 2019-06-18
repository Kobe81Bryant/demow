package com.example.demow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class DemowApplicationTests {

    @Test
    public void contextLoads() throws Exception {
        Integer test = test();
        System.out.println(test);
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
