package cn.lilq.cloudalibaba.cloudbookserver.service.impl;

import cn.lilq.cloudalibaba.cloudbookserver.mapper.CategoryMapper;
import cn.lilq.cloudalibaba.cloudbookserver.model.ao.BookAO;
import cn.lilq.cloudalibaba.cloudbookserver.model.ao.CategoryAO;
import cn.lilq.cloudalibaba.cloudbookserver.model.dto.BookDTO;
import cn.lilq.cloudalibaba.cloudbookserver.model.entity.BookDO;
import cn.lilq.cloudalibaba.cloudbookserver.mapper.BookMapper;
import cn.lilq.cloudalibaba.cloudbookserver.model.entity.CategoryDO;
import cn.lilq.cloudalibaba.cloudbookserver.model.vo.BookVO;
import cn.lilq.cloudalibaba.cloudbookserver.model.vo.CategoryVO;
import cn.lilq.cloudalibaba.cloudbookserver.service.BookService;
import cn.lilq.cloudalibaba.cloudcommon.util.CopyUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 书籍 服务实现类
 * </p>
 *
 * @author Li Liangquan
 * @since 2021-04-18
 */
@Service
@Slf4j
public class BookServiceImpl extends ServiceImpl<BookMapper, BookDO> implements BookService {
    @Resource
    private BookMapper bookMapper;
    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<BookVO> bookList() {
        List<BookDTO> bookDTOs = bookMapper.selectBooks(new QueryWrapper());
        log.info("bookList()$$bookDTOs:{}",bookDTOs);
        List<BookVO> bookVOList = bookDTOs.stream().map(bookDTO -> BookVO.builder().bookName(bookDTO.getBookName()).bookAuthor(bookDTO.getBookAuthor()).bookId(bookDTO.getBookId()).categorys(bookDTO.getCategorys().stream().map(categoryDTO -> CategoryVO.builder().bookId(categoryDTO.getBookId()).categoryId(categoryDTO.getCategoryId()).categoryName(categoryDTO.getCategoryName()).build()).collect(Collectors.toList())).build()).collect(Collectors.toList());
        log.info("bookList()$$书籍列表:{}",bookVOList);
        return bookVOList;
    }

    @Transactional
    @Override
    public Integer addBook(BookAO bookAO) {
        BookDO bookDO = CopyUtil.copyObj(bookAO,BookDO.class);
        int bm = bookMapper.insertReturnId(bookDO);
        log.info("addBook(BookAO bookAO)$$bm:{},主键id:{}", java.util.Optional.of(bm),bookDO.getBookId());
        bookAO.getCategorys().forEach(categoryAO -> categoryAO.setBookId(bookDO.getBookId()));
        int cm = categoryMapper.insertList(CopyUtil.copyList(bookAO.getCategorys(), CategoryDO.class));
        log.info("cm:{}", java.util.Optional.of(cm));
        return bm;
    }

    @Override
    public Integer addBookCategory(Long bookId,List<CategoryAO> categoryAOS) {
        boolean exists = null==bookMapper.selectById(bookId);
        if (exists)
            return 0;
        categoryAOS.forEach(categoryAO -> categoryAO.setBookId(bookId));
        int cm = categoryMapper.insertList(CopyUtil.copyList(categoryAOS, CategoryDO.class));
        log.info("addBookCategory()$$cm:{}", java.util.Optional.of(cm));
        return cm;
    }
}
