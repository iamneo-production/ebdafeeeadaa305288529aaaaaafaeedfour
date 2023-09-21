package com.examly.springapp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import com.examly.springapp.controller.LaptopController;
import com.examly.springapp.model.Laptop;
import com.examly.springapp.service.ApiService;

@ExtendWith(MockitoExtension.class)
public class SpringappApplicationTests {

    @Mock
    private ApiService apiService;

    @InjectMocks
    private LaptopController laptopController;

    @Test
    public void testAddLaptop() {
        Laptop laptopToAdd = new Laptop(1, "Brand", 1000);

        when(apiService.addLaptop(laptopToAdd)).thenReturn(true);

        boolean response = laptopController.addLaptop(laptopToAdd);

        assertThat(response).isTrue();

        verify(apiService, times(1)).addLaptop(laptopToAdd);
    }

    @Test
    public void testGetLaptopById() {
        Laptop laptop = new Laptop(1, "Brand", 1000);

        when(apiService.getLaptopById(1)).thenReturn(laptop);

        Laptop response = laptopController.getLaptopById(1);

        assertThat(response).isEqualTo(laptop);

        verify(apiService, times(1)).getLaptopById(1);
    }

    @Test
    public void testGetAllLaptops() {
        List<Laptop> mockLaptops = new ArrayList<>();
        mockLaptops.add(new Laptop(1, "Brand1", 1000));
        mockLaptops.add(new Laptop(2, "Brand2", 1500));

        when(apiService.getAllLaptops()).thenReturn(mockLaptops);

        List<Laptop> response = laptopController.getAllLaptops();

        assertThat(response).isEqualTo(mockLaptops);

        verify(apiService, times(1)).getAllLaptops();
    }

	  @Test 
    public void testcontrollerfolder() { 
        String directoryPath = "src/main/java/com/examly/springapp/controller"; // Replace with the path to your directory 
        File directory = new File(directoryPath); 
        assertTrue(directory.exists() && directory.isDirectory()); 
    }
    
    @Test 
    public void testcontrollerfile() { 
        String filePath = "src/main/java/com/examly/springapp/controller/LaptopController.java"; 
        // Replace with the path to your file 
        File file = new File(filePath); 
        assertTrue(file.exists() && file.isFile()); 
    }

	@Test 
    public void testModelFolder() { 
        String directoryPath = "src/main/java/com/examly/springapp/model"; // Replace with the path to your directory 
        File directory = new File(directoryPath); 
        assertTrue(directory.exists() && directory.isDirectory()); 
    }
    
    @Test 
    public void testModelFile() { 
        String filePath = "src/main/java/com/examly/springapp/model/Laptop.java"; 
        // Replace with the path to your file 
        File file = new File(filePath); 
        assertTrue(file.exists() && file.isFile()); 
    }


	@Test 
    public void testServiceFolder() { 
        String directoryPath = "src/main/java/com/examly/springapp/service"; // Replace with the path to your directory 
        File directory = new File(directoryPath); 
        assertTrue(directory.exists() && directory.isDirectory()); 
    }
    
    @Test 
    public void testServieFile() { 
        String filePath = "src/main/java/com/examly/springapp/service/ApiService.java"; 
        // Replace with the path to your file 
        File file = new File(filePath); 
        assertTrue(file.exists() && file.isFile()); 
    }
}
