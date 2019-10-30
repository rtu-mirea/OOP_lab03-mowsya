package com.company;

import java.util.ArrayList;
import java.util.Scanner;
/*
import java.io.IOException;
import java.io.FileWriter;*/

public class Timetable {
    static ArrayList<Professor> users = new ArrayList<>();
    static ArrayList<Request> requests = new ArrayList<>();
    static ArrayList<ArrayList<Pair>> pairs = new ArrayList<ArrayList<Pair>>();
    static int[][] vacRooms = new int[6][6];
    static Professor currentUser;
    int rooms, groups;

    public static void main(String[] args) {
        Timetable tt = new Timetable();
        int opt = -1;
        while (opt != 0) {
            opt = -1;
            System.out.println("Система автоматического составления расписания");
            System.out.println("1. Вход");
            System.out.println("2. Регистрация");
            System.out.println("3. Меню администратора");
            System.out.println("0. Выход из программы");
            Scanner in = new Scanner(System.in);
            try {
                opt = in.nextInt();
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка, повторите ввод");
                continue;
            }
            switch (opt) {
                case 1:
                    if (tt.logUser()) {
                        while (opt != 0) {
                            System.out.println("Здравствуйте, " + currentUser.getName() + "!");
                            System.out.println("1. Подача заявки");
                            System.out.println("2. Ваше расписание");
                            System.out.println("0. Выход в главное меню");
                            Scanner in1 = new Scanner(System.in);
                            opt = in1.nextInt();
                            switch (opt) {
                                case 1:
                                    System.out.println("Введите название дисциплины: ");
                                    Scanner inn = new Scanner(System.in);
                                    String disc = inn.nextLine();
                                    System.out.println("Введите группу: ");
                                    Scanner inn1 = new Scanner(System.in);
                                    int group = inn1.nextInt();
                                    System.out.println("Введите количество пар: ");
                                    Scanner inn2 = new Scanner(System.in);
                                    int pairs = inn2.nextInt();
                                    tt.addRequest(disc, group, pairs);
                                    continue;
                                case 2:

                                case 0:
                                    opt = -1;
                                    break;
                                default:
                                    System.out.println("Ошибка, повторите ввод");

                            }
                        }
                    }
                    continue;
                case 2:
                    System.out.println("Введите Ваше имя:");
                    Scanner in7 = new Scanner(System.in);
                    String name = in7.nextLine();
                    System.out.println("Введите Ваш логин:");
                    Scanner in8 = new Scanner(System.in);
                    String login = in8.nextLine();
                    System.out.println("Введите Ваш пароль:");
                    Scanner in9 = new Scanner(System.in);
                    String pass = in9.nextLine();
                    tt.addUser(name, login, pass);
                    continue;
                case 3:
                    System.out.println("Введите логин: ");
                    Scanner in2 = new Scanner(System.in);
                    login = in2.next();
                    System.out.println("Введите пароль: ");
                    Scanner in3 = new Scanner(System.in);
                    pass = in3.next();
                    if (login.equals("admin") && pass.equals("admin")) {
                        while (opt != 0) {
                            System.out.println("Здравствуйте, администратор!");
                            System.out.println("1. Указать количество аудиторий");
                            System.out.println("2. Указать количество групп");
                            System.out.println("0. Выход в главное меню");
                            Scanner in4 = new Scanner(System.in);
                            opt = in4.nextInt();
                            switch (opt) {
                                case 1:
                                    System.out.println("Введите количество аудиторий: ");
                                    Scanner in5 = new Scanner(System.in);
                                    int rooms = in5.nextInt();
                                    tt.setRooms(rooms);
                                    continue;
                                case 2:
                                    System.out.println("Введите количество групп: ");
                                    Scanner in6 = new Scanner(System.in);
                                    int groups = in6.nextInt();
                                    tt.setGroups(groups);
                                    continue;
                                case 0:
                                    break;

                            }
                        }
                    }
                    opt = -1;
                    continue;
                case 0:
                    return;
                default:
                    System.out.println("Ошибка, повторите ввод");

            }

            opt = -1;
        }
    }

    boolean logUser() {
        System.out.println("Введите логин и пароль:");
        Scanner in = new Scanner(System.in);
        String login = in.nextLine();
        Scanner in1 = new Scanner(System.in);
        String password = in1.nextLine();
        currentUser = findUser(login, password);
        if (currentUser == null) {
            return false;
        } else {
            return true;
        }
    }

    void addUser(String name, String login, String password) {
        if(findUser(login, password) != null){
            System.out.println("Пользователь уже зарегистрирован");
            return;
        }
        currentUser = new Professor(name, login, password);
        users.add(currentUser);
    }

    void addRequest(String disc, int group, int pairs) {
        Request r = new Request((Professor) currentUser, disc, group, pairs);
        requests.add(r);
    }

    /*void processRequests() {
        for(Request r : requests) {
            if (pairs.size() == 36) {
                System.out.println("Расписание заполнено!");
                return;
            }
            for (int i = 0; i < pairs.size(); i++) {
                if(pairs.get(i).isEmpty()){
                    pairs.get(i).add(new Pair(r.))
                }
                for (int j = 0; j < 6; j++) {
                    if
                    if(r.getDiscipline().equals(j.getDisc()) || r.getGroup() == j.getGroup() || r.getRequester().equals(j.getProf())){
                        j = new Pair(i,)
                    }
                }
            }
        }
    }*/

    Professor findUser(String login, String password) {
        for (Professor i : users) {
            if (i.getLogin().equals(login) && i.getPassword().equals(password)) {
                return i;
            }
        }
        return null;
    }

    void setRooms(int rooms) {
        this.rooms = rooms;
        for(int i = 0; i < vacRooms.length; i++){
            for(int j = 0; j < vacRooms[i].length; j++){
                vacRooms[i][j] = rooms;
            }
        }
    }

    void setGroups(int groups) {
        this.groups = groups;
    }

   /* void save() {
        FileWriter writer = null;
        try {
            writer = new FileWriter("users.txt");
        } catch (IOException e) {
        }
        for (User i : users) {
            String name = i.getName();
            String login = i.getLogin();
            String password = i.getPassword();
            try {
                writer.write(name + " " + login + " " + password + System.getProperty("line.separator"));
            } catch (IOException e) {
            }

        }
        try {
            writer.close();
        } catch (IOException e) {

        }
    }

    void load() {

    }*/

}
