//package game;
//
//import java.awt.Graphics;
//import java.awt.Image;
//import java.awt.image.BufferedImage;
//
//public class Animation {
//private int speed;
//private int frames;
//
//private int index = 0;
//private int count = 0;
//
//private Image[] images;
//private Image currentImg;
//
//public Animation(int speed, Image... args){
//    this.speed = speed;
//    images = new Image[args.length];
//    for(int i = 0; i < args.length; i ++){
//        images[i] = args[i];
//    }
//    frames = args.length;
//}
//
//public Animation(int speed, boolean flip, Image... args) {
//    if (flip) {
//        this.speed = speed;
//        images = new Image[(args.length * 2) - 2];
//        for (int i = 0; i < args.length; i++) {
//            images[i] = args[i];
//        }
//        Image[] temp = new Image[args.length - 2];
//        for (int i = args.length - 2; i > 0; i--) {
//            temp[args.length - i - 2] = images[i];
//        }
//        for (int i = args.length; i < images.length; i++) {
//            images[i] = temp[i - args.length];
//        }
//        frames = images.length;
//    }else{
//        this.speed = speed;
//        images = new Image[args.length];
//        for (int i = 0; i < args.length; i++) {
//            images[i] = args[i];
//        }
//        frames = args.length;
//    }
//}
//
//public void runAnimation(){
//    index ++;
//    if(index > speed){
//        index = 0;
//        nextFrame();
//    }
//}
//
//private void nextFrame(){
//    for(int i = 0; i < frames; i ++){
//        if(count == i)
//            currentImg = images[i];
//    }
//
//    count ++;
//
//    if(count >= frames)
//        count = 0;
//}
//
//public void drawAnimation(Graphics g, int x, int y, int scaleX, int scaleY){
//    g.drawImage(currentImg, x, y, scaleX, scaleY, null);
//}
//}
