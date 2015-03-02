package com.chnMicro.MFExchange.bean;

/**
 * Created by Enel on 2015/3/2.
 * <p/>
 * 标的。
 * 兼容：微投资、
 */
public class Loan {
    private int loanId; // 项目Id
    private int apply_type;        //项目类型， （ProjectTypes中定义对应关系s）
    private int loanType; // 0：所有用户可投 1：vip专享标 2：手机用户专享标
    private String loanName; // 借款标题
    private String gradeIdType; // 信用等级
    private double goalMoney; // 借款金额
    private String interestRate; // 年利率
    private String repaymentMonth; // 还款期限（月）
    private double currentMomey; // 当前已投金额
    private double progress; // 进度
    private String guaranteeType; // 担保类型（1019--保险，1020--担保,1021--再担保，1022--VIP，1023--实地认证）
    private String province_name;    //实地认证地名

    private int isRecommend; // 是否是推荐标
    private int provideCompanyid; // 担保公司id

    private String item_label; // 1022-VIP标

    // 项目详情
    private int loan_id;    // 项目Id(项目详情接口返回的是这个)
    private String loanPurposeDesc; // 详情页面的标的名称
    private String currentTime; // 服务端当前时间，eg：2014-05-12 11:44:17
    private String loanLastday;    //投标截止时间
    private String cover; // 保障范围，eg：本金保障
    private String type_name; // 还款方式，eg："月付息到期还本"
    private String repaymentType;        // 还款方式, eg：1002-等额本息（银行）
    private String loan_purpose; // 借款信息（标题），eg:经营性借款(短期借款)
    private String description; // 借款信息（具体内容）
    private String realName; // 借款人真实姓名
    private String status; // 借款状态：0-申请中，1-担保审核通过，2-一审，3-二审，4-上架，5-满标，6-已申请还款，
    // 7-还款中，8-已完结，9-流标，10-逾期(上线/还款中/已结束/已申请还款)
    private String compact_id; // 合同id
    private String lender_type; // 是否是转债权, 1-转债权，0-非转债权
    private int parent_loan_id; // 转债权相关
    private int sumDays;        //类似repaymentMonth, 二者只有其一
    private int loanPurpose;    //借款用途
    private String danBaoUrl;        //担保函图片地址
    private int guarantee;        //安全保障中，1-显示信贷服务商；2-不显示信贷服务商

    //投标倒计时
    private int day;
    private int hour;
    private int minute;
    private int seconde;

    //微小宝
    private String uplinetime; //加入时间
    private String fullscaletime; //到期时间
    private String remainderMoney;        //可投余额
    private String persistentInv_range;        //投资范围
    private String persistentDiscription;        //产品介绍
    private String limitTop;            //微小宝额度上限
    private int deadlineType;      //微小宝 1: 项目期限按月 2：项目期限按天

    //微票宝
    private int secure_loan;            //1-固定期限， 2-不固定
    private int month_or_day;        //借款期限单位：1-月，2-天
    private String billEndDay;        //非固定期限时，“到期日”,格式为“2014-12-18”
    private String billStartDay;    //开始日期

    //微转让
    private String oldinterestRate;        //转让前利率
    private String old_person;        //原借款人(此时realName是债权转让人)
    private String old_interest;        //项目详情原利息
    private String old_repaymentMonth;        //项目详情原期限
    private int saleType;        //1-折价，2-溢价
    private String saleMoney;        //折溢价金额：返回值总为正。计算公式中，溢价为负。
    private double trans_interest;        //转让金额利息合计

    //微增利
    private String fund_id;                    //基金id
    private String fundcode;                //基金代码
    private String fundname;                //基金名称
    private String company;                    //发行公司
    private double income;                    //万分收益
    private double yield;                    //7日年化收益率
    private int fund_type;                //产品类型
    private int share_method;            //分红方式
    private double first_bay_min_money;        //首次认购最低金额
    private double add_bay_min_money;        //追加认购最低金额
    private int redemption_min_share;    //单笔赎回最低份额
    private int Channel_id;                //渠道id
    private int is_show;                    //是否显示
    private String fund_type_name;            //产品类型
    private String share_method_name;        //分红类型
    private int show_sequence;        //显示序号
    private int totalAcct;            //已购人数

    public String getPersistentDiscription() {
        return persistentDiscription;
    }

    public void setPersistentDiscription(String persistentDiscription) {
        this.persistentDiscription = persistentDiscription;
    }

