package com.example.demow.controller;

import com.example.demow.common.Respone;
import com.example.demow.entity.TbMessage;
import com.example.demow.mapper.TbMessageMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TbMessageMapper messageMapper;
    @GetMapping("/test1")
    public Respone test(){
        Respone respone=new Respone();
        PageHelper.startPage(1,2);
        List<TbMessage> tbMessages = messageMapper.selectByExample(null);
        respone.setData(tbMessages);
        return respone;
    }

}
