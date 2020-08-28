package ru.geekbrains.java.homeworks;

import java.util.HashSet;
import java.util.Set;

public class BaseAuthService implements AuthService{


    private final Set<Record> records;

    public BaseAuthService(){
        records=new HashSet<>();
        records.add(new Record(1L, "Bars", "l1","p1"));
        records.add(new Record(2L, "Bax", "l2","p2"));
        records.add(new Record(3L, "Bruce", "l3","p3"));
        records.add(new Record(4L, "Bran", "l4","p4"));
    }
    public Set<Record> getRecords() {
        return records;
    }


    @Override
    public Record findRecord(String login, String password) {
        for (Record record: records){
            if( record.getLogin().equals(login)&& record.getPassword().equals(password)){
                return record;
            }
        }
        return null;
    }
    @Override
    public void addRecord (String name, String login, String password){
        records.add(new Record(records.size()+1, name, login, password));
    }
    @Override
    public boolean isLoginFree (String login) {
        for (Record record : records) {
            if (record.getLogin().equals(login)) {
                return false;
            }
            return true;
        }
        return true;
    }



    @Override
    public void start() {
        System.out.println("Сервис аутентификации запущен");
    }

    @Override
    public void stop() {
        System.out.println("Сервис аутентификации остановлен");
    }

}

