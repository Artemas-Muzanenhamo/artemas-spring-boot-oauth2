package org.artemas.controllers;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ContactControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void accessApplication() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(status().isOk());
    }

    @Test
    public void loginRedirection() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/login")).andExpect(status().is3xxRedirection());
    }


//    @Test
//    public void getContact() throws Exception{
//        mockMvc.perform(MockMvcRequestBuilders.get("/contact").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }

}
