package com.cc.base.sys.controller;

import com.cc.base.sys.bean.Company;
import com.cc.base.sys.service.ICompanyService;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private ICompanyService companyService;

    @GetMapping("/list")
    public PageInfo<Company> listCompany(int pageNum, int pageSize,Company company){
        System.out.println(company);
        return companyService.queryPage(pageNum,pageSize,company);
    }

    @GetMapping("/findCompanyByParentId")
    public List<Company> findCompanyByParentId(@RequestParam(value="parentId",defaultValue="0",required=true) int parentId){
        return companyService.findCompanyByParentId(parentId);
    }

    @PostMapping
    public Map<String,Object> saveOrUpdate(Company company) throws Exception{
        Map<String,Object> model = new HashMap<>();
        try{
            if(company != null){
                companyService.saveOrUpdate(company);
                model.put("success", true);
                model.put("msg","保存成功");
            }else{
                model.put("success",false);
                model.put("msg","所传入公司对象为空");
            }
        }catch (Exception e){
            model.put("success", false);
            model.put("msg","后台程序处理出错");
            throw new Exception(e);
        }
        return model;
    }

    @DeleteMapping
    public Map<String,Object> delete(int id)throws Exception{
        Map<String,Object> model = new HashMap<>();
        try{
            if(id > 0){
                companyService.delete(id);
            }else{
                model.put("success",false);
                model.put("msg","id为空");
            }
        }catch (Exception e){
            model.put("success", false);
            model.put("msg","后台程序处理出错");
            throw new Exception(e);
        }
        return model;
    }




}
