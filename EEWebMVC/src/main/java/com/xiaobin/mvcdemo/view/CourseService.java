package com.xiaobin.mvcdemo.view;

import com.xiaobin.mvcdemo.model.Course;
import org.springframework.stereotype.Service;


@Service
public interface CourseService {


	public Course getCoursebyId(Integer courseId);
	

	
	

}
