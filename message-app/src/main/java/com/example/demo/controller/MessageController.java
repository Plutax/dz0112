package com.example.demo.controller;

import com.example.demo.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService service;

    public MessageController(MessageService service) {
        this.service = service;
    }

    // curl: GET http://localhost:8080/messages
    // curl with filter: GET http://localhost:8080/messages?startsWith=He
    @GetMapping
    public ResponseEntity<List<String>> getMessages(
            @RequestParam(required = false) String startsWith) {
        return ResponseEntity.ok(service.getMessages(startsWith));
    }

    // curl: POST - add message (text/plain)
    @PostMapping
    public ResponseEntity<Void> addMessage(@RequestBody String text) {
        service.addMessage(text);
        return ResponseEntity.accepted().build();
    }

    // curl: GET /messages/{index}
    @GetMapping("/{index}")
    public ResponseEntity<String> getMessage(@PathVariable int index) {
        return ResponseEntity.ok(service.getMessage(index));
    }

    // curl: DELETE /messages/{index}
    @DeleteMapping("/{index}")
    public ResponseEntity<Void> deleteMessage(@PathVariable int index) {
        service.deleteMessage(index);
        return ResponseEntity.noContent().build();
    }

    // curl: PUT /messages/{index} with text/plain body
    @PutMapping("/{index}")
    public ResponseEntity<Void> updateMessage(@PathVariable int index,
                                              @RequestBody String text) {
        service.updateMessage(index, text);
        return ResponseEntity.accepted().build();
    }

    // Оценка 4: поиск первого индекса с подстрокой
    // curl: GET /messages/search/{text}
    @GetMapping("/search/{text}")
    public ResponseEntity<Integer> search(@PathVariable String text) {
        return ResponseEntity.ok(service.searchFirst(text));
    }

    // curl: GET /messages/count
    @GetMapping("/count")
    public ResponseEntity<Integer> countMessages() {
        return ResponseEntity.ok(service.count());
    }

    // curl: POST /messages/{index}/create  (body - text/plain)
    @PostMapping("/{index}/create")
    public ResponseEntity<Void> createAtIndex(@PathVariable int index, @RequestBody String text) {
        service.createAtIndex(index, text);
        return ResponseEntity.accepted().build();
    }

    // curl: DELETE /messages/search/{text}  - удалить все содержащие подстроку
    @DeleteMapping("/search/{text}")
    public ResponseEntity<Void> deleteBySubstring(@PathVariable String text) {
        service.deleteAllWithSubstring(text);
        return ResponseEntity.noContent().build();
    }
}
