import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Listener for mouse clicks
 *
 * @author javiergs
 * @version 1.0
 */
public class DrawAreaListener implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        Repository.getInstance().addPoint(new Point(e.getX(), e.getY()));
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
