package org.eugeneforest.toolbox.mp.base;


import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Eugene-Forest
 */
public class CustomizedEntity implements Serializable {
    @JsonSerialize(
            using = ToStringSerializer.class
    )
    @ApiModelProperty("主键id")
    @TableId(
            value = "id",
            type = IdType.ASSIGN_ID
    )
    private Long id;

    @JsonSerialize(
            using = ToStringSerializer.class
    )
    @ApiModelProperty("创建人")
    @TableField("create_user")
    private Long createUser;

    @JsonSerialize(
            using = ToStringSerializer.class
    )
    @ApiModelProperty("创建部门")
    @TableField("create_dept")
    private Long createDept;

    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @JsonSerialize(
            using = ToStringSerializer.class
    )
    @ApiModelProperty("更新人")
    @TableField("update_user")
    private Long updateUser;

    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @ApiModelProperty("更新时间")
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version
    @ApiModelProperty("版本状态")
    @TableField("version_status")
    private Integer versionStatus=0;

    @ApiModelProperty("是否已删除")
    @TableField("is_deleted")
    private Integer isDeleted=0;

    public Long getId() {
        return this.id;
    }

    public Long getCreateUser() {
        return this.createUser;
    }

    public Long getCreateDept() {
        return this.createDept;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public Long getUpdateUser() {
        return this.updateUser;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public Integer getIsDeleted() {
        return this.isDeleted;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setCreateUser(final Long createUser) {
        this.createUser = createUser;
    }

    public void setCreateDept(final Long createDept) {
        this.createDept = createDept;
    }

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    public void setCreateTime(final Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateUser(final Long updateUser) {
        this.updateUser = updateUser;
    }

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    public void setUpdateTime(final Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setIsDeleted(final Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "BaseEntity(id=" + this.getId() + ", createUser=" + this.getCreateUser() + ", createDept=" + this.getCreateDept() + ", createTime=" + this.getCreateTime() + ", updateUser=" + this.getUpdateUser() + ", updateTime=" + this.getUpdateTime() + ", version status=" + this.getVersionStatus() + ", isDeleted=" + this.getIsDeleted() + ")";
    }

    public Integer getVersionStatus() {
        return versionStatus;
    }

    public void setVersionStatus(Integer versionStatus) {
        this.versionStatus = versionStatus;
    }
}
