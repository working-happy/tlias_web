package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* 部门管理
* */
@Slf4j       //记录日志
@RequestMapping("/depts")
@RestController         // @RestController注解，相当于@ResponseBody ＋ @Controller @Controller注解表示后，该类将会被spring管理，@ResponseBody注解标识后，响应数据可以是文本或者JSON数据类型
public class DeptController {

//    private static Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    /**
     * 查询部门数据
     * @return
     */
//    @RequestMapping(value = "/depts", method = RequestMethod.GET)   // 处理 HTTP 请求的方法, 比如 GET, PUT, POST, DELETE 以及 PATCH
    @GetMapping
    public Result list(){
        log.info("查询全部部门数据");

        List<Dept> deptList = deptService.list();

        return Result.success(deptList);
    }

    /**
     * 删除部门
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){     //接收路径参数
        log.info("根据id删除部门：{}", id);
        deptService.delete(id);
        return Result.success();
    }

    /**
     * 新增部门
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Dept dept){  //json数据封装到对象中
        log.info("新增部门：{}", dept);
        deptService.add(dept);
        return Result.success();
    }
}
