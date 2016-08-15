# Design Document #

# Introduction: #

The main goal of this project is to create a game authoring environment which allows users to create their own game within the bounds of a specific genre. The genre our environment will create is “Top-down Strategy” (including games such as Tower Defense), which is unique in that the game is composed primarily of “actors”, which are themselves defined by their individual states and behaviors and their interactions with other actors in the game, and can be placed by the user in discretized tiles on-screen.

This project requires that we create an authoring environment GUI which allows the user to specify “rules” of the game. Our “back-end” is responsible for controlling all the actors, behaviors, and interactions, but the user must be able to see the execution of the game in the GUI. Finally, there should be a way for the user to save either the initial configuration of a game (with actors, behaviors, and interactions) or the specific state of a game (with actors saving their specific state, location, etc.), and to re-load the same configuration or state in a later session. Right now, although we will establish default actors with pre-set behaviors and interactions, we anticipate making this more flexible and eventually allowing users to customize each part of an actor, and even script their own actor variables and behaviors.

Although the user sets all these variables and actors within the authoring environment, this data is actually contained within the game engine. In addition to keeping track of all these details of the user-defined game, the engine also contains the game loop with the current game state, the win/lose conditions, level transitions, and the player input. The game engine runs and progresses the game. One example of the engine flexibility is the way we plan to collect levels in a list that can be edited, so that levels can easily move levels around randomly. Once we get the core of the game engine down, it should mostly stay closed.

The actual engine operates under the instruction of the game player, which keeps track of data across games, while also having access to the authoring environment. The player is also responsible for accessing the game state within the engine and saving it according to the user’s specifications. The player keeps track of most of the high-level classes, but does not contain too much responsibility on its own. 

# Overview:  #

Our program will be divided up into four main components: game authoring environment, game engine, game player, and game data.  The game authoring environment will consist of a user interface with a main tab that allows the user to drag and drop different components of a game, such as different types of actors, onto a grid to create a game level.  The user will be able to save a specific level configuration from here, and another tab will contain all of the different levels created so that the user can later combine and reorder as many as desired into a single game that can be played.  The game authoring environment will contain a third tab that contains the different types of actors present in the current game being created, and will allow the user to create and modify different types of actors.  Actor types will be represented as nodes in a graph.  An actor is defined by its properties, which represent that actor’s unique state.  By clicking an actor type node, the user will be able to determine which properties an actor must keep track of. 

Actors respond to triggers, which we have separated into two types, self triggers and external triggers.  Self triggers only involve the current actor and occur when some condition, such as being in a certain location or receiving input from the user, is met.  The user is able to specify what self triggers an actor type must respond to by clicking the appropriate node.  The user is then presented with a list of possible self triggers; after, selecting one of these, the user then chooses an event to associate with that actor type-trigger combination.  Events will be represented as lambda expressions that can alter an actor’s state or behavior.  Obviously, the available triggers and events for any actor type depend on the specific properties assigned to that actor type.  When that self trigger condition is satisfied during gameplay for an actor, the corresponding event will be applied to that actor.  External triggers, on the other hand, involve two actors, and occur when a specific condition involving both actors is satisfied.  The triggers cause events that act on one actor type, referred to here as the affected type, and are represented by a directed line segment drawn from the other actor type to the affected type.  Similarly, external triggers causing events that act on the other actor in the pair are represented by a directed line segment between the nodes going the opposite way.  With this structure in place, the user is able to define as many different combinations of triggers and events as desired.  In addition to all the other triggers mentioned, the user will need to define winning and losing triggers for each type of game.

After creating games in the authoring environment and saving them to the game data files, the user will be able to utilize the game player program to actually run and play games created.  The player will be able to choose a game to be played and load into the engine everything needed to run the game from the data files.  This includes two distinct types of data: actors and their corresponding triggers and events, which only needs to be loaded in once when a new game is initialized, as well as the sequence of levels and individual level configurations.  The game engine’s primary responsibility then is running the game’s current level by properly interpreting triggers and events and updating actors accordingly.  Assuming the player continues to meet winning conditions, levels will be loaded into the engine in the specified order.  Once the player meets a winning condition on the last level or a losing condition on any level, an appropriate winning or losing screen will appear to the user, along with options to restart the current game, load a new game, or quit playing.  The user will also be able to save the current state of the game at any time and load this state in to be played, along with pausing and resuming play. In order for the player to pause and resume the game, the game loop will reside in the player, while the game logic is handled by the engine and level classes. 

