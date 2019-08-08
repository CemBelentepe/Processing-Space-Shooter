class Player{
  PImage img;
  PVector pos;
  float speed;

  Player(PImage img, float x, float y, float speed){
    this.img = img;
    pos = new PVector(x, y);
    this.speed = speed;
  }

  void update(){
    image(img, pos.x, pos.y);
  }


}
