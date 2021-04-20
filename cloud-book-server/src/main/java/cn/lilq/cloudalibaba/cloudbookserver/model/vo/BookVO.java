package cn.lilq.cloudalibaba.cloudbookserver.model.vo;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @auther: Li Liangquan
 * @date: 2021/4/18 18:07
 */

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookVO implements Serializable {
    private Long bookId;

    private String bookName;

    private String bookAuthor;

    private List<CategoryVO> categorys;
}
