import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter; // Import for writing to image

public class StudentIdCardGenerator {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Student ID Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel firstNameLabel = new JLabel("First Name:");
        JLabel middleNameLabel = new JLabel("Middle Name:");
        JLabel ageLabel = new JLabel("Age:");

        JTextField firstNameField = new JTextField(15);
        JTextField middleNameField = new JTextField(15);
        JTextField ageField = new JTextField(5);

        JButton generateButton = new JButton("Generate ID");
        generateButton.setBackground(new Color(50, 150, 250));
        generateButton.setForeground(Color.WHITE);
        generateButton.setFocusPainted(false);
        generateButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 100, 200)),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(firstNameLabel, gbc);
        gbc.gridx = 1;
        inputPanel.add(firstNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(middleNameLabel, gbc);
        gbc.gridx = 1;
        inputPanel.add(middleNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(ageLabel, gbc);
        gbc.gridx = 1;
        inputPanel.add(ageField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        inputPanel.add(generateButton, gbc);

        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);
        mainPanel.add(inputPanel, "input");

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                String middleName = middleNameField.getText();
                int age;
                try {
                    age = Integer.parseInt(ageField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid age!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int uniqueId = generateUniqueId(firstName, middleName, age);

                JPanel idCardPanel = createIdCardPanel(firstName, middleName, age, uniqueId);
                mainPanel.add(idCardPanel, "idCard");

                cardLayout.show(mainPanel, "idCard");
            }
        });

        frame.add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JPanel createIdCardPanel(String firstName, String middleName, int age, int uniqueId) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel textPanel = new JPanel(new GridLayout(4, 1));
        textPanel.add(new JLabel("First Name: " + firstName));
        textPanel.add(new JLabel("Middle Name: " + middleName));
        textPanel.add(new JLabel("Age: " + age));
        textPanel.add(new JLabel("Unique ID: " + uniqueId));

        try {
            BufferedImage barcodeImage = generateBarcodeImage(String.valueOf(uniqueId), 200, 200);
            if (barcodeImage != null) {
                JLabel barcodeLabel = new JLabel(new ImageIcon(barcodeImage));
                panel.add(barcodeLabel, BorderLayout.SOUTH);
            } else {
                panel.add(new JLabel("Barcode generation failed."), BorderLayout.SOUTH);
            }
        } catch (Exception e) {
            panel.add(new JLabel("Barcode generation error: " + e.getMessage()), BorderLayout.SOUTH);
            e.printStackTrace(); // Print the full stack trace for debugging
        }

        panel.add(textPanel, BorderLayout.CENTER);

        return panel;
    }


    private static BufferedImage generateBarcodeImage(String barcodeText, int width, int height) {
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = barcodeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, width, height);
            return MatrixToImageWriter.toBufferedImage(bitMatrix); // Use the utility class
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static int generateUniqueId(String firstName, String middleName, int age) {
        int combinedHash = firstName.hashCode() + middleName.hashCode() + age;
        Random random = new Random();
        int randomNumber = random.nextInt(10000);
        return Math.abs(combinedHash) % 1000000 + randomNumber;
    }
}