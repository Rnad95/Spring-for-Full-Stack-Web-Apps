package com.example.songr;

import com.example.songr.domain.Album;
import com.example.songr.web.HelloController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;



@SpringBootTest
class SongrApplicationTests {


	//	@Test
//	void contextLoads() {
//	}
	@Test void TestConstructorInAlbumClass(){
		Album album1 = new Album("Map of the Soul: Persona","BTS",7,"1563","https://i.pinimg.com/originals/c4/6c/c2/c46cc23adeec3ca1603d7c79a742a4ef.png");
		System.out.println(album1);
		String str = "Album{title='Map of the Soul: Persona', artist='BTS', count=7, length='1563 sec', imageUrl='https://i.pinimg.com/originals/c4/6c/c2/c46cc23adeec3ca1603d7c79a742a4ef.png'}";
		assertEquals(str,album1.toString());
	}
	@Test void TestGetterInAlbumClass(){
		Album album = new Album("Map of the Soul: Persona","BTS",7,"1563","https://i.pinimg.com/originals/c4/6c/c2/c46cc23adeec3ca1603d7c79a742a4ef.png");
		String expected = "Map of the Soul: Persona";
		assertEquals(expected,album.getTitle());
	}
	@Test void TestSetterInAlbumClass(){
		Album album = new Album("Map of the Soul: Persona","BTS",7,"1563","https://i.pinimg.com/originals/c4/6c/c2/c46cc23adeec3ca1603d7c79a742a4ef.png");
		String expected = "Dynamite";
		album.setTitle("Dynamite");
		String actual = album.getTitle();
		assertEquals(expected,actual);
	}


	@Autowired
	private HelloController helloController;
	@Test public  void testController(){
		String result = this.helloController.hello();
		assertEquals("helloWorld",result);
	}
}
