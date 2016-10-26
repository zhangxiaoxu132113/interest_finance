package com.water.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/2.
 */
public class Test01 {

    private static String getConditionStr(Map<String,Object> conditionMap) {
        if (conditionMap == null) {
            throw new RuntimeException("传递的条件不能为空！");
        }

        StringBuffer condition = new StringBuffer();
        for (Map.Entry<String,Object> entry : conditionMap.entrySet()) {
            String conditionKey = entry.getKey();
            Object conditionValue = entry.getValue();

            System.out.println("key = " + conditionKey);
            System.out.println("value = " + conditionValue);
            if (conditionValue instanceof Integer || conditionValue instanceof Float
                    || conditionValue instanceof Double || conditionValue instanceof Long) {
                condition.append(conditionKey + " = " +conditionValue + " and ");
            } else if (conditionValue instanceof String) {
                condition.append(conditionKey + " = '" +conditionValue + "' and ");
            }

        }


        return condition.substring(0,condition.lastIndexOf("and"));
    }

    public static void main(String[] args) {

        Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("module",1);
        condition.put("salary",1.2);
        condition.put("stauts","haha");
        String conditionStr = getConditionStr(condition);
        System.out.println(conditionStr);
    }
}
