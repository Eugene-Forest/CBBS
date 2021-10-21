package org.eugeneforest.toolbox.common.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * Json工具类
 *
 * @author Eugene-Forest
 */
public class JsonUtil<T> {

    /**
     * jackJson 的 ObjectMapper对象，配置忽略未知的JSON字段
     */
    public static final ObjectMapper OBJECT_MAPPER=new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    /**
     * jackJson 的未配置的基础ObjectMapper对象
     */
    public static final ObjectMapper OBJECT_MAPPER_BASE=new ObjectMapper();

    /**
     * Json字符串转换成对象
     *
     */
    public static <T> T getObjFromJson(@NotNull String jsonString,@NotNull Class<T> clazz){
        if (jsonString==null || clazz==null){
            return null;
        }
        try {
            return OBJECT_MAPPER.readValue(jsonString, clazz);
        }catch (JsonProcessingException e){
            return null;
        }
    }

    /**
     * 对象转换成Json字符串
     *
     */
    public static <T> String getJsonFromObj(@NotNull T obj){
        if (obj ==null){
            return null;
        }
        try {
            return OBJECT_MAPPER.writeValueAsString(obj);
        }catch (JsonProcessingException e){
            return "{}";
        }
    }

    /**
     * map对象转换为实体对象
     */
    public static <T> T getObjFromMap(@NotNull Map map,@NotNull Class<T> clazz){
        if (map==null || clazz==null){
            return null;
        }
        try {
            return OBJECT_MAPPER.readValue(getJsonFromObj(map), clazz);
        } catch (JsonProcessingException e){
            return null;
        }
    }


    /**
     * 实体对象转化为map
     */
    public static <T> Map getMapFromObject(@NotNull T obj){
        if (obj==null){
            return null;
        }
        try {
            return OBJECT_MAPPER.readValue(getJsonFromObj(obj), Map.class);
        } catch (JsonProcessingException e){
            return null;
        }
    }


//    public static void main(String[] args) {
//        Map<String,String> aCar=new HashMap<>();
//        aCar.put("brand", "Eugene");
//        aCar.put("key", "value");
//        Car car=getObjFromMap(aCar, Car.class);
//        System.out.println(getJsonFromObj(car));
//        Map map=getMapFromObject(car);
//        System.out.println(map.get("brand"));
//    }


}
