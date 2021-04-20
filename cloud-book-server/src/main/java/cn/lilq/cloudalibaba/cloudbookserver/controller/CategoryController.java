package cn.lilq.cloudalibaba.cloudbookserver.controller;


import cn.lilq.cloudalibaba.cloudbookserver.model.ao.CategoryAO;
import cn.lilq.cloudalibaba.cloudbookserver.model.entity.BookDO;
import cn.lilq.cloudalibaba.cloudbookserver.model.entity.CategoryDO;
import cn.lilq.cloudalibaba.cloudbookserver.model.vo.BookVO;
import cn.lilq.cloudalibaba.cloudbookserver.model.vo.CategoryVO;
import cn.lilq.cloudalibaba.cloudbookserver.service.CategoryService;
import cn.lilq.cloudalibaba.cloudcommon.Result;
import cn.lilq.cloudalibaba.cloudcommon.ReturnEnum;
import cn.lilq.cloudalibaba.cloudcommon.util.CopyUtil;
import cn.lilq.cloudalibaba.cloudcommon.validation.Add;
import cn.lilq.cloudalibaba.cloudcommon.validation.Update;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 类别 前端控制器
 * </p>
 *
 * @author Li Liangquan
 * @since 2021-04-19
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    /**
     * 结果列表
     * @return
     */
    @GetMapping("")
    public Result<List<CategoryVO>> listResult(){
        return Result.success(CopyUtil.copyList(categoryService.list(),CategoryVO.class), null);
    }

    /**
     * 增加
     * @param categoryAO
     * @return
     */
    @PostMapping("")
    public Result<Integer> addCategory(@Validated(Add.class) @RequestBody CategoryAO categoryAO){
        return Result.success(categoryService.categoryAdd(categoryAO), null);
    }

    /**
     * 修改
     * @param categoryAO
     * @return
     */
    @PutMapping("")
    public Result<Boolean> updateCategory(@Validated(Update.class) @RequestBody CategoryAO categoryAO){
        return categoryService.updateById(CopyUtil.copyObj(categoryAO, CategoryDO.class))?Result.success(true, null):Result.fail(ReturnEnum.MSG_ERROR_4, null);
    }

    /**
     * 删除
     * @param id 删除id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result<Boolean> deleteCategory(@PathVariable Long id){
        return categoryService.removeById(id)?Result.success(true, null):Result.fail(ReturnEnum.MSG_ERROR_5, null);
    }
}

