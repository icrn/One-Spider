package cn.icrn.controller;

import cn.icrn.service.MessageService;
import cn.icrn.model.data.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Author: yankang
 * Date: 2017/8/17
 */
@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Message select(){
        return messageService.selectMessage(1);
    }

}
