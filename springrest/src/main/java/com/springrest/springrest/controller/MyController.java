package com.springrest.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import com.springrest.springrest.entities.*;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {
	
	//private final static CourseService courseService = new CourseServiceImpl();
	
	@Autowired
	private CourseService courseService;
	
	//Display All Courses
	@GetMapping("/courses")
	public List<Course> getCourses() {
		return this.courseService.getCourses();
	}
		
	//Display Specific Course
	@GetMapping("/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return this.courseService.getCourse(Long.parseLong(id));
	}
	
	//Add Specific Course
	@PostMapping("/courses")
	public void addCourse(@RequestBody Course course) {
		this.courseService.putCourse(course);
	}
	
	//Update Specific Course With New Title Given As Input
	@PutMapping("/courses/{id}")
	public void updateCourse(@PathVariable String id, @RequestBody String title) {
		this.courseService.updateCourse(Long.parseLong(id), title);
	}
	
	//Remove Specific Course With Given Course Id
	
	/*@DeleteMapping("/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		this.courseService.deleteCourse(Long.parseLong(id));
	}*/
	
	//Below Method Can Be Implemented In Many Ways, It's Just An Example
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
		int flag = 1;
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
		} catch (Exception e) {
			flag = -1;
		}
		if(flag == 1)
		return new ResponseEntity<>(HttpStatus.OK);
		else
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}	
}


