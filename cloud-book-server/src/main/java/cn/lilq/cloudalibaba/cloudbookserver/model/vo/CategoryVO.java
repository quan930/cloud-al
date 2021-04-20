package cn.lilq.cloudalibaba.cloudbookserver.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 类别
 * </p>
 *
 * @author Li Liangquan
 * @since 2021-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryVO implements Serializable {
    private Long categoryId;
    private String categoryName;
    private Long bookId;
}
