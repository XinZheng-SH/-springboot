package top.zhengxin1024.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zhengxin1024.entity.CourseType;
import top.zhengxin1024.service.CourseTypeService;

@Controller
@RequestMapping("/courseType")
public class CourseTypeController {

    @Autowired
    private CourseTypeService courseTypeService ;


    /**
     * 访问课程类型输入界面
     */
    @GetMapping("/toInput")
    public String input() {
        return "courseType/input_course_type";
    }

    @ResponseBody
    @PostMapping(value="/create")
    public String create(CourseType courseType){
        boolean saveSuccess = courseTypeService.save(courseType);
        return saveSuccess ? "添加成功" : "添加失败";
    }


}
