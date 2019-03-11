package codes;


import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Game implements EventHandler<ActionEvent>{ 
    
    private Pane root = new Pane();
    private ArrayList<GameEntity> tanks = new ArrayList<>();
    private ArrayList<Wall> walls = new ArrayList<Wall>();
    private ArrayList<GameEntity> bullets = new ArrayList<>();
    private boolean restart = false;
    private Button restartBtn = new Button("restart");
    private static playerCount = 2;	

    public Pane getRoot(){
        return root; //Privacy leak??
    }

    public void start(){
        //add map
       for(int i = 0; i < playerCount; i++)
           randomSpawn(new Tank());
    }

    public void restart(){
        restartBtn.setAlignment(Pos.CENTER);
        root.getChildren().add(restartBtn);
        restartBtn.setOnAction(e -> {
            root.getChildren().clear();
            start();
            restart = false;
        });
    }

    public void addGameEntity(GameEntity object, double x, double y){
        object.getView().setTranslateX(x);
        object.getView().setTranslateY(y);
        root.getChildren().add(object.getView());
    }

    public void addBullet(GameEntity bullet, double x, double y){
        bullets.add(bullet);
        addGameEntity(bullet, x, y);
    }

    public void addTank(GameEntity tank, double x, double y){
        tanks.add(tank);
        addGameEntity(tank, x, y);
    }

    public void randomSpawn(GameEntity tank){
        //addTank(tank, randomX, randomY)
    }

    public void gameUpdate(){
        if(!restart){
            for(GameEntity tank : tanks){
                if(tank.isAlive()){
                    collisionUpdate();
                }
                else{
                    restart = true;
                }
            }
        }
        else{
            root.getChildren().clear();
            tanks.clear();
            restart();
            //end game screen  
        }      

    }

    public void collisionUpdate(){
        for(GameEntity bullet : bullets){
            for(GameEntity tank : tanks){
                if(bullet.isColliding(tank)){
                    bullet.setAlive(false); //Should change to isDead()
                    tank.isDead(); //Should change to isDead()
                    root.getChildren().removeAll(bullet.getView(), tank.getView());
                }
            }
	    for(Wall wall : walls){
               if(bullet.isColliding(wall)){
                  bullet.setAlive(false); //Should change to isDead()
                  root.getChildren().removeAll(bullet.getView());
           	 }           
       	    }
        }

        bullets.clear();
    }
  
    public void shoot(GameEntity tank){  //Delete the method, is already contained in the tank class. 
        Bullet bullet = new Bullet();
        bullet.setVelocity(tank.getVelocity().normalize().multiply(5));
        addBullet(bullet, tank.getView().getTranslateX(), tank.getView().getTranslateY());
    }

    public static int rng(int min, int max) { // Random Number Generator
		if (min > max) { // Argument Error Trap
			int temp = min;
			min = max;
			max = temp;
		}
		int number = (int) (Math.random() * (max - min + 1) + min);
		return number;
	}

	
	/** Based on my code, backward is not needed, since you can 
	just hold the rotateLeft or rotateRight accoridngly then move in the desired position. 
	*/
    public void handle(KeyEvent key){
        if(key.getCode() == KeyCode.W){
            tanks.get(0).moveForward();
        }
        else if(key.getCode() == keyCode.A){
            tanks.get(0).rotateLeft(); //DELETE 
        }
        else if(key.getCode() == keyCode.S){
            tanks.get(0).moveBackward(); //DELETE 
        }
        else if(key.getCode() == KeyCode.D){
            tanks.get(0).rotateRight(); //DELETE 
        }
        else if(key.getCode() == KeyCode.Q){
            shoot(tanks.get(0));
        }
        else if(key.getCode() == KeyCode.UP){
            tanks.get(1).moveForward();
        }
        else if(key.getCode() == KeyCode.LEFT){
            tanks.get(1).rotateLeft(); //DELETE 
        }
        else if(key.getCode() == KeyCode.DOWN){
            tanks.get(1).moveBackward(); //DELETE 
        }
        else if(key.getCode() == KeyCode.RIGHT){
            tanks.get(1).rotateRight(); //DELETE 
        }
        else if(key.getCode() == KeyCode.SHIFT){
            shoot(tanks.get(1));
        }
    }   
}
