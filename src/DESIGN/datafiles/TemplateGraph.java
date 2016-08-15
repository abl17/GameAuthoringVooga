package DESIGN.datafiles;

import java.util.List;

import DESIGN.authoring.IAction;
import DESIGN.authoring.IActor;
import DESIGN.authoring.ITriggerEvent;

public interface TemplateGraph {
	
	public List<ITriggerEvent> getEvents(IActor a, IActor b);
	public List<IAction> getActions(IActor a);

}
