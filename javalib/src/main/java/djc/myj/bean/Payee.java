package djc.myj.bean;

/**
 * Author: Zeus
 * Date: 2020/11/5 18:46
 * Description: 跨境汇款收款人对象
 * History:
 */
public class Payee{


    private Long id;
    private long uid;
    private String type;
    private String country;
    private String legal_name_first;
    private String legal_name_last;
    private String mobile_number;
    private String mobile_number_prifix;
    private String account_number;

    private String id_number;

    private String address_line;
    private String address_city;
    private String address_state;
    private String segment;
    private String native_legal_name_first;
    private String native_legal_name_last;
    private String address_zip;
    private String swift_code;
    private String iban;
    private String ewallet_id;
    private String partner;

    private boolean isSelect = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getMobile_number_prifix() {
        return mobile_number_prifix;
    }

    public void setMobile_number_prifix(String mobile_number_prifix) {
        this.mobile_number_prifix = mobile_number_prifix;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getAddress_line() {
        return address_line;
    }

    public void setAddress_line(String address_line) {
        this.address_line = address_line;
    }

    public String getAddress_city() {
        return address_city;
    }

    public void setAddress_city(String address_city) {
        this.address_city = address_city;
    }

    public String getAddress_state() {
        return address_state;
    }

    public void setAddress_state(String address_state) {
        this.address_state = address_state;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
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

    public String getAddress_zip() {
        return address_zip;
    }

    public void setAddress_zip(String address_zip) {
        this.address_zip = address_zip;
    }

    public String getSwift_code() {
        return swift_code;
    }

    public void setSwift_code(String swift_code) {
        this.swift_code = swift_code;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getEwallet_id() {
        return ewallet_id;
    }

    public void setEwallet_id(String ewallet_id) {
        this.ewallet_id = ewallet_id;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
