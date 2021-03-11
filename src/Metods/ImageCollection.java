package Metods;

import javafx.scene.image.Image;

public class ImageCollection implements Aggregate {
    private String filetopic;
    public Image bi;
    public ImageCollection(String filetopic) {
        this.filetopic = filetopic;
    }
    private class ImageIterator implements Iterator {
        private int current=0;
        @Override
        public boolean hasNext() {
            String
                    filename="res\\"+filetopic+(current+1)+".PNG";
            try {
                bi = new Image(filename);

                return true;

            } catch (Exception ex) {
                preview();
                /*System.err.println("Неудалось загрузить картинку! " + filename );
                ex.printStackTrace();*/
                return true;
            }
        }
        @Override
        public Object next() {
            if(this.hasNext()){
                current++;
                return bi;
            }

            return null;
        }
        @Override
        public Object back() {
            current--;
            if(this.hasNext()){
                return bi;
            }

            return null;
        }

        @Override
        public Object preview() {
            current=0;
            return current;
        }
    }
    @Override
    public Iterator getIterator() {
        return new ImageIterator();
    }
}
