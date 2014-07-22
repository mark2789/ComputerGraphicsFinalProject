/*
 * Mark Green
 * Dr. Hong Zhang
 * CSCI 5830
 * 5 May 2011
 */

import com.sun.j3d.utils.image.TextureLoader;
import javax.vecmath.*;
import javax.media.j3d.*;
import java.applet.*;
import java.awt.*;
import java.net.URL;

public class CreateSolms extends Applet {
	float height = 0.8f;
	float topFloorStartHeight = 0.71f;
	public BranchGroup createSceneGraph() {
		
		// Set up appearance for Object
		Appearance ap = createTextureAppearance();
		ap.setMaterial(new Material());
		PolygonAttributes pa = new PolygonAttributes(
				PolygonAttributes.POLYGON_FILL, PolygonAttributes.CULL_NONE, 0);
		pa.setBackFaceNormalFlip(true);
		ap.setPolygonAttributes(pa);

		// Create Room 1
		Shape3D shape = new Room(1, 2.25, 1.0,
				0.1f, 0.4f, height,
				0.35f, 0.75f, height).createRoom2DoorsAdjacent();
		shape.setAppearance(ap);
		BranchGroup root = new BranchGroup();
		TransformGroup spin = new TransformGroup();
		

		
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		
		Transform3D tr = new Transform3D();
		tr.setScale(0.255);
		tr.setRotation(new AxisAngle4d(0, 1, 0, 3*Math.PI/2));
		tr.setTranslation(new Vector3f(1, 0, 0));
		TransformGroup tg = new TransformGroup(tr);
		
		spin.addChild(tg);
		tg.addChild(shape);

		// Create Room 2
		shape = new Room(1.5, 2.75, 1.0,
				0.6f, 0.9f, height,
				1.85f, 2.15f, height).createRoom2DoorsAdjacent();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(1.001f, 0, -0.89f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 3
		shape = new Room(2.75, 2.75, 1.0,
				2.35f, 2.65f, height).createRoom1Door();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(1.77f, 0, -0.89f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 4
		shape = new Room(2.75, 1.75, 1.0,
				1.00f, 1.75f, height,
				1.35f, 1.65f, height).createRoom2DoorsAdjacent();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setRotation(new AxisAngle4d(0, 1, 0, 3*Math.PI/2));
		tr.setTranslation(new Vector3f(4.065f, 0, -0.89f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 5
		shape = new Room(0.5, 1, 1.0,
				0.1f, 0.4f, height).createRoom1Door();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(4.068f, 0, -0.89f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 6
		shape = new Room(0.5, 1, 1.0,
				0.1f, 0.4f, height).createRoom1Door();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(4.068f, 0, -0.f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		/*TODO
		 * Place floor texture between rooms 4, 5, 6, 7
		 */
		
		//Create Room 7
		shape = new Room(3.75, 2.75, 1.0,
				0.1f, 0.4f, height,
				1.00f, 1.75f, height).createRoom2DoorsAdjacent();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(4.325f, 0, -0.89f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 8
		shape = new Room(2.75, 2.24, 1.0,
				1.35f, 1.65f, height,
				1.00f, 1.75f, height).createRoom2DoorsOpposite();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(6.74f, 0, 0.51f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, Math.PI/2));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 9
		shape = new Room(1, 1, 1.0,
				0.1f, 0.4f, height).createRoom1Door();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(8.40f, 0, -0.37f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, Math.PI));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 10
		shape = new Room(2, 1, 1.0,
				0.1f, 0.4f, height,
				1.6f, 1.90f, height).createRoom2DoorsSameSide();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(9.425f, 0, -0.37f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, Math.PI));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 11
		shape = new Room(0.5, 1, 1.0,
				0.1f, 0.4f, height).createRoom1Door();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(9.43f, 0, -0.88f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 12
		shape = new Room(2, 1, 1.0,
				0.1f, 0.4f, height,
				1.6f, 1.90f, height).createRoom2DoorsSameSide();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(10.715f, 0, -0.37f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, Math.PI));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 13
		shape = new Room(0.5, 1, 1.0,
				0.1f, 0.4f, height,
				0.0f, 0.5f, height).createRoom2DoorsOpposite();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(10.715f, 0, -0.88f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//TODO Room 14
		
		
		//Create Room 15
		shape = new Room(2, 1, 1.0,
				1.6f, 1.9f, height).createRoom1Door();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(7.89f, 0, 0f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 16
		shape = new Room(2, 1, 1.0,
				1.6f, 1.9f, height).createRoom1Door();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(8.915f, 0, 0f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 18 (Skipping 17 due to mislabeling)
		shape = new Room(2.25, 1, 1.0,
				0.9f, 1.3f, height).createRoom1Door();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(9.94f, 0, 0f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 19 (1)
		shape = new Room(2, 1, 1.0,
				0.05f, 0.35f, height).createRoom1Door();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(11.09f, 0, 0f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		
		//Create Room 19 (2)
		shape = new Room(3.25, 3, 1.0,
				2.75f, 3.05f, height).createRoom1Door();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(2.53f, 0, -3.15f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, -Math.PI / 2));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 20
		shape = new Room(1, 1.625, 1.0,
				0.6f, 0.9f, height).createRoom1Door();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(3.045f, 0, -2.325f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, Math.PI));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 21
		shape = new Room(3.25, 5.5, 1.0,
				0.1f, 0.4f, height,
				4.5f, 4.8f, height).createRoom2DoorsAdjacent();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(3.05f, 0, -1.495f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, Math.PI/2));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 22
		shape = new Room(1.75, 3.25, 1.0,
				0.5f, 0.8f, height).createRoom1Door();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(6.75f, 0, -1.495f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, Math.PI));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		
		//Create Room 23
		shape = new Room(4.25, 3.25, 1.0,
				0.1f, 0.4f, height,
				3.85f, 4.15f, height).createRoom2DoorsSameSide();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(8.925f, 0, -1.495f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, Math.PI));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 24
		shape = new Room(4.25, 3.25, 1.0,
				0.1f, 0.4f, height,
				3.85f, 4.15f, height).createRoom2DoorsSameSide();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(11.1f, 0, -1.495f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, Math.PI));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		
		//TOP FLOOR
		
		// Create Room 2
		shape = new Room(1.5, 2.75, 1.0,
				0.6f, 0.9f, height,
				1.85f, 2.15f, height).createRoom2DoorsAdjacent();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(1.001f, topFloorStartHeight, -0.89f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 3
		shape = new Room(2.75, 2.75, 1.0,
				2.35f, 2.65f, height).createRoom1Door();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(1.77f, topFloorStartHeight, -0.89f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 4
		shape = new Room(2.75, 1.75, 1.0,
				1.00f, 1.75f, height,
				1.35f, 1.65f, height).createRoom2DoorsAdjacent();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setRotation(new AxisAngle4d(0, 1, 0, 3*Math.PI/2));
		tr.setTranslation(new Vector3f(4.065f, topFloorStartHeight, -0.89f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 5
		shape = new Room(0.5, 1, 1.0,
				0.1f, 0.4f, height).createRoom1Door();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(4.068f, topFloorStartHeight, -0.89f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 6
		shape = new Room(0.5, 1, 1.0,
				0.1f, 0.4f, height).createRoom1Door();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(4.068f, topFloorStartHeight, -0.f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		/*TODO
		 * Place floor texture between rooms 4, 5, 6, 7
		 */
		
		//Create Room 7 (1)
		shape = new Room(3.75, 2.75, 1.0,
				0.1f, 0.4f, height,
				1.00f, 1.75f, height).createRoom2DoorsAdjacent();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(4.325f, topFloorStartHeight, -0.89f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 7 (2) (Over middle entrace)
		shape = new Room(2.75, 0.97, 1.0,
				1.1f, 1.4f, height,
				0.1f, 0.4f, height).createRoom2DoorsAdjacent();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(6.735f, topFloorStartHeight, -0.89f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, -Math.PI/2));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		
		//Create Room 8
		shape = new Room(2.75, 2.24, 1.0,
				1.35f, 1.65f, height,
				1.00f, 1.75f, height).createRoom2DoorsOpposite();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(6.74f, topFloorStartHeight, 0.512f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, Math.PI/2));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 9
		shape = new Room(1, 1, 1.0,
				0.1f, 0.4f, height).createRoom1Door();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(8.40f, topFloorStartHeight, -0.37f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, Math.PI));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 10
		shape = new Room(2, 1, 1.0,
				0.1f, 0.4f, height,
				1.6f, 1.90f, height).createRoom2DoorsSameSide();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(9.425f, topFloorStartHeight, -0.37f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, Math.PI));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 11
		shape = new Room(0.5, 1, 1.0,
				0.1f, 0.4f, height).createRoom1Door();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(9.43f, topFloorStartHeight, -0.88f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 12
		shape = new Room(2, 1, 1.0,
				0.1f, 0.4f, height,
				1.6f, 1.90f, height).createRoom2DoorsSameSide();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(10.715f, topFloorStartHeight, -0.37f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, Math.PI));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 13
		shape = new Room(0.5, 1, 1.0,
				0.1f, 0.4f, height,
				0.0f, 0.5f, height).createRoom2DoorsOpposite();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(10.715f, topFloorStartHeight, -0.88f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//TODO Room 14
		
		
		//Create Room 15
		shape = new Room(2, 1, 1.0,
				1.6f, 1.9f, height).createRoom1Door();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(7.89f, topFloorStartHeight, 0f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 16
		shape = new Room(2, 1, 1.0,
				1.6f, 1.9f, height).createRoom1Door();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(8.915f, topFloorStartHeight, 0f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 18 (Skipping 17 due to mislabeling)
		shape = new Room(2.25, 1, 1.0,
				0.9f, 1.3f, height).createRoom1Door();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(9.94f, topFloorStartHeight, 0f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 19 (1)
		shape = new Room(2, 1, 1.0,
				0.05f, 0.35f, height).createRoom1Door();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(11.09f, topFloorStartHeight, 0f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		
		//Create Room 19 (2)
		shape = new Room(3.25, 3, 1.0,
				2.75f, 3.05f, height).createRoom1Door();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(2.53f, topFloorStartHeight, -3.15f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, -Math.PI / 2));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 20
		shape = new Room(1, 1.625, 1.0,
				0.6f, 0.9f, height).createRoom1Door();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(3.045f, topFloorStartHeight, -2.325f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, Math.PI));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 21
		shape = new Room(3.25, 5.5, 1.0,
				0.1f, 0.4f, height,
				4.5f, 4.8f, height).createRoom2DoorsAdjacent();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(3.05f, topFloorStartHeight, -1.495f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, Math.PI/2));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 22
		shape = new Room(1.75, 3.25, 1.0,
				0.5f, 0.8f, height).createRoom1Door();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(6.75f, topFloorStartHeight, -1.495f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, Math.PI));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		
		//Create Room 23
		shape = new Room(4.25, 3.25, 1.0,
				0.1f, 0.4f, height,
				3.85f, 4.15f, height).createRoom2DoorsSameSide();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(8.925f, topFloorStartHeight, -1.495f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, Math.PI));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Create Room 24
		shape = new Room(4.25, 3.25, 1.0,
				0.1f, 0.4f, height,
				3.85f, 4.15f, height).createRoom2DoorsSameSide();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(11.1f, topFloorStartHeight, -1.495f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, Math.PI));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);	
		
		//Shell of building (Inside)
		shape = new Room(7.38, 24.85, 3,
				2.8f, 3.9f, height,
				13.1f, 14.18f, height,
				2.8f, 3.9f,height).createRoom3DoorsInside();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(-0.49f, topFloorStartHeight + -0.715f, 0.515f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, Math.PI/2));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Shell of building (outside)
		shape = new Room(7.4, 24.9, 3.05,
				2.8f, 3.9f, height,
				13.22f, 14.18f, height,
				2.8f, 3.9f, height).createRoom3DoorsOutside();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(-0.5f, topFloorStartHeight + -0.72f, 0.52f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, Math.PI/2));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Stairway 1 (Bottom half)
		shape = new Nonroom().createStairs();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.05);
		tr.setTranslation(new Vector3f(0.26f, 0, -0.9f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, -Math.PI/2));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Stair way 1 (Top half)
		shape = new Nonroom().createStairs();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.05);
		tr.setTranslation(new Vector3f(0.26f, 0.36f, -0.2f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, Math.PI/2));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Stairway 2 (Bottom half)
		shape = new Nonroom().createStairs();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.05);
		tr.setTranslation(new Vector3f(11.75f, 0f, -0.9f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, -Math.PI/2));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		Shape3D blah = shape;
		
