package com.company;

public class Request {
    private Professor requester;
    private String discipline;
    private int group, pairs;
<<<<<<< HEAD

    Request(Professor requester, String disc, int group, int pairs) {
=======
    Request(Professor requester, String disc, int group, int pairs){
>>>>>>> origin/master
        this.requester = requester;
        this.discipline = disc;
        this.group = group;
        this.pairs = pairs;
    }
<<<<<<< HEAD

    String getRequester() {
        return this.requester.getName();
    }

    String getDiscipline() {
        return this.discipline;
    }

    int getGroup() {
        return this.group;
    }

    int getPairs() {
=======
    String getRequester(){
        return this.requester.getName();
    }
    String getDiscipline(){
        return this.discipline;
    }
    int getGroup(){
        return this.group;
    }
    int getPairs(){
>>>>>>> origin/master
        return this.pairs;
    }
}
