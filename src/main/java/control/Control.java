package control;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import model.Jeux;
import model.Joueur;
import view.View1;

public class Control {
private Jeux game =new Jeux(this,6,6,new Joueur(1,"mahdi"),new Joueur(2,"youssef"));
	private View1 maquetteView = new View1(this);
	
	
	public BorderPane intialiserMaquette() {
		int[][] maquette = this.game.initialiserMaquette();
		return this.maquetteView.init(maquette);
	}
	
	
	public void blockButton() {
		this.maquetteView.blockButton();
	}
	
	
	public void  play(int col,int row) {
		int row2=this.game.identifierRowWhenColumIsValid(col);
		System.out.println(row2);
		int player=this.game.getWhoPlay();
		int status=this.game.play(col);
		if(status==1) {
			this.maquetteView.changeButton(col,row2,player);
			this.showWinner("olaa");
		}
		else if(status==2) {
			this.maquetteView.changeButton(col,row2,player);
			this.egaliter();
		}
		else {
			this.maquetteView.changeButton(col,row2,player);
		}
		
		
	}
	
	
	
	
	
	
	
	
	public void showWinner(String name) {
		this.maquetteView.alert(name);
	}
	
	
	public void egaliter() {
		this.maquetteView.showEgaliter();
		
	}
	
	
}
