package com.joey.service.impl;

import com.joey.mapper.TestBeansMapper;
import com.joey.po.TestBeans;
import com.joey.service.TestBeansService;
import com.joey.utils.DataGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by joey on 2017/7/19.
 */
@Service("testBeansService")
public class TestBeansServiceImpl implements TestBeansService {

    @Autowired
    private TestBeansMapper testBeansMapper;

    @Override
    public List getAll() {
        List list = this.testBeansMapper.getAll();
        return list;
    }

    @Override
    public DataGrid datagrid(TestBeans testBeans) {
        DataGrid dg = new DataGrid();
        int rows = testBeans.getPage() * testBeans.getRows();
        int page = (testBeans.getPage() - 1) * testBeans.getRows();
        List<TestBeans> tbList = this.testBeansMapper.datagrid(page, rows);
        int i = 0;
        for (TestBeans tb : tbList) {
            Timestamp ts = tb.getCREATE_DATETIME_TEST_();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String tsstr = sdf.format(ts);
            tbList.get(i).setCREATE_TIME_STR(tsstr);
            i++;
        }
        dg.setRows(tbList);
        dg.setTotal(this.testBeansMapper.getCounts());
        return dg;
    }

    @Override
    public boolean add(TestBeans testBeans) {
        int flag = this.testBeansMapper.add(testBeans.getNAME_TEST_(), testBeans.getSEX_TEST_(), testBeans.getCREATE_TIME_STR(), testBeans.getGONGZI_TEST_());
        return flag == 1;
    }
}
