import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

//class for drawing the shapes and the cloned shapes with the required colors, filling and size
public class MyDrawingController {

	@FXML
	private Canvas cnv;
	@FXML
	private GraphicsContext gc;

	final int SIZE=200;
	final int NUM_OF_SHAPES=6;
	private static final int LINE = 0;
	private static final int RECTANGLE = 1;
	private static final int OVAL = 2;

	private ArrayList<MyShape> list; 
	private ArrayList<MyShape> listClone;

	//shapes and cloned shapes initialize
	public void initialize() {
		gc = cnv.getGraphicsContext2D();
		list = new ArrayList<MyShape>();
		listClone=new ArrayList<MyShape>();
		fillList();
		cloneList();
		changeDuplicate();
		paintShape(cnv.getGraphicsContext2D());
	}


	// fill the original list randomly  while the color and visibility are fixed
	private void fillList() {
		for (int i = 0; i < NUM_OF_SHAPES; i++) { 
			double x1 = SIZE * Math.random();
			double y1 = SIZE * Math.random();
			double x2 = SIZE * Math.random();
			double y2 = SIZE * Math.random();
			switch (i%3) {
			case LINE:
				list.add(new MyLine(x1, y1, x2, y2,Color.RED));
				break;
			case RECTANGLE:
				list.add(new MyRectangle(x1, y1, x2, y2,Color.RED,true));
				break;
			case OVAL:
				list.add(new MyOval(x1, y1, x2, y2,Color.RED,true));
				break;
			}

		}
	}
	
	// clone the list and add to the cloned list
	private void cloneList() {
		for(int i  = 0 ; i < list.size() ; i++) {
			try {
				listClone.add((MyShape) list.get(i).clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
	}

	// move the cloned list shapes pixels and change the color and fill of the shapes
	private void changeDuplicate() {
		for (int i = 0; i <  listClone.size(); i++) {
			if (listClone.get(i)  instanceof MyBoundedShape) {
				MyBoundedShape temp = (MyBoundedShape)listClone.get(i);
				temp.setFilled(!(temp.isFilled()));	
			}
			MyShape t = listClone.get(i);
			t.setX1(t.getX1()+10);
			t.setY1(t.getY1()+10);
			t.setColor(Color.GREEN);
		}
	}

	// paint by the draw function
	private void paintShape(GraphicsContext gc) {
		for (int i = 0; i < NUM_OF_SHAPES; i++)
		{
			list.get(i).draw(gc);
			listClone.get(i).draw(gc);
		}
	}
}




