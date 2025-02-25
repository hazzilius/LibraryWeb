package com.example.LibraryWeb.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

public enum Role {
    USER("Пользователь"),
    ADMIN("Администратор");

    Role(String name) {
    }
}
