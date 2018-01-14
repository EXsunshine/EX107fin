import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Normal extends JFrame implements ActionListener,MouseListener,MouseMotionListener
{
    Container c;
    private Color color= Color.BLACK;
    private int m[][]=new int[3][10];
    private int xt,yt,xb,yb,xdir,ydir,flag,sum=30;
    Timer t;
    public Normal()
    {

        super("打磚塊");
        this.setResizable(false);
        int x = 0,y;
        xt=120;yt=430;xb=xt+23;yb=yt-3;
        xdir=7;ydir=7;flag=0;
        for (y=0;y<3;y=y+1)
            for (x=0;x<10;x=x+1)

                m[y][x]=1;
        System.out.println(x*y);

        c=getContentPane();
        t=new Timer(50,this);
        addMouseListener(this);
        addMouseMotionListener(this);
        setSize(500,500);
        setVisible(true);
        c.setBackground(new Color(0xA39FD8));
    }
    public void paint(Graphics g) {


        super.paint(g);
        g.setColor(getColor());
        g.fillRect(xt, yt, 50, 10);
        g.fillOval(xb, yb, 7, 7);
        int x,y;
        if (xb<=5||xb>=483)	xdir=-xdir;
        if (yb<=30)	ydir=-ydir;
        if (yb>453)
        {
            flag=0;xb=xt+23;yb=yt-3;t.stop();
        }
        if (xb>=xt&&xb<=xt+50&&yb+5>=yt&&yb<=yt+20)
            ydir=-13;

        for (y=0;y<3;y=y+1)
            for (x=0;x<10;x=x+1)
            {


                if (m[y][x]==0) continue;
                if (xb>=x*50&&xb<=x*50+60&&yb>=100+y*20&&yb<=125+y*20)
                {
                    m[y][x]=0;
                    ydir=-ydir;
                    sum =sum-1;
                    System.out.println(sum);
                    if(sum==0){
                        t.stop();
                        this.dispose();
                        Normal t1=new Normal();
                        t1.paint(g);
                    }
                }
                if (m[y][x]==1)

                    g.drawRect(x*50,100+y*20,50,20);
//                    if(m[y][x]==1){
//                        t.stop();
//                    }


            }
    }




    public void actionPerformed(ActionEvent e)
    {
        xb=xb+xdir;
        yb=yb+ydir;
        repaint();
    }

    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e)
    {
        t.start();flag=1;
    }
    public void mouseReleased(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}
    public void mouseDragged(MouseEvent e){}
    public void mouseMoved(MouseEvent e)
    {
        xt=e.getX();
        if (flag==0) xb=xt+23;
        repaint();
    }
    public  Color getColor(){
        return color;
    }
    public void setColor(Color color){
        this.color=color;
        repaint();
    }
}

