package sapient.monitnow.fne1.Controller;
import java.util.ArrayList;
import java.util.List;

import sapient.monitnow.fne1.Exception.ExceptionClipper;
import sapient.monitnow.fne1.entities.Lawn;
import sapient.monitnow.fne1.entities.Params;
import sapient.monitnow.fne1.entities.Params.ClipperPossibleInstruction;
import sapient.monitnow.fne1.entities.PositionClipper;

public class ProcessClipper {

	private Lawn lawn;
	private PositionClipper posClipper;
	private List<sapient.monitnow.fne1.entities.Params.ClipperPossibleInstruction> listeInstruction;
	
	public Lawn getLawn() {
		return lawn;
	}

	public void setLawn(Lawn lawn) {
		this.lawn = lawn;
	}

	public PositionClipper getPosClipper() {
		return posClipper;
	}

	public void setPosClipper(PositionClipper posClipper) {
		this.posClipper = posClipper;
	}

	public List<sapient.monitnow.fne1.entities.Params.ClipperPossibleInstruction> getListeInstruction() {
		return listeInstruction;
	}
	
	public void setListInstruction(
			List<Params.ClipperPossibleInstruction> pListeInstruction) {
		this.listeInstruction = pListeInstruction;
		if(pListeInstruction == null){
			listeInstruction = new ArrayList<ClipperPossibleInstruction>();
		}
	}
	
	public void executeInstruction() throws ExceptionClipper{
		for(ClipperPossibleInstruction instruction : listeInstruction){
			ProcessInstrunction.executeInstruction(posClipper,
					instruction, this.lawn.getPosMax());
		}
	}

	
	public String toString(){
		return 	posClipper.getCoordClipper().getX() 
				+ " " 
				+ posClipper.getCoordClipper().getY()
				+ " " 
				+ posClipper.getDirectionClipper().getCodeDirection() ;
	}
}