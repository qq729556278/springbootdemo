package com.joey.service;

import com.joey.po.TestBeans;
import com.joey.utils.DataGrid;

import java.util.List;

public interface TestBeansService {

    public List getAll();

    public DataGrid datagrid(TestBeans testBeans);

    public boolean add(TestBeans testBeans);

}
