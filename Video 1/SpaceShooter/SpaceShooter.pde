PImage bg, playerImage;

Player player;

void setup(){
  size(800, 600);
  
  bg = loadImage("res/bg.png");
  playerImage = loadImage("res/playerShip.png");
  
  player = new Player(playerImage, width/2-playerImage.width/2, height-playerImage.height, 10);
}

void draw(){
  background(0);
  wrap(bg, 0, 0, width, height);
  
  player.update();
}

void wrap(PImage img, float x1, float y1, float x2, float y2){
  for(float x = x1; x < x2; x+=img.width){
    for(float y = y1; y < y2; y+=img.height){
      image(img, x, y);
    }
  }
}
