package org.common;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.common.mapper.UserMapper;
import org.common.model.User;
import org.junit.Test;


public class MapperTest {

    @Test
    public void test() throws Exception {
        SqlSessionFactory sessionFactory = MybatisConfig.getSessionFactory();
        SqlSession session = sessionFactory.openSession();

        UserMapper userMapper = session.getMapper(UserMapper.class);

        User user = null;

//        // 新增测试
//        System.out.println("------------ 新增测试 ------------");
//        user = new User();
////        user.setId(1L);
//        user.setUserName("conanli");
//        user.setPassword("123456");
//        System.out.println("insert: " + userMapper.insert(user));
//
//        // 更新测试
//        System.out.println("------------ 更新测试 ------------");
//        user = new User();
//        user.setId(1L);
//        user.setPassword("111111");
//        System.out.println("update: " + userMapper.updateByPrimaryKeySelective(user));

        // 获取测试
        System.out.println("------------ 获取测试 ------------");
        System.out.println("user: " + userMapper.findAll());
        // 获取测试
        user = new User();
        user.setPassword("123456");
        System.out.println("------------ 获取测试 ------------");
        System.out.println("user: " + userMapper.findByCondition(user));

//        // 删除测试
//        System.out.println("------------ 删除测试 ------------");
//        System.out.println("delete: " + userMapper.deleteByPrimaryKey(1L));
//
//        // 存在测试
//        System.out.println("------------ 存在测试 ------------");
//        System.out.println("exist: " + userMapper.existById(1L));

        session.commit();
        session.close();
    }

}
