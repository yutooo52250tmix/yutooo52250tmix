package com.xpc.easyes.core.conditions.interfaces;

import com.xpc.easyes.core.enums.FieldType;

import java.io.Serializable;

/**
 * 索引相关
 * <p>
 * Copyright © 2021 xpc1024 All Rights Reserved
 **/
public interface Index<Children, R> extends Serializable {
    /**
     * 设置索引名称
     *
     * @param indexName 索引名称
     * @return 泛型
     */
    Children indexName(String indexName);

    /**
     * 设置索引的分片数和副本数
     *
     * @param shards   分片数
     * @param replicas 副本数
     * @return 泛型
     */
    Children settings(Integer shards, Integer replicas);

    /**
     * 设置mapping信息
     *
     * @param column    列
     * @param fieldType es中的类型
     * @return 泛型
     */
    Children mapping(R column, FieldType fieldType);

    /**
     * 设置创建别名信息
     *
     * @param aliasName 别名
     * @return 泛型
     */
    Children createAlias(String aliasName);
}
