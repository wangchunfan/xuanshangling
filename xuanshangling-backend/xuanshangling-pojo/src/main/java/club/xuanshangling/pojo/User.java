package club.xuanshangling.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

@Data
@ApiModel(value = "用户", description = "这里是登录用户对象")
public class User {
    /**
     * 主键
     */
    @Id
    @ApiModelProperty(hidden = true)
    private String id;

    /**
     * 用户名/登录名
     */
    @ApiModelProperty(value = "用户名", name = "username", example = "zhangsan", required = true)
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", name = "password", example = "123456a", required = true)
    private String password;

    /**
     * 昵称
     */
    @ApiModelProperty(hidden = true)
    private String nickname;

    /**
     * 用户头像
     */
    @Column(name = "face_image")
    @ApiModelProperty(hidden = true)
    private String faceImage;

    /**
     * 性别 1男 2女
     */
    @ApiModelProperty(hidden = true)
    private Integer gender;

    /**
     * 年龄
     */
    @ApiModelProperty(hidden = true)
    private Integer age;

    /**
     * 信用积分
     */
    @Column(name = "credit_score")
    @ApiModelProperty(hidden = true)
    private Integer creditScore;

    /**
     * 注册时间
     */
    @Column(name = "create_time")
    @ApiModelProperty(hidden = true)
    private Date createTime;

    /**
     * 最近登录时间
     */
    @Column(name = "update_time")
    @ApiModelProperty(hidden = true)
    private Date updateTime;

}