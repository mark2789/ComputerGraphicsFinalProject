/*
 * Mark Green
 * Dr. Hong Zhang
 * CSCI 5830
 * 5 May 2011
 */

import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.behaviors.keyboard.KeyNavigatorBehavior;
import javax.vecmath.*;
import javax.media.j3d.*;
import com.sun.j3d.utils.universe.*;
import java.applet.*;
import java.awt.*;

public class Main extends Applet {

	int location = 0;
	double fieldOfView = Math.PI / 2;
	Transform3D trans;
	TransformGroup tg;
	BranchGroup bg;
	BranchGroup bgView;
	Canvas3D cv2;
	SimpleUniverse su;
	Canvas3D cv;
	GraphicsConfiguration gc;
	ViewPlatform vp;
	View view;
	Transform3D control;

	public static void main(String[] args) {
		new MainFrame(new Main(), 800, 600);		
	}
		public void init() {
			this.setLayout(new GridLayout(1, 1));
			GraphicsConfiguration gc = SimpleUniverse.getPreferredConfiguration();
			Canvas3D cv = new Canvas3D(gc);
			SimpleUniverse su = new SimpleUniverse(cv);
			cv = new Canvas3D(gc);
			add(cv);
			cv.setFocusable(true);
			View view = new View();
			view.setFieldOfView(.4 * Math.PI);
			view.setFrontClipDistance(.01);
			
			BranchGroup bgView = createView(cv, new Point3d(0, .01, 1), new Point3d(
					0, 0, 0), new Vector3d(0, 1, 0), view);

			su.addBranchGraph(bgView);
			
			//Create Solms Hall
			BranchGroup bg = new CreateSolms().createSceneGraph();
			
			bg.compile();
			su.addBranchGraph(bg);
		}
		private BranchGroup createView(Canvas3D cv, Point3d eye, Point3d center,
				Vector3d vup, View view) {

			BranchGroup bgView = new BranchGroup();
			ViewPlatform vp = new ViewPlatform();	        
			view.addCanvas3D(cv);
			view.attachViewPlatform(vp);
			view.setPhysicalBody(new PhysicalBody());
			view.setPhysicalEnvironment(new PhysicalEnvironment());
			Transform3D trans = new Transform3D();
			trans.lookAt(eye, center, vup);
			trans.invert();
			TransformGroup tg = new TransformGroup(trans);
	        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
			tg.addChild(vp);
		    KeyNavigatorBehavior keyNav = new KeyNavigatorBehavior(tg);
		    keyNav.setSchedulingBounds(new BoundingSphere());		    
		    tg.addChild(keyNav);
		    bgView.addChild(tg);
			return bgView;
		}
}