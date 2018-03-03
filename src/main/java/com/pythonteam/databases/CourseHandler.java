package com.pythonteam.databases;

import com.pythonteam.dao.CourseDao;
import com.pythonteam.models.Course;

import java.util.List;

public class CourseHandler implements BaseHandler<Course>  {
    @Override
    public List<Course> findAll() {
        return Database.getJdbi().withExtension(CourseDao.class, CourseDao::list);
    }

    @Override
    public Course findOne(int id) {
        return Database.getJdbi().withExtension(CourseDao.class, dao -> dao.findOne(id));
    }

    @Override
    public boolean delete(int id) {
        return Database.getJdbi().withExtension(CourseDao.class,dao -> dao.delete(id));
    }

    @Override
    public Course update(Course course) {
        return Database.getJdbi().withExtension(CourseDao.class, dao -> dao.update(course.getId(),course.getCourse(),course.getDescription(),course.getHours()));
    }

    @Override
    public boolean create(Course course) {
        return Database.getJdbi().withExtension(CourseDao.class, dao -> dao.create(course.getCourse(),course.getDescription(),course.getHours()));
    }

}
