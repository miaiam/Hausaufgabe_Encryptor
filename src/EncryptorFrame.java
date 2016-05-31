import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mia on 31.05.16.
 */
public class EncryptorFrame extends JFrame{

    private JTextArea textAreaOriginal;
    public JTextArea textAreaEncrypted;
    private JButton decrypt;
    private JButton encrypt;
    private JPanel buttonPanel;
    private JComboBox comboBox;

    private Encryptor encryptor;

    private Map<String, EncryptorStrategy> encryptionMap;

    public EncryptorFrame(){

        encryptor = new Encryptor();
        encryptionMap = new HashMap<String, EncryptorStrategy>();
        encryptionMap.put("Copy", new Copy());
        encryptionMap.put("Reverse", new Reverse());

        setTitle("Encryptor");

        textAreaOriginal = new JTextArea();
        textAreaEncrypted = new JTextArea();

        decrypt = new JButton("Decrypt");
        encrypt = new JButton("Encrypt");

        comboBox = new JComboBox(encryptionMap.keySet().toArray());

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selectedStrategy = comboBox.getSelectedItem();
                EncryptorStrategy strategy = encryptionMap.get(selectedStrategy);
                encryptor.setEncryptorStrategy(strategy);
            }
        });

        textAreaOriginal.setBorder(new TitledBorder("Original"));
        textAreaEncrypted.setBorder(new TitledBorder("Encrypted"));

        buttonPanel = new JPanel();

        buttonPanel.add(encrypt);
        buttonPanel.add(decrypt);
        buttonPanel.add(comboBox);


        Box verticalBox = Box.createVerticalBox();
        add(verticalBox);
        verticalBox.add(textAreaOriginal);
        verticalBox.add(textAreaEncrypted);
        verticalBox.add(buttonPanel);

        encrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaEncrypted.setText(encryptor.encrypt(textAreaOriginal.getText()));
            }
        });

        decrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaEncrypted.setText(encryptor.decrypt(textAreaEncrypted.getText()));
            }
        });
        
        setSize(350,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args){
        JFrame frame = new EncryptorFrame();
    }
}
