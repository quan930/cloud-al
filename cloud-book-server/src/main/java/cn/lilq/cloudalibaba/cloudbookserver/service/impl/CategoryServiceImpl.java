package cn.lilq.cloudalibaba.cloudbookserver.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.lilq.cloudalibaba.cloudbookserver.model.ao.CategoryAO;
import cn.lilq.cloudalibaba.cloudbookserver.model.entity.CategoryDO;
import cn.lilq.cloudalibaba.cloudbookserver.mapper.CategoryMapper;
import cn.lilq.cloudalibaba.cloudbookserver.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 类别 服务实现类
 * </p>
 *
 * @author Li Liangquan
 * @since 2021-04-19
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryDO> implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public int categoryAdd(CategoryAO categoryAO) {
        return categoryMapper.insert(BeanUtil.copyProperties(categoryAO, CategoryDO.class));
    }
}
