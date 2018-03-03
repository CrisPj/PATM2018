package com.pythonteam.databases;

import com.pythonteam.dao.TeacherDao;
import com.pythonteam.models.Teacher;

import java.util.List;

public class TeacherHandler implements BaseHandler<Teacher>  {
    @Override
    public List<Teacher> findAll() {
        return Database.getJdbi().withExtension(TeacherDao.class, TeacherDao::list);
    }

    @Override
    public Teacher findOne(int id) {
        return Database.getJdbi().withExtension(TeacherDao.class, dao -> dao.findOne(id));
    }

    @Override
    public boolean delete(int id) {
        return Database.getJdbi().withExtension(TeacherDao.class,dao -> dao.delete(id));
    }

    @Override
    public Teacher update(Teacher teacher) {
        return Database.getJdbi().withExtension(TeacherDao.class, dao -> dao.update(teacher.getId(),teacher.getName()));
    }

    @Override
    public boolean create(Teacher teacher) {
        return Database.getJdbi().withExtension(TeacherDao.class, dao -> dao.create(teacher.getName()));
    }

}
