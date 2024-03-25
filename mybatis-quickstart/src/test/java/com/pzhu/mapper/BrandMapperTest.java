package com.pzhu.mapper;

import com.pzhu.domain.Brand;
import com.pzhu.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrandMapperTest {
    @Test
    public void testSelectAll() throws IOException {
        String resources = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //List<User> users = sqlSession.selectList("test.selectAll");
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectAll();

        sqlSession.close();
        System.out.println(brands);
    }

    @Test
    public void testSelectById() throws IOException {
        String resources = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //List<User> users = sqlSession.selectList("test.selectAll");
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectById(3);

        sqlSession.close();
        System.out.println(brands);
    }

    @Test
    public void testSelectByName() throws IOException {
        String name="松鼠";
        name = "%"+name+"%";

        String resources = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //List<User> users = sqlSession.selectList("test.selectAll");
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectByName(name);

        sqlSession.close();
        System.out.println(brands);
    }


    @Test
    public void testSelectByCondition() throws IOException {
        int status = 0;
        String brandName = "三只松鼠";
        String companyName = "松鼠";

        brandName = "%"+brandName+"%";
        companyName = "%"+companyName+"%";

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
//        brand.setCompanyName(companyName);
     /*   Map map = new HashMap();
        map.put("status",status);
        map.put("brandName",brandName);
        map.put("companyName",companyName);*/


        String resource="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

//        List<Brand> brands = brandMapper.selectByConditionn(status,brandName,companyName);
//        List<Brand> brands = brandMapper.selectByConditionn(brand);
        List<Brand> brands = brandMapper.selectByCondition(brand);
        sqlSession.close();

        System.out.println(brands);
    }

    @Test
    public void testSelectByConditionSingle() throws IOException {
        int status = 0;
        String brandName = "松鼠";
        String companyName = "松鼠";

        brandName = "%"+brandName+"%";
        companyName = "%"+companyName+"%";

        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setBrandName(brandName);
//        brand.setCompanyName(companyName);



        String resource="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = brandMapper.selectByConditionSingl(brand);
        sqlSession.close();

        System.out.println(brands);
    }

    @Test
    public void testAdd() throws IOException {
        int status = 0;
        String brandName = "松鼠";
        String companyName = "松鼠";
        String description = "真的很好吃";
        int ordered = 200;

        Brand brand = new Brand();
        brand.setOrdered(ordered);
        brand.setDescription(description);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setStatus(status);


        //获得SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获得SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获得代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        用代理对象调用add方法来做sql操作
        brandMapper.addBrand(brand);
        //手动提交事务
        sqlSession.commit();
        sqlSession.close();

        System.out.println(brand.getId());

        System.out.println("add success");

    }

    @Test
    public void testUpdate() throws IOException {
        int status = 0;
        String brandName = "卫龙辣条";
        String companyName = "卫龙";
        String description = "吃起来还行";
        int ordered = 15;
        int id = 10;

        Brand brand = new Brand();
//        brand.setOrdered(ordered);
        brand.setDescription(description);
        brand.setBrandName(brandName);
//        brand.setCompanyName(companyName);
//        brand.setStatus(status);
        brand.setId(id);


        //获得SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获得SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获得代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        用代理对象调用update方法来做sql操作
        brandMapper.updateBrand(brand);
        //手动提交事务
        sqlSession.commit();
        sqlSession.close();

        System.out.println("update success");

    }

    @Test
    public void testDeleteById() throws IOException {
        //获得SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获得SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获得代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        用代理对象调用update方法来做sql操作
        brandMapper.deleteById(10);
        //手动提交事务
        sqlSession.commit();
        sqlSession.close();

        System.out.println("delete success");
    }

    @Test
    public void testDeleteByIds() throws IOException {
        int[] ids ={11,12};

        //获得SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获得SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获得代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        用代理对象调用update方法来做sql操作
        brandMapper.deleteByIds(ids);
        //手动提交事务
        sqlSession.commit();
        sqlSession.close();

        System.out.println("delete success");
    }
}

