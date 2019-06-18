package com.example.demow.controller;

import com.example.demow.Service.TestService;
import com.example.demow.common.Respone;
import com.example.demow.entity.TbMessage;
import com.example.demow.mapper.TbMessageMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TbMessageMapper messageMapper;
    @Autowired
    private TestService testService;
    @GetMapping("/test1")
    public Respone test(){
        Respone respone=new Respone();
        PageHelper.startPage(1,2);
        List<TbMessage> tbMessages = messageMapper.selectByExample(null);
        System.out.println(messageMapper);
        System.out.println(testService);
        respone.setData(tbMessages);
        return respone;
    }


    @GetMapping("/test2")
    public Respone test2() throws IOException {
        Respone respone=new Respone();
        testService.test1();
        return respone;
    }

}
