/*
 * Mark Green
 * Dr. Hong Zhang
 * CSCI 5830
 * 5 May 2011
 */

import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.geometry.*;

public class Room extends Shape3D {
	//Scale:
	float scale = 2;
	float width = 0.32142857142857142857142857142857f;
	float length = 0.32142857142857142857142857142857f;
	float height = 0.32142857142857142857142857142857f;
	float pheta = (float)Math.PI / 3.0f;
	
	float doorPositionStart1 = 0;
	float doorPositionEnd1 = 0.10f;
	float doorHeight1 = height / 2;
	
	float doorPositionStart2 = 0;
	float doorPositionEnd2 = 0.10f;
	float doorHeight2 = height / 2;
	
	float doorPositionStart3 = 0;
	float doorPositionEnd3 = 0.10f;
	float doorHeight3 = height / 2;
	
	//Constructor for 1 doored room
	Room (double width, double length, double height,
			double doorPositionStart1, double doorPositionEnd1, double doorHeight1) {
		this.width = (float)width;
		this.length = (float)length;
		this.height = (float)height;
		this.doorPositionStart1 = (float)doorPositionStart1;
		this.doorPositionEnd1 = (float)doorPositionEnd1;
		this.doorHeight1 = (float)doorHeight1;
	}
	
	//Constructor for 2 doored room
	Room (double width, double length, double height,
			double doorPositionStart1, double doorPositionEnd1, double doorHeight1,
			double doorPositionStart2, double doorPositionEnd2, double doorHeight2) {
		this.width = (float)width;
		this.length = (float)length;
		this.height = (float)height;
		this.doorPositionStart1 = (float)doorPositionStart1;
		this.doorPositionEnd1 = (float)doorPositionEnd1;
		this.doorHeight1 = (float)doorHeight1;
		this.doorPositionStart2 = (float)doorPositionStart2;
		this.doorPositionEnd2 = (float)doorPositionEnd2;
		this.doorHeight2 = (float)doorHeight2;
	}
	//Constructor for 3 doored room
	Room (double width, double length, double height,
			double doorPositionStart1, double doorPositionEnd1, double doorHeight1,
			double doorPositionStart2, double doorPositionEnd2, double doorHeight2,
			double doorPositionStart3, double doorPositionEnd3, double doorHeight3) {
		this.width = (float)width;
		this.length = (float)length;
		this.height = (float)height;
		this.doorPositionStart1 = (float)doorPositionStart1;
		this.doorPositionEnd1 = (float)doorPositionEnd1;
		this.doorHeight1 = (float)doorHeight1;
		this.doorPositionStart2 = (float)doorPositionStart2;
		this.doorPositionEnd2 = (float)doorPositionEnd2;
		this.doorHeight2 = (float)doorHeight2;
		this.doorPositionStart3 = (float)doorPositionStart3;
		this.doorPositionEnd3 = (float)doorPositionEnd3;
		this.doorHeight3 = (float)doorHeight3;
	}
	
