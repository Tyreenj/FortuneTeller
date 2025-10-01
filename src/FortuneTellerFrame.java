import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    JPanel topPanel;
    JPanel middlePanel;
    JPanel bottomPanel;

    JTextArea textField;

    JButton button;
    JButton quitButton;

    JScrollPane scrollPane;

    ImageIcon icon;
    JLabel iconLabel;

    ArrayList<String> fortunes;

    Random rnd;

    int prevFortune = -1;
    int nextFortune = -1;

    int width;
    int height;

    public FortuneTellerFrame()
    {
        createTopPanel();
        createMiddlePanel();
        createBottomPanel();
        setLayout(new BorderLayout());

        add(topPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        Dimension screensize =  Toolkit.getDefaultToolkit().getScreenSize();
        width = (int) (screensize.width * 0.75);
        height = (int) (screensize.height * 0.75);

        setSize(width, height);
        setTitle("Fortune Teller");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        fortunes = new ArrayList<>();
        fortunes.add("You will pass your next exam!");
        fortunes.add("You will fail your class!");
        fortunes.add("You will get a raise!");
        fortunes.add("You will be fired!");
        fortunes.add("You will go on vacation in mid-February!");
        fortunes.add("You will get a new job!");
        fortunes.add("You will soon find what you lost… unless it was your sanity. That’s gone forever.");
        fortunes.add("Your phone will autocorrect something embarrassing at exactly the wrong time.");
        fortunes.add("Your future looks bright. Sunglasses recommended.");
        fortunes.add("A great opportunity will present itself. Sadly, it will be disguised as chores.");
        fortunes.add("You will soon achieve inner peace… right after the Wi-Fi reconnects.");
        fortunes.add("Your boss will compliment your work… right after taking credit for it.");

        rnd = new Random();
    }

    public void fortune()
    {
        do {
            nextFortune = rnd.nextInt(fortunes.size());
        } while (prevFortune == nextFortune);

        textField.append("\n" + fortunes.get(nextFortune));
        prevFortune = nextFortune;
    }

    public void createTopPanel()
    {
        topPanel = new JPanel();
        //<a href="https://iconscout.com/icons/fortune" class="text-underline font-size-sm" target="_blank">Fortune</a> by <a href="https://iconscout.com/contributors/fluent-emoji" class="text-underline font-size-sm">Fluent Emoji <> Microsoft</a> on <a href="https://iconscout.com" class="text-underline font-size-sm">IconScout</a>
        icon = new ImageIcon("src/fortune.png");
        iconLabel = new JLabel("Fortune Teller", icon,  JLabel.CENTER);
        iconLabel.setVerticalTextPosition(JLabel.BOTTOM);
        iconLabel.setHorizontalTextPosition(JLabel.CENTER);
        iconLabel.setFont(new Font("Courier New", Font.BOLD, 36));
        topPanel.add(iconLabel);
    }

    public void  createMiddlePanel()
    {
        middlePanel = new JPanel();
        textField = new JTextArea(10, 25);
        textField.setFont(new Font("Serif", Font.BOLD, 12));
        textField.setEditable(false);
        textField.setColumns(60);
        scrollPane = new JScrollPane(textField);
        middlePanel.add(scrollPane);
    }
    public void createBottomPanel()
    {
        bottomPanel = new JPanel();
        button = new JButton("Read my Fortune!");
        quitButton = new JButton("Quit");
        button.setFont(new Font("Calibri", Font.ITALIC, 18));
        button.addActionListener((ActionEvent ae) -> {
            fortune();
        });
        quitButton.setFont(new Font("Callisto MT", Font.PLAIN, 18));
        bottomPanel.add(button);
        bottomPanel.add(quitButton);
        quitButton.addActionListener((ActionEvent ae) -> System.exit(0));
    }

}
