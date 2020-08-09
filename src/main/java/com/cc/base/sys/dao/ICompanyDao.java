package com.cc.base.sys.dao;

import com.cc.base.sys.bean.Company;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ICompanyDao {

    List<Company> queryCompany(Company company);

    List<Company> findCompanyByParentId(int parentId);

    void update(Company company);

    void save(Company company);

    void delete(int id);

//    void update(Company company);

}