	Shape3D createRoom1Door() {
		IndexedQuadArray room = new IndexedQuadArray(15,
				IndexedQuadArray.COORDINATES|IndexedQuadArray.TEXTURE_COORDINATE_2, 80);
		int p = 0;
		
		room.setCoordinate(p++, new Point3f(0f * scale, 0f * scale, 0f * scale));
		
		room.setCoordinate(p++, new Point3f(0f * scale, 0f * scale, length * scale));
		room.setCoordinate(p++, new Point3f(0f * scale, height * scale, 0f * scale));
		
		room.setCoordinate(p++, new Point3f(0f * scale, height * scale, length * scale));
		room.setCoordinate(p++, new Point3f(width * scale, 0f * scale, 0f * scale));
		
		room.setCoordinate(p++, new Point3f(width * scale, 0f * scale, length * scale));
		room.setCoordinate(p++, new Point3f(width * scale, height * scale, 0f * scale));
		
		room.setCoordinate(p++, new Point3f(width * scale, height * scale, length * scale));
		
		//Door slot
		room.setCoordinate(p++, new Point3f(doorPositionStart1 * scale, 0f * scale, 0f * scale));
		room.setCoordinate(p++, new Point3f(doorPositionStart1 * scale, doorHeight1 * scale, 0));
		room.setCoordinate(p++, new Point3f(doorPositionEnd1 * scale, 0f * scale, 0f * scale));
		room.setCoordinate(p++, new Point3f(doorPositionEnd1 * scale, doorHeight1 * scale, 0));
		room.setCoordinate(p++, new Point3f(0 * scale, doorHeight1 * scale, 0));
		room.setCoordinate(p++, new Point3f(width * scale, doorHeight1 * scale, 0));
		
		int[] roomIndices = {0,1,3,2,
							0,4,5,1,
							3,7,6,2,
							6,7,5,4,
							7,3,1,5,
							12,9,8,0,
							11,13,4,10,
							2,6,13,12,
							};
		room.setCoordinateIndices(0, roomIndices);
		
		//Cut Texture Map into 4 sections
		TexCoord2f[] tex = {new TexCoord2f(0,0), new TexCoord2f(0, 0.5f), new TexCoord2f(0, 1), 
							new TexCoord2f(0.5f, 0), new TexCoord2f(0.5f, 0.5f),  new TexCoord2f(0.5f, 1),
							new TexCoord2f(1,0), new TexCoord2f(1f, 0.5f), new TexCoord2f(1, 1),
							};
		
		int[] texIndices = {5,8,7,4,
							1,2,5,4,
							0,1,4,3,
							5,8,7,4,
							5,8,7,4,
							5,8,7,4,
							5,8,7,4,
							5,8,7,4
							};
		room.setTextureCoordinates(0,0,tex);
		room.setTextureCoordinateIndices(0,0,texIndices);
		
		GeometryInfo gi = new GeometryInfo(room);
		NormalGenerator ng = new NormalGenerator();
		ng.generateNormals(gi);
		this.addGeometry(gi.getGeometryArray());
		return this;
	}
	
	Shape3D createRoom2DoorsSameSide() {
		IndexedQuadArray room = new IndexedQuadArray(18,
				IndexedQuadArray.COORDINATES|IndexedQuadArray.TEXTURE_COORDINATE_2, 72);
		int p = 0;
		
		room.setCoordinate(p++, new Point3f(0f * scale, 0f * scale, 0f * scale));
		
		room.setCoordinate(p++, new Point3f(0f * scale, 0f * scale, length * scale));
		room.setCoordinate(p++, new Point3f(0f * scale, height * scale, 0f * scale));
		
		room.setCoordinate(p++, new Point3f(0f * scale, height * scale, length * scale));
		room.setCoordinate(p++, new Point3f(width * scale, 0f * scale, 0f * scale));
		
		room.setCoordinate(p++, new Point3f(width * scale, 0f * scale, length * scale));
		room.setCoordinate(p++, new Point3f(width * scale, height * scale, 0f * scale));
		
		room.setCoordinate(p++, new Point3f(width * scale, height * scale, length * scale));
		//Door slot 1
		room.setCoordinate(p++, new Point3f(doorPositionStart1 * scale, 0f * scale, 0f * scale));
		room.setCoordinate(p++, new Point3f(doorPositionStart1 * scale, doorHeight1 * scale, 0));
		room.setCoordinate(p++, new Point3f(doorPositionEnd1 * scale, 0f * scale, 0f * scale));
		room.setCoordinate(p++, new Point3f(doorPositionEnd1 * scale, doorHeight1 * scale, 0));
		room.setCoordinate(p++, new Point3f(0 * scale, doorHeight1 * scale, 0));
		room.setCoordinate(p++, new Point3f(width * scale, doorHeight1 * scale, 0));
		
		//Door slot 2
		room.setCoordinate(p++, new Point3f(doorPositionStart2 * scale, 0f * scale, 0f * scale));
		room.setCoordinate(p++, new Point3f(doorPositionStart2 * scale, doorHeight1 * scale, 0));
		room.setCoordinate(p++, new Point3f(doorPositionEnd2 * scale, 0f * scale, 0f * scale));
		room.setCoordinate(p++, new Point3f(doorPositionEnd2 * scale, doorHeight1 * scale, 0));
		
		int[] roomIndices = {1,3,2,0,
							4,5,1,0,
							3,7,6,2,
							6,7,5,4,
							7,3,1,5,
							12,9,8,0,
							15,14,10,11,
							13,4,16,17,
							6,13,12,2
							};
		room.setCoordinateIndices(0, roomIndices);
		
		TexCoord2f[] tex = {new TexCoord2f(0,0), new TexCoord2f(0, 0.5f), new TexCoord2f(0, 1), 
				new TexCoord2f(0.5f, 0), new TexCoord2f(0.51f, 0.51f),  new TexCoord2f(0.51f, 1),
				new TexCoord2f(1,0), new TexCoord2f(1f, 0.51f), new TexCoord2f(1, 1)};
		int[] texIndices = {8,7,4,5,
							1,2,5,4,
							0,1,4,3,
							5,8,7,4,
							5,8,7,4,
							5,8,7,4,
							8,7,4,5,
							8,7,4,5,
							8,7,4,5
							};
		room.setTextureCoordinates(0,0,tex);
		room.setTextureCoordinateIndices(0,0,texIndices);
		
		GeometryInfo gi = new GeometryInfo(room);
		NormalGenerator ng = new NormalGenerator();
		ng.generateNormals(gi);
		this.addGeometry(gi.getGeometryArray());
		
		return this;
	}

