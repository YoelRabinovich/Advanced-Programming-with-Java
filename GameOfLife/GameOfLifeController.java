import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

//class for drawing the matrix 
//and method of pressing a button that presents the next generation according to the rules of the game of life
public class GameOfLifeController {

	private static final double GRID_SIZE = 10;
	
	@FXML
	private Canvas lifeCanvas;

	@FXML
	private Button nextGen;	
	@FXML
	private GraphicsContext gc;
	private boolean[][] lifeMat;
	

	@FXML
	public void nextGen() {
		boolean[][] nextGenMat=new boolean[lifeMat.length][lifeMat[0].length];
		for (int i = 0; i < lifeMat.length; i++) 
		{
			for (int j = 0; j < lifeMat[0].length; j++) {
				if(!this.lifeMat[i][j] && livingNeighborsCount(i,j)==3 )
				{//new born
					nextGenMat[i][j]=true;
				}
				if(this.lifeMat[i][j] && livingNeighborsCount(i,j)<=1 )
				{//death because of loneliness
					nextGenMat[i][j]=false;
				}
				if(this.lifeMat[i][j] && livingNeighborsCount(i,j)>=4 )
				{//death because of too many neighbors
					nextGenMat[i][j]=false;
				}
				if(this.lifeMat[i][j] && livingNeighborsCount(i,j)>=2 && livingNeighborsCount(i,j)<=3 )
				{//stay alive
					nextGenMat[i][j]=true;
				}
			}

		}
		
		lifeCanvas.getGraphicsContext2D().clearRect(0, 0, getCanvasHeight(), getCanvasWidth());
		this.lifeMat=nextGenMat;
		this.paintCanvas();
	}

	//count how many living neighbors  
	private int livingNeighborsCount(int i, int j)
	{
		int count=0;
		
		
		
		if(i>0) {
			count+=this.lifeMat[i-1][j]?1:0;

		}
		if(i<GRID_SIZE) {
			count+=this.lifeMat[i+1][j]?1:0;

		}
		if(j>0) {
			count+=this.lifeMat[i][j-1]?1:0;

		}
		if(j<GRID_SIZE) {
			count+=this.lifeMat[i][j+1]?1:0;

		}
		if(i>0 && j>0) {
			count+=this.lifeMat[i-1][j-1]?1:0;

		}
		if(i>0 && j<GRID_SIZE) {
			count+=this.lifeMat[i-1][j+1]?1:0;

		}
		if(i<GRID_SIZE && j>0 ) {
			count+=this.lifeMat[i+1][j-1]?1:0;

		}
		if(i<GRID_SIZE && j< GRID_SIZE) {
			count+=this.lifeMat[i+1][j+1]?1:0;

		}

		return count;
	}

	public void initialize() {
		double w=getCanvasWidth();
		double h=getCanvasHeight();
		gc = lifeCanvas.getGraphicsContext2D();
		lifeMat=new boolean[(int) w][(int) h];
		initLifeMat();
		paintCanvas();
	}

	//drawing the Matrix
	private void paintCanvas() {
		double w=(getCanvasWidth()/(double)GRID_SIZE);
		double h=(getCanvasHeight()/(double)GRID_SIZE);		
		for (int i = 0; i < GRID_SIZE; i++) 
		{
			for (int j = 0; j < GRID_SIZE; j++)
			{
				Double x=(i*getCanvasWidth()/(double)GRID_SIZE);
				Double y=(j*getCanvasHeight()/(double)GRID_SIZE);
				gc.setFill(lifeMat[i][j]?Color.GRAY:Color.WHITE);
				gc.fillRect(x, y, w, h);
			}

		}
	}

	//matrix initialize
	private void initLifeMat() {

		for (int i = 0; i < GRID_SIZE; i++) 
		{
			for (int j = 0; j < GRID_SIZE; j++)
			{
				lifeMat[i][j]=isAlive();
			}

		}		
	}

	//  Defines the chance for life in the cells in a new life matrix.
	private boolean isAlive() {
		return Math.random()< 0.3;
	}

	// canvas width getter
	public double getCanvasWidth() {
		return lifeCanvas.getWidth();
	}

	//canvas height getter
	public double getCanvasHeight() {
		return lifeCanvas.getHeight();
	}


}
