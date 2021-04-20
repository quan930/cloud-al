package cn.lilq.cloudalibaba.cloudbookserver.mapper;

import cn.lilq.cloudalibaba.cloudbookserver.model.dto.CategoryDTO;
import cn.lilq.cloudalibaba.cloudbookserver.model.entity.CategoryDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 类别 Mapper 接口
 * </p>
 *
 * @author Li Liangquan
 * @since 2021-04-19
 */
public interface CategoryMapper extends BaseMapper<CategoryDO> {

    @Insert("<script>" +
            " insert into category(category_name, book_id, is_deleted)" +
            " values " +
            " <foreach collection = \"list\" item=\"item\" index=\"index\" separator=\",\">" +
            " (#{item.categoryName}, #{item.bookId}, 0)" +
            " </foreach>" +
            "</script>")
    int insertList(@Param("list") List<CategoryDO> categoryDOS);

    @Select("SELECT category_id,category_name, book_id, is_deleted FROM category where is_deleted = 0 AND book_id = #{bookId}")
    List<CategoryDTO> selectListByBookId(Long bookId);
}
