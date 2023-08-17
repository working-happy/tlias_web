package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                       // 注在类上，提供类的get、set、equals、hashCode、toString等方法
@NoArgsConstructor          // 注在类上，提供类的无参构造
@AllArgsConstructor         // 注在类上，提供类的全参构造
public class Result {
    private Integer code;   //响应码， 1 代表成功； 0 代表失败
    private String msg;     //响应信息 描述字符串
    private Object data;    //返回的数据
    public static Result success(){     // 增删改 成功响应
        return new Result(1, "success", null);
    }
    public static Result success(Object data){  // 查询，成功响应
        return new Result(1, "success", data);
    }
    public static Result error(String msg){     //失败响应
        return new Result(0, msg, null);
    }
}
