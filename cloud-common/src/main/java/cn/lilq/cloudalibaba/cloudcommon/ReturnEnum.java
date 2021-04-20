package cn.lilq.cloudalibaba.cloudcommon;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @auther: Li Liangquan
 * @date: 2021/3/17 10:38
 */

@Getter
public enum ReturnEnum {

    MSG_SUCCESS(0, "业务处理成功"),
    MSG_ERROR_1(-1, "参数为空"),
    MSG_ERROR_2(-2, "业务处理失败"),
    MSG_ERROR_3(-3, "参数类型错误"),
    MSG_ERROR_4(-4, "更新失败"),
    MSG_ERROR_5(-5, "删除失败"),
    MSG_ERROR_6(-6, "添加失败"),
    MSG_ERROR_7(-7, "文件不存在！");

    private final Integer key;
    private final String value;

    ReturnEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
