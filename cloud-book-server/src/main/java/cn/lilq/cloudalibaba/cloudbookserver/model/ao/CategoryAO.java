package cn.lilq.cloudalibaba.cloudbookserver.model.ao;

import cn.lilq.cloudalibaba.cloudcommon.validation.Add;
import cn.lilq.cloudalibaba.cloudcommon.validation.Update;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

/**
 * @auther: Li Liangquan
 * @date: 2021/4/19 18:32
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CategoryAO {
    @NotNull(message = "类别id不为空",groups = Update.class)
    @Null(message = "id必须空",groups = Add.class)
    private Long categoryId;

    @NotBlank(message = "name不为空",groups = Add.class)
    @Size(max = 10,message = "name过长")
    private String categoryName;

    private Long bookId;
}
