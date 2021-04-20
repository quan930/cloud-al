package cn.lilq.cloudalibaba.cloudbookserver.mapper;

import cn.lilq.cloudalibaba.cloudbookserver.model.dto.BookDTO;
import cn.lilq.cloudalibaba.cloudbookserver.model.entity.BookDO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 * 书籍 Mapper 接口
 * </p>
 *
 * @author Li Liangquan
 * @since 2021-04-18
 */
public interface BookMapper extends BaseMapper<BookDO> {
    @Insert("insert into book(book_name, book_author, is_deleted) VALUES (#{bookName},#{bookAuthor},0)")
    @Options(useGeneratedKeys = true, keyProperty = "bookId",keyColumn = "book_id")
    int insertReturnId(BookDO BookDO);

    @Select("SELECT book_id,book_name,book_author FROM book where is_deleted = 0")
    @Results({
            @Result(property = "bookId",column = "book_id"),
            @Result(property = "categorys", column = "book_id",
                    many = @Many(select = "cn.lilq.cloudalibaba.cloudbookserver.mapper.CategoryMapper.selectListByBookId"))
    })
    List<BookDTO> selectBooks(@Param(Constants.WRAPPER) QueryWrapper wrapper);
}
