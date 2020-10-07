package org.ww.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.ww.edu.bean.Teacher;
import org.ww.edu.bean.vo.TeacherQuery;
import org.ww.edu.mapper.TeacherMapper;
import org.ww.edu.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author ww
 * @since 2020-10-06
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    //多条件查询讲师列表
    @Override
    public IPage<Teacher> pageTeacherCondition(long current, long limit, TeacherQuery teacherQuery) {
        //创建分页对象
        Page<Teacher> page=new Page<>(current,limit);
        //构造条件
        QueryWrapper<Teacher> wrapper=new QueryWrapper<>();
        //将条件数据分别取出
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        //判断是否为空
        if(!StringUtils.isEmpty(name)){
            //模糊查询
            wrapper.like("name",name);
        }
        if(!StringUtils.isEmpty(level)){
            wrapper.eq("level",level);
        }
        if(!StringUtils.isEmpty(begin)){
            wrapper.ge("gmt_create",begin);
        }
        if(!StringUtils.isEmpty(end)){
            wrapper.le("gmt_create",end);
        }
        //降序
        wrapper.orderByDesc("gmt_create");
        //调用方法
        IPage<Teacher> teacherIPage = baseMapper.selectPage(page, wrapper);
        return teacherIPage;
    }

}
