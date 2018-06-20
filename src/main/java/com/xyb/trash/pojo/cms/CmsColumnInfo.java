/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.pojo.cms;

import com.xyb.trash.pojo.BasePojo;
import com.xyb.trash.util.commonutil.DateUtil;

import java.util.Date;

public class CmsColumnInfo extends BasePojo {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long columnId;

    private String columnName;

    private String columnIntroduce;

    private String columnImage;

    private String status;

    private Date createTime;

    private Date updateTime;

    private Long columnParentid;

    private Integer ordinal;

    public Long getColumnId() {
        return columnId;
    }

    public void setColumnId(Long columnId) {
        this.columnId = columnId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnIntroduce() {
        return columnIntroduce;
    }

    public void setColumnIntroduce(String columnIntroduce) {
        this.columnIntroduce = columnIntroduce;
    }

    public String getColumnImage() {
        return columnImage;
    }

    public void setColumnImage(String columnImage) {
        this.columnImage = columnImage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }
    public String getCreateTimeStr() {
        return DateUtil.formatDateToString(createTime, "yyyy-MM-dd HH:mm");
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getColumnParentid() {
        return columnParentid;
    }

    public void setColumnParentid(Long columnParentid) {
        this.columnParentid = columnParentid;
    }

    public Integer getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
    }
}