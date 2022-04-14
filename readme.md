# 15 Puzzle Console edition

## Running options:
### 1. With sbt
- sbt clean run

### 2. Building a distributable packages 
- sbt clean pack
- . target/pack/bin/puzzle-app

## Controls:

WASD for moving tiles
Q to quit
R to restart

## Configuration:
game.size - game time matrix size, default - 4 (4x4)

game.shuffles - n times to shuffle tiles before the game, default - 100

game.io.provider - input\output provider to use:
- console, default
- http, TBD
- websocket, TBD