package com.example.demow.entity;

import java.io.Serializable;

public class TbMessage implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 消息类型1被回答，2被评论，3文章被赞，4回答被赞，5评论被赞
     */
    private Integer mtype;

    /**
     * 目标id
     */
    private Integer targetId;

    /**
     * 0未读，1已读
     */
    private Integer isRead;

    /**
     * 收信人id
     */
    private Integer targetUserId;

    /**
     * 收信人openId
     */
    private String targetUserOpenId;

    /**
     * tb_message
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     * @return id 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 消息类型1被回答，2被评论，3文章被赞，4回答被赞，5评论被赞
     * @return mtype 消息类型1被回答，2被评论，3文章被赞，4回答被赞，5评论被赞
     */
    public Integer getMtype() {
        return mtype;
    }

    /**
     * 消息类型1被回答，2被评论，3文章被赞，4回答被赞，5评论被赞
     * @param mtype 消息类型1被回答，2被评论，3文章被赞，4回答被赞，5评论被赞
     */
    public void setMtype(Integer mtype) {
        this.mtype = mtype;
    }

    /**
     * 目标id
     * @return target_id 目标id
     */
    public Integer getTargetId() {
        return targetId;
    }

    /**
     * 目标id
     * @param targetId 目标id
     */
    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    /**
     * 0未读，1已读
     * @return is_read 0未读，1已读
     */
    public Integer getIsRead() {
        return isRead;
    }

    /**
     * 0未读，1已读
     * @param isRead 0未读，1已读
     */
    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    /**
     * 收信人id
     * @return target_user_id 收信人id
     */
    public Integer getTargetUserId() {
        return targetUserId;
    }

    /**
     * 收信人id
     * @param targetUserId 收信人id
     */
    public void setTargetUserId(Integer targetUserId) {
        this.targetUserId = targetUserId;
    }

    /**
     * 收信人openId
     * @return target_user_open_id 收信人openId
     */
    public String getTargetUserOpenId() {
        return targetUserOpenId;
    }

    /**
     * 收信人openId
     * @param targetUserOpenId 收信人openId
     */
    public void setTargetUserOpenId(String targetUserOpenId) {
        this.targetUserOpenId = targetUserOpenId == null ? null : targetUserOpenId.trim();
    }
}