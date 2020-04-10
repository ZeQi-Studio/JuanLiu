package Servlet;

public class Student {
    public String username;
    public String name;
    public String thing;
    public int number;
    public Student(String username,String name,String thing,int number) {
        this.username=username;
        this.name=name;
        this.thing=thing;
        this.number=number;
    }
    public void setUserName(String Username) {
        username=Username;
    }
    public String getUserName() {
        return username;
    }
    public void setName(String smallName) {
        name=smallName;
    }
    public String getName(){
        return name;
    }
    public void setThing(String smallThing) {
        thing=smallThing;
    }
    public String getThing() {
        return thing;
    }
    public void setNumber(int smallNumber) {
        number=smallNumber;
    }
    public int getNumber() {
        return number;
    }
}