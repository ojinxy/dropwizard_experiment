package DropWizardProject.Expirement.resources;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class HelloWorldResourceTest {
	HelloWorldResource helloWorldResource;
	
	@Before
	public void setUp(){
		helloWorldResource = new HelloWorldResource("", "");
	}
	
	/*@Test
	public void testSayHello(){
		Optional<String> mockName = mock(Optional.class);
		when(mockName.orElse(Mockito.anyString())).thenReturn("Test");
		
		assertEquals("Test",helloWorldResource.sayHello(mockName));
	}*/
		
}
