package com.study.architecture.builder.sub;

/**
 * 产品
 */
public class Room {
    private String window;
    private String floor;

    /**
     * 隐藏构建的过程
     * @param param
     * @return
     */
    public Room apply(WorkBuild.RoomParams param){
        window = param.window;
        floor = param.floor;
        return this;
    }
}
