package com.javarush.repository;


import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface EntityRepository<T> {

    void create(Map<String, Object> map);

    List<T> getAll();

    void delete(T tableEntity);

    void save(T tableEntity);

    void update(T tableEntity);

    T findById(long id);

    T findByContent(String content) throws ParseException;

    List<T> findList(String sign);

}