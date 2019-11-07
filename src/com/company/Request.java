package com.company;

public class Request {
    private Professor requester;
    private String discipline;
    private int group, pairs;

    Request(Professor requester, String disc, int group, int pairs) {
        this.requester = requester;
        this.discipline = disc;
        this.group = group;
        this.pairs = pairs;
    }

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
        return this.pairs;
    }
}
