package com.mustang.netty.schedul;

import org.springframework.stereotype.Component;

/**
 * @author Mustang Kong
 * @apiNote
 * @date 2021/8/13
 *
 * https://www.jianshu.com/p/0f68936393fd
 */
@Component("demoTask")
public class DemoTask {
    public void taskWithParams(String params) {
        System.out.println("执行有参示例任务：" + params);
    }

    public void taskNoParams() {
        System.out.println("执行无参示例任务");
    }
}
