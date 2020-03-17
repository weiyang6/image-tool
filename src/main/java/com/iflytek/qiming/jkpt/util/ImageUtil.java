package com.iflytek.qiming.jkpt.util;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;

/**
 * @author weiyang6
 * @version 1.0
 * @ClassName ImageUtil
 * @Description  图片工具类
 * @CreateTime 2019/5/24 09:30
 */
public class ImageUtil {
    /**
     * 按照 宽高 比例压缩
     *
     * @param srcImgData 待压缩图片输入流
     * @param scale 压缩刻度
     * @return 压缩后图片数据
     * @throws IOException 压缩图片过程中出错
     */
    public static byte[] compress(byte[] srcImgData, double scale) throws IOException {
        BufferedImage bi = ImageIO.read(new ByteArrayInputStream(srcImgData));
        int width = (int) (bi.getWidth() * scale); // 源图宽度
        int height = (int) (bi.getHeight() * scale); // 源图高度

        Image image = bi.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = tag.getGraphics();
        //g.setColor(Color.RED);
        g.drawImage(image, 0, 0, null); // 绘制处理后的图
        g.dispose();

        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        ImageIO.write(tag, "JPEG", bOut);
        return bOut.toByteArray();
    }
    /**
     * 将图片压缩到指定大小以内
     *
     * @param srcImgData 源图片数据
     * @param maxSize 目的图片大小
     * @return 压缩后的图片数据
     */
    public static byte[] compressUnderSize(byte[] srcImgData, long maxSize) {
        double scale = 0.9;
        byte[] imgData = Arrays.copyOf(srcImgData, srcImgData.length);
        if(imgData.length>maxSize){
            while(imgData.length>maxSize){
                try {
                    imgData = compress(imgData, scale);

                } catch (IOException e) {
                    throw new IllegalStateException("压缩出错", e);
                }
            }
        }
        return imgData;
    }
    //byte数组到图片
    private static void byte2image(byte[] data,String path){
        try{
            FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));
            imageOutput.write(data, 0, data.length);
            imageOutput.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }




    public static void main(String[] args) throws IOException {
        /*double scallSize=0.5;
        String src="D:\\demo\\java\\date\\source\\test.jpg";
        String target="D:\\demo\\java\\date\\test2.jpg";
        BufferedImage bi = ImageIO.read(new File(src));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bi, "jpg", baos);
        byte[] srcData= baos.toByteArray();
      //  byte[] t1=compress(srcData,scallSize);
        byte[] t1=compressUnderSize(srcData,1024*1024);
        byte2image(t1,target);*/




        File file = new File("C:\\Users\\30801\\Desktop\\杨威-合肥-2019社招\\杨威-合肥-2019社招\\4.个人一寸白底照片（合肥-杨威）.jpg"); //要处理的图片路径

        //定义一个RGB的数组，因为图片的RGB模式是由三个 0-255来表示的 比如白色就是(255,255,255)
        int[] rgb = new int[3];

        BufferedImage bi = null; //用来处理图片的缓冲流
        try {
            bi = ImageIO.read(file); //用ImageIO将图片读入到缓冲中
        } catch (Exception e) {
            e.printStackTrace();
        }

        //得到图片的长宽
        int width = bi.getWidth();
        int height = bi.getHeight();

        /**
         * 以下是遍历图片的像素，把指定区域内的像素的颜色换成目标颜色
         */

        //指定每个区域的范围（x:beginX~endX, y:beginY~endY 围起来的区域）
        int[] beginX = new int[]{230, 230, 1050};
        int[] endX = new int[]{1130, 325, 1130};
        int[] beginY = new int[]{0, 400, 400};
        int[] endY = new int[]{400, 655, 685};

        for (int k = 0; k < beginX.length; k++) {
            for (int i = beginX[k]; i < endX[k]; i++) {
                for (int j = beginY[k]; j < endY[k]; j++) {
                    //得到指定像素（i,j)上的RGB值
                    int pixel = bi.getRGB(i, j);
                    //分别进行位操作得到 r g b上的值
                    rgb[0] = (pixel & 0xff0000) >> 16;
                    rgb[1] = (pixel & 0xff00) >> 8;
                    rgb[2] = (pixel & 0xff);

                    //进行换色操作，我这里是要把蓝底换成白底，那么就判断图片中rgb值是否在蓝色范围的像素
                    if (rgb[0] < 155 && rgb[0] > 0 && rgb[1] < 256 && rgb[1] > 105 && rgb[2] < 256 && rgb[2] > 105) {
                        bi.setRGB(i, j, 0xffffff); //是则把该像素换成白色
                    }

                }
            }
        }
        System.out.println(file.getName() + "处理完毕!");
        /**
         * 将缓冲对象保存到新文件中
         */
        FileOutputStream ops = new FileOutputStream(new File("C:\\Users\\30801\\Desktop\\杨威-合肥-2019社招\\杨威-合肥-2019社招\\xxx.jpg")); //生成的新图片路径
        ImageIO.write(bi, "jpg", ops);
        ops.flush();
        ops.close();
    }

}
