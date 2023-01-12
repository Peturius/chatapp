package com.example.demo;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatService {
    @Autowired
    ChatReporitory chatRepository;

    public ChatService(){}


    @Description("cica")
    public List<ChatEntity> getAllMessages() {
        return chatRepository.findAll().stream().toList();
    }
    @Parameter(description = "mica")
    @Description("addd")
    public ChatEntity addMessage(ChatEntity chat){
        Optional<ChatEntity> chatEntity = chatRepository.findById(chat.getID());
        if (!chatEntity.isPresent()) {
            return chatRepository.save(chat);
        }
        return null;
    }

    @Parameter(description = "The task to be added to the database")
    @Description("Adds a task to the database")
    public ChatEntity addTask(ChatEntity task) {
        Optional<ChatEntity> taskEntity = chatRepository.findById(task.getID());

        if (!taskEntity.isPresent()) {
            return chatRepository.save(task);
        }

        return null;
    }

    @Parameter(description = "The ID of the task to delete")
    @Description("Deletes a task from the database")
    public ChatEntity deleteTask(int id) {
        Optional<ChatEntity> taskEntity = chatRepository.findById(id);
        if (taskEntity.isPresent()) {
            chatRepository.deleteById(id);
            return taskEntity.get();
        }
        return null;
    }

    @Parameter(description = "The ID of the task to update")
    @Description("Updates a task in the database")
    public ChatEntity updateTask(int id, ChatEntity task) {
        Optional<ChatEntity> taskEntity = chatRepository.findById(id);
        if (taskEntity.isPresent()) {
            task.setID(id);
            return chatRepository.save(task);
        }
        return null;
    }
}