		//Stair way 2 (Top half)
		shape = new Nonroom().createStairs();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.05);
		tr.setTranslation(new Vector3f(11.75f, 0.36f, -0.2f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, Math.PI/2));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Ceiling of first floor
		shape = new Ceiling().createCeiling();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.05);
		tr.setTranslation(new Vector3f(12.2f, 0.52f, -0.2f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, -Math.PI/2));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);	
		
		//Ceiling of second floor
		shape = new Ceiling(-0.85f).createCeiling();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.05);
		tr.setTranslation(new Vector3f(12.2f, 1.23f, -0.2f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, -Math.PI/2));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);	
		
		//Small Ceiling of first floor (Hallway)
		shape = new Ceiling(-0.85f, 9f).createCeilingSmall();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.05);
		tr.setTranslation(new Vector3f(11.3f, 0.515f, 0.90f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, -Math.PI/2));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Small Ceiling of first floor (Above middle doors)
		shape = new Ceiling(-0.75f, 1.4f).createCeilingSmall();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.05);
		tr.setTranslation(new Vector3f(7.53f, 0.51f, -0.90f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Small Ceiling of second floor
		shape = new Ceiling(-0.85f, 9f).createCeilingSmall();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.05);
		tr.setTranslation(new Vector3f(12.2f, 1.23f, 0.90f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, -Math.PI/2));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Small Ceiling of second floor (Over stairs (1))
		shape = new Ceiling(-0.85f, 2f).createCeilingSmall();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.05);
		tr.setTranslation(new Vector3f(12.2f, 1.23f, 0.45f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, -Math.PI/2));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);	
		
		
		//Small Floor of first floor
		shape = new Floor().createFloorSmall();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.05);
		tr.setTranslation(new Vector3f(13.88f, 0.001f, 0.93f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, -Math.PI/2));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Small Floor of second floor
		shape = new Floor(-0.6f).createFloorSmall();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.05);
		tr.setTranslation(new Vector3f(13.8f, 0.705f, 0.85f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, -Math.PI/2));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Very Small Floor of second floor
		shape = new Floor(-0.92f).createFloorSmall();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.05);
		tr.setTranslation(new Vector3f(8f, 0.705f, 0.92f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, -Math.PI/2));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);	
		
		
		//Floor of second floor
		shape = new Floor().createFloor();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.05);
		tr.setTranslation(new Vector3f(12.2f, 0.705f, -0.2f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, -Math.PI/2));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		
		//Front of Solms
		ap = createTextureAppearanceSolms();
		ap.setMaterial(new Material());
		ap.setPolygonAttributes(pa);
		shape = new Nonroom().createFront();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(4.75f, 1.29f, 0.52f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Column 1
		shape = new Nonroom().createPillar();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(4.80f, 0.04f, 1f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, Math.PI/4));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Column 2
		shape = new Nonroom().createPillar();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(5.492f, 0.04f, 1f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, Math.PI/4));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Column 3
		shape = new Nonroom().createPillar();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(6.184f, 0.04f, 1f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, Math.PI/4));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Column 4
		shape = new Nonroom().createPillar();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(6.876f, 0.04f, 1f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, Math.PI/4));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Column 5
		shape = new Nonroom().createPillar();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(7.568f, 0.04f, 1f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, Math.PI/4));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Column 6
		shape = new Nonroom().createPillar();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(8.26f, 0.04f, 1f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, Math.PI/4));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 1
		ap = createTextureAppearanceWindow();
		ap.setMaterial(new Material());
		ap.setPolygonAttributes(pa);
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(5.75f, 0.1f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 2
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(5.75f, 0.8f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 3
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(7.15f, 0.1f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 4
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(7.15f, 0.8f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 5
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(6.45f, 0.8f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 6
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(5.05f, 0.1f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 7
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(5.05f, 0.8f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		
		//Window 8
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(4.35f, 0.1f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 9
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(4.35f, 0.8f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 10
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(3.65f, 0.1f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 11
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(3.65f, 0.8f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 12
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(2.95f, 0.1f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 13
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(2.95f, 0.8f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 14
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(2.25f, 0.1f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 15
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(2.25f, 0.8f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 16
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(1.55f, 0.1f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 17
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(1.55f, 0.8f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 18
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(0.85f, 0.1f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 19
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(0.85f, 0.8f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 20
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(0.15f, 0.1f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 21
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(0.15f, 0.8f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 22
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(7.85f, 0.1f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 23
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(7.85f, 0.8f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 24
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(8.55f, 0.1f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 25
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(8.55f, 0.8f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 26
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(9.25f, 0.1f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 27
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(9.25f, 0.8f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 28
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(9.95f, 0.1f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 29
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(9.95f, 0.8f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 30
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(10.65f, 0.1f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 31
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(10.65f, 0.8f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 32
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(11.35f, 0.1f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 33
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(11.35f, 0.8f, 0.525f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		
		
		
		
		
		
		
		//Back Windows
		
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(5.75f, 0.1f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 2
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(5.75f, 0.8f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 3
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(7.15f, 0.1f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 4
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(7.15f, 0.8f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 5 (1)
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(6.45f, 0.8f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 5 (2)
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(6.45f, 0.1f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 6
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(5.05f, 0.1f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 7
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(5.05f, 0.8f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		
		//Window 8
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(4.35f, 0.1f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 9
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(4.35f, 0.8f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 10
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(3.65f, 0.1f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 11
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(3.65f, 0.8f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 12
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(2.95f, 0.1f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 13
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(2.95f, 0.8f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 14
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(2.25f, 0.1f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 15
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(2.25f, 0.8f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 16
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(1.55f, 0.1f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 17
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(1.55f, 0.8f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 18
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(0.85f, 0.1f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 19
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(0.85f, 0.8f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 20
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(0.15f, 0.1f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 21
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(0.15f, 0.8f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 22
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(7.85f, 0.1f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 23
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(7.85f, 0.8f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 24
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(8.55f, 0.1f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 25
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(8.55f, 0.8f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 26
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(9.25f, 0.1f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 27
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(9.25f, 0.8f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 28
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(9.95f, 0.1f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 29
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(9.95f, 0.8f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 30
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(10.65f, 0.1f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 31
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(10.65f, 0.8f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 32
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(11.35f, 0.1f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window 33
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(11.35f, 0.8f, -3.265f));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		//Window Far Side (Above door)
		shape = new Nonroom().createWindow();
		shape.setAppearance(ap);
		spin = new TransformGroup();
		spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		root.addChild(spin);
		tr = new Transform3D();
		tr.setScale(0.255);
		tr.setTranslation(new Vector3f(12.20f, 0.8f, -1.1f));
		tr.setRotation(new AxisAngle4d(0, 1, 0, Math.PI/2));
		tg = new TransformGroup(tr);
		spin.addChild(tg);
		tg.addChild(shape);
		
		
		
		
		// Bounds, Background, and Lighting
		BoundingSphere bounds = new BoundingSphere();
		Background background = new Background(1.0f, 1.0f, 1.0f);
		background.setApplicationBounds(bounds);
		root.addChild(background);
		AmbientLight light = new AmbientLight(true, new Color3f(Color.blue));
		light.setInfluencingBounds(bounds);
		root.addChild(light);
		return root;
	}

	private BranchGroup createView(Canvas3D cv, double fovx) {
		View view = new View();
		view.setFieldOfView(fovx);
		ViewPlatform vp = new ViewPlatform();
		view.addCanvas3D(cv);
		view.attachViewPlatform(vp);
		view.setPhysicalBody(new PhysicalBody());
		view.setPhysicalEnvironment(new PhysicalEnvironment());
		Transform3D trans = new Transform3D();
		trans.lookAt(new Point3d(0, 0, 2), new Point3d(0, 0, 0), new Vector3d(
				0, 1, 0));
		trans.invert();
		TransformGroup tg = new TransformGroup(trans);
		tg.addChild(vp);
		BranchGroup bgView = new BranchGroup();
		bgView.addChild(tg);
		return bgView;
	}

	Appearance createTextureAppearance() {
		Appearance ap = new Appearance();
		URL filename = getClass().getClassLoader().getResource(
				"images/Rooms.jpg");
		TextureLoader loader = new TextureLoader(filename, this);
		Texture texture = loader.getTexture();
		ImageComponent2D image = loader.getImage();
		Texture2D texture2D = new Texture2D(Texture.BASE_LEVEL, Texture.RGBA, image.getWidth(), image.getHeight());
		texture2D.setImage(0, image);
		texture.setEnable(true);
		texture.setMagFilter(Texture.BASE_LEVEL_LINEAR);
		texture.setMinFilter(Texture.BASE_LEVEL_LINEAR);
		ap.setTexture(texture);

		return ap;
	}
	
	Appearance createTextureAppearanceStairs() {
		Appearance ap = new Appearance();
		URL filename = getClass().getClassLoader().getResource(
				"images/StairTexture.jpg");
		TextureLoader loader = new TextureLoader(filename, this);
		Texture texture = loader.getTexture();
		ImageComponent2D image = loader.getImage();
		Texture2D texture2D = new Texture2D(Texture.BASE_LEVEL, Texture.RGBA, image.getWidth(), image.getHeight());
		texture2D.setImage(0, image);
		texture.setEnable(true);
		texture.setMagFilter(Texture.BASE_LEVEL_LINEAR);
		texture.setMinFilter(Texture.BASE_LEVEL_LINEAR);
		ap.setTexture(texture);
		return ap;
	}
	Appearance createTextureAppearanceSolms() {
		Appearance ap = new Appearance();
		URL filename = getClass().getClassLoader().getResource(
				"images/Solms.jpg");
		TextureLoader loader = new TextureLoader(filename, this);
		Texture texture = loader.getTexture();
		ImageComponent2D image = loader.getImage();
		Texture2D texture2D = new Texture2D(Texture.BASE_LEVEL, Texture.RGBA, image.getWidth(), image.getHeight());
		texture2D.setImage(0, image);
		texture.setEnable(true);
		texture.setMagFilter(Texture.BASE_LEVEL_LINEAR);
		texture.setMinFilter(Texture.BASE_LEVEL_LINEAR);
		ap.setTexture(texture);

		return ap;
	}
	Appearance createTextureAppearancePillars() {
		Appearance ap = new Appearance();
		URL filename = getClass().getClassLoader().getResource(
				"images/Pillars.jpg");
		TextureLoader loader = new TextureLoader(filename, this);
		Texture texture = loader.getTexture();
		ImageComponent2D image = loader.getImage();
		Texture2D texture2D = new Texture2D(Texture.BASE_LEVEL, Texture.RGBA, image.getWidth(), image.getHeight());
		texture2D.setImage(0, image);

		texture.setEnable(true);
		texture.setMagFilter(Texture.BASE_LEVEL_LINEAR);
		texture.setMinFilter(Texture.BASE_LEVEL_LINEAR);
		ap.setTexture(texture);
		return ap;
	}
	Appearance createTextureAppearanceWindow() {
		Appearance ap = new Appearance();
		URL filename = getClass().getClassLoader().getResource(
				"images/Window.jpg");
		TextureLoader loader = new TextureLoader(filename, this);
		Texture texture = loader.getTexture();
		ImageComponent2D image = loader.getImage();
		Texture2D texture2D = new Texture2D(Texture.BASE_LEVEL, Texture.RGBA, image.getWidth(), image.getHeight());
		texture2D.setImage(0, image);

		texture.setEnable(true);
		texture.setMagFilter(Texture.BASE_LEVEL_LINEAR);
		texture.setMinFilter(Texture.BASE_LEVEL_LINEAR);
		ap.setTexture(texture);
		return ap;
	}
}