	Shape3D createRoom2DoorsOpposite() {
		IndexedQuadArray room = new IndexedQuadArray(20,
				IndexedQuadArray.COORDINATES|IndexedQuadArray.TEXTURE_COORDINATE_2, 80);
		int p = 0;
		
		room.setCoordinate(p++, new Point3f(0f * scale, 0f * scale, 0f * scale));
		
		room.setCoordinate(p++, new Point3f(0f * scale, 0f * scale, length * scale));
		room.setCoordinate(p++, new Point3f(0f * scale, height * scale, 0f * scale));
		
		room.setCoordinate(p++, new Point3f(0f * scale, height * scale, length * scale));
		room.setCoordinate(p++, new Point3f(width * scale, 0f * scale, 0f * scale));
		
		room.setCoordinate(p++, new Point3f(width * scale, 0f * scale, length * scale));
		room.setCoordinate(p++, new Point3f(width * scale, height * scale, 0f * scale));
		
		room.setCoordinate(p++, new Point3f(width * scale, height * scale, length * scale));
		//Door slot 1
		room.setCoordinate(p++, new Point3f(doorPositionStart1 * scale, 0f * scale, 0f * scale));
		room.setCoordinate(p++, new Point3f(doorPositionStart1 * scale, doorHeight1 * scale, 0));
		room.setCoordinate(p++, new Point3f(doorPositionEnd1 * scale, 0f * scale, 0f * scale));
		room.setCoordinate(p++, new Point3f(doorPositionEnd1 * scale, doorHeight1 * scale, 0));
		room.setCoordinate(p++, new Point3f(0 * scale, doorHeight1 * scale, 0));
		room.setCoordinate(p++, new Point3f(width * scale, doorHeight1 * scale, 0));
		
		//Door slot 2
		room.setCoordinate(p++, new Point3f(doorPositionStart2 * scale, 0f * scale, length * scale));
		room.setCoordinate(p++, new Point3f(doorPositionStart2 * scale, doorHeight2 * scale, length * scale));
		room.setCoordinate(p++, new Point3f(doorPositionEnd2 * scale, 0f * scale, length * scale));
		room.setCoordinate(p++, new Point3f(doorPositionEnd2 * scale, doorHeight2 * scale, length * scale));
		room.setCoordinate(p++, new Point3f(0 * scale, doorHeight2 * scale, length * scale));
		room.setCoordinate(p++, new Point3f(width * scale, doorHeight2 * scale, length * scale));
		
		int[] roomIndices = {0,1,3,2,
							4,5,1,0,
							3,7,6,2,
							6,7,5,4,
							12,9,8,0,
							11,13,4,10,
							2,6,13,12,
							15,18,1,14,
							19,17,16,5,
							7,3,18,19,
							};
		room.setCoordinateIndices(0, roomIndices);
		
		TexCoord2f[] tex = {new TexCoord2f(0,0), new TexCoord2f(0, 0.5f), new TexCoord2f(0, 1), 
				new TexCoord2f(0.5f, 0), new TexCoord2f(0.50f, 0.50f),  new TexCoord2f(0.50f, 1),
				new TexCoord2f(1,0), new TexCoord2f(1f, 0.51f), new TexCoord2f(1, 1)};
		int[] texIndices = {5,8,7,4,
							1,2,5,4,
							0,1,4,3,
							5,8,7,4,
							5,8,7,4,
							5,8,7,4,
							5,8,7,4,
							5,8,7,4,
							5,8,7,4,
							5,8,7,4,
							};
		room.setTextureCoordinates(0,0,tex);
		room.setTextureCoordinateIndices(0,0,texIndices);
		
		GeometryInfo gi = new GeometryInfo(room);
		NormalGenerator ng = new NormalGenerator();
		ng.generateNormals(gi);
		this.addGeometry(gi.getGeometryArray());
		
		return this;
	}
	
