package com.pythonteam.dao;

import com.pythonteam.models.Company;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.ArrayList;

public interface CompanyDao {
    @SqlQuery("SELECT * FROM company")
    @RegisterBeanMapper(Company.class)
    ArrayList<Company> list();

    @SqlQuery("SELECT * FROM company where :id = id")
    @RegisterBeanMapper(Company.class)
    Company findOne(@Bind("id") int id);

    @SqlUpdate("INSERT INTO company(company, address, description) VALUES (:company, :address, :description);")
    boolean create(@Bind("company") String company, @Bind("adress") String address,@Bind("description") String description);

    @SqlUpdate("delete from company where id = :id")
    boolean delete(@Bind("id") int id);

    @SqlQuery("update company set company = :company, address = :address, description = :description where id = :id")
    @RegisterBeanMapper(Company.class)
    Company update(@Bind("id") int id, @Bind("company") String company, @Bind("adress") String address,@Bind("description") String description);


}
