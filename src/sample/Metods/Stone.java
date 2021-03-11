package sample.Metods;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 * Класс, отрисовывающий песочные часы для анимации.
 * @author Kozhevnikov Alexander pPi-171
 * @version 1.2
 */

public class Stone {
    /**
     * Этот метод отрисовывает фигуры, для анимации.
     * @param gr,p,x1,x2,y1,y2,y3 Значения, которые
     * требуется для обозначения координат фигур.
     * @return Готовый рисунок.
     */

        public void draw(GraphicsContext gr, Paint p, int x1, int x2, int y1, int y2, int y3) {
            gr.setStroke(Color.BLACK);
            gr.setLineWidth(2);

            gr.strokePolygon(new double[]{90, 290, 190}, new double[]{40, 40, 100}, 3);
            gr.strokePolygon(new double[]{90, 290, 190}, new double[]{160, 160, 100}, 3);

            gr.setStroke(p);
            gr.strokeLine(190, 95, 190, 150);

            gr.setFill(p);
            gr.fillPolygon(new double[]{x1, x2, 190}, new double[]{y1, y2, 95}, 3);
            gr.fillPolygon(new double[]{105, 275, 190}, new double[]{155, 155, y3}, 3);
        }
    }




