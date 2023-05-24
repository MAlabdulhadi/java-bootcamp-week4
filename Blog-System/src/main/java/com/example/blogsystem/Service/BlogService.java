package com.example.blogsystem.Service;

import com.example.blogsystem.ApiExpcetion.ApiException;
import com.example.blogsystem.Model.Blog;
import com.example.blogsystem.Repository.BlogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    public List<Blog> getAllBlogs() {
        List<Blog> blogs = blogRepository.findAll();
        if (blogs.isEmpty()) {
            throw new ApiException("not have any blog");
        }
        return blogs;
    }

    public void addBlog(Blog blog) {
        blogRepository.save(blog);
    }

    public void updateBlog(Integer id, Blog blog) {
        Blog oldBlog = blogRepository.findBlogById(id);
        if (oldBlog == null) {
            throw new ApiException("not found any blog for this id");
        }
        oldBlog.setId(oldBlog.getId());
        oldBlog.setTitle(blog.getTitle());
        oldBlog.setCategory(blog.getCategory());
        oldBlog.setBody(blog.getBody());
        blogRepository.save(oldBlog);
    }

    public void deleteBlog(Integer id) {
        Blog oldBlog = blogRepository.findBlogById(id);
        if (oldBlog == null) {
            throw new ApiException("not found any blog for this id");
        }
        blogRepository.delete(oldBlog);
    }

    public Blog getBlogById(Integer id) {
        Blog oldBlog = blogRepository.findBlogById(id);
        if (oldBlog == null) {
            throw new ApiException("not have any blog for this id");
        }
        return oldBlog;
    }

    public Blog getBlogByTitle(String title) {
        Blog oldBlog = blogRepository.findBlogByTitle(title);
        if (oldBlog == null) {
            throw new ApiException("not have any blog for this title");
        }
        return oldBlog;
    }

    public List<Blog> getAllByCategory(String category) {
        List<Blog> blogs = blogRepository.getAllByCategory(category);
        if (blogs.isEmpty()) {
            throw new ApiException("this Category don't have any blog");
        }
        return blogs;
    }

    public void changePublishedStates(Integer Id) {
        Blog oldBlog = blogRepository.findBlogById(Id);
        if (oldBlog == null) {
            throw new ApiException("not have any blog for this id");
        }
        if (oldBlog.getIsPublished() == true) {
            throw new ApiException("already Publish");
        }
        oldBlog.setIsPublished(true);
        blogRepository.save(oldBlog);
    }
}
