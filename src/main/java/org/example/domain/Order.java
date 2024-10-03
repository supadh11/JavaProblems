package org.example.domain;

import java.util.List;

public record Order(List<Item> itemList) {
}
