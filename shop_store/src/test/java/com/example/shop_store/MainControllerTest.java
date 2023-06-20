package com.example.shop_store;

import com.example.shop_store.controllers.MainController;
import com.example.shop_store.repos.CategoryRepo;
import com.example.shop_store.repos.GoodsRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(MainController.class)
public class MainControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GoodsRepo goodsRepo;
    @MockBean
    private CategoryRepo categoryRepo;

    @Test
    public void testTest2Page() throws Exception{
        mockMvc.perform(get("/test2")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("test"))
                .andExpect(MockMvcResultMatchers.content().string(containsString("test")));
    }
}
