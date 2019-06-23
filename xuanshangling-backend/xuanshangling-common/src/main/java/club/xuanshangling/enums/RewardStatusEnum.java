package club.xuanshangling.enums;

/**
 * @Author: wangcf
 * @Date: 2019/6/23 14:23
 * @Description 悬赏令当前状态枚举对象
 */
public enum RewardStatusEnum {

    FORBID(0),  //禁止
    SUCCESS(1); //发布成功

    public final int value;

    RewardStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
