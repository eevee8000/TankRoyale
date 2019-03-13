# TankRoyale
  Tank Royale is a multiplayer game in which players control tanks by moving and shooting. Movement and shooting occurs in all four cardinal directions. The objective of the game is to eliminate all the other tanks and be the last tank standing. The current version is text-based and turn-based. Future versions will exist on a GUI and implement turning movement, as well as animation.
  
  ![image](https://user-images.githubusercontent.com/38643133/54259750-6e205100-452c-11e9-9a7a-49422893b19c.png)

# Prerequisites
To play Tank Royale you must have a recent version of java development kit(JDK) installed on your computer. 

If not, follow this link:
https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

# Getting Started 
  These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.
  
  ## Installation 
    1. Download the TankRoyale Master zip file: https://github.com/AnjolaAA/TankRoyale.git
   ![image](https://user-images.githubusercontent.com/45050947/53202462-c0ccb400-35e3-11e9-87d7-69156973d394.png)
    
    2. Locate TankRoyale-Master.zip folder inside your directory (By default, it should be in the downloads folder)
    3. Unzip file to a directory of your choice by right-clicking TankRoyale-Master.zip and choosing extract all. 
   ![image](https://user-images.githubusercontent.com/45050947/53202374-83682680-35e3-11e9-9983-e4843f387164.png)
    
  ## Compilation
    1. Open the terminal (command prompt) 
    2. Type: "cd [filepath to unzipped location]\TankRoyale-master\TankRoyale-master\TankRoyale Text Based" 
       in the command prompt to change directory. 
       Example is below.
   ![image](https://user-images.githubusercontent.com/45050947/53214493-0f8d4480-360a-11e9-80ed-0b2a82f70e9e.png)
   
    3. To compile, type in the command prompt: javac src/codes/*.java
   ![image](https://user-images.githubusercontent.com/45050947/53214514-22077e00-360a-11e9-99b1-160b80c9a178.png)
   
   ## Running the game
    1. To run the game, type in the command prompt: java -cp src codes.Main
       Make sure to have compiled the game first.
   ![image](https://user-images.githubusercontent.com/45050947/53214536-2df34000-360a-11e9-9a38-2c319f40fac6.png)

# Controls
  The controls for this program are done through user input into the console using a set command list. After each input is given the game's map will redraw itself to match the users input. The console will then prompt the user for another input. This repeats until the game ends.
  
  ## Command list:
  _Movement_    | _Shooting_
  ------------- | -------------
  Moveup        | Shootup
  Movedown      | Shootdown
  Moveright     | Shootright
  Moveleft      | Shootleft
  
*Commands are not case-sensitive
 # Versions
    - Version 1.0:Text-based format
    
# Authors
**Code Repository Manager: Harry Chen**- Sets up code repository, versions code for the various deliverables, helps other team members use repository, ensures code in repository compiles and runs.

**Code Reviewer: Andre Staffa** - Provides feedback on the quality of all code submitted to the code repository. 

**Team Lead: Anjola Adeboye** - Facilitates division of labour.

**Meeting Facilitator: Anjola Adeboye** - Organizes time/ location of meetings, ensures meetings stay on track, and all team members can and do contribute during meetings.

**Coordinator: Mei Hou** - Follows up with individual team members to ensure deadlines will be met or if meetings or deadlines are missed.

**Technical Writer: Josh Kim** - Creates documentation required for project such as README file and test document. 

**Architect: Andre Staffa** - Manages overall design of implementation and classes and maintains class diagram and other UML documentation. 

**Communications & Snack Managers: Anjola Adeboye, Mei Hou** - Provide snacks during especially long meetings, encourages team members. Will be rotated through all the members of the group. 


# Acknowledgements
The game was Inspired by the browser game "Tank Trouble", which can be found at: https://tanktrouble.com/
