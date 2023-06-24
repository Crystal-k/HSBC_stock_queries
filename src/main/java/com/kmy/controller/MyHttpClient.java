package com.kmy.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kmy.pojo.JsonRootBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class MyHttpClient {

    public static ResponseEntity<JsonRootBean> client(String url, HttpMethod method){

        RestTemplate restTemplate = new RestTemplate();
        String json = restTemplate.getForObject(url, String.class);

        // 处理JSON数据，将其转换为JSON对象或进行其他操作
//        System.out.println("pre processing:" + json);
//        json = json.substring(21, json.length() - 2);
//        System.out.println("post processing:" + json);

//        JSONArray jsonArray = JSON.parseArray(json);
        // {"stat":["ÀÛ¼Æ:","2023-05-30ÖÁ2023-06-01","-0.40","-1.60%",24.5,25.13,645712,159936.98,"0.99%"],
        //  "code":"cn_002142",
        //  "hq":[["2023-06-01","24.66","24.62","0.02","0.08%","24.50","24.94","217186","53631.74","0.33%"],
        //        ["2023-05-31","24.83","24.60","-0.40","-1.60%","24.60","24.93","212361","52482.59","0.33%"],
        //        ["2023-05-30","25.02","25.00","-0.02","-0.08%","24.72","25.13","216165","53822.65","0.33%"]],
        //  "status":0}
//        JSONObject jsonObject = jsonArray.getJSONObject(0);
        // [["2023-06-01","24.66","24.62","0.02","0.08%","24.50","24.94","217186","53631.74","0.33%"],
        //  ["2023-05-31","24.83","24.60","-0.40","-1.60%","24.60","24.93","212361","52482.59","0.33%"],
        //  ["2023-05-30","25.02","25.00","-0.02","-0.08%","24.72","25.13","216165","53822.65","0.33%"]]
//        System.out.println(jsonObject.get("hq"));

        json = json.substring(22, json.length() - 3);
        JsonRootBean jsonRootBean = JSON.parseObject(json, JsonRootBean.class);

        return ResponseEntity.ok(jsonRootBean);
    }
}
