/*
 * Mark Green
 * Dr. Hong Zhang
 * CSCI 5830
 * 5 May 2011
 */

import java.awt.geom.*;
import java.util.Vector;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.geometry.*;

public class Nonroom extends Shape3D {
	int scale = 1;
	float height = 1f;
	float width = 2f;
	float heightRotShape = 4.72f;
	
	Shape3D createPillar() {
		GeneralPath path = new GeneralPath();
		path.moveTo(0, -0.2);
		path.lineTo(-0.6, -0.2);
		path.lineTo(-0.6, 0);
		path.lineTo(-0.5, 0);
		path.curveTo(-0.6, 0.1, -0.4, 0.2, -0.3, 0.3);
		path.lineTo(-0.3, 0.3);
		path.lineTo(-0.3, heightRotShape);
		path.quadTo(-0.5, heightRotShape + 0.1, -0.4, heightRotShape + 0.2);
		path.lineTo(0, heightRotShape + 0.2);
		
		int n = 4;
		Transform3D tr = new Transform3D();
		tr.rotY(2 * Math.PI / n);
		PathIterator iterator = path.getPathIterator(new AffineTransform());
		Vector<Point3f> points = new Vector<Point3f>();
		float[] segments = new float[6];
		float x = 0;
		float y = 0;
		while (!iterator.isDone()) {
			int segType = iterator.currentSegment(segments);
			if (segType == PathIterator.SEG_MOVETO){
				x = segments[0];
				y = segments[1];
				points.add(new Point3f(x, y, 0));
			}
			else if (segType == PathIterator.SEG_LINETO) {
				x = segments[0];
				y = segments[1];
				points.add(new Point3f(x, y, 0));
			}
			else if (segType == PathIterator.SEG_QUADTO) {
				for (int i = 1; i < 10; i++) {
					float t = (float) i / 10f;
					float xi = (1 - t) * (1 - t) * x + 2 * t * (1 - t) * segments[0]
							+ t * t * segments[2];
					float yi = (1 - t) * (1 - t) * y + 2 * t * (1 - t) * segments[1]
							+ t * t * segments[3];
					points.add(new Point3f(xi, yi, 0));
				}
				x = segments[2];
				y = segments[3];
				points.add(new Point3f(x, y, 0));
			}
			else if (segType == PathIterator.SEG_CUBICTO) {
				for (int i = 1; i < 20; i++) {
					float t = (float) i / 20f;
					float xi = (1 - t) * (1 - t) * (1 - t) * x + 3 * t
							* (1 - t) * (1 - t) * segments[0] + 3 * t * t * (1 - t)
							* segments[2] + t * t * t * segments[4];
					float yi = (1 - t) * (1 - t) * (1 - t) * y + 3 * t
							* (1 - t) * (1 - t) * segments[1] + 3 * t * t * (1 - t)
							* segments[3] + t * t * t * segments[5];
					points.add(new Point3f(xi, yi, 0));
				}
				x = segments[2];
				y = segments[3];
				points.add(new Point3f(x, y, 0));
			}
			iterator.next();
		}
		Point3f[] pts = new Point3f[points.size()];
		for (int i = 0; i < points.size(); i++) {
			pts[i] = points.get(i);
		}
		IndexedQuadArray qa = new IndexedQuadArray(points.size() * n,
				IndexedQuadArray.COORDINATES, 4 * points.size() * n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < points.size() - 0; j++) {
				qa.setCoordinate(i * points.size() + j, pts[j]);
				tr.transform(pts[j]);
			}
		}
		int quadIndex = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < points.size() - 1; j++) {
				int i1 = (i + 1) % n;
				int j1 = (j + 1) % (points.size());
				qa.setCoordinateIndex(quadIndex++, i * points.size() + j);
				qa.setCoordinateIndex(quadIndex++, i * points.size() + j1);
				qa.setCoordinateIndex(quadIndex++, (i1) * points.size() + j1);
				qa.setCoordinateIndex(quadIndex++, (i1) * points.size() + j);
			}
		}
		GeometryInfo gi = new GeometryInfo(qa);
		NormalGenerator ng = new NormalGenerator();
		ng.generateNormals(gi);
		this.setGeometry(gi.getGeometryArray());
		return this;
	}
	
	
	Shape3D createFront() {
		IndexedQuadArray solms = new IndexedQuadArray(8,
				IndexedQuadArray.COORDINATES|IndexedQuadArray.TEXTURE_COORDINATE_2, 24);
		
		solms.setCoordinate(0, new Point3f(0f * scale, 0f * scale, 0f * scale));
		solms.setCoordinate(1, new Point3f(0f * scale, 0f * scale, width * scale));
		solms.setCoordinate(2, new Point3f(0f * scale, height * scale, 0f * scale));
		solms.setCoordinate(3, new Point3f(0f * scale, height * scale, width * scale));
		solms.setCoordinate(4, new Point3f(14f * scale, 0f * scale, 0f * scale));
		solms.setCoordinate(5, new Point3f(14f * scale, 0f * scale, width * scale));
		solms.setCoordinate(6, new Point3f(14f * scale, height * scale, 0f * scale));
		solms.setCoordinate(7, new Point3f(14f * scale, height * scale, width * scale));
		
		int[] floorIndices = {3,1,0,2,
							6,2,0,4,
							5,4,0,1,
							7,3,2,6,
							7,6,4,5,
							3,7,5,1
							};

		solms.setCoordinateIndices(0, floorIndices);

		TexCoord2f[] tex = {new TexCoord2f(0, 0f), new TexCoord2f(0, 0.5f), new TexCoord2f(1f, 0.5f),  new TexCoord2f(1f, 0f), new TexCoord2f(0, 1f), new TexCoord2f(1f,1f)};
		int[] texIndices = {2,3,0,1,
							0,1,2,3,
							0,1,2,3,
							1,2,3,0,
							1,2,3,0,
							4,5,2,1,
							};
		solms.setTextureCoordinates(0,0,tex);
		solms.setTextureCoordinateIndices(0,0,texIndices);
		
		GeometryInfo gi = new GeometryInfo(solms);
		NormalGenerator ng = new NormalGenerator();
		ng.generateNormals(gi);
		this.addGeometry(gi.getGeometryArray());
		return this;
	}
	
	
	Shape3D createStairs() {
		IndexedQuadArray stairs = new IndexedQuadArray(34,
				IndexedQuadArray.COORDINATES|IndexedQuadArray.TEXTURE_COORDINATE_2, 160);
		int widthOfStairs = 8;
		
		stairs.setCoordinate(0, new Point3f(0f * scale, 0f * scale, 0f * scale));
		stairs.setCoordinate(1, new Point3f(0f * scale, 0f * scale, widthOfStairs * scale));
		
		stairs.setCoordinate(2, new Point3f(0 * scale, 1f * scale, 0 * scale));
		stairs.setCoordinate(3, new Point3f(0 * scale, 1f * scale, widthOfStairs * scale));
		
		stairs.setCoordinate(4, new Point3f(2f * scale, 1f * scale, 0f * scale));
		stairs.setCoordinate(5, new Point3f(2f * scale, 1f * scale, widthOfStairs * scale));
		
		stairs.setCoordinate(6, new Point3f(2 * scale, 2f * scale, 0f * scale));
		stairs.setCoordinate(7, new Point3f(2 * scale, 2f * scale, widthOfStairs * scale));

		stairs.setCoordinate(8, new Point3f(4 * scale, 2f * scale, 0f * scale));
		stairs.setCoordinate(9, new Point3f(4 * scale, 2f * scale, widthOfStairs * scale));
		
		stairs.setCoordinate(10, new Point3f(4 * scale, 3f * scale, 0f * scale));
		stairs.setCoordinate(11, new Point3f(4 * scale, 3f * scale, widthOfStairs * scale));
		
		stairs.setCoordinate(12, new Point3f(6 * scale, 3f * scale, 0f * scale));
		stairs.setCoordinate(13, new Point3f(6 * scale, 3f * scale, widthOfStairs * scale));
		
		stairs.setCoordinate(14, new Point3f(6 * scale, 4f * scale, 0f * scale));
		stairs.setCoordinate(15, new Point3f(6 * scale, 4f * scale, widthOfStairs * scale));
		
		stairs.setCoordinate(16, new Point3f(8 * scale, 4f * scale, 0f * scale));
		stairs.setCoordinate(17, new Point3f(8 * scale, 4f * scale, widthOfStairs * scale));
		
		stairs.setCoordinate(18, new Point3f(8 * scale, 5f * scale, 0f * scale));
		stairs.setCoordinate(19, new Point3f(8 * scale, 5f * scale, widthOfStairs * scale));
		
		stairs.setCoordinate(20, new Point3f(10 * scale, 5f * scale, 0f * scale));
		stairs.setCoordinate(21, new Point3f(10 * scale, 5f * scale, widthOfStairs * scale));
		
		stairs.setCoordinate(22, new Point3f(10 * scale, 6f * scale, 0f * scale));
		stairs.setCoordinate(23, new Point3f(10 * scale, 6f * scale, widthOfStairs * scale));
		
		stairs.setCoordinate(24, new Point3f(12 * scale, 6f * scale, 0f * scale));
		stairs.setCoordinate(25, new Point3f(12 * scale, 6f * scale, widthOfStairs * scale));
		
		stairs.setCoordinate(26, new Point3f(12 * scale, 7f * scale, 0f * scale));
		stairs.setCoordinate(27, new Point3f(12 * scale, 7f * scale, widthOfStairs * scale));
		
		stairs.setCoordinate(28, new Point3f(14 * scale, 7f * scale, 0f * scale));
		stairs.setCoordinate(29, new Point3f(14 * scale, 7f * scale, widthOfStairs * scale));
		
		int[] stairIndices = {0,2,4,4,
							1,3,5,5,
							0,2,3,1,
							4,5,3,2,
							0,2,5,4,
							
							4,6,8,8,
							5,7,9,9,
							4,6,7,5,
							8,9,7,6,
							4,6,9,8,
							
							8,10,12,12,
							9,11,13,13,
							8,10,11,9,
							12,13,11,10,
							8,10,13,12,
							
							12,14,16,16,
							13,15,17,17,
							12,14,15,13,
							16,17,15,14,
							12,14,17,16,
							
							16,18,20,20,
							17,19,21,21,
							16,18,19,17,
							20,21,19,18,
							16,18,21,20,
							
							20,22,24,24,
							21,23,25,25,
							20,22,23,21,
							24,25,23,22,
							20,22,25,24,
							
							24,26,28,28,
							25,27,29,29,
							24,26,27,25,
							28,29,27,26,
							24,26,29,28};
		stairs.setCoordinateIndices(0, stairIndices);

		GeometryInfo gi = new GeometryInfo(stairs);
		NormalGenerator ng = new NormalGenerator();
		ng.generateNormals(gi);
		this.addGeometry(gi.getGeometryArray());
		return this;
	}
	

	Shape3D createWindow() {
		float scale = 0.7f;
		
		IndexedQuadArray window = new IndexedQuadArray(4,
				IndexedQuadArray.COORDINATES
						| IndexedQuadArray.TEXTURE_COORDINATE_2, 4);
		
		window.setCoordinate(0, new Point3f(0 * scale, 0f * scale, 0f * scale));
		window.setCoordinate(1, new Point3f(1 * scale, 0f * scale, 0f * scale));
		window.setCoordinate(2, new Point3f(1 * scale, 2f * scale, 0f * scale));
		window.setCoordinate(3, new Point3f(0 * scale, 2f * scale, 0f * scale));
		
		int[] floorIndices = {0,1,2,3};
		window.setCoordinateIndices(0, floorIndices);

		TexCoord2f[] tex = {new TexCoord2f(0f, 0f), new TexCoord2f(1f, 0f), new TexCoord2f(1f, 1f), new TexCoord2f(0f, 1f)};
		int[] texIndices = {0,1,2,3};
		window.setTextureCoordinates(0,0,tex);
		window.setTextureCoordinateIndices(0,0,texIndices);
		
		GeometryInfo gi = new GeometryInfo(window);
		NormalGenerator ng = new NormalGenerator();
		ng.generateNormals(gi);
		this.addGeometry(gi.getGeometryArray());
		
		return this;
	}
	
}
