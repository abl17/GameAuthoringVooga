package authoring.model.triggers;

import authoring.model.actors.Actor;
import authoring.model.tree.Parameters;
import engine.State;
import player.InputManager;

public abstract class ATriggerEvent implements ITriggerEvent {

	private static final long serialVersionUID = 143065301018200501L;

	@SuppressWarnings("rawtypes")
	public abstract boolean condition(Parameters parameters, InputManager inputManager, State state, Actor... actors);
}
