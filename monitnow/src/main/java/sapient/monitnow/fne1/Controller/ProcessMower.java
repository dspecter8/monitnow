package sapient.monitnow.fne1.Controller;
import java.util.ArrayList;
import java.util.List;

import sapient.monitnow.fne1.Exception.ExceptionMower;
import sapient.monitnow.fne1.entities.Lawn;
import sapient.monitnow.fne1.entities.Params;
import sapient.monitnow.fne1.entities.Params.MowerPossibleInstruction;
import sapient.monitnow.fne1.entities.PositionMower;

public class ProcessMower {

	private Lawn lawn;
	private PositionMower posMower;
	private List<sapient.monitnow.fne1.entities.Params.MowerPossibleInstruction> listeInstruction;
	
	public Lawn getLawn() {
		return lawn;
	}

	public void setLawn(Lawn lawn) {
		this.lawn = lawn;
	}

	public PositionMower getPosMower() {
		return posMower;
	}

	public void setPosMower(PositionMower posMower) {
		this.posMower = posMower;
	}

	public List<sapient.monitnow.fne1.entities.Params.MowerPossibleInstruction> getListeInstruction() {
		return listeInstruction;
	}
	
	public void setListInstruction(
			List<Params.MowerPossibleInstruction> pListeInstruction) {
		this.listeInstruction = pListeInstruction;
		if(pListeInstruction == null){
			listeInstruction = new ArrayList<MowerPossibleInstruction>();
		}
	}
	
	public void executeInstruction() throws ExceptionMower{
		for(MowerPossibleInstruction instruction : listeInstruction){
			ProcessInstrunction.executeInstruction(posMower,
					instruction, this.lawn.getPosMax());
		}
	}

	
	public String toString(){
		return 	posMower.getCoordMower().getX() 
				+ " " 
				+ posMower.getCoordMower().getY()
				+ " " 
				+ posMower.getDirectionMower().getCodeDirection() ;
	}
}