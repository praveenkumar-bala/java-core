package org.pk.reflection.example;

public class Entity {


    private int val;

    public String type;

    public Entity(int val, String type) {
        this.val = val;
        this.type = type;
    }

    private Entity(){
        this(0,"id");
    }

    @Override
    public String toString() {
        return "Entity{" +
                "val=" + val +
                ", type='" + type + '\'' +
                '}';
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private void calc(){
        System.out.println("Sample message");
    }
}
