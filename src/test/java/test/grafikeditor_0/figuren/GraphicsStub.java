package test.grafikeditor_0.figuren;

public class GraphicsStub extends test.grafikeditor_0.figuren.ConcreteGraphics {
    int nbOfDrawOvalCalls;
    int x;
    int width;
    int y;
    int height;

    @Override
    public void drawOval(int x, int y, int width, int height) {
        nbOfDrawOvalCalls++;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
