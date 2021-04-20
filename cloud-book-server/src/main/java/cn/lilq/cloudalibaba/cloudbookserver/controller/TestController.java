package cn.lilq.cloudalibaba.cloudbookserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: Li Liangquan
 * @date: 2021/4/18 16:21
 */
@RefreshScope
@RestController
public class TestController {

    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string) {
        return string;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String test(){
        return "hello world";
    }


    @Value("${abc.test}")
    public String name;
    @RequestMapping(value = "/name",method = RequestMethod.GET)
    public String name(){
        return '-'+name+'-';
    }

}

