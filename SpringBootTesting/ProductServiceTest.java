package Service;

import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.microserviceDemo.ProductService.Entity.Product;
import com.microserviceDemo.ProductService.controller.Controller;
import com.microserviceDemo.ProductService.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
	@Mock
	ProductRepository productRepo;
	@InjectMocks
	Controller productService;
	
	@BeforeAll
	public static void init() {
		System.out.println("BeforeAll");
	}
	@BeforeEach
	public void initEach() {
		System.out.println("BeforeEach");
	}
	
	@org.junit.jupiter.api.Test
	void addProductServiceSuccessFully() {
		Product product  = new Product();
		product.setId(1l);
		Mockito.when(productRepo.save(product)).thenReturn(product);
		Product added=productService.addProduct(product);
		Assertions.assertNotNull(added);
		Assertions.assertEquals(product.getId(), added.getId());
		Assertions.assertTrue(product.getId()==1l);
		
	}
	@Test
	public void deleteProduct() {
		Mockito.doNothing().when(productRepo).deleteById(1l);
		productRepo.deleteById(1l);
		Mockito.verify(productRepo,times(1)).deleteById(1l);
	}

}
