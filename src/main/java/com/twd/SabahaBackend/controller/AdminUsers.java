package com.twd.SabahaBackend.controller;

import com.twd.SabahaBackend.dto.ReqRes;
import com.twd.SabahaBackend.entity.Product;
import com.twd.SabahaBackend.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import com.twd.SabahaBackend.dto.PostDto;
import com.twd.SabahaBackend.dto.NoticeDto;
import com.twd.SabahaBackend.service.PostService;
import com.twd.SabahaBackend.service.NoticeService;
import org.springframework.http.HttpStatus;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AdminUsers {

    private final PostService postService;
    private final NoticeService noticeService;

    @Autowired
    private ProductRepo productRepo;

    // --- Post Operations ---

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        PostDto savedPost = postService.createPost(postDto);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable("id") Long postId) {
        PostDto postDto = postService.getPostById(postId);
        return ResponseEntity.ok(postDto);
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts() {
        List<PostDto> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    @PutMapping("{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable("id") Long postId, @RequestBody PostDto updatePost) {
        PostDto postDto = postService.updatePost(postId, updatePost);
        return ResponseEntity.ok(postDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.ok("Post deleted Successfully!");
    }

    // --- Notice Operations ---

    @PostMapping("/notice")
    public ResponseEntity<NoticeDto> createNotice(@RequestBody NoticeDto noticeDto) {
        NoticeDto savedNotice = noticeService.createNotice(noticeDto);
        return new ResponseEntity<>(savedNotice, HttpStatus.CREATED);
    }

    @GetMapping("/notice/{id}")
    public ResponseEntity<NoticeDto> getNoticeById(@PathVariable("id") Long noticeId) {
        NoticeDto noticeDto = noticeService.getNoticeById(noticeId);
        return ResponseEntity.ok(noticeDto);
    }

    @GetMapping("/notice")
    public ResponseEntity<List<NoticeDto>> getAllNotices() {
        List<NoticeDto> notices = noticeService.getAllNotices();
        return ResponseEntity.ok(notices);
    }

    @PutMapping("/notice/{id}")
    public ResponseEntity<NoticeDto> updateNotice(@PathVariable("id") Long noticeId, @RequestBody NoticeDto updatedNotice) {
        NoticeDto noticeDto = noticeService.updateNotice(noticeId, updatedNotice);
        return ResponseEntity.ok(noticeDto);
    }

    @DeleteMapping("/notice/{id}")
    public ResponseEntity<String> deleteNotice(@PathVariable("id") Long noticeId) {
        noticeService.deleteNotice(noticeId);
        return ResponseEntity.ok("Notice deleted Successfully!");
    }

    // --- Product Operations ---

    @GetMapping("/public/product")
    public ResponseEntity<Object> getAllProducts() {
        return ResponseEntity.ok(productRepo.findAll());
    }

    @PostMapping("/admin/saveproduct")
    public ResponseEntity<Object> signUp(@RequestBody ReqRes productRequest) {
        Product productToSave = new Product();
        productToSave.setName(productRequest.getName());
        return ResponseEntity.ok(productRepo.save(productToSave));
    }

    // --- Miscellaneous ---

    @GetMapping("/user/alone")
    public ResponseEntity<Object> userAlone() {
        return ResponseEntity.ok("Users alone can access this API only");
    }

    @GetMapping("/adminuser/both")
    public ResponseEntity<Object> bothAdminAndUsersApi() {
        return ResponseEntity.ok("Both Admin and Users can access the API");
    }

    @GetMapping("/public/email")
    public String getCurrentUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication); // get all details (name, email, password, roles, etc.) of the user
        System.out.println(authentication.getDetails()); // get remote IP
        System.out.println(authentication.getName()); // returns the email because the email is the unique identifier
        return authentication.getName(); // returns the email
    }
}
