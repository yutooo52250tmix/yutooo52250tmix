package com.xpc.easyes.core.conditions;

import org.elasticsearch.action.search.SearchRequest;

/**
 * Lambda表达式的祖宗类
 * <p>
 * Copyright © 2021 xpc1024 All Rights Reserved
 **/
public abstract class Wrapper<T> {
    /**
     * 获取查询条件 待优化
     * @return 查询条件
     */
    protected abstract SearchRequest getSearchRequest();
}