	Shape3D createRoom2DoorsAdjacent() {
		IndexedQuadArray room = new IndexedQuadArray(20,
				IndexedQuadArray.COORDINATES|IndexedQuadArray.TEXTURE_COORDINATE_2, 80);
		int p = 0;
		
		room.setCoordinate(p++, new Point3f(0f * scale, 0f * scale, 0f * scale));
		
		room.setCoordinate(p++, new Point3f(0f * scale, 0f * scale, length * scale));
		room.setCoordinate(p++, new Point3f(0f * scale, height * scale, 0f * scale));
		
		room.setCoordinate(p++, new Point3f(0f * scale, height * scale, length * scale));
		room.setCoordinate(p++, new Point3f(width * scale, 0f * scale, 0f * scale));
		
		room.setCoordinate(p++, new Point3f(width * scale, 0f * scale, length * scale));
		room.setCoordinate(p++, new Point3f(width * scale, height * scale, 0f * scale));
		
		room.setCoordinate(p++, new Point3f(width * scale, height * scale, length * scale));
		//Door slot 1
		room.setCoordinate(p++, new Point3f(doorPositionStart1 * scale, 0f * scale, 0f * scale));
		room.setCoordinate(p++, new Point3f(doorPositionStart1 * scale, doorHeight1 * scale, 0));
		room.setCoordinate(p++, new Point3f(doorPositionEnd1 * scale, 0f * scale, 0f * scale));
		room.setCoordinate(p++, new Point3f(doorPositionEnd1 * scale, doorHeight1 * scale, 0));
		room.setCoordinate(p++, new Point3f(0 * scale, doorHeight1 * scale, 0));
		room.setCoordinate(p++, new Point3f(width * scale, doorHeight1 * scale, 0));
		
		//Door slot 2
		room.setCoordinate(p++, new Point3f(0f * scale, 0f * scale, doorPositionStart2 * scale));
		room.setCoordinate(p++, new Point3f(0f * scale, doorHeight2 * scale, doorPositionStart2 * scale));
		room.setCoordinate(p++, new Point3f(0f * scale, 0f * scale, doorPositionEnd2 * scale));
		room.setCoordinate(p++, new Point3f(0f * scale, doorHeight2 * scale, doorPositionEnd2 * scale));
		room.setCoordinate(p++, new Point3f(0f * scale, doorHeight2 * scale, 0f * scale));
		room.setCoordinate(p++, new Point3f(0f * scale, doorHeight2 * scale, length * scale));
		
		int[] roomIndices = {4,5,1,0,
							3,7,6,2,
							6,7,5,4,
							7,3,1,5,
							12,9,8,0,
							11,13,4,10,
							2,6,13,12,
							14,0,18,15,
							16,1,19,17,
							18,19,3,2,
							};
		room.setCoordinateIndices(0, roomIndices);
		
		TexCoord2f[] tex = {new TexCoord2f(0,0), new TexCoord2f(0, 0.5f), new TexCoord2f(0, 1), 
				new TexCoord2f(0.5f, 0), new TexCoord2f(0.50f, 0.50f),  new TexCoord2f(0.50f, 1),
				new TexCoord2f(1,0), new TexCoord2f(1f, 0.50f), new TexCoord2f(1, 1)};
		int[] texIndices = {1,2,5,4, // Floor
				0,1,4,3, //Ceiling
				5,8,7,4,
				5,8,7,4,
				5,8,7,4,
				5,8,7,4,
				5,8,7,4,
				5,8,7,4,
				5,8,7,4,
				5,8,7,4,
				};
		room.setTextureCoordinates(0,0,tex);
		room.setTextureCoordinateIndices(0,0,texIndices);
		
		GeometryInfo gi = new GeometryInfo(room);
		NormalGenerator ng = new NormalGenerator();
		ng.generateNormals(gi);
		this.addGeometry(gi.getGeometryArray());
		
		return this;
	}
	
