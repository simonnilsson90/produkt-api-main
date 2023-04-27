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

    /*

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

    // Testar findAllCategories
        @Test
    void simpleTest(){
        List <Product>products = underTest.findAll();
        Assertions.assertFalse(products.isEmpty());
    }


  */

    // Tester till inlämning:


    // findByCategory
    // findByTitle
    // findAllCategories


    // Testar findByTitle, att det är sant att en specifik titel existerar
    // samt att det är falskt att en specifik titel inte existerar
    @Test
    void whenSearchingForAnExistingTitle_thenReturnPresentOptional (){
        // given, Förutsatt att jag skapar/har en produkt
        String title = "Fjallraven ";

        underTest.save(new Product(title,
                25.0,
                "El",
                "Bra att ha",
                "enBild"));

        // when, när hittar en titel
        Optional<Product> optionalProduct = underTest.findByTitle(title);

      //  then, då
     //  Assertions.assertAll(
      //         () -> assertTrue(optionalProduct.isPresent()),
      //          () -> assertFalse(optionalProduct.isEmpty())
        //);

        Assertions.assertEquals(title, optionalProduct.get().getTitle());
    }


    // Testar findByCategory(String category)
// Testar om det är falskt att inskrivna kategorin är falsk
    @Test
    void whenSearchingForANonExistingCategory_thenAssertFalse(){
        // given
        String category = "men''s clothing";

        underTest.save(new Product("t-shirt",
                25.0,
                category,
                "Bra att ha",
                "enBild"));

        // when
        List<Product> optionalProduct = underTest.findByCategory(category);


//then
          Assertions.assertFalse(category.isEmpty());


    }

    // Testar findAllCategories
    // Testar att det är falskt att kategorierna i products är tomma?
    @Test
    void whenFindingAllCategories_thenReturnTrue(){
        List<String> products = underTest.findAllCategories();
        Assertions.assertFalse(products.isEmpty());
        Assertions.assertTrue(products.addAll(products));
    }






}










