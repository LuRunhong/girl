package com.lew.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")        //类的注解 如果需要获得具体方法获得的结果，需要用两个结合请求 如
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;


/*
    @Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;*/
  /*  @RequestMapping(value ={"/say", "/hi"},method = RequestMethod.GET)  //方法的注解  通过localhost:8080/hello/say  即可返回方法中数据
        public String say(){
        return girlProperties.getCupSize();
    }
*/
/*
    @RequestMapping(value = "/{id}/say",method = RequestMethod.GET)
    public String say(@PathVariable("id") Integer id){                      //pathvariable 获取URL中的数据(id) 如果URL是  //hello/100/say  则返回100

        return "id: "+id;
//        return girlProperties.getCupSize();
    }
*/

    @RequestMapping(value = "/say",method = RequestMethod.GET)                 //= @GetMapping(Value = "/say")
    public String say(@RequestParam("id") Integer myId){                      //RequestParam 获取请求参数中的值  此时的Integer myId可以任意定义变量名  不必与id一样

       //  public String say(@RequestParam(value = "id",required = false,defaultValue = 0) Integer myId){     //此时即使不传id 也会默认返回0 ，id为非必须传参数

//http://localhost:8080/hello/say?id=100 此时返回id: 100
        return "id: "+myId;
//        return girlProperties.getCupSize();
    }

}

