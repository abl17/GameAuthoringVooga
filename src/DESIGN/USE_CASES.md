# Use Cases #

1. The user, while playing a game, can save the game state to a file. Later, the user can (in a totally new Java runtime environment) load in the saved game file and continue.
2. The user can save a game level created in our authoring environment to file.
3. The user can combine multiple levels created in our authoring environment into a multi-level game. They can save this game to file and play it with the player.
4. The user can pause the game with the game player, and go grab a sandwich, then resume playing.
5. The user can use the player to load and play any game created in our authoring environment. 
6. The user can view the game’s metadata, including the game’s name, author, date of creation, and description text. 
7. The user can drag an actor from a side panel to the screen, adding it to the level.
8. The user can change the size, font, and style of the heads up display.
9. The user can customize the game’s splash screen.
10. The user can specify the size and frequency of enemy waves.
11. The user can specify the attack damage, attack rate, and attack frequency of towers. 
12. The user can change the path that enemies follow, including introducing multiple paths.
13. The user can change where enemies spawn, including multiple spawn points.
14. The user can change where the enemies must reach to “score”.
15. The user can determine which grid cells can contain towers, and which cannot.
16. The user can use various pre-created actors and tiles to quickly make a playable game.
17. The user can change the game’s win and lose conditions.
18. The user can restart a game from the beginning, or from the lose screen.
19. The user can specify which keyboard keys move an actor on screen.
20. The user can instruct a tower to shoot at another type of tower as its default behavior.
21. The user can create an actor that can spawn more actors.
22. The user can create an asteroid that splits into two asteroids when shot.
23. An actor can be instructed to wrap around when it travels offstream.
24. The user can insert custom splash screens to be displayed between levels.
25. The user can choose what happens when two actors collide.
26. The user can define a new actor.  This will require the user to upload an image or construct a sprite using the sprite maker utility.
27. The user can modify the actors’s properties.  This includes default properties, such as position, image, and direction.  The user will also be able to add new properties and set their default values, which can be integers or booleans.  For example, if the user can define a new variable called life and initialize it to a value of 3.
28. The user can define an actor’s intrinsic behavior, or how it will act in the absence of other actors.  This is done by linking a self-trigger to an event.  The user will be able to select from our programmed list of triggers and events, but not be able to define any triggers or events themselves (this may be made possible in a future extension that uses a scripting language).  Triggers will include things such as property conditions, (i.e trigger when lives = 0) or button presses (see next use case).  Events can be movements, level advancements, property modification, or the addition/deletion of a character from the map.
29. The user can link actors to keyboard or mouse input.  This will be accomplished using a SelfTrigger that triggers when a desired button is pressed.  We will need to have a global button manager to record which keys on the keyboard are bound to which actors.  
30. An “always on” trigger can be defined for behaviors that always occur regardless of external or self conditions; i.e the cars in frogger will always move, and the clock hands on an in game timer will always spin.
31. The user can define new interactions between pairs of actors.  This is done by linking an external trigger that involves both of the actors to an event, which was defined earlier.  External triggers include conditions such as collision (when the two actors touch) and range (when the actors are a certain distance from each other) detection.
32. Events must have some sort of defined precedence.  For example, if the user holds down the left key and then starts pressing the right key, we need to decide whether the user will stand still or start moving in the most recently pressed direction.  Furthermore, if there are two ExternalTriggers that prompt an actor to move in two different directions, we must determine which has precedence (for example, a powerup prompts the actor to move toward enemies it normal avoids).
33. Moving the ship: the user defines self-triggers that link four buttons (WASD or up down left right) to movement in the four directions.
34. Shooting: this is done by linking a self-trigger which triggers when the shoot button is pressed.  The trigger will be linked to an event that creates a new bullet actor in the same direction as the ship.
35. Destroying asteroids: When a bullet and rock actor collide, several events occur as a result of the ExternalTrigger: the bullet is destroyed, the asteroid is destroyed, and two new asteroids are spawned with a smaller size than the original asteroid.  If the size of the original asteroid reached a certain threshold, the new asteroids are not created and the player’s score is increased instead.
36. Score: This can be implemented by adding an actor that simply monitors all of the asteroids.  When an asteroid is destroyed without splitting, the score increases.  When the score reaches a certain level, the game is won or the next level is reached.
37. Lives:  When an asteroid collides when a player (trigger), the player loses a life (event).  When the player’s lives reach zero (trigger), the game ends (event)
38. Random walks: an “always on” trigger makes the asteroids either move with constant velocity or randomly wander around the screen.
39. The user can use the mouse to navigate through the multiple menus and editors to change the game without editing configuration files.
40. The user can use of the authoring environment’s top drop-down menus to view the credits for our project.
