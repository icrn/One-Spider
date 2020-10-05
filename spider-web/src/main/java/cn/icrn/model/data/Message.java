package cn.icrn.model.data;

/**
 * Author: yankang
 * Date: 2017/8/17
 */


public class Message {

    private Integer id;

    private String name;

    public Message(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
