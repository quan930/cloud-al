package cn.lilq.cloudalibaba.cloudbookserver.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

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
@TableName("category")
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "category_id", type = IdType.AUTO)
    private Long categoryId;

    private String categoryName;

    private Long bookId;

    @TableLogic
    private Integer isDeleted;
}
