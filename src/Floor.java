/*
 * Mark Green
 * Dr. Hong Zhang
 * CSCI 5830
 * 5 May 2011
 */

import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.geometry.*;

public class Floor extends Shape3D {
	int scale = 20;
	float smallWidth  = -0.93f;
	public  Floor() {
	}
	public  Floor(float smallWidth) {
		this.smallWidth = smallWidth;
	}
	Shape3D createFloor() {
		IndexedQuadArray floor = new IndexedQuadArray(22,
				IndexedQuadArray.COORDINATES
						| IndexedQuadArray.TEXTURE_COORDINATE_2, 80);
		float width = -0.65f;
		
		floor.setCoordinate(0, new Point3f(-3f * scale, 0f * scale, 0f * scale));
		floor.setCoordinate(1, new Point3f(-1.3f * scale, 0f * scale, 0f * scale));
		floor.setCoordinate(2,new Point3f(-1.3f * scale, 0f * scale, 12.7f  * scale));
		floor.setCoordinate(3,new Point3f(-3f * scale, 0f * scale, 12.7f  * scale));

		floor.setCoordinate(4, new Point3f(-1.3f * scale, 0f * scale, 0f * scale));
		floor.setCoordinate(5, new Point3f(width * scale, 0f * scale, 0f * scale));
		
		floor.setCoordinate(6, new Point3f(width * scale, 0f * scale, 2f * scale));
		floor.setCoordinate(7, new Point3f(-1.3f * scale, 0f * scale, 2f * scale));
		
		floor.setCoordinate(8, new Point3f(width * scale, 0f * scale, 3f * scale));
		floor.setCoordinate(9, new Point3f(-1.3f * scale, 0f * scale, 3f * scale));
		
		floor.setCoordinate(10, new Point3f(width * scale, 0f * scale, 4.5f * scale));
		floor.setCoordinate(11, new Point3f(-1.3f * scale, 0f * scale, 4.5f * scale));
		
		floor.setCoordinate(12, new Point3f(width * scale, 0f * scale, 6f * scale));
		floor.setCoordinate(13, new Point3f(-1.3f * scale, 0f * scale, 6f * scale));
		
		floor.setCoordinate(14, new Point3f(width * scale, 0f * scale, 7.5f * scale));
		floor.setCoordinate(15, new Point3f(-1.3f * scale, 0f * scale, 7.5f * scale));
		
		floor.setCoordinate(16, new Point3f(width * scale, 0f * scale, 9f * scale));
		floor.setCoordinate(17, new Point3f(-1.3f * scale, 0f * scale, 9f * scale));
		
		floor.setCoordinate(18, new Point3f(width * scale, 0f * scale, 11f * scale));
		floor.setCoordinate(19, new Point3f(-1.3f * scale, 0f * scale, 11f * scale));
		
		floor.setCoordinate(20, new Point3f(width* scale, 0f * scale, 12.7f * scale));
		floor.setCoordinate(21, new Point3f(-1.3f * scale, 0f * scale, 12.7f * scale));

		int[] floorIndices = {0,1,2,3,
							4,5,6,7,
							6,7,9,8,
							8,9,11,10,
							10,11,13,12,
							12,13,15,14,
							14,15,17,16,
							16,17,19,18,
							18,19,21,20
							};

		floor.setCoordinateIndices(0, floorIndices);
		
		TexCoord2f[] tex = {new TexCoord2f(0, 0.5f), new TexCoord2f(0, 1), new TexCoord2f(0.50f, 0.50f),  new TexCoord2f(0.50f, 1)};
		int[] texIndices = {0,1,3,2,
							0,1,3,2,
							0,1,3,2,
							0,1,3,2,
							0,1,3,2,
							0,1,3,2,
							0,1,3,2,
							0,1,3,2,
							0,1,3,2,
							0,1,3,2,
							0,1,3,2,
							0,1,3,2,};
		floor.setTextureCoordinates(0,0,tex);
		floor.setTextureCoordinateIndices(0,0,texIndices);
		
		
		GeometryInfo gi = new GeometryInfo(floor);
		NormalGenerator ng = new NormalGenerator();
		ng.generateNormals(gi);
		this.addGeometry(gi.getGeometryArray());
		return this;
	}
	
	Shape3D createFloorSmall() {
		IndexedQuadArray floor = new IndexedQuadArray(12,
				IndexedQuadArray.COORDINATES
						| IndexedQuadArray.TEXTURE_COORDINATE_2, 80);
		
		floor.setCoordinate(0, new Point3f(-1.3f * scale, 0f * scale, 0f * scale));
		floor.setCoordinate(1, new Point3f(smallWidth * scale, 0f * scale, 0f * scale));
		
		floor.setCoordinate(2, new Point3f(-1.3f * scale, 0f * scale, 0f * scale));
		floor.setCoordinate(3, new Point3f(smallWidth * scale, 0f * scale, 0f * scale));
		
		floor.setCoordinate(4, new Point3f(smallWidth * scale, 0f * scale, 3f * scale));
		floor.setCoordinate(5, new Point3f(-1.3f * scale, 0f * scale, 3f * scale));
		
		floor.setCoordinate(6, new Point3f(smallWidth * scale, 0f * scale, 4.5f * scale));
		floor.setCoordinate(7, new Point3f(-1.3f * scale, 0f * scale, 4.5f * scale));
		
		floor.setCoordinate(8, new Point3f(smallWidth * scale, 0f * scale, 6f * scale));
		floor.setCoordinate(9, new Point3f(-1.3f * scale, 0f * scale, 6f * scale));

		int[] floorIndices = {0,1,3,2,
							4,5,7,6,
							6,7,9,8
							};

		floor.setCoordinateIndices(0, floorIndices);
		
		TexCoord2f[] tex = {new TexCoord2f(0, 0.5f), new TexCoord2f(0, 1), new TexCoord2f(0.50f, 0.50f),  new TexCoord2f(0.50f, 1)};
		int[] texIndices = {0,1,3,2,
							0,1,3,2,
							0,1,3,2};
		floor.setTextureCoordinates(0,0,tex);
		floor.setTextureCoordinateIndices(0,0,texIndices);
		
		
		GeometryInfo gi = new GeometryInfo(floor);
		NormalGenerator ng = new NormalGenerator();
		ng.generateNormals(gi);
		this.addGeometry(gi.getGeometryArray());
		return this;
	}
}
