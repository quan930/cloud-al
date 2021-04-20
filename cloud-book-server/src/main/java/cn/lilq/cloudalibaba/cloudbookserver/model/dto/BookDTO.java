package cn.lilq.cloudalibaba.cloudbookserver.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @auther: Li Liangquan
 * @date: 2021/4/20 11:31
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BookDTO {
    private Long bookId;

    private String bookName;

    private String bookAuthor;

    private List<CategoryDTO> categorys;
}
