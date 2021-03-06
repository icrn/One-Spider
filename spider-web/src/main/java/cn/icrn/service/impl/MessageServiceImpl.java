package cn.icrn.service.impl;

import cn.icrn.model.mapper.MessageMapper;
import cn.icrn.model.data.Message;
import cn.icrn.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: yankang
 * Date: 2017/8/17
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public Message selectMessage(Integer id) {
        System.out.println("hello");
        System.out.println(messageMapper.messageMapper(id).toString());
        return messageMapper.messageMapper(id);
    }

}
