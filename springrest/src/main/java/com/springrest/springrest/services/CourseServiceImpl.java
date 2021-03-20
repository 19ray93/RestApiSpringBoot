package com.springrest.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
	
	@Override
	public List<Course> getCourses() {
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
		return courseDao.getOne(courseId);
	}

	@Override
	public void putCourse(Course course) {
		courseDao.save(course);
	}

	@Override
	public void updateCourse(long id, String title) {
		Course temp = courseDao.getOne(id);
		String descriptionTemp = temp.getDescription();
		courseDao.save(new Course(id, title, descriptionTemp));
	}

	@Override
	public void deleteCourse(long id) {
		Course temp = courseDao.getOne(id);
		courseDao.delete(temp);
	}
}

//Following Lines Were Added Initially To Work With Static Data

	/*private List<Course> list;*/
	
	/*public CourseServiceImpl() {
		this.list = new ArrayList<>();
		list.add(new Course(1, "Java", "Rest API"));
		list.add(new Course(2, "Spring Boot", " Creating Rest API"));
	}*/
	
	/*@Override
	public List<Course> getCourses() {
		return this.list;
	}*/

	/*@Override
	public Course getCourse(long courseId) {
		Course c = null;
		for(Course course:this.list) {
			if(course.getId()==courseId) {
				c = course;
				break;
			}
		}
		return c;
	}*/
	
	/*@Override
	public void putCourse(Course course) {
		this.list.add(course);
	}*/

	/*@Override
	public void updateCourse(long id, String title) {
		for(Course c:this.list) {
			if(c.getId() == id) {
				c.setTitleString(title);
			}
		}
	}*/
	
	/*@Override
	public void deleteCourse(long id) {
		for(Course c:this.list) {
			if(c.getId()==id) {
				this.list.remove(c);
			}
		}
	}*/
	
	/*@Override
	public void deleteCourse(long courseId) {
		this.list = this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
	}*/
