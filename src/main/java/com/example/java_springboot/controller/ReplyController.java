package com.example.java_springboot.controller;

import com.example.java_springboot.entity.Reply;
import com.example.java_springboot.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/admin")
public class ReplyController {
        @Autowired
        ReplyService replyService;

        @RequestMapping(method = RequestMethod.GET, path = "/replies")
        public Page<Reply> getList(@RequestParam(defaultValue = "1") int page,
                                   @RequestParam(defaultValue = "1") int limit) {
            return replyService.findAll(page, limit);

        }

        @RequestMapping(method = RequestMethod.GET, path = "/replies/get-all")
        public List<Reply> getList() {
            return replyService.getAll();
        }

        @RequestMapping(method = RequestMethod.POST, path = "/replies")
        public Reply save(@RequestBody Reply reply) {
            replyService.save(reply);
            return reply;
        }

        @RequestMapping(method = RequestMethod.GET, path = "/replies/{id}")
        public Reply getDetail(@PathVariable Integer id) {
            return replyService.findById(id).get();
        }

        @RequestMapping(method = RequestMethod.DELETE, path = "/replies/{id}")
        public boolean delete(@PathVariable Integer id) {
            replyService.deleteById(id);
            return true;
        }

        @RequestMapping(method = RequestMethod.PUT, path = "/replies/{id}")
        public Reply update(@PathVariable Integer id, @RequestBody Reply updateReply) {
            Reply existing = replyService.findById(id).get();
            existing.setContent(updateReply.getContent());
            existing.setStatus(updateReply.getStatus());
            replyService.save(existing);
            return updateReply;
        }
}
