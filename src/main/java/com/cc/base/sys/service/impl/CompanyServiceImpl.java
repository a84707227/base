package com.cc.base.sys.service.impl;

import com.cc.base.sys.bean.Company;
import com.cc.base.sys.dao.ICompanyDao;
import com.cc.base.sys.service.ICompanyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class CompanyServiceImpl implements ICompanyService {

    @Autowired
    private ICompanyDao companyDao;

    @Override
    public List<Company> queryCompany(Company company) {
        return companyDao.queryCompany(company);
    }

    @Override
    public PageInfo<Company> queryPage(int pageNum, int pageSize,Company company) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Company> pageInfo = new PageInfo<>(companyDao.queryCompany(company));
        return pageInfo;
    }

    @Override
    public List<Company> findCompanyByParentId(int parentId) {
        return companyDao.findCompanyByParentId(parentId);
    }

    @Override
    public void saveOrUpdate(Company company){
        if(company.getId() > 0){
            companyDao.update(company);
        }else{
            companyDao.save(company);
        }
    }

    @Override
    public void delete(int id) {
        companyDao.delete(id);
    }


}
