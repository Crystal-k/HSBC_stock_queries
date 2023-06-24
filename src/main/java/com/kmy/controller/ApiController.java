package com.kmy.controller;

import com.kmy.pojo.JsonRootBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "stock")
public class ApiController {

    @Autowired
    MyHttpClient httpClient;

    @GetMapping(value = "/code={code}/start={startDate}/end={endDate}")
    public ResponseEntity<JsonRootBean> getByCodeObject(@PathVariable String code, @PathVariable String startDate, @PathVariable String endDate) {
        StringBuilder sb = new StringBuilder("https://q.stock.sohu.com/hisHq?code=");
        sb.append(code).append("&start=").append(startDate).append("&end=").append(endDate).append("&stat=1&order=D&period=d&callback=historySearchHandler&rt=jsonp");
        String url = sb.toString();
        System.out.println("访问api:" + url);

        HttpMethod method = HttpMethod.GET;

        return httpClient.client(url, method);
    }


}
