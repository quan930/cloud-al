package cn.lilq.cloudalibaba.cloudbookserver.model.ao;

import cn.lilq.cloudalibaba.cloudcommon.validation.Add;
import cn.lilq.cloudalibaba.cloudcommon.validation.Update;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @auther: Li Liangquan
 * @date: 2021/4/20 10:11
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BookAO {
    @NotNull(message = "id不为空",groups = Update.class)
    @Null(message = "id必须空",groups = Add.class)
    private Long bookId;

    @NotBlank(message = "bookName 不为空",groups = Add.class)
    @Size(max = 10,message = "bookName 过长")
    private String bookName;

    @NotBlank(message = "bookAuthor不为空",groups = Add.class)
    @Size(max = 10,message = "bookAuthor过长")
    private String bookAuthor;

    private List<CategoryAO> categorys;
}
