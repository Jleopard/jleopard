package com.leopardframework.core.session.sessionFactory;

import com.leopardframework.logging.log.Log;
import com.leopardframework.logging.log.LogFactory;
import com.leopardframework.util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2018, Chen_9g 陈刚 (80588183@qq.com).
 * <p>
 * DateTime 2018/4/8
 * <p>
 * A novice on the road, please give me a suggestion.
 * 众里寻他千百度，蓦然回首，那人却在，灯火阑珊处。
 * Find a way for success and not make excuses for failure.
 *
 *  辅助类 判断获取值并拼接sql...
 */
final class ArraysHelper {
private static final Log LOG=LogFactory.getLog(SessionDirectImpl.class);
    public static String getSql(Object[] values){
        if (ArrayUtil.isEmpty(values)){
            LOG.error(" 没有带参数...");
        }
        StringBuilder SQL=new StringBuilder();
        String sql;
            if (values.length > 1) {
                SQL.append("in").append("(");
                for (int i = 0; i < values.length; ++i) {
                    SQL.append("?").append(",");
                }
                SQL.deleteCharAt(SQL.length() - 1).append(")");
                sql = SQL.toString();
                /*for (int i = 0; i < values.length; ++i) {
                    pstm.setObject(i + 1, values[i]);
                }*/
            } else {
                SQL.append("=").append("?");
                sql = SQL.toString();
            }
        return sql;
    }
    public static List<String> toUpperCase(List<String> list){
        List<String> ls=new ArrayList<String>();
        for (String obj:list){
            ls.add(obj.toUpperCase());
        }
        return ls;
    }
}
