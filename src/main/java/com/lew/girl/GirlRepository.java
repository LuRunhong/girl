package com.lew.girl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//通过jpa生成数据库
public interface GirlRepository extends JpaRepository<Girl,Integer> {

    public List<Girl> findByAge(Integer age);
}
