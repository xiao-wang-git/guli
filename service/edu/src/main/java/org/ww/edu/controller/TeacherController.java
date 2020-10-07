package org.ww.edu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //1 查询所有讲师信息
    @GetMapping("/findAll")
    public List<Teacher> findAllTeacher(){
        List<Teacher> teacherList = teacherService.list(null);

        return teacherList;
    }

    //2 逻辑删除讲师信息
    @DeleteMapping("{id}")
    public boolean deleteTeacherById(@PathVariable String id){
        boolean flag = teacherService.removeById(id);
        return flag;
    }
}

