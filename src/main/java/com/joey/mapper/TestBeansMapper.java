package com.joey.mapper;

import com.joey.po.TestBeans;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public abstract interface TestBeansMapper {

    @Select({"select * from test_beans_"})
    @ResultType(TestBeans.class)
    public abstract List<TestBeans> getAll();

    @Select({"select * from test_beans_ limit #{page},#{rows}"})
    @ResultType(TestBeans.class)
    public abstract List<TestBeans> datagrid(@Param("page") int page, @Param("rows") int rows);

    @Select({"select count(*) from test_beans_"})
    @ResultType(Long.class)
    public abstract Long getCounts();

    @Insert({"INSERT INTO test_beans_ (NAME_TEST_, SEX_TEST_,CREATE_DATETIME_TEST_,GONGZI_TEST_) VALUES (#{NAME_TEST_},#{SEX_TEST_},#{CREATE_DATETIME_TEST_},#{GONGZI_TEST_})"})
    @ResultType(Integer.class)
    public abstract Integer add(@Param("NAME_TEST_") String nameTest, @Param("SEX_TEST_") String sexTest, @Param("CREATE_DATETIME_TEST_") String createDatetimeTest, @Param("GONGZI_TEST_") double gongziTest);
}