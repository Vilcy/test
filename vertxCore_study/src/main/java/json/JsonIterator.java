package json;

import io.vertx.core.json.JsonObject;

import java.util.Objects;

/**
 * @Author: zhangWs
 * @Date: 2021/12/31 16:56
 * @Classname: JsonIterator
 * @Description: TODO
 */
public class JsonIterator {

    public static void main(String[] args) {
        JsonObject jsonObject = new JsonObject()
                .put("name","Lang")
                .put("email","lang.yu@hp.com")
                .put("age",34);

        //常用迭代(如果去掉copy会报错，foreach是里面使用的是迭代器，是快速失败的)
        jsonObject.copy().stream().filter(entry -> Objects.nonNull(entry.getValue()))
                .forEach(item->{
                    if ("name".equals(item.getKey())){
                        jsonObject.remove(item.getKey());
                    }
                });

    }
}
