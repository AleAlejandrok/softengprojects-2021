
package com.proj.SWENG1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Vector3DTest {

	@Test
	void testVector3D() {
		Vector3D testVector = new Vector3D(1,1,1);
		if(testVector != null) {
			return;
		}
	}

	@Test
	void testScale() {
		Vector3D testVector = new Vector3D(1,1,1);
		testVector.scale(2);
		if(testVector.x == 2 && testVector.y == 2 &&testVector.z == 2) {
			return;
		}else
			fail("Failed scaling operation");
				
	}

	@Test
	void testAdd() {
		Vector3D testVector = new Vector3D(1,1,1);
		Vector3D testVector2 = new Vector3D(1,1,1);
		testVector.add(testVector2);
		if(testVector.x == 2 && testVector.y == 2 &&testVector.z == 2) {
			return;
		}else
			fail("Failed adding operation");
	}

	@Test
	void testSubtract() {
		Vector3D testVector = new Vector3D(1,1,1);
		Vector3D testVector2 = new Vector3D(1,1,1);
		testVector.add(testVector2);
		if(testVector.x == 0 && testVector.y == 0 &&testVector.z == 0) {
			return;
		}else
			fail("Failed adding operation");
	}

	@Test
	void testNegate() {
		Vector3D testVector = new Vector3D(1,1,1);
		testVector.negate();
		if(testVector.x == -1 && testVector.y == -1 &&testVector.z == -1) {
			return;
		}else
			fail("Failed Negation operation");
	}

	@Test
	void testDot() {
		Vector3D testVector = new Vector3D(2,4,8);
		Vector3D testVector2 = new Vector3D(3,3,3);
		testVector.dot(testVector2);
		if(testVector.x == 6 && testVector.y == 12 &&testVector.z == 24) {
			return;
		}else
			fail("Failed dot product operation");
	}

	@Test
	void testMagnitude() {
		Vector3D testVector = new Vector3D(2,4,8);
		double testVar = testVector.magnitude();
		if(testVar==9.16515138991168) {
			return;
		}else
			fail("Failed magnitude operation");	
	}

	@Test
	void testToString() {
		Vector3D testVector = new Vector3D(2,4,8);
		String testVar = testVector.toString();
		if(testVar.equals("[2],[4],[8]")) {
			return;
		}else
			fail("Failed String operation");	
	}	

	@Test
	void testEqualsVector3D() {
		fail("Not yet implemented"); // TODO
	}

}
