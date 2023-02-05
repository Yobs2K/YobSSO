package com.example.web.component.navigation;

public class NavBar {
    private String url;
    private String name;

    public NavBar(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public NavBar setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getName() {
        return name;
    }

    public NavBar setName(String name) {
        this.name = name;
        return this;
    }
}
