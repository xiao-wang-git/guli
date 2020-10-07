package org.ww.edu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.ww.commonutils.R;
import org.ww.edu.bean.Teacher;
import org.ww.edu.bean.vo.TeacherQuery;
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
@Api(description = "教师管理")
public class TeacherController {

    //注入service
    @Autowired
    private TeacherService teacherService;

    //1 查询所有讲师信息
    @GetMapping("/findAll")
    @ApiOperation(value = "所有讲师列表")
    public R findAllTeacher(){
        List<Teacher> teacherList = teacherService.list(null);

        return R.ok().data("items",teacherList);
    }

    //2 逻辑删除讲师信息
    @DeleteMapping("{id}")
    @ApiOperation("逻辑删除讲师")
    public R deleteTeacherById(@PathVariable String id){
        boolean flag = teacherService.removeById(id);

        if(flag){
            return R.ok();
        }else{
            return R.error();
        }
    }

    //3 分页查询讲师列表
    @GetMapping("/pageTeacher/{current}/{limit}")
    @ApiOperation("分页查询讲师列表")
    public R pageTeacher(@PathVariable(value = "current") int current,
                         @PathVariable(value = "limit") int limit){
        //创建分页对象
        Page<Teacher> page=new Page<>(current,limit);
        //调用分页方法
        //调用方法的时候底层会将teacher的所有信息封装进page中
        teacherService.page(page,null);

        long total = page.getTotal();//总记录数
        List<Teacher> records = page.getRecords();//数据

        return R.ok().data("total",total).data("rows",records);
    }

    //4 分页多条件查询讲师列表
    @PostMapping("/pageTeacherCondition/{current}/{limit}")
    @ApiOperation("分页多条件查询讲师列表")
    public R pageTeacherCondition(@PathVariable long current, @PathVariable long limit,
                                  @RequestBody(required = false) TeacherQuery teacherQuery){
        //调用方法
        IPage<Teacher> teacherIPage = teacherService.pageTeacherCondition(current, limit, teacherQuery);
        long total = teacherIPage.getTotal();//总数
        List<Teacher> records = teacherIPage.getRecords();//数据
        return R.ok().data("total",total).data("records",records);

    }
}

