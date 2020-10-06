package org.ww.edu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.ww.edu.bean.Teacher;
import org.ww.edu.service.TeacherService;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author ww
 * @since 2020-10-06
 */
@RestController
@RequestMapping("/edu/teacher")
public class TeacherController {

    //注入service
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/findAll")
    public List<Teacher> findAllTeacher(){
        List<Teacher> teacherList = teacherService.list(null);

        return teacherList;
    }
}

