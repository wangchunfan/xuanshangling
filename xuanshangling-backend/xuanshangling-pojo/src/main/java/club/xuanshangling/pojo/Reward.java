package club.xuanshangling.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: wangcf
 * @Date: 2019/6/23 11:51
 * @Description ${description}
 */
@Data
@ApiModel(value = "悬赏令", description = "这里是悬赏令对象")
public class Reward {
    @Id
    @ApiModelProperty(hidden = true)
    private String id;

    @ApiModelProperty(name = "rewardTitle", value = "悬赏令标题", required = true, example = "帮忙买饭")
    private String rewardTitle;

    @ApiModelProperty(name = "rewardContent", value = "悬赏令内容", required = true, example = "随便10元的饭，送到401")
    private String rewardContent;

    @ApiModelProperty(name = "rewardPrice", value = "悬赏价格", required = true, example = "123")
    private BigDecimal rewardPrice;

    @ApiModelProperty(name = "startTime", value = "开始时间", required = true, example = "2019-06-23 14:00:00")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date startTime;

    @ApiModelProperty(name = "startTime", value = "结束时间", example = "2019-06-23 16:00:00")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date endTime;

    @ApiModelProperty(name = "userId", value = "用户Id", required = true, example = "admin")
    private String userId;

    @ApiModelProperty(name = "status", value = "悬赏令状态", example = "1")
    private Integer status;

    @ApiModelProperty(hidden = true)
    private Date createTime;

    @ApiModelProperty(hidden = true)
    private Date updateTime;

}
