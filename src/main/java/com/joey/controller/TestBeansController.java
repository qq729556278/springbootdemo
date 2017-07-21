package com.joey.controller;

import com.joey.po.TestBeans;
import com.joey.service.TestBeansService;
import com.joey.utils.DataGrid;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by joey on 2017/7/19.
 */
@Controller
@RequestMapping({"/testBeans"})
public class TestBeansController {

    @Autowired
    private TestBeansService testBeansService;

    @RequestMapping(value = "/getAll")
    public String getAll(HttpServletRequest request, ModelMap map) {
        List<TestBeans> list = this.testBeansService.getAll();
        int i = 0;
        for (TestBeans tb : list) {
            Timestamp ts = list.get(i).getCREATE_DATETIME_TEST_();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String tsstr = sdf.format(ts);
            list.get(i).setCREATE_TIME_STR(tsstr);
            i++;
        }
        map.addAttribute("list", JSONArray.fromObject(list));
        return "/index";
    }

    @RequestMapping(value = "/datagrid", method = RequestMethod.POST)
    @ResponseBody
    public DataGrid datagrid(TestBeans testBeans) {
        return this.testBeansService.datagrid(testBeans);
    }

    @RequestMapping(value = "/addTb", method = RequestMethod.POST)
    @ResponseBody
    public boolean addTb(TestBeans testBeans) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        testBeans.setCREATE_TIME_STR(sdf.format(date));
        return this.testBeansService.add(testBeans);
    }
}
