package cn.edu.buaa.myblog.service.impl;

import cn.edu.buaa.myblog.dao.BlogCategoryMapper;
import cn.edu.buaa.myblog.entity.BlogCategory;
import cn.edu.buaa.myblog.service.CategoryService;
import cn.edu.buaa.myblog.utils.PageQueryUtil;
import cn.edu.buaa.myblog.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private BlogCategoryMapper blogCategoryMapper;

    @Override
    public PageResult getBlogCategoryPage(PageQueryUtil pageUtil) {
        List<BlogCategory> categoryList = blogCategoryMapper.findCategoryList(pageUtil);
        int total = blogCategoryMapper.getTotalCategories(pageUtil);
        PageResult pageResult = new PageResult(categoryList, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    @Override
    public boolean saveCategory(String categoryName, String categoryIcon) {
        BlogCategory temp = blogCategoryMapper.selectByCategoryName(categoryName);
        if (temp == null) {
            BlogCategory blogCategory = new BlogCategory();
            blogCategory.setCategoryName(categoryName);
            blogCategory.setCategoryIcon(categoryIcon);
            return blogCategoryMapper.insertSelective(blogCategory) > 0;
        }

        return false;
    }

    @Override
    @Transactional
    public boolean updateCategory(Integer categoryId, String categoryName, String categoryIcon) {
        BlogCategory blogCategory = blogCategoryMapper.selectByPrimaryKey(categoryId);
        if (blogCategory != null) {
            blogCategory.setCategoryIcon(categoryIcon);
            blogCategory.setCategoryName(categoryName);
            return blogCategoryMapper.updateByPrimaryKeySelective(blogCategory) > 0;
        }

        return false;
    }

    @Override
    public BlogCategory selectById(Integer id) {
        return blogCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public boolean deleteBatch(Integer[] ids) {

        if (ids.length < 1) {

            return false;
        }
        return blogCategoryMapper.deleteBatch(ids) > 0;
    }

    @Override
    public List<BlogCategory> getAllCategories() {
        return blogCategoryMapper.findCategoryList(null);
    }

    @Override
    public int getTotalCategories() {
        return blogCategoryMapper.getTotalCategories(null);
    }
}
