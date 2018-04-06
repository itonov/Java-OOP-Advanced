package square;

class Rectangle {
    protected int m_width;
    protected int m_height;

    public Rectangle(int width, int height) {
        this.m_width = width;
        this.m_height = height;
    }

    public int getWidth() {
        return this.m_width;
    }

    public int getHeight() {
        return this.m_height;
    }

    public int getArea() {
        return this.m_width * this.m_height;
    }
}
