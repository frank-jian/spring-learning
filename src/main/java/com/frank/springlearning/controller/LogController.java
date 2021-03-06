package com.frank.springlearning.controller;

import com.alibaba.fastjson.JSON;
import com.frank.springlearning.factory.BeanFactoryAwareDemo;
import com.frank.springlearning.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jianweilin
 * @date 2018/7/31
 */
@RestController
@Slf4j
public class LogController {

    @Autowired
    private LogService logService;

    @Autowired
    private RegistryService registryService;

    @Autowired
    private InitService initService;

    @Autowired
    private AnnotationService annotationService;

    @Autowired
    private ContainerService containerService;

    @Autowired
    private BeanFactoryAwareDemo beanFactoryAwareDemo;

    @RequestMapping("/node/online")
    public String onlien(){
        logService.nodeOnline("test test");
        return "onlne";
    }

    @RequestMapping("/node/off")
    public String off(){
        return JSON.toJSONString(logService.nodeOff());
    }

    @RequestMapping("/node/route")
    public String route(){
        logService.createRoute();
        return "route";
    }

    @RequestMapping("/create/node")
    public String createNode(){
        logService.createRoute("Hello World!");
        return "create node";
    }

    @RequestMapping("/registry")
    public String registry(){
        registryService.registry();
        return "registry services";
    }

    @RequestMapping("/init")
    public String init(){
        return initService.getFilterPhone();
    }

    @RequestMapping("/annotation")
    public String annotation(){
        return annotationService.annotion();
    }

    @RequestMapping("/container")
    public String container(){
        return containerService.echo();
    }

    @RequestMapping("/beanFactoryAware")
    public String beanFactoryAware(){
        beanFactoryAwareDemo.println();
        return "success";
    }
}
