package com.example.xyy.test.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author yayu
 * @title: EntityTest
 * @description: TODO
 * @date 2020/12/4 11:38
 */
public class EntityTest {
    private static final ObjectMapper mapper=new ObjectMapper();
    public static Map<String,Object> getModifyContent(Object source, Object target) {
        Map<String,Object> modifies=new HashMap<>();
         /*
          process null problem, if all null means equal
          if only source is null means all modified
          if only target is null means nothing changed
         */
        if(null == source || null == target) {
            if(null==source&&null==target) return modifies;
            else if(null == target) return modifies;
            else {return mapper.convertValue(target, new TypeReference<Map<String,Object>>(){});}
        }
        // source and target must be same class type
        if(!Objects.equals(source.getClass().getName(), target.getClass().getName())){
            throw new ClassCastException("source and target are not same class type");
        }
        Map<String, Object> sourceMap= mapper.convertValue(source, new TypeReference<Map<String,Object>>(){});
        Map<String, Object> targetMap = mapper.convertValue(target, new TypeReference<Map<String,Object>>(){});
        sourceMap.forEach((k,v)->{
            Object targetValue=targetMap.get(k);
            if (!Objects.equals(v,targetValue)){modifies.put(k,targetValue);}
        });
        return modifies;
    }
}
