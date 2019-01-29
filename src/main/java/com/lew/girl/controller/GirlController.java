package com.lew.girl.controller;

import com.lew.girl.domain.Girl;
import com.lew.girl.repository.GirlRepository;
import com.lew.girl.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;
    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        System.out.println("girlList");
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     * @return
     */
/*    @PostMapping(value = "/girls")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRepository.save(girl);
    }*/
    //通过表单验证 添加女生对象
    @PostMapping(value = "/girls")
    public Girl girlAdd(@Valid Girl girl,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }

        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        return girlRepository.save(girl);
    }
    /**
     * 通过ID查询一个女生
     * @param id
     * @return
     */

    @GetMapping(value = "/girls/{id}")
    public Girl findOne(@PathVariable("id") Integer id){
        return girlRepository.findById(id).orElse(null) ;  //老版本sp1.5 可以用.findOne()
    }

    //更新一个女生信息
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRepository.save(girl);
    }

    //删除一个女生
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
      girlRepository.deleteById(id);     //为啥不能直接delete(id)->新版本springboot2.0不能这样用
      }

      //通过年龄查询
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){

        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }
}
