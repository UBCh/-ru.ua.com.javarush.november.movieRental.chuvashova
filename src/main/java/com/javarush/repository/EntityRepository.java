package com.javarush.repository;


import java.util.List;
import java.util.Map;

public interface EntityRepository <T>{

    void create (Map<String,Object> map);



    void delete (T tableEntity);

     void save(T tableEntity);

    void update(T tableEntity);

    T findById(long id);


}