    public String getPersistentInv_range() {
        return persistentInv_range;
    }

    public void setPersistentInv_range(String persistentInv_range) {
        this.persistentInv_range = persistentInv_range;
    }

    public String getRemainderMoney() {
        return remainderMoney;
    }

    public void setRemainderMoney(String remainderMoney) {
        this.remainderMoney = remainderMoney;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public int getLoanType() {
        return loanType;
    }

    public void setLoanType(int loanType) {
        this.loanType = loanType;
    }

    public String getLoanName() {
        return loanName;
    }

    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }

    public String getGradeIdType() {
        return gradeIdType;
    }

    public void setGradeIdType(String gradeIdType) {
        this.gradeIdType = gradeIdType;
    }

    public double getGoalMoney() {
        return goalMoney;
    }

    public void setGoalMoney(double goalMoney) {
        this.goalMoney = goalMoney;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public String getRepaymentMonth() {
        return repaymentMonth;
    }

    public void setRepaymentMonth(String repaymentMonth) {
        this.repaymentMonth = repaymentMonth;
    }

    public String getGuaranteeType() {
        return guaranteeType;
    }

    public void setGuaranteeType(String guaranteeType) {
        this.guaranteeType = guaranteeType;
    }

    public int getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(int isRecommend) {
        this.isRecommend = isRecommend;
    }

    public int getProvideCompanyid() {
        return provideCompanyid;
    }

    public void setProvideCompanyid(int provideCompanyid) {
        this.provideCompanyid = provideCompanyid;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLoanPurposeDesc() {
        return loanPurposeDesc;
    }

    public void setLoanPurposeDesc(String loanPurposeDesc) {
        this.loanPurposeDesc = loanPurposeDesc;
    }

    public String getCompact_id() {
        return compact_id;
    }

    public void setCompact_id(String compact_id) {
        this.compact_id = compact_id;
    }

    public String getLender_type() {
        return lender_type;
    }

    public void setLender_type(String lender_type) {
        this.lender_type = lender_type;
    }

    public String getItem_label() {
        return item_label;
    }

    public void setItem_label(String item_label) {
        this.item_label = item_label;
    }

    public int getParent_loan_id() {
        return parent_loan_id;
    }

    public void setParent_loan_id(int parent_loan_id) {
        this.parent_loan_id = parent_loan_id;
    }

    public int getSumDays() {
        return sumDays;
    }

    public void setSumDays(int sumDays) {
        this.sumDays = sumDays;
    }

    public String getLoanLastday() {
        return loanLastday;
    }

    public void setLoanLastday(String loanLastday) {
        this.loanLastday = loanLastday;
    }

    public int getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(int loan_id) {
        this.loan_id = loan_id;
    }

    public double getCurrentMomey() {
        return currentMomey;
    }

    public void setCurrentMomey(double currentMomey) {
        this.currentMomey = currentMomey;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSeconde() {
        return seconde;
    }

    public void setSeconde(int seconde) {
        this.seconde = seconde;
    }

    public String getLoan_purpose() {
        return loan_purpose;
    }

    public void setLoan_purpose(String loan_purpose) {
        this.loan_purpose = loan_purpose;
    }

    public int getLoanPurpose() {
        return loanPurpose;
    }

    public void setLoanPurpose(int loanPurpose) {
        this.loanPurpose = loanPurpose;
    }

    public String getUplinetime() {
        return uplinetime;
    }

    public void setUplinetime(String uplinetime) {
        this.uplinetime = uplinetime;
    }

    public String getFullscaletime() {
        return fullscaletime;
    }

    public void setFullscaletime(String fullscaletime) {
        this.fullscaletime = fullscaletime;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public String getLimitTop() {
        return limitTop;
    }

    public void setLimitTop(String limitTop) {
        this.limitTop = limitTop;
    }

    public String getDanBaoUrl() {
        return danBaoUrl;
    }

    public void setDanBaoUrl(String danBaoUrl) {
        this.danBaoUrl = danBaoUrl;
    }

    public String getRepaymentType() {
        return repaymentType;
    }

    public void setRepaymentType(String repaymentType) {
        this.repaymentType = repaymentType;
    }

    public int getDeadlineType() {
        return deadlineType;
    }

    public void setDeadlineType(int deadlineType) {
        this.deadlineType = deadlineType;
    }

    public int getSecure_loan() {
        return secure_loan;
    }

    public void setSecure_loan(int secure_loan) {
        this.secure_loan = secure_loan;
    }

    public int getMonth_or_day() {
        return month_or_day;
    }

    public void setMonth_or_day(int month_or_day) {
        this.month_or_day = month_or_day;
    }

    public String getBillEndDay() {
        return billEndDay;
    }

    public void setBillEndDay(String billEndDay) {
        this.billEndDay = billEndDay;
    }

    public String getOldinterestRate() {
        return oldinterestRate;
    }

    public void setOldinterestRate(String oldinterestRate) {
        this.oldinterestRate = oldinterestRate;
    }

    public String getOld_person() {
        return old_person;
    }

    public void setOld_person(String old_person) {
        this.old_person = old_person;
    }

    public String getOld_interest() {
        return old_interest;
    }

    public void setOld_interest(String old_interest) {
        this.old_interest = old_interest;
    }

    public String getOld_repaymentMonth() {
        return old_repaymentMonth;
    }

    public void setOld_repaymentMonth(String old_repaymentMonth) {
        this.old_repaymentMonth = old_repaymentMonth;
    }

    public int getSaleType() {
        return saleType;
    }

    public void setSaleType(int saleType) {
        this.saleType = saleType;
    }

    public String getSaleMoney() {
        return saleMoney;
    }

    public void setSaleMoney(String saleMoney) {
        this.saleMoney = saleMoney;
    }

    public double getTrans_interest() {
        return trans_interest;
    }

    public void setTrans_interest(double trans_interest) {
        this.trans_interest = trans_interest;
    }

    public int getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(int guarantee) {
        this.guarantee = guarantee;
    }


    //处理过的属性

    /**
     * status==4，可投；其余不可投
     */
    public boolean isEnable() {
        if ("4".equals(status)) {
            return true;
        } else {
            return false;
        }
    }

    public String getFund_id() {
        return fund_id;
    }

    public void setFund_id(String fund_id) {
        this.fund_id = fund_id;
    }

    public String getFundcode() {
        return fundcode;
    }

    public void setFundcode(String fundcode) {
        this.fundcode = fundcode;
    }

    public String getFundname() {
        return fundname;
    }

    public void setFundname(String fundname) {
        this.fundname = fundname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getYield() {
        return yield;
    }

    public void setYield(double yield) {
        this.yield = yield;
    }

    public int getFund_type() {
        return fund_type;
    }

    public void setFund_type(int fund_type) {
        this.fund_type = fund_type;
    }

    public int getShare_method() {
        return share_method;
    }

    public void setShare_method(int share_method) {
        this.share_method = share_method;
    }

    public double getFirst_bay_min_money() {
        return first_bay_min_money;
    }

    public void setFirst_bay_min_money(double first_bay_min_money) {
        this.first_bay_min_money = first_bay_min_money;
    }

    public double getAdd_bay_min_money() {
        return add_bay_min_money;
    }

    public void setAdd_bay_min_money(double add_bay_min_money) {
        this.add_bay_min_money = add_bay_min_money;
    }

    public int getRedemption_min_share() {
        return redemption_min_share;
    }

    public void setRedemption_min_share(int redemption_min_share) {
        this.redemption_min_share = redemption_min_share;
    }

    public int getChannel_id() {
        return Channel_id;
    }

    public void setChannel_id(int channel_id) {
        Channel_id = channel_id;
    }

    public int getIs_show() {
        return is_show;
    }

    public void setIs_show(int is_show) {
        this.is_show = is_show;
    }

    public String getFund_type_name() {
        return fund_type_name;
    }

    public void setFund_type_name(String fund_type_name) {
        this.fund_type_name = fund_type_name;
    }

    public String getShare_method_name() {
        return share_method_name;
    }

    public void setShare_method_name(String share_method_name) {
        this.share_method_name = share_method_name;
    }

    public int getShow_sequence() {
        return show_sequence;
    }

    public void setShow_sequence(int show_sequence) {
        this.show_sequence = show_sequence;
    }

    public int getTotalAcct() {
        return totalAcct;
    }

    public void setTotalAcct(int totalAcct) {
        this.totalAcct = totalAcct;
    }

    public int getApply_type() {
        return apply_type;
    }

    public void setApply_type(int apply_type) {
        this.apply_type = apply_type;
    }

    public String getBillStartDay() {
        return billStartDay;
    }

    public void setBillStartDay(String billStartDay) {
        this.billStartDay = billStartDay;
    }

}
