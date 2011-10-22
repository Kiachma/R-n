package task2src;

import java.awt.Color;
import java.util.AbstractList;

interface Renderer {
    public void putBackground();
    public void putBody(AbstractList body);
    public void setSnakeColor(Color color);
    public void putBonus(AbstractList bonus);
    public void outside();
}
