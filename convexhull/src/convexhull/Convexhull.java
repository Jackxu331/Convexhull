/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convexhull;

import java.util.ArrayList;

/**
 *
 * @author xxuji
 */
class Point
{
    int x,y;
    Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
public class Convexhull {
    ArrayList<Point> points = new ArrayList<Point>();
    ArrayList<Point> convexhull =  new ArrayList<Point>();
    public Convexhull()
    {
        
        Point p0=new Point(0,4);//
        Point p1=new Point(4,4);//
        Point p2=new Point(0,0);
        Point p3=new Point(1,0);
        Point p4=new Point(2,3);
        Point p5=new Point(3,1);
        Point p6=new Point(2,1);
        Point p7=new Point(4,1);
        Point p8=new Point(-2,-2);//
        Point p9=new Point(4,0);//
        Point p10=new Point(4,3);
        points.add(p0);
        points.add(p1);
        points.add(p2);
        points.add(p3);
        points.add(p4);
        points.add(p5);
        points.add(p6);
        points.add(p7);
        points.add(p8);
        points.add(p9);
        points.add(p10);
        //System.out.println("111");
        convexhull(points, points.size());
        for(int i = 0; i < convexhull.size(); i++)
        {
            System.out.println("(" + convexhull.get(i).x + "," + convexhull.get(i).y + ")");
        }
    }
    public Point findleft(ArrayList<Point> s)
    {
        int leftmost = 0;
        for(int i = 1; i < s.size(); i++)
        {
            if(s.get(i).x < s.get(leftmost).x)
            {
                leftmost = i;
            }
        }
        return s.get(leftmost);
    }
    public boolean slope(Point p, Point q, Point r)
    {
        int slope1 = (r.y - p.y)*(q.x - p.x);
        int slope2 = (q.y - p.y)*(r.x - p.x);
        if(slope1 > slope2)
            return true;
        else
            return false;
    }
    public void convexhull(ArrayList<Point> s, int n)
    {
        if(n == 3)
            return;
        Point temp = findleft(s);
        int startpoint = s.indexOf(temp);
        int pivot = startpoint;
        do
        {
            //System.out.println("222");
            convexhull.add(s.get(pivot));
            int nextpoint = (pivot + 1)%n;
            
            for(int i = 0;  i < n; i++ )
            {
                if(slope(s.get(pivot),s.get(nextpoint),s.get(i)))
                {
                    nextpoint = i;
                }  
            }
             pivot = nextpoint;
        }while(startpoint != pivot);
        //convexhull.add(temp); //find the leftmost point as the startpoint;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Convexhull p = new Convexhull();
        // TODO code application logic here
    }
    
}
