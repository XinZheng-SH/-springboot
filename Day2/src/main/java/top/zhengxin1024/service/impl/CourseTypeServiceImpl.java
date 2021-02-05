package top.zhengxin1024.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zhengxin1024.entity.CourseType;
import top.zhengxin1024.mapper.CourseTypeMapper;
import top.zhengxin1024.service.CourseTypeService;

@Service
@Transactional(rollbackFor = Exception.class)
public class CourseTypeServiceImpl extends ServiceImpl<CourseTypeMapper, CourseType> implements CourseTypeService {
}
