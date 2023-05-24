package com.example.blogsystem.Controller;


import com.example.blogsystem.Model.Blog;
import com.example.blogsystem.Service.BlogService;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blog")
@AllArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/get-all-blogs")
    public ResponseEntity getAllBlogs() {
        List<Blog> blogs = blogService.getAllBlogs();
        return ResponseEntity.status(200).body(blogs);
    }

    @PostMapping("/add-blog")
    public ResponseEntity addBlog(@RequestBody @Valid Blog blog) {
        blogService.addBlog(blog);
        return ResponseEntity.status(200).body("done add !");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBlog(@PathVariable Integer id, @RequestBody @Valid Blog blog) {
        blogService.updateBlog(id, blog);
        return ResponseEntity.status(200).body("done update !");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBlog(@PathVariable Integer id) {
        blogService.deleteBlog(id);
        return ResponseEntity.status(200).body("done delete");
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity getBlogById(@PathVariable Integer id) {
        Blog blog = blogService.getBlogById(id);
        return ResponseEntity.status(200).body(blog);
    }

    @GetMapping("/get-by-title/{title}")
    public ResponseEntity getBlogByTitle(@PathVariable String title) {
        Blog blog = blogService.getBlogByTitle(title);
        return ResponseEntity.status(200).body(blog);
    }

    @GetMapping("/get-by-category/{category}")
    public ResponseEntity getAllByCategory(@PathVariable String category) {
        List<Blog> blogs = blogService.getAllByCategory(category);
        return ResponseEntity.status(200).body(blogs);
    }

    @PutMapping("/change-state/{id}")
    public ResponseEntity changePublishedStates(@PathVariable Integer id) {
        blogService.changePublishedStates(id);
        return ResponseEntity.status(200).body("do change state this blog to true");
    }


}
