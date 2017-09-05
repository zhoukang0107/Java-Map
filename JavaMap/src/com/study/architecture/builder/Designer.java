package com.study.architecture.builder;

/**
 * 设计者(指导者)
 *
 * 他肯定知道房屋怎么设计
 *
 * 他肯定对工人所具备的能力有所了解
 *
 */
public class Designer {

    public Room build(Build build){
        build.makeFllor();
        build.makeWindow();
        return build.build();
    }
}
