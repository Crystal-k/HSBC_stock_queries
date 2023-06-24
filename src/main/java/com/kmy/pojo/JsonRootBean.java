package com.kmy.pojo;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class JsonRootBean {

    private int status;
    private List<List<String>> hq;
    private String code;
    private List<String> stat;
    public void setStatus(int status) {
        this.status = status;
    }
    public int getStatus() {
        return status;
    }

    public void setHq(List<List<String>> hq) {
        this.hq = hq;
    }
    public List<List<String>> getHq() {
        return hq;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }

    public void setStat(List<String> stat) {
        this.stat = stat;
    }
    public List<String> getStat() {
        return stat;
    }

}