package cn.icrn.serv.service.impl;

import cn.icrn.serv.mapper.MessageMapper;
import cn.icrn.serv.model.Message;
import cn.icrn.serv.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Author: yankang
 * Date: 2017/8/17
 */
@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageMapper messageMapper;

    @Override
    public Message selectMessage(Integer id) {
        System.out.println("hello");
        System.out.println(messageMapper.messageMapper(id).toString());
        return messageMapper.messageMapper(id);
    }

}
