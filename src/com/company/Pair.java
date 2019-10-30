package com.company;

public class Pair {
    private String day;
    private int hour;
    private int room;
    private int group;
    private String disc;
    private String prof;
    Pair(String day, int hour, int room, String disc, String prof, int group){
        this.day = day;
        this.hour = hour;
        this.room = room;
        this.disc = disc;
        this.prof = prof;
        this.group = group;
    }
    public void printPair(){
        System.out.println("День недели: " + day + ", пара №" + hour + ", ауд. №" + ", " + disc + "дисц.:" + disc + ", преп. " + prof);
    }

    public int getHour() {
        return hour;
    }

    public int getRoom() {
        return room;
    }

    public String getDay() {
        return day;
    }

    public String getDisc() {
        return disc;
    }

    public String getProf() {
        return prof;
    }
    public int getGroup(){
        return group;
    }
}
