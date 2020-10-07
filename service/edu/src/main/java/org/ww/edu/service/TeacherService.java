package org.ww.edu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.ww.edu.bean.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import org.ww.edu.bean.vo.TeacherQuery;

import java.util.List;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author ww
 * @since 2020-10-06
 */
public interface TeacherService extends IService<Teacher> {
    //分页多条件查询讲师列表
    public IPage<Teacher> pageTeacherCondition(long current, long limit, TeacherQuery teacherQuery);
}
