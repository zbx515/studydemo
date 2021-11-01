package com.example.demo.nio.netty;

public class MessageEntry {
    private int id;
    private int length;
    private String content;

    public MessageEntry() {
    }

    public MessageEntry(int id, int length, String content) {
        this.id = id;
        this.length = length;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MessageEntry{" +
                "id=" + id +
                ", length=" + length +
                ", content='" + content + '\'' +
                '}';
    }
}
