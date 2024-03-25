package com.pzhu.mapper;

import com.pzhu.domain.Brand;
import com.pzhu.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    @Select("select * from tb_brand")
    @ResultMap("brandMap")
    List<Brand> selectAll();

    @Select("select * from tb_brand where id = #{id}")
    @ResultMap("brandMap")
    List<Brand> selectById(int id);

    List<Brand> selectByName(String name);

    /**
     * 多条件查询
     * @param brand
     * @return
     */
    //List<Brand> selectByCondition(@Param("status") int status,@Param("brandName") String brandName,@Param("companyName") String companyName);

    List<Brand> selectByCondition(Brand brand);

//    List<Brand> selectByCondition(Map map);


    /**
     * 单条件查询
     * @param brand
     * @return
     */
    List<Brand> selectByConditionSingl(Brand brand);

    /**
     * 添加一条记录
     * @param brand
     */
    void addBrand(Brand brand);

    /**
     * 修改一条记录
     * @param brand
     */
    void updateBrand(Brand brand);

    /**
     * 按id进行删除
     * @param id
     */
    @Select("delete from tb_brand where id = #{id}")
    @ResultMap("brandMap")
    void deleteById(int id);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);
}
