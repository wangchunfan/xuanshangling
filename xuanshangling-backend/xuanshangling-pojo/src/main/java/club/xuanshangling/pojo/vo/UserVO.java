package club.xuanshangling.pojo.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
public class UserVO {

    /**
     * 主键
     */
    private String id;

    /**
     * 用户token
     */
    private String userToken;

    /**
     * 用户名/登录名
     */
    private String username;

    /**
     * 密码
     */
    @JsonIgnore
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 用户头像
     */
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
    private Integer creditScore;

    /**
     * 注册时间
     */
    private Date createTime;

    /**
     * 最近登录时间
     */
    private Date updateTime;


}