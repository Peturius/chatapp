package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @GetMapping("/tasks/all")
    public List<ChatEntity> getAllMessages() {
        return chatService.getAllMessages();
    }

    @PostMapping("/tasks/add")
    public ChatEntity addTask(@RequestBody ChatEntity chat) {
        ChatEntity chatEntity = chatService.addMessage(chat);

        /*if (chatEntity == null) {
            throw new TaskAlreadyAddedException("Task with ID " + chat.getID() + " already exists!");
        }*/

        return chatEntity;}


    @DeleteMapping("/tasks/delete/{id}")
    public ChatEntity deleteTask(@PathVariable int id) {
        ChatEntity chatEntity = chatService.deleteTask(id);

        if (chatEntity == null) {
            throw new ChatNotFoundException("Task not found with id: " + id);
        }

        return chatEntity;
    }

    @PutMapping("/tasks/update/{id}")
    public ChatEntity updateTask(@PathVariable int id, @RequestBody ChatEntity task) {
        ChatEntity chatEntity = chatService.updateTask(id, task);

        if(chatEntity == null) {
            throw new ChatNotFoundException("Task not found with id: " + id);
        }

        return chatEntity;
    }

}
