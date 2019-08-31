package com.jjcw.course.bean;

import com.jjcw.course.utils.BaseBean;

import java.util.Date;

/**
 * @Description 班级期数
 * @Author:liuxiaodong
 * @Date 2019/8/9 9:21
 */
public class ClassidInfo extends BaseBean {
    //班级编号
    private int classId;
    //培训内容
    private String trainContent;
    //培训日期
    private Date trainDate;
    //培训人数
    private int trainNumber;
    //培训地址
    private String trainAddress;
    //培训收到现金
    private double trainMakeCash;

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getTrainContent() {
        return trainContent;
    }

    public void setTrainContent(String trainContent) {
        this.trainContent = trainContent;
    }

    public Date getTrainDate() {
        return trainDate;
    }

    public void setTrainDate(Date trainDate) {
        this.trainDate = trainDate;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainAddress() {
        return trainAddress;
    }

    public void setTrainAddress(String trainAddress) {
        this.trainAddress = trainAddress;
    }

    public double getTrainMakeCash() {
        return trainMakeCash;
    }

    public void setTrainMakeCash(double trainMakeCash) {
        this.trainMakeCash = trainMakeCash;
    }

    @Override
    public String toString() {
        return "ClassidInfo{" +
                "classId=" + classId +
                ", trainContent='" + trainContent + '\'' +
                ", trainDate=" + trainDate +
                ", trainNumber=" + trainNumber +
                ", trainAddress='" + trainAddress + '\'' +
                ", trainMakeCash=" + trainMakeCash +
                '}';
    }
}
