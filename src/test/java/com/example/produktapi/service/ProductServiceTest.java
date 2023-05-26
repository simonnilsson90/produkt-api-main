package com.example.produktapi.service;

import com.example.produktapi.exception.BadRequestException;
import com.example.produktapi.model.Product;
import com.example.produktapi.repository.ProductRepository;
import jakarta.persistence.Id;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.BDDMockito.*;

import org.mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;


import static javax.management.Query.times;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService underTest;

    @Captor
    ArgumentCaptor<Product> productCaptor;


    /*
     1. Alla metoder i service-klassen testas med lämpliga enhetstester
     (observera att det ibland kan vara lämpligt med fler enhetstester av samma metod).
2. Mockning tillämpas där så är lämpligt, dvs. Åtminstone då serviceklassen enhetstestas ska repositoryt vara mockat.
3. Konfiguration mot Github Actions som automatiskt bygger och kör alla tester för varje gång koden pushas.
     */


    // Tester till inlämning

    // Metoder att testa:
    // getAllProducts()    Check
    // getAllCategories()  Check
    // getProductsByCategory(String category) check
    // getProductById(Integer id) Check
    // addProduct(Product product) Check  OBS!! Fattas felflöde
    // updateProduct(Product updatedProduct, Integer id) OBS !!! Fattas felflöde
    // deleteProduct(Integer id) Check



    // Testar getAllProducts()

    @Test
    void givenGetAllProducts_thenOnlyOneInteractionWithRepositoryMethodFindALl() {
        // when, När vi ropar på getAllProducts
        underTest.getAllProducts();
        // then, då verifierar vi att vårt repository åberopas med Metoden findAll exakt en gång.
        verify(repository, Mockito.times(1)).findAll();
    }
    // Test Passed

    // Testar getAllCategories() att den nås genom Repositoryt
    @Test
    void givenGetAllCategories_thenExactlyOneInteractionWithRepositoryMethodFindALlCategories() {

        // when
        underTest.getAllCategories();

        // then
        verify(repository, Mockito.times(1)).findAllCategories();
    }
    // Test Passed


    // Testar getProductsByCategory(String category)
    @Test

    void givenGetProductsByCategory_thenOneInteractionWithRepositoryMethodGetProductsByCategory() {

        // when
        underTest.getProductsByCategory("jewelery");
        // then
        verify(repository, Mockito.times(1)).findByCategory("jewelery");
    }
    // Test passed


    @Test
        // Testar om det går att lägga till ny produkt genom att anropa underTest.addProduct(product)

    void whenCreatingNewProduct_thenOneInteractionWithMethodGetProductsByCategory() {
// given
        Product product = new Product("Lasersvärd", 40.0, "sword", "red", "img");
       // when
        underTest.addProduct(product);

        //then
        BDDMockito.verify(repository).save(Mockito.any(Product.class));
    }
    // Test passed


    // Testar att getProductById(Integer id) blir kallad
    @Test

    void whenGettingProductById_thenGetProductByIdShouldBeCalled() {
// given

        Product product = new Product("Adidas 500", 14.5, "shoes", "cool", "img");

       given(repository.findById(1)).willReturn(Optional.of(product));
       //when
        underTest.getProductById(1);
        // then
        BDDMockito.verify(repository).findById(1);
    }
    // Test passed?

   /* @Test
    void testingIfProductIsEmptyThenThrowEntityNotFound (){
}    */



    // Testar addProduct(Product product) att det går att åberopa addProduct
    @Test

    void whenAddingProduct_thenSaveMethodShouldBeCalled (){
        // given
        Product product = new Product("Holy Graal", 5000.0, "jewelry","The real one, found on the bottom of the ocean ner Island of all places","img_hg" );
        // when
        underTest.addProduct(product);

        // then
        verify(repository).save(product);
    }
    // Test passed




// Testar att updateProduct åberopas Använder
// ArgumentMatchers.eq() för att jämföra objekten och verifiera att save()-metoden
// anropas med rätt uppdaterade produkt.

@Test
void upDateProduct() {
    // given
    Integer id = 1;
    Product updatedProduct = new Product("Updated Product", 20.0, "category", "description", "img");
    given(repository.findById(id)).willReturn(Optional.of(new Product("Original Product", 10.0, "category", "description", "img")));

    // when
    underTest.updateProduct(updatedProduct, id);

    // then
    BDDMockito.verify(repository).findById(id);
    BDDMockito.verify(repository).save(ArgumentMatchers.eq(updatedProduct));
}


// Test failed





    // Testar delete Product
@Test
    void deleteProduct(){
        // when
    repository.deleteById(1);
    // then
    BDDMockito.verify(repository).deleteById(1);
}




    @Test
    // Product updateProduct(Product updatedProduct, Integer id)
    void testingUpdateProduct () {
// when


    }

}


/*

    @Test
    void whenGettAllCategories_thenOnlyOneInteractionWithRepositoryMethodFindALlGetByCategory(){
        // when
        underTest.getAllCategories();
        // then
        verify(repository, Mockito.times(1)).findAllCategories();
        verifyNoMoreInteractions((repository));
    }

    /*



    @Test
    void givenAnExistingCategory_whenGetProductsByCategory_ThenReceivesANonEmptyList (){
        // when
     //  List<Product> underTest.getProductsByCategory("Electronics");
    }


*/








