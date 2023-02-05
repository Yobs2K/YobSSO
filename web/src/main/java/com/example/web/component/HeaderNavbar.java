package com.example.web.component;

import com.example.web.component.navigation.NavBar;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@Component
public class HeaderNavbar {
    private final List<NavBar> headerNavBar = new LinkedList<>();

    @PostConstruct
    private void constuctNavbar(){
        headerNavBar.add(new NavBar("/dashboard", "Обзор"));
        headerNavBar.add(new NavBar("/company", "Мои компании"));
        headerNavBar.add(new NavBar("/apps", "Мои приложения"));
    }

    public List<NavBar> getHeaderNavBar() {
        return headerNavBar;
    }
}
