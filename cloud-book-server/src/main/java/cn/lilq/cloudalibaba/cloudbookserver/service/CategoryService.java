package cn.lilq.cloudalibaba.cloudbookserver.service;

import cn.lilq.cloudalibaba.cloudbookserver.model.ao.CategoryAO;
import cn.lilq.cloudalibaba.cloudbookserver.model.entity.CategoryDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 类别 服务类
 * </p>
 *
 * @author Li Liangquan
 * @since 2021-04-19
 */
public interface CategoryService extends IService<CategoryDO> {
    int categoryAdd(CategoryAO categoryAO);
}
