package com.beiyuan.note.controller;
//
//import com.beiyuan.note.common.openfeign.UserFeign;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
///**
// * @author: beiyuan
// * @date: 2022/12/3  11:39
// */
//@RestController
//@RequestMapping("/catesharing/note")
public class OpenFeginTest {
//
//    @Autowired
//    UserFeign userFeign;
//
//    @GetMapping("testSayhi")
//    public String testSayhi(){
//        return userFeign.sayhi();
//    }
//
//    @Autowired
//    DiscoveryClient discoveryClient;
//
//    @GetMapping("/findDiscovery")
//    public String findDiscovery(){
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-server");
//        System.out.println(instances.get(0).getHost());  //192.168.210.182
//        System.out.println(instances.get(0).getPort());  //8302
//        return "ok";
//    }
//
//    @GetMapping("testOne")
//    public String testOne(@RequestParam String pre){
//        return pre+userFeign.oneParam("oneParam");
//    }
}
