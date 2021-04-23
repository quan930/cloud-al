package cn.lilq.cloudalibaba.cloudbookserver.controller;


import cn.lilq.cloudalibaba.cloudbookserver.model.ao.BookAO;
import cn.lilq.cloudalibaba.cloudbookserver.model.ao.CategoryAO;
import cn.lilq.cloudalibaba.cloudbookserver.model.vo.BookVO;
import cn.lilq.cloudalibaba.cloudbookserver.service.BookService;
import cn.lilq.cloudalibaba.cloudcommon.Result;
import cn.lilq.cloudalibaba.cloudcommon.ReturnEnum;
import cn.lilq.cloudalibaba.cloudcommon.validation.Add;
import cn.lilq.cloudalibaba.cloudcommon.validation.Update;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 书籍 前端控制器
 * </p>
 *
 * @author Li Liangquan
 * @since 2021-04-18
 */
@RestController
@RequestMapping("/book")
@Slf4j
@Validated
public class BookController {
    @Resource
    private BookService bookService;

    @GetMapping("")
    public Result<List<BookVO>> list(){
        return Result.success(bookService.bookList());
    }

    @PostMapping("")
    public Result<Integer> addBook(@Validated(Add.class) @RequestBody BookAO bookAO){
        return bookService.addBook(bookAO)!=0?Result.success(1):Result.fail(ReturnEnum.MSG_ERROR_6,null);
    }

    @PostMapping("/{id}/category")
    public Result<Integer> addBookCategory(@PathVariable Long id,@Validated(Add.class) @RequestBody List<CategoryAO> categoryAOS){
        return bookService.addBookCategory(id,categoryAOS)!=0?Result.success(1):Result.fail(ReturnEnum.MSG_ERROR_6,null);
    }

    @PutMapping("")
    public Result<Boolean> updateBook(@Validated(Update.class) @RequestBody BookAO bookAO){
        return Result.success(bookService.updateBook(bookAO));
    }
}

