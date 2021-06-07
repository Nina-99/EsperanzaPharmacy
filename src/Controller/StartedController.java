package Controller;
import Model.UserDAO;
import View.ProgressThreads;
import View.frmLogin;
import View.frmStarted;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LinearGradientPaint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.Point2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicProgressBarUI;

public class StartedController implements ChangeListener{
    
    private frmStarted Started;
    ProgressThreads threads;
    
    public StartedController(frmStarted Started){        
        this.Started = Started;
        this.Started.progreso.addChangeListener(this);
        InitializeStarted();
    }
        
    
    public void InitializeStarted(){
        //Started.setContentPane(fond);
        Started.lbTitle.setIcon(SIcon("/Image/Titulo.png", Started.lbTitle));
        Started.lbLogo.setIcon(SIcon("/Icon/Pharmacy icon1.png", Started.lbLogo));
        Started.setLocationRelativeTo(null);
        startedSplash();
        // Creamos un objeto HiloProgreso al cual le pasamos por parámetro la barra de progreso.
        threads = new ProgressThreads(Started.progreso);
        // Iniciamos el Hilo.
        threads.start();
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        // Obtenemos el tamaño de la ventana.
        Dimension windows = Started.getSize();
        // Para centrar la ventana lo hacemos con el siguiente calculo.
        Started.setLocation((screen.width - screen.width) / 2, (screen.height - screen.height) / 2);
        // Le damos tamaño y posición a nuestro Frame.
        Started.setSize(410, 346);
        threads = null;        
    }
    
    @Override
    public void stateChanged(ChangeEvent e) {          
        if (Started.progreso.getValue() == 100) {
            Started.dispose();
            //Aqui llamamos al JFrame que queremos que aparezca despues
            frmLogin Login = new frmLogin();
            UserDAO LoginModel = new UserDAO();
            LoginController loginController = new LoginController(Login, LoginModel);

            Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            //obtenemos el tamaño de la ventana
            Dimension window = Login.getSize();
            //para centrar la ventana lo hacemos con el siguiente calculo
            Login.setLocation((screen.width - window.width) / 2, (screen.height - window.height) / 2);
            Login.setVisible(true);
        }
    }
    
    public void startedSplash() {
        Started.progreso.setUI(new BasicProgressBarUI(){
            @Override
            protected void paintDeterminate(Graphics g, JComponent c) {
                Graphics2D g2d = (Graphics2D)g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);                
                int _width = Started.progreso.getWidth();
                int _height = Started.progreso.getHeight();
                int spaceWidth = _width-6;
                int spaceHeight = _height-6;
                double percentProgress = Started.progreso.getPercentComplete();
                spaceWidth = (int) (spaceWidth*percentProgress);
                
                Point2D _start = new Point2D.Double(6,6);
                Point2D _end = new Point2D.Double(6,6+spaceHeight);
                float[] positionGradient = {0.0f,0.75f,1.0f};
                Color[] color = {Color.RED,Color.MAGENTA,Color.RED};
                LinearGradientPaint gradient = new LinearGradientPaint(_start,_end,positionGradient,color);
                g2d.setPaint(gradient);
                // Pintamos el Rectangulo.                                       
                Rectangle paintProgess = new Rectangle(3,3,spaceWidth,spaceHeight);
                g2d.fill(paintProgess);                
            }
            
        });        
    }      
    
    public Icon SIcon(String url, JLabel label) {
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        ImageIcon _icon = new ImageIcon(icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        return _icon;
    }    
    
}