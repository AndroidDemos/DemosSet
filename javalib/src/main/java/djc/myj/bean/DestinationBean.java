package djc.myj.bean;

/**
 * Author: Zeus
 * Date: 2020/11/6 10:07
 * Description: 收款人
 * History:
 */
public class DestinationBean {

    private String account_number;//银行账号
    private String legal_name_first;//持卡人名  中国专用
    private String legal_name_last;//持卡人姓   中国专用
    private String mobile_number;//手机号码
    private String address_city;//城市
    private String address_line;//详细地址
    private String address_state;//洲
    private String address_zip;//邮编
    private String bank;//银行代码
    private String branch;//银行分行
    private String country;//收款方国家号
    private String currency;//币种
    private String iban;//目的国的有效国际银行账号
    private String id_number;//身份证号码
    private String native_legal_name_first;//银行卡名   日本专用
    private String native_legal_name_last;//银行卡姓    日本专用
    private String partner;//
    private String segment;//个人或企业
    private String swift_code;//SWIFT码
    private String type;//收款方类型

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getLegal_name_first() {
        return legal_name_first;
    }

    public void setLegal_name_first(String legal_name_first) {
        this.legal_name_first = legal_name_first;
    }

    public String getLegal_name_last() {
        return legal_name_last;
    }

    public void setLegal_name_last(String legal_name_last) {
        this.legal_name_last = legal_name_last;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getAddress_city() {
        return address_city;
    }

    public void setAddress_city(String address_city) {
        this.address_city = address_city;
    }

    public String getAddress_line() {
        return address_line;
    }

    public void setAddress_line(String address_line) {
        this.address_line = address_line;
    }

    public String getAddress_state() {
        return address_state;
    }

    public void setAddress_state(String address_state) {
        this.address_state = address_state;
    }

    public String getAddress_zip() {
        return address_zip;
    }

    public void setAddress_zip(String address_zip) {
        this.address_zip = address_zip;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getNative_legal_name_first() {
        return native_legal_name_first;
    }

    public void setNative_legal_name_first(String native_legal_name_first) {
        this.native_legal_name_first = native_legal_name_first;
    }

    public String getNative_legal_name_last() {
        return native_legal_name_last;
    }

    public void setNative_legal_name_last(String native_legal_name_last) {
        this.native_legal_name_last = native_legal_name_last;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getSwift_code() {
        return swift_code;
    }

    public void setSwift_code(String swift_code) {
        this.swift_code = swift_code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

