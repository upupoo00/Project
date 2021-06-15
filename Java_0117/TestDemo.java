package Java_0117;

abstract class shape{
    abstract public void draw();
}

class Cycle extends shape{
    @Override
    public void draw(){
        System.out.println("○");
    }
}

class Flower extends shape{
    @Override
    public void draw() {
        System.out.println("❀");
    }
}

class Rect extends shape{
    @Override
    public void draw() {
        System.out.println("◇");
    }
}

public class TestDemo {
    public static void main(String[] args) {
        shape[] shapes = {new Cycle() ,new Flower() , new Rect() };
        for (shape shape:shapes) {

            shape.draw();
        }
    }
}
