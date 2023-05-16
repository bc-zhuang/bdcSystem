package com.bdc.reservationService.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author bc
 * @since 2023-05-16
 */
@TableName("x_numberball")
public class Numberball implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 不动产登记中心id
     */
    private Integer centerId;

    /**
     * 一级业务类型id
     */
    private Integer firstId;

    /**
     * 所属时段id
     */
    private Integer timeId;

    /**
     * 号球数量
     */
    private Integer number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getCenterId() {
        return centerId;
    }

    public void setCenterId(Integer centerId) {
        this.centerId = centerId;
    }
    public Integer getFirstId() {
        return firstId;
    }

    public void setFirstId(Integer firstId) {
        this.firstId = firstId;
    }
    public Integer getTimeId() {
        return timeId;
    }

    public void setTimeId(Integer timeId) {
        this.timeId = timeId;
    }
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Numberball{" +
            "id=" + id +
            ", centerId=" + centerId +
            ", firstId=" + firstId +
            ", timeId=" + timeId +
            ", number=" + number +
        "}";
    }
}
