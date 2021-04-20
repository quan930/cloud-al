package cn.lilq.cloudalibaba.cloudbookserver.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 书籍
 * </p>
 *
 * @author Li Liangquan
 * @since 2021-04-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("book")
public class BookDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "book_id", type = IdType.AUTO)
    private Long bookId;

    private String bookName;

    private String bookAuthor;

    @TableLogic
    private Integer isDeleted;
}
