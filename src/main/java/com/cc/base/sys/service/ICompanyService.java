package com.cc.base.sys.service;

import com.cc.base.sys.bean.Company;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface ICompanyService {

    List<Company> queryCompany(Company company);

    PageInfo<Company> queryPage(int pageNum, int pageSize,Company company);

    /**
     * 根据父ID查询所有子节点
     * @param parentId
     * @return
     */
    List<Company> findCompanyByParentId(int parentId);

    void saveOrUpdate(Company company);

    void delete(int id);
}
