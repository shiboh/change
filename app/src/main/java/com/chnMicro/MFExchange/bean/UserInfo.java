package com.chnMicro.MFExchange.bean;

public class UserInfo {
    @Override public String toString() {
        return "UserInfo{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", userLevel=" + userLevel +
                ", realName='" + realName + '\'' +
                ", idCard='" + idCard + '\'' +
                ", accountStatus=" + accountStatus +
                ", authLevel=" + authLevel +
                ", balance=" + balance +
                ", currentTotal=" + currentTotal +
                ", totalIncoming=" + totalIncoming +
                ", currentInvest=" + currentInvest +
                ", yearInvest=" + yearInvest +
                ", totalInvest=" + totalInvest +
                ", myMoney=" + myMoney +
                ", available='" + available + '\'' +
                ", totalReserv=" + totalReserv +
                ", lowestMoney=" + lowestMoney +
                ", loanStatus=" + loanStatus +
                ", userSession='" + userSession + '\'' +
                ", effctLogList=" + effctLogList +
                ", refereeId=" + refereeId +
                ", transSum=" + transSum +
                '}';
    }

    private String userId;
    private String username;
    private String phone;
    private String email;
    private int userLevel;            //1-非vip，2-vip
    private String realName;
    private String idCard;
    private int accountStatus;    //0-未设置提现密码，1-已设置提现密码，2-已绑定银行卡。 默认0
    private int authLevel;            //1-未实名，2-已实名
    private double balance;            //余额
    private double currentTotal;        //本月收益
    private double totalIncoming;    //累计收益
    private double currentInvest;    //本月投资
    private double yearInvest;        //本年投资
    private double totalInvest;        //累计投资
    private double myMoney;        //资产总计
    private String available;            //可用余额
    private double totalReserv;        //累计预约
    private int lowestMoney;    //用户的起投金额;
    private int loanStatus;        //用户是否有借款 1：无借款 2：有借款
    private String userSession;

    //-------红包相关
//	private int				isRedPaperVisible;			//是否显示红包
    private BonusEffctLog effctLogList;        //邀请好友生效列表
    private int refereeId;                        //邀请码
//	private int 			useMoneyed;				//是否使用红包
//	private double		useMoney;					//红包金额

    private double transSum;        //我的转让金额

    /**
     * 红包：
     * 是否显示根据 sixRedStatus 字段判断（如果是借款人，则所有红包信息不显示）：
     * 1（未开始）- 所有红包相关元素都不显示。
     * 2（进行中）- 都显示。
     * 0（已结束）- “如何获得红包”的按钮不显示，其余显示。
     */
//	private int 			redExpired;  				//redExpired（有效红包是否过期） 0:过期 1：可用
//	private int 			sixRedStatus;  		 	//sixRedStatus（600红包的活动状态）			0:结束 1：未开始 2：进行中
//	private int 			randomRedStatus;	//randomRedStatus（随机红包的活动状态） 	0:结束 1：未开始 2：进行中
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public int getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(int accountStatus) {
        this.accountStatus = accountStatus;
    }

    public int getAuthLevel() {
        return authLevel;
    }

    public void setAuthLevel(int authLevel) {
        this.authLevel = authLevel;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getCurrentInvest() {
        return currentInvest;
    }

    public void setCurrentInvest(double currentInvest) {
        this.currentInvest = currentInvest;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getUserSession() {
        return userSession;
    }

    public void setUserSession(String userSession) {
        this.userSession = userSession;
    }

    public double getYearInvest() {
        return yearInvest;
    }

    public void setYearInvest(double yearInvest) {
        this.yearInvest = yearInvest;
    }

    public double getTotalReserv() {
        return totalReserv;
    }

    public void setTotalReserv(double totalReserv) {
        this.totalReserv = totalReserv;
    }

    public double getTotalIncoming() {
        return totalIncoming;
    }

    public void setTotalIncoming(double totalIncoming) {
        this.totalIncoming = totalIncoming;
    }

    public double getTotalInvest() {
        return totalInvest;
    }

    public void setTotalInvest(double totalInvest) {
        this.totalInvest = totalInvest;
    }

    public int getLowestMoney() {
        return lowestMoney;
    }

    public void setLowestMoney(int lowestMoney) {
        this.lowestMoney = lowestMoney;
    }

    public int getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(int loanStatus) {
        this.loanStatus = loanStatus;
    }

    public double getCurrentTotal() {
        return currentTotal;
    }

    public void setCurrentTotal(double currentTotal) {
        this.currentTotal = currentTotal;
    }

    public BonusEffctLog getEffctLogList() {
        return effctLogList;
    }

    public void setEffctLogList(BonusEffctLog effctLogList) {
        this.effctLogList = effctLogList;
    }

    public int getRefereeId() {
        return refereeId;
    }

    public void setRefereeId(int refereeId) {
        this.refereeId = refereeId;
    }

    //	public int getSixRedStatus() {
//		return sixRedStatus;
//	}
//	public void setSixRedStatus(int sixRedStatus) {
//		this.sixRedStatus = sixRedStatus;
//	}
//	public int getRedExpired() {
//		return redExpired;
//	}
//	public void setRedExpired(int redExpired) {
//		this.redExpired = redExpired;
//	}
//	public int getRandomRedStatus() {
//		return randomRedStatus;
//	}
//	public void setRandomRedStatus(int randomRedStatus) {
//		this.randomRedStatus = randomRedStatus;
//	}
    public double getMyMoney() {
        return myMoney;
    }

    public void setMyMoney(double myMoney) {
        this.myMoney = myMoney;
    }

    public double getTransSum() {
        return transSum;
    }

    public void setTransSum(double transSum) {
        this.transSum = transSum;
    }


    //处理过的
    public boolean isRealName() {
        return 2 == authLevel ? true : false;
    }

}
