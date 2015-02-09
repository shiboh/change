package com.chnMicro.MFExchange.bean;

import java.util.List;

public class BonusEffctLog {
    private double usedAmount;            //已使用的红包金额
    private double avaiAmout;                //已生效的红包金额
    private double notAvaiAmout;            //未生效的红包金额
    private int realNameNotInvest;    //已实名认证
    private int investCount;                //未生效的红包数
    private int refereeId;                    //邀请码
    private List<Friend> peopleList;        //已邀请好友

    public double getUsedAmount() {
        return usedAmount;
    }

    public void setUsedAmount(double usedAmount) {
        this.usedAmount = usedAmount;
    }

    public double getAvaiAmout() {
        return avaiAmout;
    }

    public void setAvaiAmout(double avaiAmout) {
        this.avaiAmout = avaiAmout;
    }

    public double getNotAvaiAmout() {
        return notAvaiAmout;
    }

    public void setNotAvaiAmout(double notAvaiAmout) {
        this.notAvaiAmout = notAvaiAmout;
    }

    public int getRealNameNotInvest() {
        return realNameNotInvest;
    }

    public void setRealNameNotInvest(int realNameNotInvest) {
        this.realNameNotInvest = realNameNotInvest;
    }

    public int getInvestCount() {
        return investCount;
    }

    public void setInvestCount(int investCount) {
        this.investCount = investCount;
    }

    public int getRefereeId() {
        return refereeId;
    }

    public void setRefereeId(int refereeId) {
        this.refereeId = refereeId;
    }

    public List<Friend> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<Friend> peopleList) {
        this.peopleList = peopleList;
    }

    public static class Friend {
        private String phone_Number;
        private int whetherInvest;
        private String realName;
        private int whetherRealname;        //0-没有实名

        public String getPhone_Number() {
            return phone_Number;
        }

        public void setPhone_Number(String phone_Number) {
            this.phone_Number = phone_Number;
        }

        public int getWhetherInvest() {
            return whetherInvest;
        }

        public void setWhetherInvest(int whetherInvest) {
            this.whetherInvest = whetherInvest;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public int getWhetherRealname() {
            return whetherRealname;
        }

        public void setWhetherRealname(int whetherRealname) {
            this.whetherRealname = whetherRealname;
        }
    }

}
