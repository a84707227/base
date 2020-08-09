package com.cc.base.sys.bean;

import lombok.Data;

@Data
public class Company {
    private int id;
    private String code;
    private String name;
    private int parentId;
    private String status;
    private String isLeaf;
    private String remark;
    private int sort;
}
