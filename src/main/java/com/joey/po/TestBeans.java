package com.joey.po;

import java.sql.Timestamp;

/**
 * Created by joey on 2017/7/19.
 */
public class TestBeans {
    private int page;
    private int rows;
    private String sort;
    private String order;

    private Integer ID_TEST_;
    private String NAME_TEST_;
    private String SEX_TEST_;
    private Timestamp CREATE_DATETIME_TEST_;
    private String CREATE_TIME_STR;
    private Double GONGZI_TEST_;

    public String getCREATE_TIME_STR() {
        return CREATE_TIME_STR;
    }

    public void setCREATE_TIME_STR(String CREATE_TIME_STR) {
        this.CREATE_TIME_STR = CREATE_TIME_STR;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getID_TEST_() {
        return ID_TEST_;
    }

    public void setID_TEST_(Integer ID_TEST_) {
        this.ID_TEST_ = ID_TEST_;
    }

    public String getNAME_TEST_() {
        return NAME_TEST_;
    }

    public void setNAME_TEST_(String NAME_TEST_) {
        this.NAME_TEST_ = NAME_TEST_;
    }

    public String getSEX_TEST_() {
        return SEX_TEST_;
    }

    public void setSEX_TEST_(String SEX_TEST_) {
        this.SEX_TEST_ = SEX_TEST_;
    }

    public Timestamp getCREATE_DATETIME_TEST_() {
        return CREATE_DATETIME_TEST_;
    }

    public void setCREATE_DATETIME_TEST_(Timestamp CREATE_DATETIME_TEST_) {
        this.CREATE_DATETIME_TEST_ = CREATE_DATETIME_TEST_;
    }

    public Double getGONGZI_TEST_() {
        return GONGZI_TEST_;
    }

    public void setGONGZI_TEST_(Double GONGZI_TEST_) {
        this.GONGZI_TEST_ = GONGZI_TEST_;
    }
}
