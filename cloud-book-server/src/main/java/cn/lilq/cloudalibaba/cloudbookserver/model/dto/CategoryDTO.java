package cn.lilq.cloudalibaba.cloudbookserver.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @auther: Li Liangquan
 * @date: 2021/4/20 14:04
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CategoryDTO {
    private Long categoryId;

    private String categoryName;

    private Long bookId;
}
