package pojo;

import java.util.Date;
import javax.persistence.*;

public class Users {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 用户名/登录名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 用户头像
     */
    @Column(name = "face_image")
    private String faceImage;

    /**
     * 性别 1男 2女
     */
    private Integer gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 信用积分
     */
    @Column(name = "credit_score")
    private Integer creditScore;

    /**
     * 注册时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最近登录时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户名/登录名
     *
     * @return username - 用户名/登录名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名/登录名
     *
     * @param username 用户名/登录名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取昵称
     *
     * @return nickname - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取用户头像
     *
     * @return face_image - 用户头像
     */
    public String getFaceImage() {
        return faceImage;
    }

    /**
     * 设置用户头像
     *
     * @param faceImage 用户头像
     */
    public void setFaceImage(String faceImage) {
        this.faceImage = faceImage;
    }

    /**
     * 获取性别 1男 2女
     *
     * @return gender - 性别 1男 2女
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置性别 1男 2女
     *
     * @param gender 性别 1男 2女
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取信用积分
     *
     * @return credit_score - 信用积分
     */
    public Integer getCreditScore() {
        return creditScore;
    }

    /**
     * 设置信用积分
     *
     * @param creditScore 信用积分
     */
    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }

    /**
     * 获取注册时间
     *
     * @return create_time - 注册时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置注册时间
     *
     * @param createTime 注册时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取最近登录时间
     *
     * @return update_time - 最近登录时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置最近登录时间
     *
     * @param updateTime 最近登录时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}