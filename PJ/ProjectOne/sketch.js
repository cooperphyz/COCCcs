var x = 100;

function setup() {
  createCanvas(900, 400);  
  stroke(255);   
  frameRate(30);
}

function draw() { 
  background(0);   
  x = x - 2; 
  if (x < 0) { 
    x = height; 
  } 
  line(900, 300, 100, x);  
} 