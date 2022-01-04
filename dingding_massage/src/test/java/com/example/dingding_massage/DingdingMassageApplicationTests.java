package com.example.dingding_massage;

import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class DingdingMassageApplicationTests {

    @Test
    void contextLoads() {

        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("name","zhngsan");
        objectObjectHashMap.put("date",new Date());
        System.out.println(objectObjectHashMap);

        System.out.println(new Date());

        String test="https://oapi.dingtalk.com/robot/send?access_token=021a6d53c8aa9ee34fbe1056b9679a857c30b150e208b41b4a72a539950c5a1c?secret=SEC1ff33ed5d541d9d4232e36f44b81d6d36d26742cb1d19acd1d87b59a1dcb8e79";
        String[] split = test.split("\\?");
        for (String s:split) {
            if (s.contains("=")){
                String[] split1 = s.split("=");
                if (split1.length>1){
                    System.out.println(split1[1]);
                }
            }else {
                System.out.println(s);
            }

        }
        System.out.println(Arrays.toString(split));
    }

    @Test
    public void test() {

        boolean temp=false;
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            for (int j = 5; j < 9; j++) {
                if (j == 7) {
                    temp=true;
                    break ;
                }
                System.out.println(j);
            }
            if (temp){
                continue;
            }
            for (int j = 9; j <15 ; j++) {
                System.out.println(j);
            }

        }
    }

    @Test
    public void listTest(){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <9 ; i++) {
            list.add(i);
        }

        System.out.println(Math.ceil(1.1));


        System.out.println(list);
        System.out.println(list.subList(6, 8));
    }

}
