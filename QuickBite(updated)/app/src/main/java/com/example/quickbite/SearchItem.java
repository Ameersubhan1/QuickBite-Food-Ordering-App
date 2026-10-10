package com.example.quickbite;

public class SearchItem {
    private String name;
    private String category;
    private int imageResId;
    private String imageUrl;

    public SearchItem(String name, String category, int imageResId) {
        this.name = name;
        this.category = category;
        this.imageResId = imageResId;
        this.imageUrl = null;
    }

    public SearchItem(String name, String category, String imageUrl) {
        this.name = name;
        this.category = category;
        this.imageResId = 0;
        this.imageUrl = imageUrl;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public int getImageResId() { return imageResId; }
    public String getImageUrl() { return imageUrl; }
}