package com.study.architecture.builder.sub;


/**
 * 具体建造者
 * 持有对房子的引用
 */
public class WorkBuild   {
    Room room = new Room();
    private RoomParams params = new RoomParams();
    public WorkBuild makeWindow(String window) {
        params.window = window;
        return this;
    }

    public WorkBuild makeFllor(String floor) {
        params.floor = floor;
        return this;
    }

    /**
     * 真正构建房子
     * @return
     */
    public Room build() {
        room.apply(params);
        return room;
    }

    class RoomParams{
        public String window;
        public String floor;
    }
}
