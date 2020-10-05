package cn.icrn.spider;

import cn.icrn.spider.bean.VideoInfo;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Author: yankang
 * Date: 2017/9/9
 */
@Service
public class Pipeline<T> {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void cacheVideoInfo(Map<String, T> map) {
        if (map != null) {
            for (String title : map.keySet()) {
                // TODO 性能可优化
                String value = JSONObject.toJSONString(map.get(title));
                redisTemplate.opsForValue().set(title, value);
                redisTemplate.expire(title, 3, TimeUnit.DAYS);
            }
        }
    }

    public T getCacheVideoInfo(String key, Class<T> clazz) {
        T info = null;
        if (key != null) {
            String cache = redisTemplate.opsForValue().get(key);
            info = JSONObject.parseObject(cache, clazz);
        }
        return info;
    }


}
