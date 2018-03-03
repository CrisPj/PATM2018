package com.pythonteam.databases;

import com.pythonteam.dao.CourseTeacherDao;
import com.pythonteam.models.CourseTeacher;

import java.util.List;

public class CourseTeacherHandler implements BaseHandler<CourseTeacher>  {
    @Override
    public List<CourseTeacher> findAll() {
        return Database.getJdbi().withExtension(CourseTeacherDao.class, CourseTeacherDao::list);
    }

    @Override
    public CourseTeacher findOne(int id) {
        return null;
    }

    public CourseTeacher findOne(int id,int id2) {
        return Database.getJdbi().withExtension(CourseTeacherDao.class, dao -> dao.findOne(id,id2));
    }

    @Override
    public boolean delete(int id){
        return false;
    }


    public boolean delete(int id,int id2) {
        return Database.getJdbi().withExtension(CourseTeacherDao.class,dao -> dao.delete(id,id2));
    }

    @Override
    public CourseTeacher update(CourseTeacher courseTeacher) {
        return Database.getJdbi().withExtension(CourseTeacherDao.class, dao -> dao.update(courseTeacher.getIdCourse(),courseTeacher.getIdTeacher(),courseTeacher.getStartDate(),courseTeacher.getEndDate()));
    }

    @Override
    public boolean create(CourseTeacher courseTeacher) {
        return Database.getJdbi().withExtension(CourseTeacherDao.class, dao -> dao.create(courseTeacher.getIdCourse(),courseTeacher.getIdTeacher(),courseTeacher.getStartDate(),courseTeacher.getEndDate()));
    }

}
