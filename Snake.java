import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Snake extends JPanel implements KeyListener, ActionListener {
    
    private final int width = 500;
    private final int height = 500;
    private final int dotSize = 20;
    private final int allDots = 900;
    private final int delay = 100;
    
    private final int x[] = new int[allDots];
    private final int y[] = new int[allDots];
    
    private int dots;
    private int appleX;
    private int appleY;
    
    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;
    
    private Timer timer;
    private Image ball;
    private Image apple;
    private Image head;
    
    public Snake() {
        initGame();
    }
    
    private void initGame() {
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.black);
        setFocusable(true);
        addKeyListener(this);
        loadImages();
        initSnake();
        placeApple();
        timer = new Timer(delay, this);
        timer.start();
    }
    
    private void loadImages() {
        ImageIcon iid = new ImageIcon("dot.png");
        ball = iid.getImage();
        
        ImageIcon iia = new ImageIcon("apple.png");
        apple = iia.getImage();
        
        ImageIcon iih = new ImageIcon("head.png");
        head = iih.getImage();
    }
    
    private void initSnake() {
        dots = 3;
        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * 10;
            y[z] = 50;
        }
    }
    
    private void placeApple() {
        Random rand = new Random();
        appleX = rand.nextInt((int)(width / dotSize)) * dotSize;
        appleY = rand.nextInt((int)(height / dotSize)) * dotSize;
    }
    
    private void checkApple() {
        if (x[0] == appleX && y[0] == appleY) {
            dots++;
            placeApple();
        }
    }
    
    private void move() {
        for (int z = dots; z > 0; z--) {
            x[z] = x[z - 1];
            y[z] = y[z - 1];
        }
        
        if (leftDirection) {
            x[0] -= dotSize;
        }
        
        if (rightDirection) {
            x[0] += dotSize;
        }
        
        if (upDirection) {
            y[0] -= dotSize;
        }
        
        if (downDirection) {
            y[0] += dotSize;
        }
    }
    
    private void checkCollision() {
        for (int z = dots; z > 0; z--) {
            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
            }
        }
        
        if (y[0] >= height || y[0] < 0 || x[0] >= width || x[0] < 0) {
            inGame = false;
        }
        
        if (!inGame) {
            timer.stop();
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {
        if (inGame) {
            g.drawImage(apple, appleX, appleY, this);
            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(head, x[z], y[z], this);
                } else {
                    g.drawImage(ball, x[z], y[z], this);
                }
            }
            Toolkit.getDefaultToolkit().sync();
        } else {
            gameOver(g);
        }        
    }
    
    
    private void gameOver(Graphics g) {
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);
        
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (width - metr.stringWidth(msg)) / 2, height / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            checkApple();
            checkCollision();
            move();
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
            leftDirection = true;
            upDirection = false;
            downDirection = false;
        }
        
        if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
            rightDirection = true;
            upDirection = false;
            downDirection = false;
        }
        
        if ((key == KeyEvent.VK_UP) && (!downDirection)) {
            upDirection = true;
            rightDirection = false;
            leftDirection = false;
        }
        
        if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
            downDirection = true;
            rightDirection = false;
            leftDirection = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(new Snake());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
