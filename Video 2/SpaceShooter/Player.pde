class Player {
  PImage img;
  PVector pos;
  float speed;

  Player(PImage img, float x, float y, float speed) {
    this.img = img;
    pos = new PVector(x, y);
    this.speed = speed;
  }

  void render() {
    image(img, pos.x, pos.y);
  }

  void update() {
    if (keys[0]) pos.y -= speed;
    if (keys[2]) pos.y += speed;
    if (keys[1]) pos.x -= speed;
    if (keys[3]) pos.x += speed;
    
    if(pos.x < 0) pos.x = 0;
    else if(pos.x + img.width > width) pos.x = width-img.width;
    
    if(pos.y < 0) pos.y = 0;
    else if(pos.y + img.height > height) pos.y = height-img.height;
  }
}
