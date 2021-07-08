package com.zy.testmyjpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 分类
 */
@Entity
public class Classification implements Serializable {
    @Id
    @GeneratedValue
    @Column
    private Integer id;
    /**
     * 上级分类Id
     */
    @Column
    private Integer parentId;
    /**
     * 分类名称
     */
    @Column
    private String cname;
    /**
     * 类型 1一级分类 2二级分类
     */
    @Column
    private Integer type;


    /**
     * 主打类型
     */
    @Column
    private String cnametype;
    /**
     * 购买方式
     */
    @Column
    private String cbuy;
    /**
     * 货物来源
     */
    @Column
    private String csource;
    /**
     * 付款方式
     */
    @Column
    private String cpayment;
    /**
     * 店家所在地址
     */
    @Column
    private String caddress;
    /**
     * 店家联系方式
     */
    @Column
    private String cphone;


    public String getCnametype() {
        return cnametype;
    }

    public void setCnametype(String cnametype) {
        this.cnametype = cnametype;
    }

    public String getCbuy() {
        return cbuy;
    }

    public void setCbuy(String cbuy) {
        this.cbuy = cbuy;
    }

    public String getCsource() {
        return csource;
    }

    public void setCsource(String csource) {
        this.csource = csource;
    }

    public String getCpayment() {
        return cpayment;
    }

    public void setCpayment(String cpayment) {
        this.cpayment = cpayment;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    private static final long serialVersionUID = 1L;

    public Classification(Integer id, Integer parentId, String cname, Integer type) {
        this.id = id;
        this.parentId = parentId;
        this.cname = cname;
        this.type = type;
    }

    public Classification() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Classification other = (Classification) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getCname() == null ? other.getCname() == null : this.getCname().equals(other.getCname()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getCname() == null) ? 0 : getCname().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", cname=").append(cname);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}