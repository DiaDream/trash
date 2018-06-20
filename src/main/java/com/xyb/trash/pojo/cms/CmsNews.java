/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.pojo.cms;

import com.xyb.trash.pojo.BasePojo;

import java.util.Date;

public class CmsNews extends BasePojo {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long articleId;

    private Long columnId;

    private String columnName;

    private String title;

    private String shortTitle;

    private String filePath;

    private String previewabstract;

    private String checkStatus;

    private Date releaseTime;
    private String releaseTimeStr;
    private String origin;

    private String author;

    private String status;

    private String articleType;

    private Long receiverId;

    private String important;

    private Integer clicktotal;

    private String description;

    private String tags;

    private String outurl;

    private Integer recommendcount;

    private Long creatorId;

    private Date createTime;
    
    private Date auditTime;

    private Long auditor;

    private String content;

    
    /**
	 * 取得
	 * @return the releaseTimeStr
	 */
	public String getReleaseTimeStr() {
		return releaseTimeStr;
	}

	/**
	 * 设置
	 * @param releaseTimeStr the releaseTimeStr to set.
	 */
	public void setReleaseTimeStr(String releaseTimeStr) {
		this.releaseTimeStr = releaseTimeStr;
	}

	public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getPreviewabstract() {
        return previewabstract;
    }

    public void setPreviewabstract(String previewabstract) {
        this.previewabstract = previewabstract;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public String getImportant() {
        return important;
    }

    public void setImportant(String important) {
        this.important = important;
    }

    public Integer getClicktotal() {
        return clicktotal;
    }

    public void setClicktotal(Integer clicktotal) {
        this.clicktotal = clicktotal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getOuturl() {
        return outurl;
    }

    public void setOuturl(String outurl) {
        this.outurl = outurl;
    }

    public Integer getRecommendcount() {
        return recommendcount;
    }

    public void setRecommendcount(Integer recommendcount) {
        this.recommendcount = recommendcount;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Long getAuditor() {
        return auditor;
    }

    public void setAuditor(Long auditor) {
        this.auditor = auditor;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}