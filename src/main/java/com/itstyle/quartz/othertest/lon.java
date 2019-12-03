package com.itstyle.quartz.othertest;

public class lon {
    private static double EARTH_RADIUS = 6371.393;  
    private static double rad(double d)  
    {  
       return d * Math.PI / 180.0;  
    }
    public static void main(String[] args) {
        double lat1 = 52.32223;
        double lng1 = 124.69399;
        double lat2 = 52.23829;
        double lng2 = 124.78579;
        double aa = 20;
        double bb = 30;
        double radLat1 = rad(lat1);  
        double radLat2 = rad(lat2);
        double radLng1 = rad(lng1);
        double radLng2 = rad(lng2);
//        System.out.println(radLat1);
//        System.out.println(radLng1);
//        System.out.println(radLat2);
//        System.out.println(radLng2);

        double x1 = 0;
        double h = (Math.tan(Math.toRadians(90 - aa))*radLat1 - Math.tan(Math.toRadians(90+bb))*radLat2 + radLng2 - radLng1);
        double d = Math.tan(Math.toRadians(90 - aa)) - Math.tan(Math.toRadians(90+bb));
        x1 = h / d;
        double y1 = Math.tan(Math.toRadians(90 - aa))*(x1 - radLat1) + radLng1;

        double a = x1 - radLat1;
        double b = y1 - radLng1;

        double s = 2 * Math.asin(Math.sqrt(Math.abs(Math.pow(Math.sin(a/2),2) +   
            Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2))));   
        s = s * EARTH_RADIUS;
        s = Math.round(s * 1000);
//        System.out.println(x1);
//        System.out.println(y1);
        System.out.println(s);
    }
    
    private void getDis(double a,double b) {
    	
    }
}