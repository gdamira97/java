/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author Damira
 */
public class SpriteAnimation extends Transition{
        private final ImageView imageView;
        private final int count;
        private final int columns;
        private final int offsetX;
        private final int offsetY;
        private final int width;
        private final  int height;
        
        public SpriteAnimation(ImageView imageView, Duration duration, int count, int columns, int offsetX,int offsetY, int width,int height){
            this.imageView = imageView;
            this.count = count;
            this.columns = columns;
            this.offsetX = offsetX;
            this.offsetY = offsetY;
            this.width = width;
            this.height = height;
            setCycleDuration(duration);
    }
        @Override
        public void interpolate(double k){
            final int index=Math.min((int) Math.floor(k*count), count-1);
            final int x=(index % columns) * width + offsetX;
            final int y=(index / columns) * height + offsetY;
            imageView.setViewport(new Rectangle2D(x, y, width, height));
        }
}
