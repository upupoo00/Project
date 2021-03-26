package com.shopping.model;

public class Commodit {
    private int sid;
    private String name;
    private String level;
    private String remark;
    private double price;
    private String sort;
    private int count;
    private int uid;
    private String image;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "commodit{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", remark='" + remark + '\'' +
                ", price=" + price +
                ", sort='" + sort + '\'' +
                ", count=" + count +
                ", uid=" + uid +
                ", image='" + image + '\'' +
                '}';
    }
}
