package cn.icrn.controller;

import cn.icrn.service.MessageService;
import cn.icrn.model.data.Message;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author: yankang
 * Date: 2017/8/17
 */
@Controller
@AllArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @GetMapping("/user")
    @ResponseBody
    public Message select(){
        return messageService.selectMessage(1);
    }

}
