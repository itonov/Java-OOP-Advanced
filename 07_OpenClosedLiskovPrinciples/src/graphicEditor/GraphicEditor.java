package graphicEditor;

public class GraphicEditor {
    public void drawShape(Shape shape) {
        System.out.println(shape.toString());
    }

    public static void main(String[] args) {
        GraphicEditor editor = new GraphicEditor();
        editor.drawShape(new Rectangle());
    }
}
