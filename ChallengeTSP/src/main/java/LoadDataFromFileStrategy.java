package com.hotsno;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** A strategy implementation to load the points from our file.
 * Note that the format seems to vary, so there may be unexpected results with other files.
 *
 * @author Andrew Kulakovsky
 * @author Michael Wilson
 * @version 1.0
 */
public class LoadDataFromFileStrategy implements  LoadDataStrategy {
    public void loadData(String path) throws IOException {
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        boolean started = false;
        ArrayList<Point> points = new ArrayList<>();

        int maxX = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        while ((str = br.readLine()) != null) {
            if (str.startsWith("1")) {
                started = true;
            } else if (str.startsWith("EOF")) {
                return;
            }
            if (started) {
                String[] data = str.split(" ");
                double x = -Double.parseDouble(data[2].trim());
                double y = -Double.parseDouble(data[1].trim());
                points.add(new Point((int) x, (int) y));

                maxX = Integer.max(maxX, points.getLast().x);
                minX = Integer.min(minX, points.getLast().x);
                maxY = Integer.max(maxY, points.getLast().y);
                minY = Integer.min(minY, points.getLast().y);
            }
        }

        int panelWidth = Repository.getInstance().getPanelWidth();
        int panelHeight = Repository.getInstance().getPanelHeight();

        double scaleX = (double) panelWidth / (maxX - minX);
        double scaleY = (double) panelHeight / (maxY - minY);

        double scale = Math.min(scaleX, scaleY);

        int newMaxX = Integer.MIN_VALUE;
        int newMinX = Integer.MAX_VALUE;
        int newMaxY = Integer.MIN_VALUE;
        int newMinY = Integer.MAX_VALUE;
        ArrayList<Point> scaledPoints = new ArrayList<>();
        for (Point point : points) {
            scaledPoints.add(new Point(
                    (int) (scale * (point.x - minX)),
                    (int) (scale * (point.y - minY))
            ));
            newMaxX = Integer.max(newMaxX, scaledPoints.getLast().x);
            newMinX = Integer.min(newMinX, scaledPoints.getLast().x);
            newMaxY = Integer.max(newMaxY, scaledPoints.getLast().y);
            newMinY = Integer.min(newMinY, scaledPoints.getLast().y);
        }

        Repository.getInstance().setPoints(scaledPoints);
        setFivePoints(newMaxX, newMinX, newMaxY, newMinY);
    }

    private void setFivePoints(int maxX, int minX, int maxY, int minY) {
        ArrayList<Point> points = Repository.getInstance().getPoints();

        Point bottomLeft = new Point(minX, maxY);
        Point bottomRight = new Point(maxX, maxY);
        Point topLeft = new Point(minX, minY);
        Point topRight = new Point(maxX, minY);
        Point middle = new Point((maxX - minX) / 2, (maxY - minY) / 2);

        Point closestBottomLeft = points.getFirst();
        Point closestBottomRight = points.getFirst();
        Point closestTopLeft = points.getFirst();
        Point closestTopRight = points.getFirst();
        Point closestMiddle = points.getFirst();

        for (Point point : points) {
            if (point.distance(bottomLeft) < closestBottomLeft.distance(bottomLeft)) {
                closestBottomLeft = point;
            }
            if (point.distance(bottomRight) < closestBottomRight.distance(bottomRight)) {
                closestBottomRight = point;
            }
            if (point.distance(topLeft) < closestTopLeft.distance(topLeft)) {
                closestTopLeft = point;
            }
            if (point.distance(topRight) < closestTopRight.distance(topRight)) {
                closestTopRight = point;
            }
            if (point.distance(middle) < closestMiddle.distance(middle)) {
                closestMiddle = point;
            }
        }

        List<Point> fivePoints = List.of(closestBottomLeft, closestBottomRight, closestTopLeft,
                closestTopRight, closestMiddle);

        Repository.getInstance().setFivePoints(fivePoints);
    }
}
