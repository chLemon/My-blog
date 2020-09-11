package cn.edu.buaa.myblog.service;

import cn.edu.buaa.myblog.utils.PageQueryUtil;
import cn.edu.buaa.myblog.utils.PageResult;

public interface TagService {
    PageResult getBlogTagPage(PageQueryUtil pageUtil);

    boolean saveTag(String tagName);

    boolean deleteBatch(Integer[] ids);
}
