package club.xuanshangling.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: wangcf
 * @Date: 2019/6/24 21:02
 * @Description ${description}
 */
@Data
public class RewardVO {
    private String id;

    private String rewardTitle;

    private String rewardContent;

    private BigDecimal rewardPrice;

    private Date startTime;

    private Date endTime;

    private String userId;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private UserVO userVO;
}
