package cn.lilq.cloudalibaba.cloudbookserver.service;

import cn.lilq.cloudalibaba.cloudbookserver.model.ao.BookAO;
import cn.lilq.cloudalibaba.cloudbookserver.model.ao.CategoryAO;
import cn.lilq.cloudalibaba.cloudbookserver.model.entity.BookDO;
import cn.lilq.cloudalibaba.cloudbookserver.model.vo.BookVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 书籍 服务类
 * </p>
 *
 * @author Li Liangquan
 * @since 2021-04-18
 */
public interface BookService extends IService<BookDO> {
    /**
     *
     * @return
     */
    List<BookVO> bookList();

    /**
     *
     * @param bookAO
     * @return
     */
    Integer addBook(BookAO bookAO);

    /**
     *
     * @param categoryAOS
     * @return
     */
    Integer addBookCategory(Long bookId,List<CategoryAO> categoryAOS);
}
