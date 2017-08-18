package cn.icrn.serv.model;

/**
 * Author: yankang
 * Date: 2017/8/17
 */

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Message {

    private Integer id;

    private String name;

    public Message(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
