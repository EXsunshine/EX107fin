
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;





public class Dialogue extends Frame {
    private Button easy=new Button("Easy");
    private Button normal=new Button("Normal");
    private Button hard=new Button("Hard");
    //    private ImageIcon img = new ImageIcon("718.jpg") ;
//    private JLabel jlb = new JLabel();
//    private JPanel jp= new JPanel();
    public Dialogue(){
        super("難易度");
        this.setResizable(false);
        init();
    }
    private void init(){

        setBounds(100,100,200,250);
//        jlb.setIcon(img);
//        jp.add(jlb);
        this.setBackground(Color.decode("#6495ED"));
        this.add(easy);
        this.add(normal);
        this.add(hard);
        easy.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame2 mfm2 = new MainFrame2();
                mfm2.setVisible(true);
            }
        });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        normal.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Normal n=new Normal();
                n.setVisible(true);
            }
        });

        hard.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hard h=new hard();
                h.setVisible(true);
            }
        });

        easy.setBounds(60,60,80,30);
        normal.setBounds(60,120,80,30);
        hard.setBounds(60,180,80,30);
        this.setLayout(null);
    }



}
