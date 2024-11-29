package com.tka.virtual_assistant.enums;

public enum Status {
    UPCOMING("Sắp tới"),
    ONGOING("Đang diễn ra"),
    COMPLETED("Đã hoàn thành"),
    CANCELLED("Đã hủy");

    private final String description;

    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}


