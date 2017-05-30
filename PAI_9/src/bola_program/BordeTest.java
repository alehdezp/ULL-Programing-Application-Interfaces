package bola_program;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class BordeTest {
	BolaFill bola = new BolaFill(Color.RED, 50);
	
	@Test
	public void bordeXD() {
		bola.setCenter(200, 200, 100);
		bola.setMoveX(250);//Max 150 + 50(radio)
		assertEquals(true, bola.getBorder());
		
		bola.setMoveX(50);
		assertEquals(false, bola.getBorder());
		
		bola.setMoveX(100);
		assertEquals(false, bola.getBorder());
		
		bola.setMoveX(150);
		assertEquals(true, bola.getBorder());
		
		//Borde de la ventana
		assertEquals(150, bola.getMoveX() );
	}
	
		
	
	@Test
	public void bordeXI() {
		bola.setCenter(200, 200, 100);
		bola.setMoveX(-250);
		assertEquals(true, bola.getBorder());
		bola.setMoveX(-50);
		assertEquals(false, bola.getBorder());
		bola.setMoveX(-100);
		assertEquals(false, bola.getBorder());
		bola.setMoveX(-150);
		assertEquals(true, bola.getBorder());
		
		//Borde de la ventana
		assertEquals(-150, bola.getMoveX() );
	}
	
	
	@Test
	public void BordeYU() {
		bola.setCenter(200, 200, 100);
		bola.setMoveY(-250);
		assertEquals(true, bola.getBorder());
		bola.setMoveY(-50);
		assertEquals(false, bola.getBorder());
		bola.setMoveY(-100);
		assertEquals(false, bola.getBorder());
		bola.setMoveY(-150);
		assertEquals(true, bola.getBorder());
		
		//Borde de la ventana
		assertEquals(-150, bola.getMoveY() );
		
	}

	@Test
	public void BordeYD() {
		bola.setCenter(200, 200, 100);
		bola.setMoveY(250);
		assertEquals(true, bola.getBorder());
		bola.setMoveY(50);
		assertEquals(false, bola.getBorder());
		bola.setMoveY(100);
		assertEquals(false, bola.getBorder());
		bola.setMoveY(150);
		assertEquals(true, bola.getBorder());
		
		
		//Borde de la ventana
		assertEquals(150, bola.getMoveY());
	}

	

}
