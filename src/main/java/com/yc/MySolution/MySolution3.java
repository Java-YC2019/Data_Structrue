package com.yc.MySolution;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *2. Given a “flatten” dictionary object, whose keys are dot-separated.
 *  For example, { ‘A’: 1, ‘B.A’: 2, ‘B.B’: 3, ‘CC.D.E’: 4, ‘CC.D.F’: 5}.
 *  Implement a function to transform it to a “nested” dictionary object.
 *  In the above case, the nested version is like:
 *  {
 *   ‘A’: 1,
 *   ‘B’: {
 *     ‘A’: 2,
 *     ‘B’: 3
 *   },
 *   ‘CC’: {
 *     ‘D’: {
 *       ‘E’: 4,
 *       ‘F’: 5
 *     }
 *   }
 * }
 * It’s guaranteed that no keys in dictionary are prefixes of other keys.
 */
public class MySolution3 {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
        jsonObject.put("A", 1);
        jsonObject.put("B.A", 2);
//        jsonObject.put("B.B", 3);
        jsonObject.put("B.B.C", 7);
        jsonObject.put("CC.D.E", 4);
        jsonObject.put("CC.D.F.G", 6);
        jsonObject.put("CC.D.F.H", 6);
//        jsonObject.put("CC.D.F", 5);
//        jsonObject.put("CC.D.F", 5);
//        jsonObject.put("CC.D.F", 5);
//        jsonObject.put("CC.D.F", 5);

        System.out.println(jsonObject);

        JSONObject result = transform1(jsonObject);

        System.out.println(result);

    }

    //JSON格式  可以改成Map格式
    public static JSONObject transform1(JSONObject obj) {
        JSONObject repeat = new JSONObject(new LinkedHashMap<>());
        for (String s : obj.keySet()) {
            if (s.contains(".")) {
                String[] split = s.split("\\.");

                if (repeat.get(split[0]) == null) {
                    JSONObject value = new JSONObject(new LinkedHashMap<>());
                    repeat.put(split[0],value);
                }


                for (int i = 1; i < split.length; i++) {
                    JSONObject temp;
                    temp = repeat;
                    int k = 0;
                    while (k < i) {
                        temp = (JSONObject) temp.get(split[k]);
                        k++;
                    }
                    if (i == split.length - 1) {

                        temp.put(split[i], obj.get(s));

                    }else {
                        if (temp.get(split[i]) == null) {
                            JSONObject temp3 = new JSONObject(new LinkedHashMap<>());
                            temp.put(split[i],temp3);
                        }

                    }

                }
            }


        }
        JSONObject result = new JSONObject(new LinkedHashMap<>());
        for (String s : obj.keySet()) {
            if (s.contains(".")) {
                String[] split = s.split("\\.");
                String key1 = split[0];
                result.put(key1, repeat.get(key1));
            }else {
                result.put(s, obj.get(s));
            }
        }
        return result;
    }

    /**
     * 思路，相当于把springboot的properties转为yml
     * @param map
     * @return
     */
    public static Map<String,Object> transform(HashMap<String,Object> map) {
        //Object可以看作是一个Map，将里面包含“.”key拿出来判断，把改变的关系填到新创建的map里面，
        //再删除原来map里面重复的map，替换过去。
        HashMap<String, Object> repeat = new HashMap<>();
        for (String s : map.keySet()) {
            if (s.contains(".")) {
                String[] split = s.split("\\.");

                if (repeat.get(split[0]) == null) {
                    HashMap<String, Object> value = new HashMap<>();
                    repeat.put(split[0],value);
                }


                for (int i = 1; i < split.length; i++) {
                    HashMap<String, Object> temp;
                    temp = repeat;
                    int k = 0;
                    while (k < i) {
                        temp = (HashMap<String, Object>) temp.get(split[k]);
                        k++;
                    }
                    if (i == split.length - 1) {

                        temp.put(split[i], map.get(s));

                    }else {

                        HashMap<String, Object> temp3 = new HashMap<>();

                        temp.put(split[i],temp3);
                    }

                }
            }


        }
        System.out.println(repeat.toString());
        HashMap<String, Object> result = new HashMap<>();
        for (String s : map.keySet()) {
            if (!s.contains(".")) {
                result.put(s, map.get(s));

            }else {
                String[] split = s.split("\\.");
                String key1 = split[0];
                result.put(key1, repeat.get(key1));
            }
        }
        return result;
    }
}