	Shape3D createRoom3DoorsOutside() {
		IndexedQuadArray room = new IndexedQuadArray(26,
				IndexedQuadArray.COORDINATES|IndexedQuadArray.TEXTURE_COORDINATE_2, 96);
		int p = 0;
		
		room.setCoordinate(p++, new Point3f(0f * scale, 0f * scale, 0f * scale));
		
		room.setCoordinate(p++, new Point3f(0f * scale, 0f * scale, length * scale));
		room.setCoordinate(p++, new Point3f(0f * scale, height * scale, 0f * scale));
		
		room.setCoordinate(p++, new Point3f(0f * scale, height * scale, length * scale));
		room.setCoordinate(p++, new Point3f(width * scale, 0f * scale, 0f * scale));
		
		room.setCoordinate(p++, new Point3f(width * scale, 0f * scale, length * scale));
		room.setCoordinate(p++, new Point3f(width * scale, height * scale, 0f * scale));
		
		room.setCoordinate(p++, new Point3f(width * scale, height * scale, length * scale));
		
		//Door slot 1 (Adjacent to 2 and Opposite of 3)
		room.setCoordinate(p++, new Point3f(doorPositionStart1 * scale, 0f * scale, 0f * scale));
		room.setCoordinate(p++, new Point3f(doorPositionStart1 * scale, doorHeight1 * scale, 0));
		room.setCoordinate(p++, new Point3f(doorPositionEnd1 * scale, 0f * scale, 0f * scale));
		room.setCoordinate(p++, new Point3f(doorPositionEnd1 * scale, doorHeight1 * scale, 0));
		room.setCoordinate(p++, new Point3f(0 * scale, doorHeight1 * scale, 0));
		room.setCoordinate(p++, new Point3f(width * scale, doorHeight1 * scale, 0));
		
		//Door slot 2 (Adjacent to 1 and 3)
		room.setCoordinate(p++, new Point3f(0f * scale, 0f * scale, doorPositionStart2 * scale));
		room.setCoordinate(p++, new Point3f(0f * scale, doorHeight2 * scale, doorPositionStart2 * scale));
		room.setCoordinate(p++, new Point3f(0f * scale, 0f * scale, doorPositionEnd2 * scale));
		room.setCoordinate(p++, new Point3f(0f * scale, doorHeight2 * scale, doorPositionEnd2 * scale));
		room.setCoordinate(p++, new Point3f(0f * scale, doorHeight2 * scale, 0f * scale));
		room.setCoordinate(p++, new Point3f(0f * scale, doorHeight2 * scale, length * scale));
		
		//Door slot 3 (Opposite to 1 and adjacent to 2)
		room.setCoordinate(p++, new Point3f(doorPositionStart3 * scale, 0f * scale, length * scale));
		room.setCoordinate(p++, new Point3f(doorPositionStart3 * scale, doorHeight3 * scale, length * scale));
		room.setCoordinate(p++, new Point3f(doorPositionEnd3 * scale, 0f * scale, length * scale));
		room.setCoordinate(p++, new Point3f(doorPositionEnd3 * scale, doorHeight3 * scale, length * scale));
		room.setCoordinate(p++, new Point3f(0 * scale, doorHeight3 * scale, length * scale));
		room.setCoordinate(p++, new Point3f(width * scale, doorHeight3 * scale, length * scale));
		
		
		int[] roomIndices = {4,5,1,0,
							3,7,6,2, 	//Top Large
							6,7,5,4, 	// Right Large
							12,9,8,0, 	//Third door bottom right
							4,10,11,13, //Third door bottom left
							2,6,13,12, 	//Back Large
							15,18,0,14, //Front bottom left
							16,1,19,17, //Front bottom right
							3,2,18,19, 	//Left Large
							1,20,21,24, //Front bottom left
							22,5,25,23, //Front bottom right
							3,7,25,24, 	//Front
							}; 
		room.setCoordinateIndices(0, roomIndices);
		
		TexCoord2f[] tex = {new TexCoord2f(0,0), new TexCoord2f(0, 0.5f), new TexCoord2f(0, 1), 
				new TexCoord2f(0.5f, 0), new TexCoord2f(0.50f, 0.50f),  new TexCoord2f(0.50f, 1),
				new TexCoord2f(1,0), new TexCoord2f(1f, 0.50f), new TexCoord2f(1, 1)};
		int[] texIndices = {1,2,5,4, // Floor
				0,0,0,0, //Ceiling
				6,3,4,7,
				6,3,4,7,
				6,3,4,7,
				6,3,4,7,
				6,3,4,7,
				6,3,4,7,
				6,3,4,7,
				6,3,4,7,
				6,3,4,7,
				6,3,4,7,
				};
		room.setTextureCoordinates(0,0,tex);
		room.setTextureCoordinateIndices(0,0,texIndices);
		
		GeometryInfo gi = new GeometryInfo(room);
		NormalGenerator ng = new NormalGenerator();
		ng.generateNormals(gi);
		this.addGeometry(gi.getGeometryArray());
		
		return this;
	}
	
