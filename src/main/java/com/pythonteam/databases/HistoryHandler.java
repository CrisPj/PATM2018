package com.pythonteam.databases;

import com.pythonteam.dao.HistoryDao;
import com.pythonteam.models.History;

import java.util.List;

public class HistoryHandler implements BaseHandler<History>  {
    @Override
    public List<History> findAll() {
        return Database.getJdbi().withExtension(HistoryDao.class, HistoryDao::list);
    }

    @Override
    public History findOne(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    public History findOne(int id,int id2) {
        return Database.getJdbi().withExtension(HistoryDao.class, dao -> dao.findOne(id,id2));
    }

    public boolean delete(int id,int id2) {
        return Database.getJdbi().withExtension(HistoryDao.class,dao -> dao.delete(id,id2));
    }

    @Override
    public History update(History history) {
        return Database.getJdbi().withExtension(HistoryDao.class, dao -> dao.update(history.getIdCourse(),history.getIdEmpleado(),history.getGrade()));
    }

    @Override
    public boolean create(History history) {
        return Database.getJdbi().withExtension(HistoryDao.class, dao -> dao.create(history.getIdCourse(),history.getIdEmpleado(),history.getGrade()));
    }

}
