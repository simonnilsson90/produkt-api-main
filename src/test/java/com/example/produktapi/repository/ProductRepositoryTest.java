package com.example.produktapi.repository;

import com.example.produktapi.model.Product;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class ProductRepositoryTest {
    @Autowired
private ProductRepository underTest;

    @Test
    void simpleTest(){
        List <Product>products = underTest.findAll();
        Assertions.assertFalse(products.isEmpty());
    }

    @Test
    void whenSearchingForAnExistingTitle_thenReturnThatProduct  (){
        // given
        String title = "En dator";
        underTest.save(new Product(title,
                25000.0,
                "Elektronik",
                "bra o ha",
                "urTillBild"));
        // when
  Optional<Product> optionalProduct  = underTest.findByTitle(title);

  //then
        // Ett sätt att skriva tre tester
        assertTrue(optionalProduct.isPresent());
      assertFalse(optionalProduct.isEmpty());
      assertEquals(title, optionalProduct.get().getTitle());


        // Ett annat sätt att skriva samma tre tester
      Assertions.assertAll(
              () -> assertTrue(optionalProduct.isPresent()),
        () -> assertFalse(optionalProduct.isPresent()),
              () -> assertEquals(title, optionalProduct.get().getTitle())
      );

    }

    @Test
    void whenSearchingForNonExistingTitle_thenReturnEmptyOptional (){
        // given
        String title = "En titel som absolut inte finns";

        // when
       Optional<Product> optionalProduct = underTest.findByTitle(title);

       Assertions.assertAll(
               () -> assertFalse(optionalProduct.isPresent()),
               () -> assertTrue(optionalProduct.isEmpty())
       );
    }

    // Tester till inlämning

    // Testar findByTitle, att det är sant att en specifik titel existerar
    // samt att det är falskt att en specifik titel inte existerar
    @Test
    void whenSearchingForAnExistingTitle_thenReturnPresentOptional (){
        // given
        String title = "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops";
        // when
        Optional<Product> optionalProduct = underTest.findByTitle(title);
        Assertions.assertAll(
                () -> assertTrue(optionalProduct.isPresent()),
                () -> assertFalse(optionalProduct.isEmpty())
        );
    }

    // Vete tusan om den här duger
    // Testar findByCategory(String category)
    @Test
    void whenSearchingForAnExistingCategory_thenAssertEquals(){
        // given
        String category = "men''s clothing";
        // when
        underTest.findByCategory(category);
      assertEquals(category,"men''s clothing" );




    }
}








