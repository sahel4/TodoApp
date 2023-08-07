package com.todolist.dto;

import lombok.Getter;

public class TodoDto {
    @Getter
    public static class Post {
        private String title;
        private int todoOrder;
        private boolean completed;
    }

    @Getter
    public static class Patch {
        private String title;
        private int todoOrder;
        private boolean completed;
    }

}
