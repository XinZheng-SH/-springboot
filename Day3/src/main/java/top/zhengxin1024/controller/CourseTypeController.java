package top.zhengxin1024.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.zhengxin1024.entity.CourseType;
import top.zhengxin1024.service.CourseTypeService;

import java.util.Map;

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

    /**
     * 创建新课程类型
     */
    @PostMapping(value="/create")
    public String create(CourseType courseType) {

        courseTypeService.save(courseType);

        return "redirect:/courseType/list";

    }

    @GetMapping("/list")
    public String list(Map<String, Object> map, @RequestParam(value="pageNo", required=false, defaultValue="1") String pageNoStr) {

        int pageNo = 1;

        //对 pageNo 的校验
        pageNo = Integer.parseInt(pageNoStr);
        if(pageNo < 1){
            pageNo = 1;
        }

        /*
         * 第一个参数：第几页;
         * 第二个参数：每页获取的条数.
         */
        Page<CourseType> page = new Page<>(pageNo,10);
        IPage<CourseType> iPage = courseTypeService.page(page,
                new LambdaQueryWrapper<CourseType>()
                        .orderByAsc(CourseType::getTypeId)
        );

        map.put("page", iPage);

        return "courseType/list_course_type";
    }

    @DeleteMapping(value="/remove/{typeId}")
    public String remove(@PathVariable("typeId") Integer typeId) {

        courseTypeService.removeById(typeId);

        return "redirect:/courseType/list";
    }
    @GetMapping(value="/preUpdate/{typeId}")
    public String preUpdate(@PathVariable("typeId") Integer typeId, Map<String, Object> map) {

        map.put("courseType", courseTypeService.getById(typeId));

        return "courseType/update_course_type";
    }

    @PutMapping(value="/update")
    public String update(CourseType courseType) {

        courseTypeService.updateById(courseType);

        return "redirect:/courseType/list";
    }

}
