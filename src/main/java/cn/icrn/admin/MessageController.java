package cn.icrn.admin;

import cn.icrn.serv.model.Message;
import cn.icrn.serv.service.MessageService;
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
