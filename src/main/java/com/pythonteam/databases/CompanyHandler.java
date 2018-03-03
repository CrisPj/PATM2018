package com.pythonteam.databases;

import com.pythonteam.dao.CompanyDao;
import com.pythonteam.models.Company;

import java.util.List;

public class CompanyHandler implements BaseHandler<Company>  {
    @Override
    public List<Company> findAll() {
        return Database.getJdbi().withExtension(CompanyDao.class, CompanyDao::list);
    }

    @Override
    public Company findOne(int id) {
        return Database.getJdbi().withExtension(CompanyDao.class, dao -> dao.findOne(id));
    }

    @Override
    public boolean delete(int id) {
        return Database.getJdbi().withExtension(CompanyDao.class,dao -> dao.delete(id));
    }

    @Override
    public Company update(Company company) {
        return Database.getJdbi().withExtension(CompanyDao.class, dao -> dao.update(company.getId(),company.getCompany(),company.getAddress(), company.getDescription()));
    }

    @Override
    public boolean create(Company company) {
        return Database.getJdbi().withExtension(CompanyDao.class, dao -> dao.create(company.getCompany(),company.getAddress(), company.getDescription()));
    }

}
