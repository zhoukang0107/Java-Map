package com.study.architecture.builder.sub;

public class SimpleBuiderClient {

    public static void main(String[] args){
        Room room =  new WorkBuild().makeWindow("window").makeFllor("floor").build();
        room.toString();
    }

}