# User Interface: #

![](http://i.imgur.com/2NOShyG.png)

![](http://i.imgur.com/v6nEHhN.png)

At the highest level, the UI will be organized using a menu system; thus, all components of the program will be accessible from a central hub, and a navigation system will be in place to allow the user to switch between the different components (i.e editing mode, player, settings, credits, etc).

As of right now, the main two components which are clearly defined are the authoring environment and game player.  The other screens can be implemented as necessary--if there are global variables we want the user to have access to, we will implement a settings page, and possibly include documentation/about page.  The menu system will allow us to easily hook all of these components up to a central hub.

## Authoring Environment ##

The function of the game authoring environment will be divided into two tabs.

1. *Actor Placement Grid Tab*: This tab will be used to position the actor elements upon the grid. It has two main sections, the first of which is the actor selector.  The actor elements will be the javaFX front-end representation (imageView) and possibly shuffles images using the sprite system. The second portion of this tab is the map/grid which will be a visual representation of locations of each instance of the actors. The placement of the actors onto the parts of the graph through click&select or drag&drop will also correlate to the population of a backend mapping of newly instantiated actors on the backend. It will be designed to have a zooming and scrolling viewing screen. In future sprints we may also expand this screen to resize itself to accommodate all actors in the game by recalculating the zoomed view when an actor leaves the bounds of the map.  The map will scale the positions of the actors and their sizes so that they will all fit within the map. The second section. The seco
2. *Actor Relationship Graph Tab*: This tab will be used to draw relationships between the different actors.  For our first simple iteration of this UI, you will be able to connect unidirectional or multidirectional arrows that signify a relationship between those two kinds of actors (actors will also be able to establish relationships with their own type). When the user is creating a link, they will be see which two actors they are drawing the relationship between as well as the possible Triggers that cause an interaction and as the resulting action. Users will be able to select multiple types of triggers as well as the different actions that go along with each trigger. For our first iteration these possible triggers and actions will be coming from the backend, however we hope to be able to add our own variables/conditions in a later sprint. In addition, we hope to make the graph and trigger/actions selections less static by making the Graph tab one tab with a dynamic graph. We would attempt to create a graph display where dragging connections between different actors would result in a popup with the possible trigger/action combinations!  

## Game Player Environment ##

The player screen will consist of a map and a heads up display that could indicate a variety of in game statistics. The game player will also have a few buttons that apply to every game (such as play, pause, load game).  There will also be a ListView within the UI that gives state information about each of the actors.  These informational states will be the unique actor characteristics from the backend.  The error handling will be displayed in either the HUD or pop-up dialog boxes when a user does something that doesn’t translate to a possible move.

### Future Considerations for UI ###

*General Display*

Ideally, we would want to make the different tabs drag-and-droppable from different parts of the screen (in the same way that the console and navigator windows are movable in Eclipse, but it we might end up just using tabs if that proves too difficult)

http://stackoverflow.com/questions/26610660/how-to-drag-a-javafx-node-and-detect-a-drop-event-outside-the-javafx-windows

*Actor Relationship Grid:*

The main tab will consist of a map and a ListView or TreeView of actors.  When the user drags and drops an actor from the list onto the map, an appropriate actor will be added to the map.  In a separate tab or window, there will be an interface that allows the user to modify the actors present in the current game.  The actors will be arranged as nodes in a circular graph, and the user will be able to create and delete actors from this graph.  The nodes will be connected to each other using lines, which represent the interactions between actors.  When the user clicks a node, the node will move to the center of the screen, and the user will be able to modify properties (set state) and behavior (link self-triggers to events) for this actor.  When the user clicks a line, the user will be able to modify interactions (link external-triggers to events) between actors.  Both of these properties will show up in another component that contains a treelist of all properties or links that correspond to the currently selected node or link, and allows the user to add new entries.  This will be contained in a ListView.

# Design Details #

## Player: ##

The game player (henceforth “player”) and game data are closely coupled. The player will allow the user to load and play games from files. Additionally, it will allow the user to pause the game, and to save a game in progress and reload and resume it later. (Ideally, our game player will be embedded in our authoring environment.) To meet these requirements, our game data will be stored in two slightly different forms:

1. Levels designed with our authoring environment will be stored in separate files. A complete game will include several level data files, along with a game data file that holds information about how the level fit together, and meta-information like the game name, author, and description text.
2. Saved game state will be stored in a single file. This will contain the level data for the level in progress, along with meta-game info and internal player info that stores information specific to the current game state.

Our data will be saved and loaded using XStream. All of the objects serialized will typically be game engine objects describing the state of the various actors and tiles in our game. The notable exceptions are the meta-information objects saved by the authoring environment to describe cross-level characteristics, and by the game player for similar reasons. 

The player API will consist of three methods, as can be seen in the Player interface: pause, play, and renderGUI. renderGUI will be called by the top level container whenever the user switches from the authoring environment to the player. Pause and play can be used by the game engine (in response to user input) or internally by the player to pause and resume the game.

## File Manager: ##

The file manager is used by the authoring environment and the game player to save and load XML files that represent the game and the game’s state. 
There will be two types of files: one for entire playable games and one for midgame state. 

The file manager’s API consists of save and load methods for games, levels, and game states. Saving and loading entire games and individual levels is used by the authoring environment for game creation and editing. Loading games is done by the player to display available games and turn files into objects for the game engine to run. 

Saving and loading game states is used only by the player, in order to save/load progress in the middle of a game. If a method runs into an error, it throws a GameFileException that the front end of the authoring environment or player handles. 

## Game Authoring Environment: ##

When creating the level the authoring environment allows the user to create Actors in the level. The actors are part of ActorGroups that have a pre-defined list of Properties and Behaviors. These are enumerated in a template from where the GUI can get the attributes and then list all possible options. There are also TriggerEvents that are enumerated for all possible combinations of attributes between actors. When two actors are selected the GUI will similarly get these triggers from the template and list them as options. It works similarly with Actions that actors can perform on the Triggers. The LevelGraph has Actors as nodes and each actor node has an interaction defined with other actors. These interactions are LinkNodes between the actor nodes, they contain the triggers and the Actions that are to be performed. This graph in created in the Level object. The Level class also has a run method, which the game engine uses to run each level. The run method executes all the triggers on the graph and performs the necessary operations to run the level. 

But the authoring environment doesn’t actually run the levels. The levels are authored and then saved as a resource. The control returns to the Player that can select the levels he wants to play from the resource. The levels are then loaded in and the GameEngine is initialized with the levels.

## Game Engine: ##

The Player loads the levels from the resource bases on what the user wants to play. The levels are then sent to the GameEngine. The Player has the ability to play or pause the game loop. On play the game loop runs the GameEngine. The GameEngine has a list of the levels and maintains the state of the game variables. To run the level, the GameEngine uses the run methods of the levels. The GameEngine also manages the level transitions. 

ISSUES:
How do the levels communicate state from within the level to the the game engine (the LevelData to the GameData)?

## Model of the Graph: ##

Actors are shapes on the front end. They have Properties, Events and SelfTriggers on the back end.

Properties:

- Position
- Type
- Angle
- Image (defines size and bounds)
- Additional Variables (Map String -> Integer)

Events:

- Shoot
- Run
- Jump
 
SelfTriggers link self conditions to events; when the self condition is met, the event occurs.
SelfTrigger examples:

- Property Check
- Control Check
- Always (always on)
 
ExternalTriggers are defined between two actors and consist of mutual conditions and events.  They link the condition to the event; as long as the condition is met, the event occurs.

ExternalTrigger examples:

- On Collision
- Within Range
- Watch (event happens to one when the other dies)
 
Events are lambda expressions that modify one actor’s state or behavior, or create/delete an actor

- modify variable
- delete actor
- create actor                  	
- modify position
- modify angle
- move toward actor
- move toward destination
- face actor
- face destination
- win/lose the game
 
 
Under this model, the backend must define (hard code) all possible SelfTriggers, ExternalTriggers, and Events


# Example Games: #

Some possible examples, separated into perceived difficulty:

**Simple:** Asteroids, Pong, Frogger, Tanks

**Difficult:** Tower defense, Platformer, Pacman, Worms, Fire Emblem, SuperHexagon

## Tower Defense ##

For a tower defense game, different types of actors serve as the different unit types in the game. For example, for enemy spawning, there would be a “spawner” actor with a self-trigger that periodically generates enemy actors.  

A tower would have a “shoot” behavior that is activated when it interacts with an enemy. The trigger event for the interaction would be based on distance between the tower and the enemy. The shoot behavior spawns a “bullet” actor that heads towards the enemy (through self-triggers). On collision between bullets and enemies, enemies die.  

The “base” you are defending would also be implemented as an actor, with a health property. When an enemy collides with the base, the base loses health - if it reaches zero, a trigger activates making the player lose.  

In the authoring environment, the user can select actor types from the actor graph and place them on the play area/grid. To customize different kinds of tower or enemy types, the user will be able to add provided behaviors (self-triggered actions) to actors to change how they react to interactions with other types of actors.  

Specific tower defense use cases are described in the use cases document. 

## Asteroids ##

Asteroids is similar to a tower defense game in that there is an actor (the spaceship) which can generate other actors (fire bullets). The largest challenge with Asteroids that a tower defense lacks is the ability for the player to directly control a unit. In our design, this could be done by attaching event handlers to the spaceship Actor’s self-triggers. The momentum of units can also be described with self-triggers and behaviors. The result of a collision between a bullet and an asteroid can be implemented in the same way as collisions in a tower defense. Asteroid objects would destroy itself and spawn two smaller asteroids as a reaction to the collision trigger event. 

Specific Asteroids use cases are described in the use cases document. 

## Mario (or generic platformer) ##

Unlike the other two example games, Mario is shown from a side view, rather than a top-down view, and has gravity. Gravity can be implemented as a self-triggered behavior for every actor affected by it, where they are all pulled down at a constant acceleration. For this to work, it is important to also define the interaction between actors and the ground, to make sure actors do not fall through.  

Power-ups will be actors, which modify Mario on collision. The bottom of the stage could also be an actor that kills characters that collide with it (for example, if Mario fell into a pit, it should result in a death). The flag at the end of the level will be an actor that, on collision with Mario, triggers winning the level (unlike the other two examples, where winning is determined by time or point score).  

In order to implement lives, we would have to reset and reload a level while carrying over information on Mario’s remaining lives. The engine could tell the player to reload a particular level file or load a state file in order to reposition the actors of the stage.  
Mario has a scrolling camera - our design will eventually include the ability to define a viewport or camera, so that only a portion of a level is visible. While this functionality will be used mainly in the authoring environment for convenience (it would be difficult to work with individual actors for a large level otherwise), this feature could be used in the player to implement the camera of a side-scrolling platformer like Mario. 

# Design Considerations: #

Design possibility for collisions:

##Visitor design pattern. This is a natural fit for the problem of sprite collision because the behavior of each collision is dependent on the sprite type. More information about the visitor design pattern can be seen here: 

http://www.tutorialspoint.com/design_pattern/visitor_pattern.htm

Design possibility for sprite types/states:

Using the State pattern,  we can define the non-background elements of a game. This can include players, enemies, projectiles, and obstacles.

![](http://i.imgur.com/fhlW09s.png)

Components of Sprites:

1. State → each state is represented by its own object. All messages sent to the player sprite are delegated to the current state object. 
2. Exhibit behaviors → states are responsible for their own transitions. Each state is only aware of its own neighbors.

Drawbacks:

Unidirectional transitions between states can be complicated for many states. For N states, each with N-1 neighbors, determining transitions is difficult.

Packaging and Splitting up:

Using the Model-View-Controller pattern, we can clearly separate different components of the project.

Controls and Inputs (e.g. Keyboarding):

Use the Observer pattern. 

# Team Responsibilities: #

- David - authoring/player UI (primary), Engine actor logic (secondary)
- Chris - Engine (primary), Authoring Backend (primary) Control (secondary)
- Austin - engine (primary/secondary), control (secondary), data (secondary)
- Sung - player (primary), data (secondary)
- Collin - Player
- Daniel - Maps/Camera (primary), Actor objects (secondary)
- Tyler - Engine (primary), Authoring Backend (primary)
- Inan - Engine (primary), Authoring Backend (primary)
- Bridget - Menus/Organization (primary)
- Connor - Authoring UI (primary)