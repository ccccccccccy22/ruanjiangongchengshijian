package com.example.demo.entiy;

public class BuyCar {
    private int id;
    private int goodid;
    private int custid;

    public BuyCar(int goodid, int custid) {
        this.goodid = goodid;
        this.custid = custid;
    }

    public int getId() {
        return id;
    }

    public int getGoodid() {
        return goodid;
    }

    public int getCustid() {
        return custid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGoodid(int goodid) {
        this.goodid = goodid;
    }

    public void setCustid(int custid) {
        this.custid = custid;
    }

    public BuyCar(){}

}
