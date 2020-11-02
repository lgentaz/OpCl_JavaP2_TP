import java.util.List;
import java.util.LinkedList;

/** La liste des objets mobiles présents à l'écran. */
List<FallingObject> particles = new LinkedList();

/**
 * Configuration initiale.
 *
 * C'est ici que les "particules" sont instanciées.
 * Modifier cette méthode pour changer leur nombre, leur forme...
 */

 public void settings() {
  size(640, 360);
}

void setup() {
  rectMode(RADIUS);
  ellipseMode(RADIUS);
  

  
  for(int i = 0; i < 50; i++) {
    particles.add(new FallingSquare(random(4)+1));
  }
}

/**
 * Affichage d'une nouvelle image à l'écran.
 *
 * Cette méthode est appelée 60 fois par seconde. NE PAS MODIFIER. 
 */
void draw() {
  background(0);
  for(FallingObject object : particles) {
    object.display();
  }
}

abstract class FallingObject {
  /** Position horizontale */
  float x;
  /** Position verticale */
  float y;
  /** Vitesse de chute */
  float speed;
  
  /** 
   * Constructeur sans argument.
   * 
   * Initialise l'objet avec une position et une vitesse aléatoires.
   */
  FallingObject() {
    x = random(width);
    y = random(height);
    speed = random(2.5)+0.5;
  }
  
  /**
   * Mise à jour de la position.
   *
   * Méthode à appeler à chaque nouvelle image.
   * Implémente le comportement de "chute".
   */
  void display() {
    y += speed;
    if(y > height + 100) {
      y = -100;
    }
    pushMatrix();
    translate(x, y);
    draw();
    popMatrix();
  }
  
  /**
   * Dessin de l'objet.
   *
   * Méthode à implémenter par les classes enfants 
   * pour spécifier la forme de l'objet
   */
  abstract void draw();
}

class FallingCircle extends FallingObject {
  /** Le rayon du cercle */
  float radius;
  
  /** 
   * Constructeur.
   * 
   * @param r Le rayon du cercle
   */
  FallingCircle(float r) {
    super();
    this.radius = r;
  }
  
  /**
   * Dessin du cercle.
   *
   * Appelée par 'display' pour afficher l'objet à l'écran
   */
  @Override
  void draw() {
    strokeWeight(0);
    circle(0, 0, radius);
  }
}

class FallingSquare extends FallingObject {
  /** Le coté du carré */
  float side;
  
  /** 
   * Constructeur.
   * 
   * @param s le coté du carré
   */
  FallingSquare(float s) {
    super();
    this.side = s;
  }
  
  /**
   * Dessin du carré.
   *
   * Appelée par 'display' pour afficher l'objet à l'écran
   */
  @Override
  void draw() {
    strokeWeight(0);
    square(0, 0, side);
  }
  }
