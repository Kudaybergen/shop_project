package com.example.shop_store;

import com.example.shop_store.controllers.AuthController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AuthController.class)
public class AuthControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testTestPage() throws Exception{
        mockMvc.perform(get("/test")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("test")) // Имя представления в папке resources/template
                .andExpect(content().string(containsString("test")));
    }

    @Test
    public void testIndexPage() throws Exception{
        mockMvc.perform(get("/")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }
}