	Shape3D createRoom3DoorsInside() {
		IndexedQuadArray room = new IndexedQuadArray(26,
				IndexedQuadArray.COORDINATES|IndexedQuadArray.TEXTURE_COORDINATE_2, 96);
		int p = 0;
		
		room.setCoordinate(p++, new Point3f(0f * scale, 0f * scale, 0f * scale));
		
		room.setCoordinate(p++, new Point3f(0f * scale, 0f * scale, length * scale));
		room.setCoordinate(p++, new Point3f(0f * scale, height * scale, 0f * scale));
		
		room.setCoordinate(p++, new Point3f(0f * scale, height * scale, length * scale));
		room.setCoordinate(p++, new Point3f(width * scale, 0f * scale, 0f * scale));
		
		room.setCoordinate(p++, new Point3f(width * scale, 0f * scale, length * scale));
		room.setCoordinate(p++, new Point3f(width * scale, height * scale, 0f * scale));
		
		room.setCoordinate(p++, new Point3f(width * scale, height * scale, length * scale));
		
		//Door slot 1 (Adjacent to 2 and Opposite of 3)
		room.setCoordinate(p++, new Point3f(doorPositionStart1 * scale, 0f * scale, 0f * scale));
		room.setCoordinate(p++, new Point3f(doorPositionStart1 * scale, doorHeight1 * scale, 0));
		room.setCoordinate(p++, new Point3f(doorPositionEnd1 * scale, 0f * scale, 0f * scale));
		room.setCoordinate(p++, new Point3f(doorPositionEnd1 * scale, doorHeight1 * scale, 0));
		room.setCoordinate(p++, new Point3f(0 * scale, doorHeight1 * scale, 0));
		room.setCoordinate(p++, new Point3f(width * scale, doorHeight1 * scale, 0));
		
		//Door slot 2 (Adjacent to 1 and 3)
		room.setCoordinate(p++, new Point3f(0f * scale, 0f * scale, doorPositionStart2 * scale));
		room.setCoordinate(p++, new Point3f(0f * scale, doorHeight2 * scale, doorPositionStart2 * scale));
		room.setCoordinate(p++, new Point3f(0f * scale, 0f * scale, doorPositionEnd2 * scale));
		room.setCoordinate(p++, new Point3f(0f * scale, doorHeight2 * scale, doorPositionEnd2 * scale));
		room.setCoordinate(p++, new Point3f(0f * scale, doorHeight2 * scale, 0f * scale));
		room.setCoordinate(p++, new Point3f(0f * scale, doorHeight2 * scale, length * scale));
		
		//Door slot 3 (Opposite to 1 and adjacent to 2)
		room.setCoordinate(p++, new Point3f(doorPositionStart3 * scale, 0f * scale, length * scale));
		room.setCoordinate(p++, new Point3f(doorPositionStart3 * scale, doorHeight3 * scale, length * scale));
		room.setCoordinate(p++, new Point3f(doorPositionEnd3 * scale, 0f * scale, length * scale));
		room.setCoordinate(p++, new Point3f(doorPositionEnd3 * scale, doorHeight3 * scale, length * scale));
		room.setCoordinate(p++, new Point3f(0 * scale, doorHeight3 * scale, length * scale));
		room.setCoordinate(p++, new Point3f(width * scale, doorHeight3 * scale, length * scale));
		
		
		int[] roomIndices = {4,5,1,0,
							3,7,6,2,	//Top Large
							6,7,5,4, 	// Right Large
							12,9,8,0, 	//Third door bottom right
							4,10,11,13, //Third door bottom left
							2,6,13,12, 	//Back Large
							15,18,0,14, //Front bottom left
							16,1,19,17, //Front bottom right
							3,2,18,19, 	//Left Large
							1,20,21,24, //Front bottom left
							22,5,25,23, //Front bottom right
							25,24,3,7	//Front
							}; 
		room.setCoordinateIndices(0, roomIndices);
		
		TexCoord2f[] tex = {new TexCoord2f(0,0), new TexCoord2f(0, 0.5f), new TexCoord2f(0, 1), 
				new TexCoord2f(0.5f, 0), new TexCoord2f(0.50f, 0.50f),  new TexCoord2f(0.50f, 1),
				new TexCoord2f(1,0), new TexCoord2f(1f, 0.50f), new TexCoord2f(1, 1)};
		int[] texIndices = {1,2,5,4, // Floor
				0,1,4,3, //Ceiling
				5,8,7,4,
				5,8,7,4,
				5,8,7,4,
				5,8,7,4,
				5,8,7,4,
				5,8,7,4,
				5,8,7,4,
				5,8,7,4,
				5,8,7,4,
				5,8,7,4,
				};
		room.setTextureCoordinates(0,0,tex);
		room.setTextureCoordinateIndices(0,0,texIndices);
		
		GeometryInfo gi = new GeometryInfo(room);
		NormalGenerator ng = new NormalGenerator();
		ng.generateNormals(gi);
		this.addGeometry(gi.getGeometryArray());
		
		return this;
	}

}
