package cn.easyes.test.nested;

import cn.easyes.core.conditions.LambdaEsQueryWrapper;
import cn.easyes.core.toolkit.FieldUtils;
import cn.easyes.test.TestEasyEsApplication;
import cn.easyes.test.entity.Document;
import cn.easyes.test.entity.Faq;
import cn.easyes.test.entity.User;
import cn.easyes.test.mapper.DocumentMapper;
import org.elasticsearch.action.search.SearchResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * 嵌套测试
 * <p>
 * Copyright © 2022 xpc1024 All Rights Reserved
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestEasyEsApplication.class)
public class NestedTest {
    @Resource
    private DocumentMapper documentMapper;

    @Test
    public void testNestedMatch() {
        // 嵌套查询 查询内容匹配人才且嵌套数据中用户名匹配"用户1"的数据
        LambdaEsQueryWrapper<Document> wrapper = new LambdaEsQueryWrapper<>();
        wrapper.match(Document::getContent, "人才");
        // 其中嵌套类的字段名称获取我们提供了工具类FieldUtils.val帮助用户通过lambda函数式获取字段名称,当然如果不想用也可以直接传字符串
        wrapper.nestedMatch(Document::getUsers, FieldUtils.val(User::getUsername), "用户");
        List<Document> documents = documentMapper.selectList(wrapper);
        System.out.println(documents);
    }

    @Test
    public void testChildMatch() {
        // 父子类型匹配查询 查询内容匹配人才子文档中用户名匹配"用户"的数据  这里以父文档为document,子文档为faq为例
        LambdaEsQueryWrapper<Document> wrapper = new LambdaEsQueryWrapper<>();
        wrapper.match(Document::getContent, "人才");
        // 其中嵌套类的字段名称获取我们提供了工具类FieldUtils.val帮助用户通过lambda函数式获取字段名称,当然如果不想用也可以直接传字符串
        wrapper.hasChild("users", FieldUtils.val(User::getUsername), "用户");
        SearchResponse search = documentMapper.search(wrapper);
        System.out.println(search);
    }

    @Test
    public void testParentMatch() {
        // 父子类型匹配查询 查询父文档中包含技术的文档
        LambdaEsQueryWrapper<Faq> wrapper = new LambdaEsQueryWrapper<>();
        // 其中字段名称获取我们提供了工具类FieldUtils.val帮助用户通过lambda函数式获取字段名称,当然如果不想用也可以直接传字符串
        wrapper.hasParent("document", FieldUtils.val(Document::getContent), "技术");
//        SearchResponse search = faqMapper.search(wrapper);
//        System.out.println(search);
    }

}
