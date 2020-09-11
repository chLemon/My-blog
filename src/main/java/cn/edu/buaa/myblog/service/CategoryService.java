package cn.edu.buaa.myblog.service;

import cn.edu.buaa.myblog.entity.BlogCategory;
import cn.edu.buaa.myblog.utils.PageQueryUtil;
import cn.edu.buaa.myblog.utils.PageResult;

import java.util.List;

public interface CategoryService {
    PageResult getBlogCategoryPage(PageQueryUtil pageUtil);

    boolean saveCategory(String categoryName, String categoryIcon);

    boolean updateCategory(Integer categoryId, String categoryName, String categoryIcon);

    BlogCategory selectById(Integer id);

    boolean deleteBatch(Integer[] ids);

    List<BlogCategory> getAllCategories();

    int getTotalCategories();
}
