package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    private final List<String> messages = new ArrayList<>();

    public List<String> getMessages(String startsWith) {
        if (startsWith == null || startsWith.isEmpty()) {
            return messages;
        }
        List<String> filtered = new ArrayList<>();
        for (String m : messages) {
            if (m.startsWith(startsWith)) filtered.add(m);
        }
        return filtered;
    }

    public void addMessage(String message) {
        messages.add(message);
    }

    public String getMessage(int index) {
        return messages.get(index);
    }

    public void deleteMessage(int index) {
        messages.remove(index);
    }

    public void updateMessage(int index, String message) {
        messages.set(index, message);
    }

    public int searchFirst(String text) {
        for (int i = 0; i < messages.size(); i++) {
            if (messages.get(i).contains(text)) return i;
        }
        return -1;
    }

    public int count() {
        return messages.size();
    }

    public void createAtIndex(int index, String text) {
        messages.add(index, text);
    }

    public void deleteAllWithSubstring(String text) {
        messages.removeIf(m -> m.contains(text));
    }
}
